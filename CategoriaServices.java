package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Categoria;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.CategoriaRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.ICategoriaServices;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class CategoriaServices implements ICategoriaServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaServices.class); // Logger para registrar
                                                                                           // eventos y errores.

    @Autowired // Inyección de dependencias para el repositorio de categorías.
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria createcategoria(Categoria categoria) {
        try {
            return categoriaRepository.save(categoria); // Guarda la nueva categoría en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear estudiante: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Categoria> listCategoria() {
        try {
            return categoriaRepository.findAll(); // Devuelve todas las categorías de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while deleting categoria: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Categoria getCategoriaById(int Id_categoria) {
        // Busca una categoría por su ID y lanza una excepción si no se encuentra.
        return categoriaRepository.findById(Id_categoria)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public Categoria updateCategoria(int id, Categoria categoria) {
        // Busca la categoría existente por su ID.
        Optional<Categoria> existingCategoria = categoriaRepository.findById(id);
        if (existingCategoria.isPresent()) {
            Categoria updatedCategoria = existingCategoria.get();
            updatedCategoria.setDescripcion(categoria.getDescripcion()); // Actualiza la descripción.
            return categoriaRepository.save(updatedCategoria); // Guarda la categoría actualizada.
        }
        return null; // Retorna null si la categoría no existe.
    }

    @Override
    public HashMap<String, String> deletecategoria(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            categoriaRepository.deleteById(Id); // Elimina la categoría por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar user: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
