package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Marca;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.MarcaRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IMarcaServices;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class MarcaServices implements IMarcaServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarcaServices.class); // Logger para registrar eventos
                                                                                       // y errores.

    @Autowired // Inyección de dependencias para el repositorio de marcas.
    MarcaRepository marcaRepository;

    @Override
    public Marca createmarca(Marca marca) {
        try {
            return marcaRepository.save(marca); // Guarda la nueva marca en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear marca: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Marca> listMarca() {
        try {
            return marcaRepository.findAll(); // Devuelve todas las marcas de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while listing marca: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Marca getMarcaById(int Id_marca) {
        // Busca una marca por su ID y lanza una excepción si no se encuentra.
        return marcaRepository.findById(Id_marca)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    }

    @Override
    public Marca updateMarca(int id, Marca marca) {
        // Busca la marca existente por su ID.
        Optional<Marca> existingMarca = marcaRepository.findById(id);
        if (existingMarca.isPresent()) {
            Marca updatedMarca = existingMarca.get();
            updatedMarca.setNombre_marca(marca.getNombre_marca()); // Actualiza el nombre de la marca.
            return marcaRepository.save(updatedMarca); // Guarda la marca actualizada.
        }
        return null; // Retorna null si la marca no existe.
    }

    @Override
    public HashMap<String, String> deletemarca(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            marcaRepository.deleteById(Id); // Elimina la marca por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar user: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
