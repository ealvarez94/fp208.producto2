package com.example.demo.interfaceService;
import com.example.demo.modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface IclienteService {
    List<Cliente>listar();
    Optional<Cliente>listarId(int id);
    int save(Cliente p);
    void delete(int id);
}
