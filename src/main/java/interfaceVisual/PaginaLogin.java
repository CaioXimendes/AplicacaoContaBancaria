package interfaceVisual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            }
        });
    }

    public static void main(String[] args) {
        PaginaLogin p2 = new PaginaLogin();
        p2.setContentPane(p2.painelPrincipal);
        p2.setVisible(true);
        p2.setSize(500,500);
        p2.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}