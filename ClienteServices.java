package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.hibernate.mapping.List;*/
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Cliente;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.ClienteRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IClienteServices;
import java.util.HashMap;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class ClienteServices implements IClienteServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServices.class); // Logger para registrar
                                                                                         // eventos y errores.

    @Autowired // Inyección de dependencias para el repositorio de clientes.
    ClienteRepository clienteRepository;

    @Override
    public Cliente createcliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente); // Guarda el nuevo cliente en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear estudiante: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Cliente> listCliente() {
        try {
            return clienteRepository.findAll(); // Devuelve todos los clientes de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while deleting estudiante: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Cliente getClienteById(int Id_cliente) {
        // Busca un cliente por su ID y lanza una excepción si no se encuentra.
        return clienteRepository.findById(Id_cliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente updateCliente(int id, Cliente cliente) {
        // Busca el cliente existente por su ID.
        Optional<Cliente> existingCliente = clienteRepository.findById(id);
        if (existingCliente.isPresent()) {
            Cliente updatedCliente = existingCliente.get();
            // Actualiza los atributos del cliente.
            updatedCliente.setNombre(cliente.getNombre());
            updatedCliente.setApellido(cliente.getApellido());
            updatedCliente.setTelefono(cliente.getTelefono());
            updatedCliente.setDireccion(cliente.getDireccion());
            return clienteRepository.save(updatedCliente); // Guarda el cliente actualizado.
        }
        return null; // Retorna null si el cliente no existe.
    }

    @Override
    public HashMap<String, String> deletecliente(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            clienteRepository.deleteById(Id); // Elimina el cliente por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar user: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
