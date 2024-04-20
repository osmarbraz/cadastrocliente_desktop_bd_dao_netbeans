package principal;

import visao.FrmCliente;

/**
 * Classe que possui a operação main da aplicação.
 *
 * Serve para dar inicio ao sistema.
 *
 */
public class Principal {

    /**
     * Inicia a aplicação.
     *
     * @param args args
     */
    public static void main(String[] args) {
        //Instancio a classe da janela do cadastro de cliente
        FrmCliente frmCliente = new FrmCliente();
        //Deixo a janela visivel
        frmCliente.setVisible(true);
    }
}
