package tn.sarra.easily_stock.business;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.sarra.easily_stock.business.exceptions.IncoherentCountryCityException;
import tn.sarra.easily_stock.business.exceptions.NotEnoughSpaceException;
import tn.sarra.easily_stock.business.exceptions.SameAddressException;
import tn.sarra.easily_stock.business.exceptions.UncoveredCityException;
import tn.sarra.easily_stock.business.exceptions.UncoveredCountryException;
import tn.sarra.easily_stock.data.AppConstants;
import tn.sarra.easily_stock.data.Pays;
import tn.sarra.easily_stock.data.entities.Address;
import tn.sarra.easily_stock.data.entities.Entrepot;
import tn.sarra.easily_stock.data.entities.EntrepotRectangulaire;
import tn.sarra.easily_stock.data.entities.Produit;
import tn.sarra.easily_stock.data.repositories.AdresseRepository;
import tn.sarra.easily_stock.data.repositories.EntrepotRectangulaireRepository;
import tn.sarra.easily_stock.data.repositories.EntrepotRepository;
import tn.sarra.easily_stock.data.repositories.ProduitRepository;


@Service
public class EntrepotServicesImpl implements EntrepotServices {
	
	@Autowired
	private EntrepotRepository entrepotRepository;
	
	@Autowired
	private AdresseRepository addressRepository;
	
	@Autowired
	private ProduitServices produitServices;
	
	@Autowired
	private EntrepotRectangulaireRepository entrepotRectangulaireRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	public String[] PAYS = AppConstants.PAYS;
	public String[] VILLES = AppConstants.VILLES;
	public List<Pays> PAYS_VILLES = AppConstants.PAYS_VILLES;
	
	@Override
	public void createEntrepot(Entrepot e) throws SameAddressException, UncoveredCountryException, UncoveredCityException, IncoherentCountryCityException {
		
		Address a = e.getAdresse();
		if(addressRepository.countByNumberAndRueIgnoreCaseAndVilleIgnoreCaseAndPaysIgnoreCaseAndCpIgnoreCase(a.getNumber(),a.getRue(), a.getVille(), a.getPays(),a.getCp()) > 0) {
			throw new SameAddressException("Cette adresse existe déjà");
		}
		else if ( !Arrays.stream(PAYS).anyMatch(e.getAdresse().getPays().toLowerCase()::equals)) {
			throw new UncoveredCountryException("Ce pays n'est pas dans la liste!");
		} 
		else if (!Arrays.stream(VILLES).anyMatch(e.getAdresse().getVille().toLowerCase()::equals)) {
			throw new UncoveredCityException("Cette ville n'est pas dans la liste!");
		} else
	
			entrepotRepository.save(e);
		}

	@Override
	public List<String> getEntrepots() {
		return entrepotRepository.findAll().stream().map(ent -> ent.getNom()).collect(Collectors.toList());
	}
	
	@Override
	public Double getGlobalCapacity(Entrepot e) {
		Double volume = 0.0;
		if (e instanceof EntrepotRectangulaire) {
		
		volume = ((EntrepotRectangulaire) e).getHeight() * ((EntrepotRectangulaire) e).getLength() * ((EntrepotRectangulaire) e).getWidth();
		}
		return volume;
	}


	@Override
	public Double getOccupiedSpace(Entrepot e) {

		List<Produit> produits = e.getProduits();
		Double capacity =  produits.stream().map(p -> produitServices.getDimensionProduit(p)).reduce((double) 0, (a, b) -> a+b);
		return capacity;
		
	}
	

	@Override
	public Double getRemainingSpace(Entrepot e) {
		 
		return getGlobalCapacity(e) - getOccupiedSpace(e);
	}

	@Override
	public List<String> getEntrepotsWithCapacityAlert() {
		
		List<String> entrepotsWAlert = entrepotRectangulaireRepository.findAll().stream().filter(ent -> getRemainingSpace(ent) == 0.2 * getGlobalCapacity(ent)).map( ent -> ent.getNom()).collect(Collectors.toList());
		return entrepotsWAlert;
	}

	@Override
	public Entrepot affecterProduitToEntrepot(Produit p, Entrepot e) throws NotEnoughSpaceException{
		
		System.out.println(getRemainingSpace(e));
		System.out.println(produitServices.getDimensionProduit(p));
		System.out.println(e.getNom());
		if(getRemainingSpace(e) > produitServices.getDimensionProduit(p)) {
			e.getProduits().add(p);
			System.out.println(e.getProduits().stream().map(pr -> pr.getLabel()).collect(Collectors.toList()));
			entrepotRepository.save(e);
			
		} else throw new NotEnoughSpaceException("Espace de l'entrepot pas suffisant!");
		return e;
		
		
	}

	@Override
	public Long nbreEntrepotParVille(String ville) {
		return entrepotRepository.nbreEntrepotParVille(ville);
	}

	@Override
	public Long nbreEntrepotParPays(String pays) {
		
		return entrepotRepository.nbreEntrepotParPays(pays);
	}

	@Override
	public void deplacerProduits(Integer entrepotId1, Integer entrepotId2) {
		Entrepot e1 = entrepotRepository.getOne(entrepotId1);
		Entrepot e2 = entrepotRepository.getOne(entrepotId2);
		System.out.println(e1);
		System.out.println(e2);
		
		e1.getProduits().stream().forEach(p -> {
		if(getRemainingSpace(e2) > produitServices.getDimensionProduit(p)) {
			e2.getProduits().add(p);
			e1.getProduits().remove(p);
		}
		else System.out.print("entrepot complet");
		});
		entrepotRepository.save(e1);
		entrepotRepository.save(e2);
		
		
		
	}

	
	
	

	
	

		
}
