package dao;

/**
 * Interface que armazena os dados de configuracao do banco de dados Oracle.
 *
 */
public interface OracleDadosBanco {

    //Altere aqui os dados do seu banco de dados	
    public String USUARIO = "cliente";
    public String SENHA = "cliente";
    public String SERVIDOR = "localhost";
    public String DATABASE = "XE";
    public String DRIVER = "oracle.jdbc.OracleDriver";
    public String PORTA = "1521";
}
