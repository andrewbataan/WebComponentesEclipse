package com.eCommerce.controller;

import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.eCommerce.entity.*;



@SuppressWarnings("finally")
public class UsuarioController extends ServiceEntity<Usuario> {
	private TypedQuery<Usuario> query;
	private Usuario usuario;

	public Usuario loginClient(String email, String password) throws GlobalException {
		Usuario usuario = null;
		try {
			this.startEntityManagerFactory();
			Session session = this.getEm().unwrap(Session.class);
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("mail", email));
			usuario = (Usuario) criteria.uniqueResult();
			this.stopEntityManagerFactory();
		} catch (NonUniqueResultException e) {
			e.printStackTrace();
		}

		if (usuario == null) {
			System.out.println("user not register on our sysytem!");
		} else if (usuario.ValidPassword(password)) {
			System.out.println("Welcome " + usuario.getNombre());
		} else {
			System.out.println("invalid Password!");
		}

		return usuario;

	}

	

	public Object selectRegister(String id) throws GlobalException {
		try {
			this.startEntityManagerFactory();
			this.usuario = this.getEm().createNamedQuery("User.findOne", Usuario.class).setParameter("param", id)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.usuario;
		}

	}
}
	