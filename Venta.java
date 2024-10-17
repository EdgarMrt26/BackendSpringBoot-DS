package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_venta;
    private Date Fecha;
    private int Id_cliente;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Venta() {
    }

    // Constructor que permite crear un objeto Venta con todos sus atributos.
    public Venta(Date fecha, int id_cliente) {
        this.Fecha = fecha;
        this.Id_cliente = id_cliente;
    }

}