package com.example.wizer.service;

import java.util.List;

/**
 * @author OKala III
 * on 5/16/2021
 */

public interface CRUDService<E, Dto> {


    E create(Dto e);

    List<E> create(List<Dto> d);

    E update(Dto d);

    List<E> update(List<Dto> d);

    Boolean delete(Long id);


    List<E> findAll();

    E findById(long id);



}
