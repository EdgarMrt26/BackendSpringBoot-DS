package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_cliente;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Direccion;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Cliente() {
    }

    // Constructor que permite crear un objeto Cliente con todos sus atributos.
    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Telefono = telefono;
        this.Direccion = direccion;
    }

}
