package com.BackendDollarStoreA.BackendDollarStoreA.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Detalle_venta {
    @Id // Indica que este campo es la clave primaria de la entidad.
    private int Id_detalle_v;
    private int Cantidad;
    private Double Precio_unitario;
    private int Id_venta;
    private int Id_producto;

    // Constructor vacío, necesario para JPA y Hibernate.
    public Detalle_venta() {
    }

    // Constructor que permite crear un objeto Detalle_venta con todos sus
    // atributos.
    public Detalle_venta(int cantidad, Double precio_unitario, int id_venta, int id_producto) {
        this.Cantidad = cantidad;
        this.Precio_unitario = precio_unitario;
        this.Id_venta = id_venta;
        this.Id_producto = id_producto;
    }

}
