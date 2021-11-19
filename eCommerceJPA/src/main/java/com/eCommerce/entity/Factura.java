package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFactura;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double total;

	//bi-directional many-to-one association to Carrito
	@ManyToOne
	@JoinColumn(name="FK_Carrito")
	private Carrito carrito;

	public Factura() {
	}

	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

}