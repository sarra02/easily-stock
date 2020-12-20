package tn.sarra.easily_stock.data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Produit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long reference;
    private String label;
    private Double prix;
    private String description;
    private Double width;
	private Double length;
	private Double height;
	private Integer quantite;
    
    @Enumerated
    private TypeEmballage emballage;
    
    @ManyToMany(mappedBy="produits")
    private List<Entrepot> entrepots;
    
  
    @JoinColumn(name = "arrivage_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Arrivage arrivageId;
    
	public TypeEmballage getEmballage() {
		return emballage;
	}
	public void setEmballage(TypeEmballage emballage) {
		this.emballage = emballage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public List<Entrepot> getEntrepots() {
		return entrepots;
	}
	public void setEntrepots(List<Entrepot> entrepots) {
		this.entrepots = entrepots;
	}
	public Arrivage getArrivageId() {
		return arrivageId;
	}
	public void setArrivageId(Arrivage arrivageId) {
		this.arrivageId = arrivageId;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
    
}
