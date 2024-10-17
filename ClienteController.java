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
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Cliente;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IClienteServices;
import java.util.HashMap;

@RestController // Indica que esta clase es un controlador REST, manejando solicitudes HTTP.
@RequestMapping("/ClienteController") // Definición de la Base de la URL para todas las rutas
public class ClienteController {
    @Autowired // Inyecta automáticamente la implementación de IClienteServices.
    IClienteServices clienteServices;

    // Método para crear un nuevo cliente.
    @PostMapping("/insertarcliente") // Mapea las solicitudes POST a esta ruta.
    public ResponseEntity<Cliente> createcliente(@RequestBody Cliente cliente) {
        try {
            // Llama al servicio para crear un cliente y guarda el resultado.
            Cliente createdCliente = clienteServices.createcliente(cliente);
            // Devuelve el cliente creado con un estado 201 (CREATED).
            return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            // En caso de error, devuelve un estado 500 (INTERNAL SERVER ERROR).
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para listar todos los clientes.
    @GetMapping("/listarcliente") // Mapea las solicitudes GET a esta ruta.
    public ResponseEntity<List<Cliente>> listCliente() {
        try {
            // Llama al servicio para obtener la lista de clientes.
            List<Cliente> cliente = clienteServices.listCliente();
            // Devuelve la lista de clientes con un estado 200 (OK).
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            // En caso de error, devuelve un estado 500 (INTERNAL SERVER ERROR).
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para buscar un cliente por su ID.
    @GetMapping("/busquedaCliente/{Id_cliente}") // Mapea las solicitudes GET a esta ruta con un parámetro de ruta.
    public ResponseEntity<Cliente> getClienteById(@PathVariable int Id_cliente) {
        try {
            // Llama al servicio para obtener el cliente por ID.
            Cliente cliente = clienteServices.getClienteById(Id_cliente);
            if (cliente != null) {
                // Si el cliente existe, devuelve el cliente con un estado 200 (OK).
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            } else {
                // Si no se encuentra, devuelve un estado 404 (NOT FOUND).
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // En caso de error, devuelve un estado 500 (INTERNAL SERVER ERROR).
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un cliente existente.
    @PutMapping("/actualizarcliente/{id}") // Ruta para actualizar una cliente
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        try {
            // Llama al servicio para actualizar el cliente.
            Cliente updatedCliente = clienteServices.updateCliente(id, cliente);
            if (updatedCliente != null) {
                // Si se actualiza correctamente, devuelve el cliente actualizado con un estado
                // 200 (OK).
                return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
            } else {
                // Si no se encuentra el cliente, devuelve un estado 404 (NOT FOUND).
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Registra el error para depuración y devuelve un estado 500 (INTERNAL SERVER
            // ERROR).
            System.err.println("Error actualizando cliente: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un cliente.
    @DeleteMapping("/eliminarcliente/{id}") // Mapea las solicitudes DELETE a esta ruta con un parámetro de ruta.
    public ResponseEntity<HashMap<String, String>> deletecliente(@PathVariable int id) {
        try {
            // Llama al servicio para eliminar el cliente y obtiene la respuesta.
            HashMap<String, String> response = clienteServices.deletecliente(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
            // Devuelve la respuesta con un estado 200 (OK).
        } catch (Exception e) {
            // En caso de error, devuelve un estado 500 (INTERNAL SERVER ERROR).
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
