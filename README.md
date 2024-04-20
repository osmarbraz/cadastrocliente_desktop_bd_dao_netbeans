# Sistema de Cadastro de Clientes para Desktop em Banco de Dados Oracle ou MySQL utilizando o padrão Abstract Factory para a IDE NetBeans.

## Contextualização

 - Esta é uma versão do sistema para a IDE NetBeans.<br> 
 - O projeto no NetBeans deve ser chamado cadastrocliente_desktop_bd_dao_netbeans.<br>
 - Este programa possui diversas classes organizada nos pacotes, principal, visao, modelo e dao.<br>
 - Utiliza o padrão abstract factory para abstrair os bancos de dados Oracle e MySQL.
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - Os dados de configuração(Servidor, Database, Usuario, Senha) da integração do java com o banco de dados estão no arquivo src/DadosBanco.java.<br>
 - A especificação da fábrica a ser utilizada é feita na interface Fabrica.java.
 - Crie o banco de dados antes de executar o projeto, as especificações das tabelas estão no arquivo banco_mysql.sql e banco_oracle.sql.<br>
 - A pasta src contêm os fontes do projeto.<br>

## Arquivos

- *.sql - Script do banco de daddos.
- pom.xml - Arquivo de configurção da ferramenta de automação Maven.