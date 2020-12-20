package tn.sarra.easily_stock.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.sarra.easily_stock.business.EntrepotServices;
import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.Produit;
import tn.sarra.easily_stock.data.repositories.EntrepotRectangulaireRepository;
import tn.sarra.easily_stock.data.repositories.EntrepotRepository;
import tn.sarra.easily_stock.data.repositories.ProduitRepository;


@RestController
@RequestMapping("/api")
public class EntrepotRestController {
	
	    @Autowired
	    private EntrepotServices entrepotServices;
	
	 	@Autowired
	    private EntrepotRepository entrepotRepository;
	 	
		@Autowired
	    private ProduitRepository produitRepository;
		
		@Autowired 
		private EntrepotRectangulaireRepository entrepotRectangulaireRepository;


	    @PostMapping("/entrepots")
	    @ResponseBody
	    void create(@RequestBody Entrepot e) {
	        try {
	            this.entrepotServices.createEntrepot(e);
	        } catch (Exception ex) {
	            System.out.println(ex);
	        }
	    }

	    @GetMapping("/entrepots")
	    @ResponseBody
	    public List<Entrepot> findAll()
	    {
	        return entrepotRepository.findAll();
	    }
	    
	    // 1st method
	    @PatchMapping("/entrepots/add-product/{entrepot_id}/{produit_id}")
	    @ResponseBody
	    public Entrepot addProduitToEntrepot(@PathVariable("entrepot_id") Integer entrepotId, @PathVariable("produit_id") Integer produitId)
	    {	
	    	Entrepot entrepot = entrepotRectangulaireRepository.getOne(entrepotId);
	    	Produit produit =  produitRepository.getOne(produitId);
	    	System.out.println(produit.toString());
	    	try {
	        return entrepotServices.affecterProduitToEntrepot(produit, entrepot);
	        
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
			return entrepot;
	    }
	    
	    // second method
	    @PostMapping("/entrepot/addProduit")
	    void addProduitToEntrepot(@RequestBody Produit p,Entrepot e) {
	    	try {
	       entrepotServices.affecterProduitToEntrepot(p, e);
	    	} catch (Exception ex) {
	    		System.out.print(ex);
	    	}
	    }


	    @PutMapping("/entrepots/{entrepot_id}")
	    @ResponseBody
	    public Entrepot update(@PathVariable("entrepot_id") Integer entrepotId, @RequestBody Entrepot entrepotObject)
	    {
	    	Entrepot entrepot = entrepotRepository.getOne(entrepotId);
	    	entrepot.setNom(entrepotObject.getNom());
	        return entrepotRepository.save(entrepot);
	    }
	    
	    @DeleteMapping("/entrepots/{entrepot_id}")
	    @ResponseBody
	    public List<Entrepot> delete(@PathVariable("entrepot_id") Integer entrepotId)
	    {	
	    	Entrepot entrepot = entrepotRepository.getOne(entrepotId);
	    	
	    	if (entrepot.getProduits().isEmpty()) {
	    		entrepotRepository.deleteById(entrepotId);
	    	} else {
	    		System.out.println("entrepot n'est pas vide!!");
	    	}
	    	
	        return entrepotRepository.findAll();
	    }
	    
	  
	    
	    @PutMapping("/entrepot/{entrepot_id1}/{entrepot_id2}")
	    public void moveProducts(@PathVariable("entrepot_id1") Integer entrepotId1, @PathVariable("entrepot_id2") Integer entrepotId2)
	    {    
	        entrepotServices.deplacerProduits(entrepotId1, entrepotId2);
	    }


}