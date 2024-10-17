package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import org.springframework.stereotype.Repository;
import com.BackendDollarStoreA.BackendDollarStoreA.Models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository // Componente de acceso a datos manejados por Spring
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
