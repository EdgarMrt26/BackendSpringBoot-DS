package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import org.springframework.stereotype.Repository;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository // Componente de acceso a datos manejados por Spring
public interface VentaRepository extends JpaRepository<Venta, Integer> {

}