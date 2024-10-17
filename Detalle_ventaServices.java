package com.BackendDollarStoreA.BackendDollarStoreA.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.hibernate.mapping.List;*/
import org.slf4j.Logger;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Detalle_venta;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.Detalle_ventaRepository;
import com.BackendDollarStoreA.BackendDollarStoreA.Repository.IDetalle_ventaServices;
import java.util.HashMap;

@Service // Indica que esta clase es un servicio, manejado por Spring.
public class Detalle_ventaServices implements IDetalle_ventaServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(Detalle_ventaServices.class); // Logger para registrar
                                                                                               // eventos y errores.

    @Autowired // Inyección de dependencias para el repositorio de detalles de venta.
    Detalle_ventaRepository detalle_ventaRepository;

    @Override
    public Detalle_venta createdetalle_venta(Detalle_venta detalle_venta) {
        try {
            return detalle_ventaRepository.save(detalle_venta); // Guarda el nuevo detalle de venta en la base de datos.
        } catch (Exception e) {
            LOGGER.error("Error al crear detalle_venta: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al crear un user"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public List<Detalle_venta> listDetalle_venta() {
        try {
            return detalle_ventaRepository.findAll(); // Devuelve todos los detalles de venta de la base de datos.
        } catch (Exception e) {
            LOGGER.error(String.format("Error while deleting detalle_venta: %s", e.getMessage())); // Registra el error.
            throw new RuntimeException("Error listing users"); // Lanza una excepción en caso de error.
        }
    }

    @Override
    public Detalle_venta getDetalle_ventaById(int Id_detalle_v) {
        // Busca un detalle de venta por su ID y lanza una excepción si no se encuentra.
        return detalle_ventaRepository.findById(Id_detalle_v)
                .orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));
    }

    @Override
    public Detalle_venta updateDetalle_venta(int id, Detalle_venta detalle_venta) {
        // Busca el detalle de venta existente por su ID.
        Optional<Detalle_venta> existingDetalle_venta = detalle_ventaRepository.findById(id);
        if (existingDetalle_venta.isPresent()) {
            Detalle_venta updatedDetalle_venta = existingDetalle_venta.get();
            // Actualiza los atributos del detalle de venta.
            updatedDetalle_venta.setCantidad(detalle_venta.getCantidad());
            updatedDetalle_venta.setPrecio_unitario(detalle_venta.getPrecio_unitario());
            updatedDetalle_venta.setId_venta(detalle_venta.getId_venta());
            updatedDetalle_venta.setId_producto(detalle_venta.getId_producto());
            return detalle_ventaRepository.save(updatedDetalle_venta); // Guarda el detalle de venta actualizado.
        }
        return null; // Retorna null si el detalle de venta no existe.
    }

    @Override
    public HashMap<String, String> deletedetalle_venta(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted successfully!"); // Mensaje de éxito.
            detalle_ventaRepository.deleteById(Id); // Elimina el detalle de venta por su ID.
            return response; // Retorna la respuesta.
        } catch (Exception e) {
            LOGGER.error("Error al borrar user: {}", e.getMessage()); // Registra el error.
            throw new RuntimeException("Error al borrar user"); // Lanza una excepción en caso de error.
        }
    }
}
