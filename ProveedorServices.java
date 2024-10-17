package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Proveedor;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.ProveedorRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IProveedorServices;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class ProveedorServices implements IProveedorServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorServices.class); // Logger para registrar
                                                                                           // eventos y errores.

    @Autowired // Inyección de dependencias para el repositorio de proveedores.
    ProveedorRepository proveedorRepository;

    @Override
    public Proveedor createproveedor(Proveedor proveedor) {
        try {
            return proveedorRepository.save(proveedor); // Guarda el nuevo proveedor en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear proveedor: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Proveedor> listProveedor() {
        try {
            return proveedorRepository.findAll(); // Devuelve todos los proveedores de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while listing proveedor: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Proveedor getProveedorById(int Id_proveedor) {
        // Busca un proveedor por su ID y lanza una excepción si no se encuentra.
        return proveedorRepository.findById(Id_proveedor)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public Proveedor updateProveedor(int id, Proveedor proveedor) {
        // Busca el proveedor existente por su ID.
        Optional<Proveedor> existingProveedor = proveedorRepository.findById(id);
        if (existingProveedor.isPresent()) {
            Proveedor updatedProveedor = existingProveedor.get();
            // Actualiza los atributos del proveedor.
            updatedProveedor.setCompayia(proveedor.getCompayia());
            updatedProveedor.setTelefono(proveedor.getTelefono());
            updatedProveedor.setCorreo_electronico(proveedor.getCorreo_electronico());
            return proveedorRepository.save(updatedProveedor); // Guarda el proveedor actualizado.
        }
        return null; // Retorna null si el proveedor no existe.
    }

    @Override
    public HashMap<String, String> deleteproveedor(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            proveedorRepository.deleteById(Id); // Elimina el proveedor por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar user: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
