package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Venta;
import java.util.HashMap;
import java.util.List;

/*import org.hibernate.mapping.List;*/

public interface IVentaServices {
    // Método para crear Venta
    public Venta createventa(Venta venta);

    // Método para listar Venta
    public List<Venta> listVenta();

    // Método para actualizar Venta
    Venta updateVenta(int id, Venta venta);

    // Método para obtener Venta
    public Venta getVentaById(int Id_venta);

    // Método para eliminar Venta
    public HashMap<String, String> deleteventa(int Id);

}
