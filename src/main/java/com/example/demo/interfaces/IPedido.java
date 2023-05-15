package com.example.demo.interfaces;

import com.example.demo.modelo.Pedido;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedido extends CrudRepository<Pedido, Integer> {

}
