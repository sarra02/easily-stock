package tn.sarra.easily_stock.business;

import java.util.List;

import tn.sarra.easily_stock.business.exceptions.IncoherentCountryCityException;
import tn.sarra.easily_stock.business.exceptions.NotEnoughSpaceException;
import tn.sarra.easily_stock.business.exceptions.SameAddressException;
import tn.sarra.easily_stock.business.exceptions.UncoveredCityException;
import tn.sarra.easily_stock.business.exceptions.UncoveredCountryException;
import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.Produit;


public interface EntrepotServices {
	void createEntrepot(Entrepot en) throws SameAddressException, UncoveredCountryException, UncoveredCityException, IncoherentCountryCityException;
	
	List<String> getEntrepots();
	
	Double getGlobalCapacity(Entrepot e);
	
	Double getOccupiedSpace(Entrepot e);
	
	Double getRemainingSpace(Entrepot e);
	
//	Double getGlobalCapacity(EntrepotRectangulaire e);
//	Double getOccupiedSpace(EntrepotRectangulaire e);
//	Double getRemainingSpace(EntrepotRectangulaire e);
	List<String> getEntrepotsWithCapacityAlert();
	
	Entrepot affecterProduitToEntrepot(Produit p, Entrepot e) throws NotEnoughSpaceException;
	
    Long nbreEntrepotParVille(String ville);
    
    Long nbreEntrepotParPays(String pays); 
    
	void deplacerProduits(Integer entrepotId1, Integer entrepotId2) ;

}
