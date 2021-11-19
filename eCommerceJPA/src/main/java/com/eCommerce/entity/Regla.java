package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reglas database table.
 * 
 */
@Entity
@Table(name="reglas")
@NamedQuery(name="Regla.findAll", query="SELECT r FROM Regla r")
public class Regla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idReglas;

	private String activo;

	private String descripcion;

	@Column(name="nombre_regla")
	private String nombreRegla;

	private double valor;

	//bi-directional many-to-one association to Descuento
	@OneToMany(mappedBy="regla")
	private List<Descuento> descuentos;

	public Regla() {
	}

	public int getIdReglas() {
		return this.idReglas;
	}

	public void setIdReglas(int idReglas) {
		this.idReglas = idReglas;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreRegla() {
		return this.nombreRegla;
	}

	public void setNombreRegla(String nombreRegla) {
		this.nombreRegla = nombreRegla;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Descuento> getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	public Descuento addDescuento(Descuento descuento) {
		getDescuentos().add(descuento);
		descuento.setRegla(this);

		return descuento;
	}

	public Descuento removeDescuento(Descuento descuento) {
		getDescuentos().remove(descuento);
		descuento.setRegla(null);

		return descuento;
	}

}