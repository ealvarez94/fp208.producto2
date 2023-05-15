package com.example.demo.controler;

import com.example.demo.interfaceService.IclienteService;
import com.example.demo.modelo.Cliente;
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
public class ClienteControlador {

    @Autowired
    private IclienteService service;

    @GetMapping("/clientes")
    public String listar(Model model) {
        List<Cliente> clientes=service.listar();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/new-cliente")
    public String agregar(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "form-cliente";
    }

    @PostMapping("/save-cliente")
    public String save(@Validated Cliente p, Model model) {
        service.save(p);
        return "redirect:/clientes";
    }

    @GetMapping("/editar-cliente/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Cliente>cliente=service.listarId(id);
        model.addAttribute("cliente", cliente);
        return "form-cliente";
    }

    @GetMapping("/eliminar-cliente/{id}")
    public  String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/clientes";
    }

}
