package Principal;

import Armazenamento.Persistencia;

import javax.swing.*;
import java.awt.*;

public class Aplicativo {
    public static void main(String[] args) {
        //Conexão com Banco de Dados pela classe Persistencia
        Persistencia.conectar();
    }
}
