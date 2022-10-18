package com.example.gerenciadordecarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gerenciadordecarros.domain.Fabricante;
import com.example.gerenciadordecarros.service.FabricanteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService FabricanteService;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("fabricantes/listar");
        mv.addObject("fabricantes", FabricanteService.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("fabricantes/cadastrar");
        mv.addObject("fabricante", new Fabricante());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(Fabricante fabricante) {
    	FabricanteService.save(fabricante);
        return "redirect:/fabricantes/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id) {
    	FabricanteService.delete(id);
        return "redirect:/fabricantes/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) throws ObjectNotFoundException {
        ModelAndView mv = new ModelAndView("fabricantes/editar");
        mv.addObject("fabricante", FabricanteService.findOne(id));
        return mv;
    }

    @PostMapping("/atualizar")
    public String atualizar(Fabricante fabricante) throws ObjectNotFoundException {
    	FabricanteService.update(fabricante);
        return "redirect:/fabricantes/listar";
    }

}
