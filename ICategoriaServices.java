package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Categoria;

import java.util.HashMap;
import java.util.List;

public interface ICategoriaServices {
    // Método para crear una nueva categoria
    public Categoria createcategoria(Categoria categoria);

    // Método para Listar Categorias
    public List<Categoria> listCategoria();

    // Método para Actualiza Categorías
    Categoria updateCategoria(int id, Categoria categoria);

    // Método para obtener categorías
    public Categoria getCategoriaById(int Id_categoria);

    // Método para eliminar categorias
    public HashMap<String, String> deletecategoria(int Id);
}
