package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCarrito;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="FK_Productos")
	private Producto producto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="FK_Usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="carrito")
	private List<Factura> facturas;

	public Carrito() {
	}

	public int getIdCarrito() {
		return this.idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCarrito(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCarrito(null);

		return factura;
	}

}