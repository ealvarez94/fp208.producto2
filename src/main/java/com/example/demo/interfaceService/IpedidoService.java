package com.example.demo.interfaceService;

import com.example.demo.modelo.Pedido;

import java.util.List;
import java.util.Optional;

public interface IpedidoService {
    public List<Pedido>listar();
    public Optional<Pedido>listarId(int id);
    public int save(Pedido p);
    public void delete(int id);
}
