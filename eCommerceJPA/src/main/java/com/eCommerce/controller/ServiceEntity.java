package com.eCommerce.controller;

import com.eCommerce.controller.*;


public class ServiceEntity<E> extends ServiceEntityManager<E> {



    public void insert(E item) throws GlobalException, DataNotFoundException {
        if (item == null) {
            throw new DataNotFoundException();
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(item);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
        }
        catch (Exception e) {
        	e.printStackTrace();
            throw new GlobalException();
        }

    }



    public void update(E item) throws GlobalException, DataNotFoundException {



        if (item == null) {

            throw new DataNotFoundException();

        }

        

        try {

            getEntityManager().getTransaction().begin();

            getEntityManager().merge(item);

            getEntityManager().flush();

            getEntityManager().getTransaction().commit();

        }

        catch (Exception e) {

            // getEntityManager().getTransaction().rollback();

            throw new GlobalException();

        }

    }



    public void delete(E item) throws GlobalException, DataNotFoundException {



        if (item == null) {

            throw new DataNotFoundException();

        }



        try {

            getEntityManager().getTransaction().begin();

            item = getEntityManager().merge(item);

            getEntityManager().remove(item);

            getEntityManager().getTransaction().commit();

        }

        catch (Exception e) {

            throw new GlobalException();

        }

    }

}