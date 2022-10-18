package com.example.gerenciadordecarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gerenciadordecarros.domain.Acessorio;
import com.example.gerenciadordecarros.service.AcessorioService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioService AcesorioService;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("acessorios/listar");
        mv.addObject("acessorios", AcesorioService.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("acessorios/cadastrar");
        mv.addObject("acessorio", new Acessorio());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(Acessorio acessorio) {
    	AcesorioService.save(acessorio);
        return "redirect:/acessorios/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id) {
    	AcesorioService.delete(id);
        return "redirect:/acessorios/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) throws ObjectNotFoundException {
        ModelAndView mv = new ModelAndView("acessorios/editar");
        mv.addObject("acessorio", AcesorioService.findOne(id));
        return mv;
    }

    @PostMapping("/atualizar")
    public String atualizar(Acessorio acessorio) throws ObjectNotFoundException {
    	AcesorioService.update(acessorio);
        return "redirect:/acessorios/listar";
    }

}
