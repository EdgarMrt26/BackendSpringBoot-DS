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
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Categoria;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.ICategoriaServices;
import java.util.HashMap;
import java.util.List;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/CategoriaController") // Define la ruta base para las peticiones.
public class CategoriaController {
    @Autowired // Inyección de dependencias para los servicios de categoría.
    ICategoriaServices categoriaServices;

    @PostMapping("/insertarcategoria") // Ruta para crear una nueva categoría.
    public ResponseEntity<Categoria> createcategoria(@RequestBody Categoria categoria) {
        try {
            Categoria createdCategoria = categoriaServices.createcategoria(categoria); // Crea la categoría.
            return new ResponseEntity<>(createdCategoria, HttpStatus.CREATED); // Retorna la categoría creada con estado
                                                                               // 201.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/listarcategoria") // Ruta para listar todas las categorías.
    public ResponseEntity<List<Categoria>> listCategoria() {
        try {
            List<Categoria> categoria = categoriaServices.listCategoria(); // Obtiene la lista de categorías.
            return new ResponseEntity<>(categoria, HttpStatus.OK); // Retorna la lista con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @GetMapping("/busquedaCategoria/{Id_categoria}") // Ruta para buscar una categoría por ID.
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable int Id_categoria) {
        try {
            Categoria categoria = categoriaServices.getCategoriaById(Id_categoria); // Busca la categoría.
            if (categoria != null) {
                return new ResponseEntity<>(categoria, HttpStatus.OK); // Retorna la categoría con estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @PutMapping("/actualizarcategoria/{id}") // Ruta para actualizar una categoría.
    public ResponseEntity<Categoria> updateCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        try {
            Categoria updatedCategoria = categoriaServices.updateCategoria(id, categoria); // Actualiza la categoría.
            if (updatedCategoria != null) {
                return new ResponseEntity<>(updatedCategoria, HttpStatus.OK); // Retorna la categoría actualizada con
                                                                              // estado 200.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna error 404 si no se encuentra.
            }
        } catch (Exception e) {
            // Puedes registrar el error aquí para más detalles.
            System.err.println("Error actualizando categoria: " + e.getMessage()); // Registra el error.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }

    @DeleteMapping("/eliminarcategoria/{id}") // Ruta para eliminar una categoría.
    public ResponseEntity<HashMap<String, String>> deletecategoria(@PathVariable int id) {
        try {
            HashMap<String, String> response = categoriaServices.deletecategoria(id); // Elimina la categoría.
            return new ResponseEntity<>(response, HttpStatus.OK); // Retorna la respuesta con estado 200.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna error 500 en caso de fallo.
        }
    }
}
