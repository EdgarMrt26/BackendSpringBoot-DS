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
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Marca;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IMarcaServices;
import java.util.HashMap;
import java.util.List;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/MarcaController") // Define la ruta base para las peticiones.
public class MarcaController {
    @Autowired // Inyección de dependencias para los servicios de marca.
    IMarcaServices marcaServices;

    @PostMapping("/insertarmarca") // Ruta para crear una nueva marca.
    public ResponseEntity<Marca> createmarca(@RequestBody Marca marca) {
        try {
            Marca createdMarca = marcaServices.createmarca(marca); // Crea la marca.
            return new ResponseEntity<>(createdMarca, HttpStatus.CREATED); // Retorna la marca creada con estado 201.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/listarmarca") // Ruta para listar todas las marcas.
    public ResponseEntity<List<Marca>> listMarca() {
        try {
            List<Marca> marca = marcaServices.listMarca(); // Obtiene la lista de marcas.
            return new ResponseEntity<>(marca, HttpStatus.OK); // Retorna la lista con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/busquedaMarca/{Id_marca}") // Ruta para buscar una marca por ID.
    public ResponseEntity<Marca> getMarcaById(@PathVariable int Id_marca) {
        try {
            Marca marca = marcaServices.getMarcaById(Id_marca); // Busca la marca.
            if (marca != null) {
                return new ResponseEntity<>(marca, HttpStatus.OK); // Retorna la marca con estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @PutMapping("/actualizarmarca/{id}") // Ruta para actualizar una marca.
    public ResponseEntity<Marca> updateMarca(@PathVariable int id, @RequestBody Marca marca) {
        try {
            Marca updatedMarca = marcaServices.updateMarca(id, marca); // Actualiza la marca.
            if (updatedMarca != null) {
                return new ResponseEntity<>(updatedMarca, HttpStatus.OK); // Retorna la marca actualizada con estado
                                                                          // 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            // Puedes registrar el error aquí para más detalles.
            System.err.println("Error actualizando marca: " + e.getMessage()); // Registra el error.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @DeleteMapping("/eliminarmarca/{id}") // Ruta para eliminar una marca.
    public ResponseEntity<HashMap<String, String>> deletemarca(@PathVariable int id) {
        try {
            HashMap<String, String> response = marcaServices.deletemarca(id); // Elimina la marca.
            return new ResponseEntity<>(response, HttpStatus.OK); // Retorna la respuesta con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }
}
