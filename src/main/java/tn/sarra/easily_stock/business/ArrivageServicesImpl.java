package tn.sarra.easily_stock.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.sarra.easily_stock.data.entities.Arrivage;
import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.Produit;
import tn.sarra.easily_stock.data.repositories.ArrivageRepository;


@Service
public class ArrivageServicesImpl implements ArrivageServices{
	
	
	@Autowired
	private ArrivageRepository ar;

	@Override
	public List<Arrivage> getArrivages() {
		return ar.findAll();
	}

	@Override
	public List<Produit> getArrivageProduits(Integer arrId) {
		return ar.findById(arrId).get().getProduits();
	}

	@Override
	public List<Entrepot> getArrivageEntrepots(Integer arrId) {
		List<Entrepot> entrepots = new ArrayList<Entrepot>();
		getArrivageProduits(arrId).stream().forEach(p ->
			p.getEntrepots().stream().forEach(e-> entrepots.add(e))
		);
		return entrepots.stream().distinct().collect(Collectors.toList());
	}

}
