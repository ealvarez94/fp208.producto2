package com.example.demo.interfaces;

import com.example.demo.modelo.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlato extends CrudRepository<Plato, Integer> {

}
