package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Marca;
import java.util.HashMap;
import java.util.List;

public interface IMarcaServices {
    // Método para crear una Marca
    public Marca createmarca(Marca marca);

    // Método para listar Marca
    public List<Marca> listMarca();

    // Método para actualizar Marca
    Marca updateMarca(int id, Marca marca);

    // Método para obtener Marca
    public Marca getMarcaById(int Id_marca);

    // Método para eliminar Marca
    public HashMap<String, String> deletemarca(int Id);
}
