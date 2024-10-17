package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.hibernate.mapping.List;*/
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Venta;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.VentaRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IVentaServices;
import java.util.HashMap;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class VentaServices implements IVentaServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(VentaServices.class); // Logger para registrar eventos
                                                                                       // y errores.

    @Autowired // Inyección de dependencias para el repositorio de ventas.
    VentaRepository ventaRepository;

    @Override
    public Venta createventa(Venta venta) {
        try {
            return ventaRepository.save(venta); // Guarda la nueva venta en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear la venta: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Venta> listVenta() {
        try {
            return ventaRepository.findAll(); // Devuelve todas las ventas de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while listing ventas: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Venta getVentaById(int Id_venta) {
        // Busca una venta por su ID y lanza una excepción si no se encuentra.
        return ventaRepository.findById(Id_venta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Venta updateVenta(int id, Venta venta) {
        // Busca la venta existente por su ID.
        Optional<Venta> existingVenta = ventaRepository.findById(id);
        if (existingVenta.isPresent()) {
            Venta updatedVenta = existingVenta.get();
            // Actualiza los atributos de la venta.
            updatedVenta.setFecha(venta.getFecha());
            updatedVenta.setId_cliente(venta.getId_cliente());
            return ventaRepository.save(updatedVenta); // Guarda la venta actualizada.
        }
        return null; // Retorna null si la venta no existe.
    }

    @Override
    public HashMap<String, String> deleteventa(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            ventaRepository.deleteById(Id); // Elimina la venta por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar venta: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
