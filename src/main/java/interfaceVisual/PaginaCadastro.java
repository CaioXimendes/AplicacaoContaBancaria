package interfaceVisual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                System.out.println(nomeCliente+"\n"+emailCliente+"\n"+senhaCliente);
                System.out.println("Cadastrado!");
            }
        });
    }

    public static void main(String[] args) {
        PaginaCadastro p1 = new PaginaCadastro();
        p1.setContentPane(p1.painelprincipal);
        p1.setVisible(true);
        p1.setSize(500,500);
        p1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
