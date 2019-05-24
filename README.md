# Sistema de Cadastro de Clientes para Desktop em Banco de Dados Oracle ou MySQL utilizando o padrão Abstract Factory.
 - Este programa possui diversas classes organizada nos pacotes visão, modelo e dao.<br>
 - 
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - Os dados de configuração(Servidor, Database, Usuario, Senha) da integração do java com o banco de dados estão no arquivo src/DadosBanco.java.<br>
 - Crie o banco de dados antes de executar o projeto, as especificações das tabelas estão no arquivo banco_mysql.sql e banco_oracle.sql.<br>
 - A pasta src contêm os fontes do projeto e na pasta  lib o driver jdbc para Oracle e MySQL.<br>