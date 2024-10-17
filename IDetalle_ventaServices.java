package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Detalle_venta;

import java.util.HashMap;
import java.util.List;

/*import org.hibernate.mapping.List;*/

public interface IDetalle_ventaServices {
    // Método para crear un detalle_venta
    public Detalle_venta createdetalle_venta(Detalle_venta detalle_venta);

    // Método para listar detalle_venta
    public List<Detalle_venta> listDetalle_venta();

    // Método para actualizar un detalle_venta
    Detalle_venta updateDetalle_venta(int id, Detalle_venta detalle_venta);

    // Método para obtener un detalle_venta
    public Detalle_venta getDetalle_ventaById(int Id_detalle_v);

    // Método para eliminar un detalle_venta
    public HashMap<String, String> deletedetalle_venta(int Id);

}
