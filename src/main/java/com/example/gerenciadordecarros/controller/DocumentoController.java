package com.example.gerenciadordecarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gerenciadordecarros.domain.Documento;
import com.example.gerenciadordecarros.service.DocumentoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService DocumentoService;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("documentos/listar");
        mv.addObject("documentos", DocumentoService.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("documentos/cadastrar");
        mv.addObject("documento", new Documento());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(Documento documento) {
    	DocumentoService.save(documento);
        return "redirect:/documentos/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id) {
    	DocumentoService.delete(id);
        return "redirect:/documentos/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) throws ObjectNotFoundException {
        ModelAndView mv = new ModelAndView("documentos/editar");
        mv.addObject("documento", DocumentoService.findOne(id));
        return mv;
    }

    @PostMapping("/atualizar")
    public String atualizar(Documento documento) throws ObjectNotFoundException {
    	DocumentoService.update(documento);
        return "redirect:/documentos/listar";
    }

}
