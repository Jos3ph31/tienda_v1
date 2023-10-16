package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    //La anotación autowired crea un único objeto mientras se ejecuta la aplicación 
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos){
        
        var lista = categoriaDao.findAll(); //encontrar todos los datos de la lista de la base de datos
        
        if(activos){
            lista.removeIf(e-> !e.isActivo());
        }
        
        return lista;
    }
}
