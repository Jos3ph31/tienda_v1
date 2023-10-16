
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se declara un método para obtener un arrayList de Objetos Categoria
    // Los objetos vienen de la tabla categoría 
    
    public List<Categoria> getCategorias (boolean activos);
    
    //Abajo se colocará los métodos para realizar el CRUD de categorías, semana 6
    
}
