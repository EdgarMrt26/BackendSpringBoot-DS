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
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Detalle_venta;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IDetalle_ventaServices;
import java.util.HashMap;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/Detalle_ventaController") // Define la ruta base para las peticiones.
public class Detalle_ventaController {
    @Autowired // Inyección de dependencias para los servicios de detalle de venta.
    IDetalle_ventaServices detalle_ventaServices;

    @PostMapping("/insertardetalle_venta") // Ruta para crear un nuevo detalle de venta.
    public ResponseEntity<Detalle_venta> createdetalle_venta(@RequestBody Detalle_venta detalle_venta) {
        try {
            Detalle_venta createdDetalle_venta = detalle_ventaServices.createdetalle_venta(detalle_venta);
            return new ResponseEntity<>(createdDetalle_venta, HttpStatus.CREATED); // Retorna el detalle creado con
                                                                                   // estado 201.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/listardetalle_venta") // Ruta para listar todos los detalles de venta.
    public ResponseEntity<List<Detalle_venta>> listDetalle_venta() {
        try {
            List<Detalle_venta> detalle_venta = detalle_ventaServices.listDetalle_venta();
            return new ResponseEntity<>(detalle_venta, HttpStatus.OK); // Retorna la lista con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/busquedaDetalle_venta/{Id_detalle_v}") // Ruta para buscar un detalle de venta por ID.
    public ResponseEntity<Detalle_venta> getDetalle_ventaById(@PathVariable int Id_detalle_v) {
        try {
            Detalle_venta detalle_venta = detalle_ventaServices.getDetalle_ventaById(Id_detalle_v);
            if (detalle_venta != null) {
                return new ResponseEntity<>(detalle_venta, HttpStatus.OK); // Retorna el detalle con estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @PutMapping("/actualizardetalle_venta/{id}") // Ruta para actualizar un detalle de venta.
    public ResponseEntity<Detalle_venta> updateDetalle_venta(@PathVariable int id,
            @RequestBody Detalle_venta detalle_venta) {
        try {
            Detalle_venta updatedDetalle_venta = detalle_ventaServices.updateDetalle_venta(id, detalle_venta);
            if (updatedDetalle_venta != null) {
                return new ResponseEntity<>(updatedDetalle_venta, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            // Puedes registrar el error aquí para más detalles.
            System.err.println("Error actualizando detalle_venta: " + e.getMessage()); // Registra el error.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @DeleteMapping("/eliminardetalle_venta/{id}") // Ruta para eliminar un detalle de venta.
    public ResponseEntity<HashMap<String, String>> deletedetalle_venta(@PathVariable int id) {
        try {
            HashMap<String, String> response = detalle_ventaServices.deletedetalle_venta(id);
            return new ResponseEntity<>(response, HttpStatus.OK); // Retorna la respuesta con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }
}
