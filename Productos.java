package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Productos {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_producto;
    private String Descripcion;
    private int Cantidad;
    private Double Precio_producto;
    private int Existencia;
    private int Id_marca;
    private int Id_categoria;
    private Byte Calificacion;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Productos() {
    }

    // Constructor que permite crear un objeto Producto con todos sus atributos.
    public Productos(String descripcion, int cantidad, Double precio_producto, int existencia, int id_marca,
            int id_categoria, Byte calificacion) {
        this.Descripcion = descripcion;
        this.Cantidad = cantidad;
        this.Precio_producto = precio_producto;
        this.Existencia = existencia;
        this.Id_marca = id_marca;
        this.Id_categoria = id_categoria;
        this.Calificacion = calificacion;
    }

}
