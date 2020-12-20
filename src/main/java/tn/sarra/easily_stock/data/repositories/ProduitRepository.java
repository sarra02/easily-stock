package tn.sarra.easily_stock.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.sarra.easily_stock.data.entities.Produit;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	
	@Query(nativeQuery=true, value="select * from produit p where p.id not in (select produit_id from entrepot_produit)")
	List<Produit> findUnaffectedProduits();
	
	@Query("select sum(p.quantite) from Produit p") 
	Long quantiteTotale();
	 
	@Query("select count(p) from Produit p where p.entrepots.size > 0")
	Long nbreProduitsAffectes();
	 
	@Query("select avg(quantite) from Produit")
	Integer avgQuantite();

	
}
