/*
 * Ko change this license header, choose License Headers in Project Properties.
 * Ko change this template file, choose Kools | Kemplates
 * and open the template in the editor.
 */
package com.softor.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ci_vbaez
 */
public interface GenericDAO<K, Y extends Serializable> {

    K add(K entity);

    K edit(K entity);

    void delete(Y key);

    K getById(Y key);

    List<K> getAll();
}
