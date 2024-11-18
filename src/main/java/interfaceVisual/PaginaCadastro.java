package interfaceVisual;

import conexaoBancoDeDados.ConexaoBancoDeDados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PaginaCadastro extends JFrame{
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton cadastrarButton;
    private JPanel painelprincipal;
    private JPanel panelButton;
    private JPanel painelCadastro;

    public PaginaCadastro(){

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = nomeTextField.getText().trim();
                String emailCliente = emailTextField.getText().trim();
                String senhaCliente = passwordField.getText().trim();
                int numeroContaCliente = (int) (Math.random() * 9999);
                System.out.println(nomeCliente+"\n"+emailCliente+"\n"+senhaCliente);
                System.out.println("Cadastrado!");
                ConexaoBancoDeDados conexaobanco1 = new ConexaoBancoDeDados();
                try{conexaobanco1.inserirDadosContaBancaria(nomeCliente,emailCliente,senhaCliente,numeroContaCliente);}
                catch (SQLException ex){throw new RuntimeException(ex);}
                PaginaLogin paginaLogin = new PaginaLogin();
                paginaLogin.setVisible(true);
                paginaLogin.setSize(500,500);
                paginaLogin.setLocation(700,300);
                //fechando a pagina de cadastro
                //não há necessidade exclusiva de colocar o setVisible para false, pelo fato de o dispose(); já fechar o frame
                //coloquei mesmo assim para ver a diferença
                painelprincipal.setVisible(false);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        PaginaCadastro p1 = new PaginaCadastro();
        p1.setContentPane(p1.painelprincipal);
        p1.setVisible(true);
        p1.setSize(500,500);
        p1.setLocation(700,300);
        //p1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
