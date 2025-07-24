/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.crud.dao;

import com.antonio.crud.entities.Usuario;
import com.antonio.crud.orm.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

/**
 *
 * @author Professor
 */
public class UsuarioDao extends GenericDao<Usuario, Long> {

    public UsuarioDao(Class<Usuario> entityClass) {
        super(entityClass);
    }

    public Usuario findByEmailAndPassword(String email, String password) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha",
                    Usuario.class
            ).setParameter("email", email)
                    .setParameter("senha", password)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {

        }
    }

}
