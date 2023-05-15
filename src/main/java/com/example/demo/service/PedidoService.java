package com.example.demo.service;

import com.example.demo.interfaceService.IpedidoService;
import com.example.demo.interfaces.IPedido;
import com.example.demo.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IpedidoService {

    @Autowired
    private IPedido data;

    @Override
    public List<Pedido> listar() {

        return (List<Pedido>)data.findAll();
    }

    @Override
    public Optional<Pedido> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Pedido p) {
        int res=0;
        Pedido pedido=data.save(p);
        if(!pedido.equals(null)){
            res=1;
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
