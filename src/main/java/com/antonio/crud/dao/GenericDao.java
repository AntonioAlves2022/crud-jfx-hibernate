/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.crud.dao;

import com.antonio.crud.orm.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author Professor
 */
public abstract class GenericDao<T, ID> implements IGenercDao<T, ID> {

    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entity) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();

        try {
            trx.begin();
            em.persist(entity);
            trx.commit();
        } catch (Exception ex) {
            if (trx != null && trx.isActive()) {
                trx.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public T findById(ID id) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            return em
                    .createQuery("FROM " + entityClass.getSimpleName()+" ORDER BY id",
                            entityClass).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T entity) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();
        
        try{
            trx.begin();
            em.merge(entity);
            trx.commit();
        }catch(Exception ex){
            if(trx != null && trx.isActive()){
                trx.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }

    @Override
    public void delete(T entity) {
         EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();
        
        try{
            trx.begin();
            em.remove(em.contains(entity)? entity:em.merge(entity));
            trx.commit();
        }catch(Exception ex){
            if(trx != null && trx.isActive()){
                trx.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }

}
