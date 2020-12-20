package tn.sarra.easily_stock.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.EntrepotRectangulaire;

@Repository
public interface EntrepotRepository extends JpaRepository<Entrepot, Integer>{
	
	@Query("select count (e) from Entrepot e where TRIM(UPPER(e.adresse.number))=TRIM(UPPER(?1)) "
			+ "and TRIM(UPPER(e.adresse.rue))=TRIM(UPPER(?2)) and "
			+ "TRIM(UPPER(e.adresse.ville))=TRIM(UPPER(?3)) and "
			+ "TRIM(UPPER(e.adresse.pays))=TRIM(UPPER(?4)) and "
			+ "TRIM(UPPER(e.adresse.cp))=TRIM(UPPER(?5))") //JPQL
	Long checkDuplicateAddress(Integer number, String rue, String ville, String pays, String cp);
	
	 // façon 2 : SQL natif
    //
    // @Query(nativeQuery = true,value = "select count(*) from entrepot e join address a on a.id=e.id where a.number=?1 and a.rue=?2 and a.ville=?3 and a.pays=?4 and a.cp=?5")
    
	// façon 3 : méthode conventionnelle
    // Long countByNumberAndRueIgnoreCaseAndVilleIgnoreCaseAndPaysIgnoreCaseAndCpIgnoreCase(Integer number, String rue, String ville, String pays, String cp);
	


	@Query(nativeQuery = true,value = "select * from entrepot e join entrepot_rectangulaire er on e.id = er.id")
	List<EntrepotRectangulaire> getEntrepotsRectangulaire();

	@Query(nativeQuery = true,value = "insert into entrepot_prduit values (:pId, :eId)")
	 void affecterProduitToEntrepot(Integer pId, Integer eId);
	
	
	@Query(nativeQuery = true,value="select count(*) from entrepot e join address a on e.id = a.entrepot_id where a.ville=?1 group by a.ville ")
	Long nbreEntrepotParVille(String ville); 
	
	@Query(nativeQuery = true,value="select count(*) from entrepot e join address a on e.id = a.entrepot_id where a.pays=?1 group by a.pays ")
	Long nbreEntrepotParPays(String pays); 

	
}

