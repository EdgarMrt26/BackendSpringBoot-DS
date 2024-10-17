package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Productos;
import java.util.HashMap;
import java.util.List;

/*import org.hibernate.mapping.List;*/

public interface IProductosServices {
    // Método para crear Productos
    public Productos createproductos(Productos productos);

    // Método para listar Productos
    public List<Productos> listProductos();

    // Método para actualizar Productos
    Productos updateProductos(int id, Productos productos);

    // Método para obtener Productos
    public Productos getProductosById(int Id_producto);

    // Método para eliminar Productos
    public HashMap<String, String> deleteproductos(int Id);

}
