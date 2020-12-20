package tn.sarra.easily_stock.data.entities;

import javax.persistence.Entity;


@Entity
public class EntrepotRectangulaire extends Entrepot{

	private Double width;
	private Double length;
	private Double height;
	
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
}
