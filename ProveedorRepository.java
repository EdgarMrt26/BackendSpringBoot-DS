package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import org.springframework.stereotype.Repository;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository // Componente de acceso a datos manejados por Spring
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

}