package Principal;

import java.sql.*;

public class Crud {

    //Variável superglobal para conexão com Banco de Dados
    private static Connection connection;

    public static void main(String[] args) {
        /* Vai tentar executar a conexão com o banco de dados e,
        * caso uma exceção relacionada ao banco seja lançada, fará
        * o tratamento da mesma */
        try{
            //Conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            //Script sql para criação da tabela veiculos no banco test
            PreparedStatement stm = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS veiculos(codigo INT, modelo TEXT, cor TEXT)"
            );

            //Execução do script sql criado acima no banco test
            stm.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }

        /* EXEMPLOS CRUD */

        //Inserindo valores
        inserirVeiculo(1, "Jeep", "Azul");
        inserirVeiculo(2, "Corsa", "Branco");
        inserirVeiculo(3, "Cruze", "Verde");
        inserirVeiculo(4, "Pálio", "Cinza");
        inserirVeiculo(5, "Onix", "Prata");

        //Atualizando valores
        atualizarVeiculo(5, "Fusca", "Azul");

        //Visualizando valores
        mostrarVeiculo();

        //Deletando valores
        excluirVeiculo(4);
    }

    /*MÉTODOS PARA REALIZAR O CRUD*/

    //Método de inserção
    private static void inserirVeiculo(int codigo, String modelo, String cor){
        try{
            //As interogações indicam que aqueles valores serão passados posteriormente
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO veiculos(codigo, modelo, cor) VALUES(?, ?, ?)"
            );

            //Valores dos parâmetros do método passados como valores no banco
            stm.setInt(1, codigo);
            stm.setString(2, modelo);
            stm.setString(3, cor);

            stm.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //Método de atualização
    private static void atualizarVeiculo(int codigo, String modelo, String cor){
        try{
           PreparedStatement stm = connection.prepareStatement(
                   "UPDATE veiculos SET modelo = ?, cor = ? WHERE codigo = ?"
           );

           stm.setString(1, modelo);
           stm.setString(2, cor);
           stm.setInt(3, codigo);

           stm.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //Método de seleção/visualização
    private static void mostrarVeiculo(){
        try{
            PreparedStatement stm = connection.prepareStatement(
                    "SELECT * FROM veiculos"
            );

            //Executar comando sql de visualização e guardando os registros obtidos na variável resultSet
            ResultSet resultSet = stm.executeQuery();

            while(resultSet.next()){
                int codigo = resultSet.getInt("codigo");
                String modelo = resultSet.getString("modelo");
                String cor = resultSet.getString("cor");

                System.out.println("Código: " + codigo);
                System.out.println("Modelo: " + modelo);
                System.out.println("Cor: " + cor);
                System.out.println(" ");
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //Método de deleção
    private static void excluirVeiculo(int codigo){
        try{
            PreparedStatement stm = connection.prepareStatement(
                    "DELETE FROM veiculos WHERE codigo = ?"
            );

            stm.setInt(1, codigo);

            stm.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}
