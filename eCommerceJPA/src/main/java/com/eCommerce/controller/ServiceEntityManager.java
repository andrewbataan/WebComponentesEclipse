package com.eCommerce.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eCommerce.controller.*;

public abstract class ServiceEntityManager<E> {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager em = null;
	
	public EntityManager getEm() {
		return em;
	}

	protected EntityManager getEntityManager() throws GlobalException  {

		if (em == null || !em.isOpen()) {

			em = this.getEntityManagerFactory().createEntityManager();

		}

		return em;

	}

	@Override
	protected void finalize() throws Throwable {

		super.finalize();

		if (em != null)

			em.close();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })

	private final Class<E> getEntityClass() {

		Class c = this.getClass();

		ParameterizedType parameterizedType = (ParameterizedType) c

				.getGenericSuperclass();

		Type res = parameterizedType.getActualTypeArguments()[0];

		return (Class<E>) res;

	}

	public E findByPK(Object pk) throws GlobalException {

		return (E) getEntityManager().find(getEntityClass(), pk);

	}

	public List<E> findAll() throws GlobalException  {

		Class<E> clazz = getEntityClass();

		String jpql = "SELECT t FROM " + clazz.getSimpleName() + " t";

		return getEntityManager().createQuery(jpql, clazz).getResultList();

	}

	public EntityManagerFactory getEntityManagerFactory() throws GlobalException  {

		if (this.entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			startEntityManagerFactory();
		}
		return entityManagerFactory;
	}

	public void startEntityManagerFactory() throws GlobalException  {
		startEntityManagerFactory("eCommerceJPA");
	}

	public void startEntityManagerFactory(String persistenceUnit)

			throws GlobalException {

		if (this.entityManagerFactory == null) {

			try {
				entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);

			}

			catch (Exception e) {

				Logger.getLogger(ServiceEntity.class.getName()).log(Level.SEVERE, "error: ", e);

				throw new GlobalException();

			}

		}

	}

	public void stopEntityManagerFactory() throws GlobalException {

		if (entityManagerFactory != null) {

			if (entityManagerFactory.isOpen()) {

				try {

					entityManagerFactory.close();

				}

				catch (Exception e) {

					Logger.getLogger(ServiceEntity.class.getName()).log(

							Level.SEVERE, "error: ", e);

					throw new GlobalException();

				}

			}

			entityManagerFactory = null;

		}

	}

}