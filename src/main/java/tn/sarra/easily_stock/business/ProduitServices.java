package tn.sarra.easily_stock.business;

import java.util.List;

import tn.sarra.easily_stock.business.exceptions.ProduitExistDansEntrepotException;
import tn.sarra.easily_stock.data.entities.Produit;



public interface ProduitServices {
	List<Produit> getProduits();
	
	List<Produit> getUnaffectedProduits();
	
	void ajouterProduit(Produit p);
	
	void supprimerProduit(Integer produitId) throws ProduitExistDansEntrepotException;
	
	List<Integer> nbreProduitParEntrepot();
	
	Long moyProduitParEntrepot();
	
	Double pourcentagePdtAffectés();
	
	Integer avgQuantite();
	
	Double getDimensionProduit(Produit p);

}
