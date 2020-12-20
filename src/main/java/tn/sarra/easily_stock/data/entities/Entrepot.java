package tn.sarra.easily_stock.data.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Entrepot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	
	@OneToOne(mappedBy = "entrepot", cascade = CascadeType.ALL)
	private Address adresse;
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "entrepot_produit", 
      joinColumns = 
        { @JoinColumn(name = "produit_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "entrepot_id", referencedColumnName = "id") })
	private List<Produit> produits;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Address getAdresse() {
		return adresse;
	}
	public void setAdresse(Address adresse) {
		this.adresse = adresse;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	

}
