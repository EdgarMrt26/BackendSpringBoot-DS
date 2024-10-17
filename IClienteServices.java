package com.BackendDollarStoreA.BackendDollarStoreA.Repository;

import com.BackendDollarStoreA.BackendDollarStoreA.Models.Cliente;
import java.util.HashMap;
import java.util.List;

/*import org.hibernate.mapping.List;*/

public interface IClienteServices {
    // Método para crear un nuevo cliente
    public Cliente createcliente(Cliente cliente);

    // Método para listar clientes
    public List<Cliente> listCliente();

    // Método para Actualizar clientes
    Cliente updateCliente(int id, Cliente cliente);

    // Método para obtener clientes
    public Cliente getClienteById(int Id_cliente);

    // Método para eliminar clientes
    public HashMap<String, String> deletecliente(int Id);

}
