package tn.sarra.easily_stock.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.sarra.easily_stock.data.entities.EntrepotRectangulaire;


@Repository
public interface EntrepotRectangulaireRepository extends JpaRepository<EntrepotRectangulaire, Integer>{

}
