package com.example.demo.service;

import com.example.demo.interfaceService.IclienteService;
import com.example.demo.interfaces.ICliente;
import com.example.demo.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IclienteService {

    @Autowired
    private ICliente data;

    @Override
    public List<Cliente> listar() {

        return (List<Cliente>)data.findAll();
    }

    @Override
    public Optional<Cliente> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Cliente p) {
        int res=0;
        Cliente cliente=data.save(p);
        if(!cliente.equals(null)) {
            res = 1;
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}


