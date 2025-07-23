/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.crud.dao;

import com.antonio.crud.entities.Categoria;
import com.antonio.crud.orm.JPAUtils;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Professor
 */
public class CategoriaDao extends GenericDao<Categoria, Long>{
    
    public CategoriaDao(Class<Categoria> entityClass) {
        super(entityClass);
    }
    
    // Métodos próprios do CategoriaDao
    public List<Categoria> findByName(String nome){
        EntityManager em = JPAUtils.getEntityManager();
        try{
            return em.createQuery("SELECT c from Categoria c WHERE c.nome LIKE :nome",
                    Categoria.class).setParameter("nome", "%"+nome+"%")
                    .getResultList();
        }finally{
            em.close();
        }
    }
    
}
