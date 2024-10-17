package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Marca {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_marca;
    private String Nombre_marca;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Marca() {

    }

    // Constructor que permite crear un objeto Marca con todos sus atributos.
    public Marca(String nombre_marca) {
        this.Nombre_marca = nombre_marca;
    }
}
