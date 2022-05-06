package dao.cliente;

import java.util.*;
import java.sql.*;
import dao.OracleDAOFactory;
import modelo.Cliente;

/**
 * Implementação do dao de cliente para o banco de dados Oracle.
 *
 */
public class OracleClienteDAO extends OracleDAOFactory implements ClienteDAO, OracleClienteMetaDados {

    /**
     * Executa uma consulta de cliente no bando de dados.
     *
     * @param sql Um sql com uma consulta a cliente.
     * @return Uma lista com os objetos clientes resultantes do Select.
     */
    private List select(String sql) {
        LinkedList lista = new LinkedList();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt("CLIENTEID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                lista.add(cliente);
            }
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {;
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {;
                }
                con = null;
            }
        }
        return lista;
    }

    /**
     * Realiza a inserção dos dados de cliente.
     *
     * @param objetoCliente Um objeto cliente a ser inserido.
     *
     * @return Verdadeiro ou falso se conseguiu fazer a inclusão.
     */
    @Override
    public boolean inserir(Object objetoCliente) {
        if (objetoCliente != null) {
            Cliente cliente = (Cliente) objetoCliente;
            Connection con = null;
            Statement stmt = null;
            boolean res = false;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("insert into " + TABLE + "(");
                sql.append(METADADOSINSERT + " ) ");

                sql.append("values ('" + preparaSQL(cliente.getClienteId() + ""));
                sql.append("','" + preparaSQL(cliente.getNome() + ""));
                sql.append("','" + preparaSQL(cliente.getCpf()) + "')");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString()) > 0;
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                System.out.println(e);
                res = false;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {;
                    }
                    stmt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {;
                    }
                    con = null;
                }
            }
            return res;
        }
        return false;
    }

    /**
     * Realiza a atualizado dos dados de cliente.
     *
     * @param objetoCliente Um objeto cliente a ser atualizado.
     *
     * @return Verdadeiro ou falso se conseguiu fazer a atualização.
     */
    @Override
    public int atualizar(Object objetoCliente) {
        if (objetoCliente != null) {
            Cliente cliente = (Cliente) objetoCliente;
            Connection con = null;
            Statement stmt = null;
            int res = 0;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("update " + TABLE);
                sql.append(" set NOME='" + cliente.getNome() + "'");
                sql.append(",CPF='" + cliente.getCpf() + "'");
                sql.append(" where " + TABLE + "." + PK[0] + "='" + preparaSQL(cliente.getClienteId() + "") + "'");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                System.out.println(e);
                res = 0;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {;
                    }
                    stmt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {;
                    }
                    con = null;
                }
            }
            return res;
        }
        return 0;
    }

    /**
     * Exclui um registro de cliente do banco de dados.
     *
     * @param objetoCliente Um objeto cliente com o Id a ser excluído.
     * @return A quantidade de registros excluídos.
     */
    @Override
    public int apagar(Object objetoCliente) {
        if (objetoCliente != null) {
            Cliente cliente = (Cliente) objetoCliente;
            Connection con = null;
            Statement stmt = null;

            StringBuilder sql = new StringBuilder();
            int res = 0;
            try {
                sql.append("delete from " + TABLE + " where " + TABLE + "." + PK[0] + " = '" + preparaSQL(cliente.getClienteId() + "") + "'");
                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (Exception e) {
                System.out.println(e);
                res = 0;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {;
                    }
                    stmt = null;
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {;
                    }
                    con = null;
                }
            }
            return res;
        }
        return 0;
    }

    /**
     * Recupera todos os objetos clientes do banco de dados.
     *
     * @return Uma lista com todos os objetos cliente do banco de dados.
     */
    @Override
    public List getLista() {
        return select("select " + METADADOSSELECT + " from " + TABLE + " order by " + TABLE + "." + PK[0]);
    }

    /**
     * Aplica uma filtragem nos dados de cliente.
     *
     * @param objetoCliente Objeto cliente com os dados a serem filtrados.
     * @return Uma lista de objetos clientes que atendem os dados.
     */
    @Override
    public List aplicarFiltro(Object objetoCliente) {
        if (objetoCliente != null) {
            Cliente cliente = (Cliente) objetoCliente;

            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("select " + METADADOSSELECT + " from " + TABLE);

            List filtros = new ArrayList();

            if (cliente.getClienteId() != -1) {
                filtros.add(TABLE + "." + PK[0] + "='" + preparaSQL(cliente.getClienteId() + "") + "'");
            }

            if (cliente.getNome() != null && !"".equals(cliente.getNome())) {
                filtros.add(TABLE + ".NOME like upper('%" + preparaSQL(cliente.getNome()) + "%')");
            }

            if (!filtros.isEmpty()) {
                sqlBuilder.append(" where " + implode(" and ", filtros));
            }

            sqlBuilder.append(" order by " + TABLE + "." + PK[0]);

            return select(sqlBuilder.toString());
        } else {
            return null;
        }
    }

    /**
     * Recupera um objeto cliente do banco de dados apartir do seu Id.
     *
     * @param objetoCliente Um objeto cliente com o Id a ser recuperado.
     *
     * @return Um objeto cliente do banco de dados ou null se não encontrar o
     * cliente.
     */
    @Override
    public Cliente recuperarPelaChave(Object objetoCliente) {

        //Aplica o filtro
        List lista = aplicarFiltro(objetoCliente);

        //Verifica a lita não está vazia
        if (!lista.isEmpty()) {
            //Retorna o primeiro objeto da lista
            return (Cliente) lista.get(0);
        } else {
            return null;
        }
    }
}
