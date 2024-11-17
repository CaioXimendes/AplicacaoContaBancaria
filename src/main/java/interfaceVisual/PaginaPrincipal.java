package interfaceVisual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipal extends JFrame{
    private JTextArea texto1TextArea;
    private JTextArea texto2TextArea;
    private JTextArea valorSaldoTextArea;
    private JTextArea valorDepositoTextArea;
    private JTextArea valorTransferenciaTextArea;
    private JTextArea numeroTextArea;
    private JButton transferirButton;
    private JButton sairButton;
    private JPanel painelPrincipal;
    private JButton depositarButton;

    public PaginaPrincipal(){
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: atualizar os valores de saldo apos realizar uma transferencia

            }
        });

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: atualizar os valores de saldo apos realizar um deposito
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: fechar a pagina apos apertar o botao de sair
                dispose();
            }
        });
    }
}
