package interfaceVisual;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class PaginaPrincipal extends JFrame{
    private JTextArea nomeTextArea;
    private JTextArea numerocontaTextArea;
    private JTextArea valorSaldoTextArea;
    private JTextArea valorDepositoTextArea;
    private JTextArea valorTransferenciaTextArea;
    private JTextArea numeroTextArea;
    private JButton transferirButton;
    private JButton sairButton;
    private JPanel painelPrincipal;
    private JButton depositarButton;
    private JButton consultarSaldoButton;

    private String nomeCliente;
    private String emailCliente;
    private String senhaCliente;
    private int numeroConta;
    private double saldoCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public String getSenhaCliente() {
        return senhaCliente;
    }
    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }
    public double getSaldoCliente(){
        return saldoCliente;
    }
    public void setSaldoCliente(double saldoCliente){
        this.saldoCliente = saldoCliente;
    }
    public int getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }
    public PaginaPrincipal() throws SQLException {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                nomeTextArea.setText(nomeCliente);
                numerocontaTextArea.setText(String.valueOf(numeroConta));
                valorSaldoTextArea.setText(String.valueOf(saldoCliente));
            }
        });

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
