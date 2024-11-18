package interfaceVisual;

import conexaoBancoDeDados.ConexaoBancoDeDados;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class PaginaPrincipal extends JFrame{
    private JTextArea nomeTextArea;
    private JTextArea numerocontaTextArea;
    private JTextArea valorSaldoTextArea;
    private JTextArea valorDepositoTextArea;
    private JTextArea valorTransferenciaTextArea;
    private JTextArea numeroContaTransferenciaTextArea;
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
    private double valorTransferencia;
    private int numeroContaTransferencia;

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
    public void setValorTransferencia(double valorTransferencia){
        this.valorTransferencia = valorTransferencia;
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
        consultarSaldoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexaoBancoDeDados conexao1 = new ConexaoBancoDeDados();
                try{
                    conexao1.consultarInformacoesBanco(nomeCliente,emailCliente,senhaCliente);
                    valorSaldoTextArea.setText(String.valueOf(saldoCliente));
                }
                catch (SQLException ex){
                    throw new RuntimeException();
                }
            }
        });

        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: atualizar os valores de saldo apos realizar uma transferencia
                ConexaoBancoDeDados conexao1 = new ConexaoBancoDeDados();
                valorTransferencia = Double.parseDouble(valorTransferenciaTextArea.getText());
                numeroContaTransferencia = Integer.parseInt(numeroContaTransferenciaTextArea.getText());
                try{
                    if (valorTransferencia>0 && valorTransferencia <= saldoCliente){
                        conexao1.realizarTransferencia(numeroConta,numeroContaTransferencia,valorTransferencia);
                        //conexao1.reduzirSaldo(nomeCliente, emailCliente, senhaCliente, saldoCliente, valorTransferencia);
                        saldoCliente = saldoCliente - valorTransferencia;
                        valorSaldoTextArea.setText(String.valueOf(saldoCliente));
                        JOptionPane.showMessageDialog(transferirButton, "Transferência realizada para a conta: "+numeroContaTransferencia);
                        numeroContaTransferenciaTextArea.setText("");
                    }else{
                        JOptionPane.showMessageDialog(transferirButton,"Insira apenas um valor válido para tranferência!");
                    }
                }
                catch (SQLException ex){
                    throw new RuntimeException();
                }
            }
        });

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: atualizar os valores de saldo apos realizar um deposito
                ConexaoBancoDeDados conexao1 = new ConexaoBancoDeDados();
                try{
                    if (Double.parseDouble(valorDepositoTextArea.getText()) > 0){
                        conexao1.consultarInformacoesBanco(nomeCliente,emailCliente,senhaCliente);
                        saldoCliente = saldoCliente + Double.parseDouble(valorDepositoTextArea.getText());
                        valorSaldoTextArea.setText(String.valueOf(saldoCliente));
                        valorDepositoTextArea.setText("");
                        conexao1.atualizarSaldoBanco(nomeCliente,emailCliente,senhaCliente,saldoCliente);
                    } else{
                        JOptionPane.showMessageDialog(depositarButton, "Insira apenas um valor válido para depósito!");
                    }
                }
                catch (SQLException ex){
                    throw new RuntimeException();
                }
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
