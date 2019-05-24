package dao;

/**
 * Permite selecionar qual banco de dados da fábrica abstrata será utilizado.
 *
 */
public interface Factory {

    /**
     * Mude o valor de FABRICA para trocar o banco de dados.
     */
    public static final int FABRICA = 2;

}
