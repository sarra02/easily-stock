package tn.sarra.easily_stock.business;

import java.util.List;

import tn.sarra.easily_stock.data.entities.Arrivage;
import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.Produit;

public interface ArrivageServices {
	List<Arrivage> getArrivages();
	List<Produit> getArrivageProduits(Integer arrId);
	List<Entrepot> getArrivageEntrepots(Integer arrId);

}
