package dao.cliente;

import modelo.Cliente;

import java.util.List;

/**
 * DAO é um Design Pattern que encapsula e abstrai o acesso aos dados.
 *
 * Operações para acesso aos dados de cliente.
 *
 */
public interface ClienteDAO {

    public boolean inserir(Object objetoCliente);

    public int atualizar(Object objetoCliente);

    public int apagar(Object objetoCliente);

    public List aplicarFiltro(Object objetoCliente);

    public Cliente consultarChave(Object objetoCliente);

    public List consultarTudo();

}
