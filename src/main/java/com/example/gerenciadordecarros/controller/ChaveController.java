package com.example.gerenciadordecarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gerenciadordecarros.domain.Chave;
import com.example.gerenciadordecarros.service.ChaveService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("chaves")
public class ChaveController {

    @Autowired
    private ChaveService Chaveservice;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("chaves/listar");
        mv.addObject("chaves", Chaveservice.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("chaves/cadastrar");
        mv.addObject("chave", new Chave());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(Chave chave) {
    	Chaveservice.save(chave);
        return "redirect:/chaves/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id) {
    	Chaveservice.delete(id);
        return "redirect:/chaves/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) throws ObjectNotFoundException {
        ModelAndView mv = new ModelAndView("chaves/editar");
        mv.addObject("chave", Chaveservice.findOne(id));
        return mv;
    }

    @PostMapping("/atualizar")
    public String atualizar(Chave chave) throws ObjectNotFoundException {
    	Chaveservice.update(chave);
        return "redirect:/chaves/listar";
    }

}
