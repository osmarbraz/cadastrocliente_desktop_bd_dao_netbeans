package dao;

/**
 * Interface que armazena os dados de configuracao do banco de dados MySQL.
 *
 */
public interface MySQLDadosBanco {

    //Altere aqui os dados do seu banco de dados	
    public String USUARIO = "root";
    public String SENHA = "";
    public String SERVIDOR = "localhost";
    public String DATABASE = "cliente";
    public String DRIVER = "com.mysql.jdbc.Driver";
    public String PORTA = "3306";
}
