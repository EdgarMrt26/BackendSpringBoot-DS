package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.hibernate.mapping.List;*/
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Productos;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.ProductosRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IProductosServices;
import java.util.HashMap;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class ProductosServices implements IProductosServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductosServices.class); // Logger para registrar
                                                                                           // eventos y errores.

    @Autowired // Inyección de dependencias para el repositorio de productos.
    ProductosRepository productosRepository;

    @Override
    public Productos createproductos(Productos productos) {
        try {
            return productosRepository.save(productos); // Guarda el nuevo producto en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear productos: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Productos> listProductos() {
        try {
            return productosRepository.findAll(); // Devuelve todos los productos de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while listing productos: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Productos getProductosById(int Id_producto) {
        // Busca un producto por su ID y lanza una excepción si no se encuentra.
        return productosRepository.findById(Id_producto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Productos updateProductos(int id, Productos productos) {
        // Busca el producto existente por su ID.
        Productos existingProductos = productosRepository.findById(id).orElse(null);

        if (existingProductos != null) {
            // Actualiza los atributos del producto.
            existingProductos.setDescripcion(productos.getDescripcion());
            existingProductos.setCantidad(productos.getCantidad());
            existingProductos.setPrecio_producto(productos.getPrecio_producto());
            existingProductos.setExistencia(productos.getExistencia());
            existingProductos.setId_marca(productos.getId_marca());
            existingProductos.setId_categoria(productos.getId_categoria());
            existingProductos.setCalificacion(productos.getCalificacion());

            return productosRepository.save(existingProductos); // Guarda el producto actualizado.
        } else {
            throw new RuntimeException("Producto no encontrado"); // Lanza una excepción si el producto no existe.
        }
    }

    @Override
    public HashMap<String, String> deleteproductos(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            productosRepository.deleteById(Id); // Elimina el producto por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar user: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
