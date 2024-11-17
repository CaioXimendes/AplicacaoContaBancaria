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

    private String nomeCliente;
    private String emailCliente;
    private String senhaCliente;

    public PaginaLogin(){
        setContentPane(painelPrincipal);
        logarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeCliente = nomeTextField.getText().trim();
                emailCliente = emailTextField.getText().trim();
                senhaCliente = passwordField.getText().trim();
//                System.out.println(nomeCliente+"\n"+emailCliente+"\n"+senhaCliente);
//                System.out.println("Logado!");
                ConexaoBancoDeDados conexao1 = new ConexaoBancoDeDados();
                try{
                    conexao1.realizarLogin(nomeCliente, emailCliente, senhaCliente);
                    if(conexao1.realizarLogin(nomeCliente, emailCliente, senhaCliente)){
                        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
                        paginaPrincipal.setVisible(true);
                        paginaPrincipal.setSize(500,500);
                        paginaPrincipal.setLocation(700,300);
                        paginaPrincipal.setNomeCliente(nomeCliente);
                        System.out.println(paginaPrincipal.getNomeCliente());
//                fecha a pagina de login e abre a pagina principal
                        dispose();
                    } else{
                        JOptionPane.showMessageDialog(logarButton,"Credenciais erradas, tente novamente!");
                    }
                }
                catch (SQLException ex){
                    throw new RuntimeException();
                }
            }
        });
    }
}