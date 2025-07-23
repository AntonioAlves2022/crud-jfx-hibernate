/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.antonio.crud.dao;

import java.util.List;

/**
 *
 * @author Professor
 */
public interface IGenercDao<T, ID> {

    void save(T entity);

    T findById(ID id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);
}
