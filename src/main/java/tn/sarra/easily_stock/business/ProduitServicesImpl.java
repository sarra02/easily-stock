package tn.sarra.easily_stock.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.sarra.easily_stock.business.exceptions.ProduitExistDansEntrepotException;
import tn.sarra.easily_stock.data.entities.Produit;
import tn.sarra.easily_stock.data.repositories.EntrepotRepository;
import tn.sarra.easily_stock.data.repositories.ProduitRepository;


@Service
public class ProduitServicesImpl implements ProduitServices {
	
	@Autowired
	private ProduitRepository pr;
	
	@Autowired
	private EntrepotRepository er;

	@Override
	public List<Produit> getProduits() {
		return pr.findAll();
	}

	@Override
	public List<Produit> getUnaffectedProduits() {
	
		return pr.findUnaffectedProduits();
	}

	@Override
	public Double getDimensionProduit(Produit p) {
		Double volume = p.getHeight() * p.getLength() * p.getWidth();
		return volume;
	}
	

@Override
public List<Integer> nbreProduitParEntrepot() {
	return er.findAll().stream().map(e -> e.getProduits().size()).collect(Collectors.toList());
}

@Override
public Long moyProduitParEntrepot() {
	
	return nbreProduitParEntrepot().stream().mapToLong(i -> i).sum()/er.count();
			
}

@Override
public Integer avgQuantite() {
	
	return pr.avgQuantite();
}

@Override
public Double pourcentagePdtAffectés() {
	return (double) pr.nbreProduitsAffectes()/pr.count();
}
@Override
public void ajouterProduit(Produit p) {
	pr.save(p);
	
}
@Override
public void supprimerProduit(Integer produitId) throws ProduitExistDansEntrepotException{
	if( pr.getOne(produitId).getEntrepots().isEmpty())
		pr.deleteById(produitId);
	else throw new ProduitExistDansEntrepotException("le produit ne peut pas ètre supprimé car il existe déjà dans un entrepot");
	
}

	
}
