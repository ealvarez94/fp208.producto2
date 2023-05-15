package com.example.demo.interfaceService;
import com.example.demo.modelo.Plato;

import java.util.List;
import java.util.Optional;

public interface IplatoService {
    List<Plato>listar();
    Optional<Plato>listarId(int id);
    int save(Plato p);
    void delete(int id);
}
