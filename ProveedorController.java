package com.BackendDollarStoreA.BackendDollarStoreA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Proveedor;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IProveedorServices;
import java.util.HashMap;
import java.util.List;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/ProveedorController") // Define la ruta base para las peticiones.
public class ProveedorController {
    @Autowired // Inyección de dependencias para los servicios de proveedores.
    IProveedorServices proveedorServices;

    @PostMapping("/insertarproveedor") // Ruta para crear un nuevo proveedor.
    public ResponseEntity<Proveedor> createproveedor(@RequestBody Proveedor proveedor) {
        try {
            Proveedor createdProveedor = proveedorServices.createproveedor(proveedor); // Crea el proveedor.
            return new ResponseEntity<>(createdProveedor, HttpStatus.CREATED); // Retorna el proveedor creado con estado
                                                                               // 201.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/listarproveedor") // Ruta para listar todos los proveedores.
    public ResponseEntity<List<Proveedor>> listProveedor() {
        try {
            List<Proveedor> proveedor = proveedorServices.listProveedor(); // Obtiene la lista de proveedores.
            return new ResponseEntity<>(proveedor, HttpStatus.OK); // Retorna la lista con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/busquedaProveedor/{Id_proveedor}") // Ruta para buscar un proveedor por ID.
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable int Id_proveedor) {
        try {
            Proveedor proveedor = proveedorServices.getProveedorById(Id_proveedor); // Busca el proveedor.
            if (proveedor != null) {
                return new ResponseEntity<>(proveedor, HttpStatus.OK); // Retorna el proveedor con estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @PutMapping("/actualizarproveedor/{id}") // Ruta para actualizar un proveedor.
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        try {
            Proveedor updatedProveedor = proveedorServices.updateProveedor(id, proveedor); // Actualiza el proveedor.
            if (updatedProveedor != null) {
                return new ResponseEntity<>(updatedProveedor, HttpStatus.OK); // Retorna el proveedor actualizado con
                                                                              // estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            // Puedes registrar el error aquí para más detalles.
            System.err.println("Error actualizando proveedor: " + e.getMessage()); // Registra el error.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @DeleteMapping("/eliminarproveedor/{id}") // Ruta para eliminar un proveedor.
    public ResponseEntity<HashMap<String, String>> deleteproveedor(@PathVariable int id) {
        try {
            HashMap<String, String> response = proveedorServices.deleteproveedor(id); // Elimina el proveedor.
            return new ResponseEntity<>(response, HttpStatus.OK); // Retorna la respuesta con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }
}
