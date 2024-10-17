package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Proveedor;
import java.util.HashMap;
import java.util.List;

public interface IProveedorServices {
    // Método para crear Proveedor
    public Proveedor createproveedor(Proveedor proveedor);

    // Método para listar Proveedor
    public List<Proveedor> listProveedor();

    // Método para actualizar Proveedor
    Proveedor updateProveedor(int id, Proveedor proveedor);

    // Método para obtener Proveedor
    public Proveedor getProveedorById(int Id_proveedor);

    // Método para eliminar Proveedor
    public HashMap<String, String> deleteproveedor(int Id);
}
