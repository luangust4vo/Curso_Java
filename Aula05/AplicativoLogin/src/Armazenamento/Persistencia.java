package Armazenamento;

import Modelos.Pessoa;

import java.sql.*;
import java.util.HashMap;

public class Persistencia {

    public static Connection connection;
    public static HashMap<String, Pessoa> pessoas = new HashMap<>();

    public static void conectar() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            PreparedStatement stm = connection.prepareStatement("create table if not exists pessoas(usuario TEXT, senha TEXT)");

            stm.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        carregarPessoas();
    }

    public static void carregarPessoas() {
        try {
            PreparedStatement stm = connection.prepareStatement("select * from pessoas");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.usuario = rs.getString("usuario");
                pessoa.senha = rs.getString("senha");

                pessoas.put(pessoa.usuario.toLowerCase(), pessoa);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void inserir(Pessoa pessoa) {
        try {

            PreparedStatement stm = connection.prepareStatement("insert into pessoas(usuario, senha) values(?,?)");

            stm.setString(1, pessoa.usuario);
            stm.setString(2, pessoa.senha);

            stm.executeUpdate();

            pessoas.put(pessoa.usuario.toLowerCase(), pessoa);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean temCadastro(String usuario) {
        return pessoas.containsKey(usuario.toLowerCase());
    }

    public static void deletar(String usuario) {
        try {

            PreparedStatement stm = connection.prepareStatement("delete from pessoas where usuario = ?");

            stm.setString(1, usuario);

            stm.executeUpdate();

            pessoas.remove(usuario.toLowerCase());
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void mudarSenha(Pessoa pessoa, String novaSenha) {
        pessoa.senha = novaSenha;
        try {

            PreparedStatement stm = connection.prepareStatement("update pessoas set senha = ? where usuario = ?");

            stm.setString(1, pessoa.senha);
            stm.setString(2, pessoa.usuario);

            stm.executeUpdate();

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
