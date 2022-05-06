package visao;

import dao.DAOFactory;
import dao.Factory;
import modelo.Cliente;
import dao.cliente.ClienteDAO;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.util.Iterator;

/**
 * Classe que implementa a interface principal do sistema.
 */
public class FrmCliente extends JFrame {

    //Container da janela
    private JPanel contentPane;

    //Atributos de rótulo e caixas de texto
    private JLabel jLClienteId;
    private JTextField jTClienteId;
    private JLabel jLNome;
    private JTextField jTNome;
    private JLabel jLCpf;
    private JTextField jTCpf;

    //Botões da janela
    private JButton jBInserir;
    private JButton jBListar;
    private JButton jBAlterar;
    private JButton jBExcluir;
    private JButton jBConsultar;
    private JButton jBLimpar;
    private JButton jBSair;

    /**
     * Construtor sem argumentos do FrmCliente
     */
    public FrmCliente() {
        //Chamo metodo que inicializa os componentes da interface grafica
        inicializar();
    }

    /**
     * Metodo que inicializa os componentes da interface grafica
     */
    private void inicializar() {
        //Recupero o container da janela
        contentPane = (JPanel) this.getContentPane();

        //Instancia os componentes
        jLClienteId = new JLabel();
        jTClienteId = new JTextField();
        jLNome = new JLabel();
        jTNome = new JTextField();
        jLCpf = new JLabel();
        jTCpf = new JTextField();

        jBInserir = new JButton();
        jBListar = new JButton();
        jBAlterar = new JButton();
        jBExcluir = new JButton();
        jBConsultar = new JButton();
        jBLimpar = new JButton();
        jBSair = new JButton();

        //Deixo nulo o layout do container
        contentPane.setLayout(null);

        //Defino o tamanho da janela
        this.setSize(new Dimension(310, 250));

        //Defino o titulo da janela
        this.setTitle("Cadastro de Cliente");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Tamanho e configuração dos componentes
        jLClienteId.setBounds(new Rectangle(11, 11, 60, 17));
        jTClienteId.setBounds(new Rectangle(11, 28, 70, 21));
        jLClienteId.setText("ClienteId");

        jLNome.setBounds(new Rectangle(11, 60, 60, 17));
        jTNome.setBounds(new Rectangle(11, 75, 180, 21));
        jLNome.setText("Nome");

        jLCpf.setBounds(new Rectangle(11, 109, 170, 17));
        jTCpf.setBounds(new Rectangle(11, 124, 120, 21));
        jLCpf.setText("CPF");

        jBInserir.setBounds(new Rectangle(200, 9, 90, 27));
        jBInserir.setText("Inserir");

        jBListar.setBounds(new Rectangle(200, 39, 90, 27));
        jBListar.setText("Listar");

        jBAlterar.setBounds(new Rectangle(200, 69, 90, 27));
        jBAlterar.setText("Alterar");

        jBExcluir.setBounds(new Rectangle(200, 99, 90, 27));
        jBExcluir.setText("Excluir");

        jBConsultar.setBounds(new Rectangle(200, 129, 90, 27));
        jBConsultar.setText("Consultar");

        jBLimpar.setBounds(new Rectangle(200, 159, 90, 27));
        jBLimpar.setText("Limpar");

        jBSair.setBounds(new Rectangle(200, 189, 90, 27));
        jBSair.setText("Sair");

        //Adiciona os componentes no container	
        contentPane.add(jLClienteId, null);
        contentPane.add(jTClienteId, null);
        contentPane.add(jLNome, null);
        contentPane.add(jTNome, null);
        contentPane.add(jLCpf, null);
        contentPane.add(jTCpf, null);

        contentPane.add(jBInserir, null);
        contentPane.add(jBListar, null);
        contentPane.add(jBAlterar, null);
        contentPane.add(jBExcluir, null);
        contentPane.add(jBConsultar, null);
        contentPane.add(jBLimpar, null);
        contentPane.add(jBSair, null);

        //Associa os eventos aos componentes da interface grafica
        associarEventos();
    }

    /**
     * Método para mostrar mensagem.
     *
     * Emcapsula o JOptionPane.
     *
     * @param mensagem Mensagem a ser exibida.
     */
    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Método que define o evento do botao fechar da janela.
     */
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    /**
     * Metodo que associa os metodos das operacoes nos eventos dos botoes.
     * Utiliza classes internas anonimas para realizar a associacao.
     */
    public void associarEventos() {
        jBInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBInserir_actionPerformed(e);
            }
        });

        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBListar_actionPerformed(e);
            }
        });

        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBAlterar_actionPerformed(e);
            }
        });

        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBExcluir_actionPerformed(e);
            }
        });

        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBConsultar_actionPerformed(e);
            }
        });

        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBLimpar_actionPerformed(e);
            }
        });

        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBSair_actionPerformed(e);
            }
        });
    }

    /**
     * Metodo para realizar a inclusão no banco de dados
     */
    void jBInserir_actionPerformed(ActionEvent e) {
        if (!jTClienteId.getText().equals("")) {
            //Instancio um cliente para passar ao gerente com os dados a serem incluidos
            Cliente cliente = new Cliente();

            //Preencho o objeto com os dados do formulario                        
            cliente.setClienteId(jTClienteId.getText());
            cliente.setNome(jTNome.getText());
            cliente.setCpf(jTCpf.getText());

            //Instancio o DAO
            DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
            ClienteDAO clienteDAO = factory.getClienteDAO();

            if (clienteDAO.inserir(cliente)) {
                mostrarMensagem("Cliente inserido com sucesso!");
            } else {
                mostrarMensagem("Cliente não inserido!");
            }
        } else {
            mostrarMensagem("Preencha os dados do cliente para realizar a inserção!");
        }
    }

    /**
     * Metodo para realizar a alteração no banco de dados
     */
    void jBAlterar_actionPerformed(ActionEvent e) {
        if (!jTClienteId.getText().equals("")) {
            //Instancio um cliente para passar ao dado com os dados a serem alterados
            Cliente cliente = new Cliente();

            //Preencho o objeto com os dados do formulario                        
            cliente.setClienteId(jTClienteId.getText());
            cliente.setNome(jTNome.getText());
            cliente.setCpf(jTCpf.getText());

            //Instancio o DAO
            DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
            ClienteDAO clienteDAO = factory.getClienteDAO();

            if (clienteDAO.atualizar(cliente) != 0) {
                mostrarMensagem("Cliente atualizado com sucesso!");
            } else {
                mostrarMensagem("Cliente não atualizado!");
            }
        } else {
            mostrarMensagem("Preencha o Id do cliente e execute a consulta antes de realizar a alteração!");
        }
    }

    /**
     * Metodo para realizar a consulta no banco de dados
     */
    void jBConsultar_actionPerformed(ActionEvent e) {
        if (!jTClienteId.getText().equals("")) {
            //Instancio o DAO
            DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
            ClienteDAO clienteDAO = factory.getClienteDAO();
            //Recupero o cliente com o id
            Cliente cliente = clienteDAO.recuperarPelaChave(new Cliente(jTClienteId.getText(), "", ""));
            //Verifico se o cliente foi encontrado
            if (cliente != null) {
                jTClienteId.setText(cliente.getClienteId() + "");
                jTNome.setText(cliente.getNome());
                jTCpf.setText(cliente.getCpf());
            } else {
                mostrarMensagem("Cliente não encontrado");
            }
        } else {
            mostrarMensagem("Preencha o Id do cliente antes de executar a consulta!");
        }
    }

    /**
     * Metodo para realizar a exclusao no banco de dados
     */
    void jBExcluir_actionPerformed(ActionEvent e) {
        if (!jTClienteId.getText().equals("")) {
            //Instancio o DAO
            DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
            ClienteDAO clienteDAO = factory.getClienteDAO();
            //Recupero o cliente com o id
            Cliente cliente = clienteDAO.recuperarPelaChave(new Cliente(jTClienteId.getText(), "", ""));
            //Verifico se o cliente foi encontrado
            if (cliente != null) {
                jTClienteId.setText(cliente.getClienteId() + "");
                jTNome.setText(cliente.getNome());
                jTCpf.setText(cliente.getCpf());
                Object[] options = {"Sim", "Não"};
                int opcao = JOptionPane.showOptionDialog(null, "Voce deseja realmente excluir?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    if (clienteDAO.apagar(new Cliente(jTClienteId.getText(), "", "")) != 0) {
                        mostrarMensagem("Exclusão realizada com sucesso!");
                        jTClienteId.setText("");
                        jTNome.setText("");
                        jTCpf.setText("");
                    } else {
                        mostrarMensagem("Exclusão não realizada!");
                    }
                } else {
                    mostrarMensagem("Exclusão cancelada!");
                }
            } else {

                mostrarMensagem("Cliente nao encontrado!");
            }
        } else {
            mostrarMensagem("Preencha o Id do cliente antes de executar a exclusão!");
        }
    }

    /**
     * Metodo para realizar a limpeza dos campos do formulário
     */
    void jBLimpar_actionPerformed(ActionEvent e) {
        //Limpa as caixas de texto do formulário
        jTClienteId.setText("");
        jTNome.setText("");
        jTCpf.setText("");
    }

    /**
     * Metodo para realizar a listagem dos dados do banco de dados
     */
    void jBListar_actionPerformed(ActionEvent e) {
        //Cria um textArea para exibir os dados
        JTextArea textArea = new JTextArea(10, 30);
        //Deixa o textarea editavel
        textArea.setEditable(false);
        //Coloca um painel de rolagem ao textArea
        JScrollPane painelRolagem = new JScrollPane(textArea);
        String linha = "";
        //Instancio o DAO
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clienteDAO = factory.getClienteDAO();
        //Recupro um interador com uma lista de todos clientes no banco de dados	        
        Iterator it = clienteDAO.getLista().iterator();
        //Percorro a lista de clientes enquanto existir cliente
        while (it.hasNext()) {
            //Recupero um cliente da lista	
            Cliente cliente = (Cliente) it.next();
            //Concateno a os dados cliente em uma String
            linha = linha + cliente.paraString() + "\n";
        }
        //Coloco a string no textArea
        textArea.setText(linha);
        //Mostro o textArea com o JOptionPane
        JOptionPane.showMessageDialog(null, painelRolagem, "Relatorio de Cliente", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método para sair o sistema
     */
    void jBSair_actionPerformed(ActionEvent e) {
        //Fecho o sistema
        System.exit(0);
    }
}
