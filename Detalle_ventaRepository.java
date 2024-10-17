package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import org.springframework.stereotype.Repository;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Detalle_venta;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository // Componente de acceso a datos manejados por Spring
public interface Detalle_ventaRepository extends JpaRepository<Detalle_venta, Integer> {

}