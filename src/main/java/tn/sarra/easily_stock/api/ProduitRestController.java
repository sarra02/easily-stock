package tn.sarra.easily_stock.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.sarra.easily_stock.business.ProduitServices;
import tn.sarra.easily_stock.data.entities.Produit;


@RestController
public class ProduitRestController {
	
	@Autowired
	private ProduitServices produitServices;
	
	@JsonIgnore
	@RequestMapping(path="/produits", method = RequestMethod.GET)
	public List<Produit> getAll() {
		return produitServices.getProduits();
	}
	
	@PostMapping("/produits/add-produit")
    void addProduct(@RequestBody Produit p) {
      produitServices.ajouterProduit(p);
    }

	
	@RequestMapping(path="/produits/unaffected", method = RequestMethod.GET)
	public List<Produit> getUnaffectedProduits(){
		return produitServices.getUnaffectedProduits();
	}
	

	
	@RequestMapping(path="/produits/entrepot",method = RequestMethod.GET)
	public List<Integer> getNbreProduitParEntrepot(){
		return produitServices.nbreProduitParEntrepot();  
	}
	@RequestMapping(path="/produits/moyenne-produit-par-entrepot",method = RequestMethod.GET)
	public Long getNbreMoyProduitParEntrepot(){
		return produitServices.moyProduitParEntrepot();  
	}
	
	@RequestMapping(path="/produits/moyenne-quantite",method = RequestMethod.GET)
	public Integer getMoyQuantiteParProduit(){
		return produitServices.avgQuantite();   
	}
	@RequestMapping(path="/produits/pourcentage",method = RequestMethod.GET)
	public Double getPourcentageProduit(){
		return produitServices.pourcentagePdtAffectés();   
	}
	 @DeleteMapping("/produits/delete/{produit_id}")
	 @ResponseBody
	 public void delete(@PathVariable("produit_id") Integer produitId)
	    {	try {
	   produitServices.supprimerProduit(produitId);
	    }catch(Exception ex) {
	    	System.out.print(ex);
	    }
	    }


}
