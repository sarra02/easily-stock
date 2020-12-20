package tn.sarra.easily_stock.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.sarra.easily_stock.business.ArrivageServices;
import tn.sarra.easily_stock.data.entities.Arrivage;
import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.Produit;

@RestController
public class ArrivageRestController {

	@Autowired
	private ArrivageServices arrivageService;
	
	@RequestMapping(path="/arrivages",method = RequestMethod.GET)
	public List<Arrivage> getAll(){
		return arrivageService.getArrivages();
	}
	
	@RequestMapping(path="/arrivages/{arrivage_id}/produits",method = RequestMethod.GET)
	public List<Produit> getArrivageProducts(@PathVariable("arrivage_id") Integer arrId){
		return arrivageService.getArrivageProduits(arrId);
	}
	@JsonIgnore
	@RequestMapping(path="/arrivages/{arrivage_id}/entrepots",method = RequestMethod.GET)
	public List<Entrepot> getArrivageEntrepot(@PathVariable("arrivage_id") Integer arrId){
		return arrivageService.getArrivageEntrepots(arrId);
	}
	
}

