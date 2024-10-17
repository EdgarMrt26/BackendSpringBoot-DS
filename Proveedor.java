package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proveedor {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_proveedor;
    private String Compayia;
    private String Telefono;
    private String Correo_electronico;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Proveedor() {
    }

    // Constructor que permite crear un objeto Proveedor con todos sus atributos.
    public Proveedor(String compayia, String telefono, String correo_electronico) {
        this.Compayia = compayia;
        this.Telefono = telefono;
        this.Correo_electronico = correo_electronico;
    }

}
