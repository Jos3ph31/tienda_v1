package com.tienda.controller;

import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")//Ejecuta lo de la plantilla del listado y crea un URL 
    public String listado(Model model){
        
        var categorias = categoriaService.getCategorias(false); //trae todas las categorias activas e inactivas 
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        
        return "/categoria/listado"; //es un folder en trmplates que vamos a crear
    }
    
    //agrega más información la próxima semana
}
