package com.example.demo.controler;

import com.example.demo.interfaceService.IpedidoService;
import com.example.demo.modelo.Pedido;
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
public class PedidoControlador {

    @Autowired
    private IpedidoService service;

    @GetMapping("/pedidos")
    public String listar(Model model) {
        List<Pedido>pedido=service.listar();
        model.addAttribute("pedidos", pedido);
        return "pedidos";
    }

    @GetMapping("/new-pedido")
    public String agregar(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "form-pedido";
    }

    @PostMapping("/save-pedido")
    public String save(@Validated Pedido p, Model model) {
        service.save(p);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar-pedido/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Pedido>pedido=service.listarId(id);
        model.addAttribute("pedido", pedido);
        return "form-pedido";
    }

    @GetMapping("/eliminar-pedido/{id}")
    public  String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/pedidos";
    }
}
