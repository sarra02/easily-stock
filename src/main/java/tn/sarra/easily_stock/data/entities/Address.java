package tn.sarra.easily_stock.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Table(
    uniqueConstraints=
        @UniqueConstraint(columnNames={"number","rue", "ville","pays","cp"})
)

@Entity
public class Address {
	
	@Id
	@Column(name = "id")
	private Integer id;
	private String rue;
	private String ville;
	private String pays;
	private String cp;
	private Integer number;
	
	@JsonIgnore
	@OneToOne
    @MapsId
	private Entrepot entrepot;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public Entrepot getEntrepot() {
		return entrepot;
	}
	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
