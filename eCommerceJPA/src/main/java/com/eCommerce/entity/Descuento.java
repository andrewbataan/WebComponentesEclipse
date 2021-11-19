package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the descuento database table.
 * 
 */
@Entity
@NamedQuery(name="Descuento.findAll", query="SELECT d FROM Descuento d")
public class Descuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDescuento;

	private String codigo;

	private String nombre;

	private int valor;

	//bi-directional many-to-one association to Regla
	@ManyToOne
	@JoinColumn(name="FK_Regla")
	private Regla regla;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="descuento")
	private List<Producto> productos;

	public Descuento() {
	}

	public int getIdDescuento() {
		return this.idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Regla getRegla() {
		return this.regla;
	}

	public void setRegla(Regla regla) {
		this.regla = regla;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setDescuento(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setDescuento(null);

		return producto;
	}

}