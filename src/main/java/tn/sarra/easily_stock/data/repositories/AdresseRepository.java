package tn.sarra.easily_stock.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.sarra.easily_stock.data.entities.Address;



@Repository
public interface AdresseRepository extends JpaRepository<Address, Integer>{
	 // façon 3 : méthode conventionnelle
     Long countByNumberAndRueIgnoreCaseAndVilleIgnoreCaseAndPaysIgnoreCaseAndCpIgnoreCase(Integer number, String rue, String ville, String pays, String cp);


}

