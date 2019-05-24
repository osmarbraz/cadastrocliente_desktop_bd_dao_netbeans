package dao;

import dao.cliente.ClienteDAO;

/**
 * Fábrica abstrata para escolher o banco de dados a ser utilizado.
 *
 */
public abstract class DAOFactory {

    //Tipos de Fonte de Dados suportados pela Factory
    public static final int ORACLE = 1;
    public static final int MYSQL = 2;

    /**
     * Método a ser implementado pelas fábricas respectivas.
     *
     * @return Um dado de cliente.
     */
    public abstract ClienteDAO getClienteDAO();

    /**
     * Retorna a Factory do tipo especificado.
     *
     * @param qualFabrica Especifica o tipo da fábrica a ser utilizado.
     *
     * @return A fábrica instãnciada.
     */
    public static DAOFactory getDAOFactory(int qualFabrica) {
        switch (qualFabrica) {
            case ORACLE:
                return new OracleDAOFactory();
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
