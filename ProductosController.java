package com.BackendDollarStoreA.BackendDollarStoreA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Productos;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IProductosServices;
import java.util.HashMap;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/ProductosController") // Define la ruta base para las peticiones.
public class ProductosController {
    @Autowired // Inyección de dependencias para los servicios de productos.
    IProductosServices productosServices;

    @PostMapping("/insertarproductos") // Ruta para crear un nuevo producto.
    public ResponseEntity<Productos> createproductos(@RequestBody Productos productos) {
        try {
            Productos createdProductos = productosServices.createproductos(productos); // Crea el producto.
            return new ResponseEntity<>(createdProductos, HttpStatus.CREATED); // Retorna el producto creado con estado
                                                                               // 201.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/listarproductos") // Ruta para listar todos los productos.
    public ResponseEntity<List<Productos>> listProductos() {
        try {
            List<Productos> productos = productosServices.listProductos(); // Obtiene la lista de productos.
            return new ResponseEntity<>(productos, HttpStatus.OK); // Retorna la lista con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/busquedaproductos/{Id_producto}") // Ruta para buscar un producto por ID.
    public ResponseEntity<Productos> getProductosById(@PathVariable int Id_producto) {
        try {
            Productos productos = productosServices.getProductosById(Id_producto); // Busca el producto.
            if (productos != null) {
                return new ResponseEntity<>(productos, HttpStatus.OK); // Retorna el producto con estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @PutMapping("/actualizarproductos/{id}") // Ruta para actualizar un producto.
    public ResponseEntity<Productos> updateProductos(@PathVariable int id, @RequestBody Productos productos) {
        try {
            Productos updatedProductos = productosServices.updateProductos(id, productos); // Actualiza el producto.
            if (updatedProductos != null) {
                return new ResponseEntity<>(updatedProductos, HttpStatus.OK); // Retorna el producto actualizado con
                                                                              // estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            // Puedes registrar el error aquí para más detalles.
            System.err.println("Error actualizando productos: " + e.getMessage()); // Registra el error.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @DeleteMapping("/eliminarproductos/{id}") // Ruta para eliminar un producto.
    public ResponseEntity<HashMap<String, String>> deleteproductos(@PathVariable int id) {
        try {
            HashMap<String, String> response = productosServices.deleteproductos(id); // Elimina el producto.
            return new ResponseEntity<>(response, HttpStatus.OK); // Retorna la respuesta con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }
}
