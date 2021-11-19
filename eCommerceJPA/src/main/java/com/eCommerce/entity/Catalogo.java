package com.eCommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCatalogo;

	private String categoria;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="catalogo")
	private List<Categoria> categorias;

	public Catalogo() {
	}

	public int getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setCatalogo(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setCatalogo(null);

		return categoria;
	}

}