package tn.sarra.easily_stock.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.sarra.easily_stock.data.entities.Arrivage;

@Repository
public interface ArrivageRepository extends JpaRepository<Arrivage, Integer>{

}

