package com.example.demo.controler;

import com.example.demo.interfaceService.IplatoService;
import com.example.demo.modelo.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class PlatoControlador {

    @Autowired
    private IplatoService service;

    @GetMapping("/platos")
    public String listar(Model model) {
        List<Plato>platos=service.listar();
        model.addAttribute("platos", platos);
        return "platos";
    }

    @GetMapping("/new-plato")
    public String agregar(Model model) {
        model.addAttribute("plato", new Plato());
        return "form-plato";
    }

    @PostMapping("/save-plato")
    public String save(@Validated Plato p, Model model) {
        service.save(p);
        return "redirect:/platos";
    }

    @GetMapping("/editar-plato/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Plato>plato=service.listarId(id);
        model.addAttribute("plato", plato);
        return "form-plato";
    }

    @GetMapping("/eliminar-plato/{id}")
    public  String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/platos";
    }
}
