package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Categoria {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_categoria;
    private String Descripcion;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Categoria() {

    }

    // Constructor que permite crear un objeto Categoria con todos sus atributos.
    public Categoria(String descripcion) {
        this.Descripcion = descripcion;
    }
}
