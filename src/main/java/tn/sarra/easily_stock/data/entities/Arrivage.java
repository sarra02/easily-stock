package tn.sarra.easily_stock.data.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Arrivage {
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String reference;
	 private Date dateArrivage;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "arrivageId")
	 private List<Produit> produits;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateArrivage() {
		return dateArrivage;
	}

	public void setDateArrivage(Date dateArrivage) {
		this.dateArrivage = dateArrivage;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
}

