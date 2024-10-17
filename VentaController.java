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
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Venta;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IVentaServices;
import java.util.HashMap;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/VentaController") // Define la ruta base para las peticiones.
public class VentaController {
    @Autowired // Inyección de dependencias para los servicios de ventas.
    IVentaServices ventaServices;

    @PostMapping("/insertarventa") // Ruta para crear una nueva venta.
    public ResponseEntity<Venta> createventa(@RequestBody Venta venta) {
        try {
            Venta createdVenta = ventaServices.createventa(venta); // Crea la venta.
            return new ResponseEntity<>(createdVenta, HttpStatus.CREATED); // Retorna la venta creada con estado 201.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/listarventa") // Ruta para listar todas las ventas.
    public ResponseEntity<List<Venta>> listVenta() {
        try {
            List<Venta> venta = ventaServices.listVenta(); // Obtiene la lista de ventas.
            return new ResponseEntity<>(venta, HttpStatus.OK); // Retorna la lista con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/busquedaVenta/{Id_venta}") // Ruta para buscar una venta por ID.
    public ResponseEntity<Venta> getVentaById(@PathVariable int Id_venta) {
        try {
            Venta venta = ventaServices.getVentaById(Id_venta); // Busca la venta.
            if (venta != null) {
                return new ResponseEntity<>(venta, HttpStatus.OK); // Retorna la venta con estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @PutMapping("/actualizarventa/{id}") // Ruta para actualizar una venta.
    public ResponseEntity<Venta> updateVenta(@PathVariable int id, @RequestBody Venta venta) {
        try {
            Venta updatedVenta = ventaServices.updateVenta(id, venta); // Actualiza la venta.
            if (updatedVenta != null) {
                return new ResponseEntity<>(updatedVenta, HttpStatus.OK); // Retorna la venta actualizada con estado
                                                                          // 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            // Puedes registrar el error aquí para más detalles.
            System.err.println("Error actualizando venta: " + e.getMessage()); // Registra el error.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @DeleteMapping("/eliminarventa/{id}") // Ruta para eliminar una venta.
    public ResponseEntity<HashMap<String, String>> deleteventa(@PathVariable int id) {
        try {
            HashMap<String, String> response = ventaServices.deleteventa(id); // Elimina la venta.
            return new ResponseEntity<>(response, HttpStatus.OK); // Retorna la respuesta con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }
}
