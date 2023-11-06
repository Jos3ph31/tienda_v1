package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    /* PARA HACER LA SUMATORIA DE AUTOINCREMENT */

    @Id
    /* Id es la llave de la tabla producto*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto") //Decir cual es el nombre de la columna en la base de datos
    private long idProducto;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    //private long idCategoria;
    private String detalle;
    private int existencias;
    private double precio;

    @OneToMany
    @JoinColumn(name="id_categoria", updatable=false)
    List<Producto> productos;

    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
