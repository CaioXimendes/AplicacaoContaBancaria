package interfaceVisual;

import conexaoBancoDeDados.ConexaoBancoDeDados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PaginaLogin extends JFrame{
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton logarButton;
    private JPanel painelPrincipal;
    private JPanel painelLogin;
    private JPanel panelButton;

    public PaginaLogin(){
        setContentPane(painelPrincipal);
        logarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = nomeTextField.getText().trim();
                String emailCliente = emailTextField.getText().trim();
                String senhaCliente = passwordField.getText().trim();
                System.out.println(nomeCliente+"\n"+emailCliente+"\n"+senhaCliente);
                System.out.println("Logado!");
                ConexaoBancoDeDados conexao1 = new ConexaoBancoDeDados();
                try{conexao1.realizarLogin(nomeCliente, emailCliente, senhaCliente);}
                catch (SQLException ex){
                    throw new RuntimeException();
                }

                PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
                paginaPrincipal.setVisible(true);
                paginaPrincipal.setSize(500,500);
                paginaPrincipal.setLocation(700,300);
//                fecha a pagina de login e abre a pagina principal
                dispose();
            }
        });
    }
}