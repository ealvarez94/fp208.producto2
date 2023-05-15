package com.example.demo.service;

import com.example.demo.interfaceService.IplatoService;
import com.example.demo.interfaces.IPlato;
import com.example.demo.modelo.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements IplatoService {

    @Autowired
    private IPlato data;

    @Override
    public List<Plato> listar() {

        return (List<Plato>)data.findAll();
    }

    @Override
    public Optional<Plato> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Plato p) {
        int res=0;
        Plato plato=data.save(p);
        if(!plato.equals(null)) {
            res = 1;
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}


