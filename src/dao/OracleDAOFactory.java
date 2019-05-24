package dao;

import java.util.*;
import java.sql.*;
import dao.cliente.ClienteDAO;
import dao.cliente.OracleClienteDAO;

/**
 * Implementação da Fábrica para o banco de dados Oracle.
 *
 */
public class OracleDAOFactory extends DAOFactory {

    private String driverClass;
    private String jdbcURL;
    private String usuario;
    private String senha;

    /**
     * Construtor sem parâmetros.
     */
    public OracleDAOFactory() {
        setDriverClass(OracleDadosBanco.DRIVER);
        setJdbcURL("jdbc:oracle:thin:@" + OracleDadosBanco.SERVIDOR + ":" + OracleDadosBanco.PORTA + ":" + OracleDadosBanco.DATABASE);
        setUsuario(OracleDadosBanco.USUARIO);
        setSenha(OracleDadosBanco.SENHA);
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna uma conexão com o banco de dados.
     *
     * @return Um objeto Connection aberto.
     * @throws SQLException
     */
    protected Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(getDriverClass());
            con = DriverManager.getConnection(getJdbcURL(), getUsuario(), getSenha());
        } catch (ClassNotFoundException e) {
            System.out.println("O Driver JDBC não foi encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            if (e.getMessage().contains("Unknown database")) {
                System.out.println("O DataBase não existe!");
                e.printStackTrace();
            } else {
                if (e.getMessage().contains("Access denied")) {
                    System.out.println("Os dados do usuário login e senha estão incorretos! \nVerifique o arquivo OracleDadosBanco.java");
                    e.printStackTrace();
                } else {
                    if (e.getMessage().contains("Communication")) {
                        System.out.println("O servidor de banco de dados nao esta acessível. \nVerifique se o banco de dados foi iniciado. \nVerique o endereço e/ou porta do servidor no arquivo OracleDadosBanco.java");
                        e.printStackTrace();
                    } else {
                        System.out.println("Erro na conexão!" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        return con;
    }

    /**
     * Operação para prepara a string que será enviada ao banco de dados Se ela
     * possui uma ' serã duplicada para anular o efeito de sql injetado
     *
     * @return String texto com ' duplicado
     * @param valor string a ser preparada para envio ao banco de dados
     */
    protected String preparaSQL(String valor) {
        if (valor != null) {
            return valor.replaceAll("\'", "''");
        } else {
            return "";
        }
    }

    /**
     * Concatena String bareado nos valores Strings de uma Collection
     *
     * @param separator
     * @param collection
     * @return String
     */
    public String implode(String separator, Collection collection) {
        StringBuffer textBufferReturn = new StringBuffer();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String text = (String) it.next();
            textBufferReturn.append(text);
            if (it.hasNext()) {
                textBufferReturn.append(separator);
            }
        }
        return textBufferReturn.toString();
    }

    /**
     * Retorna uma Cliente DAO
     *
     * @return ClienteDAO Um DAO para cliente
     */
    public ClienteDAO getClienteDAO() {
        return new OracleClienteDAO();
    }
}
