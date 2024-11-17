package conexaoBancoDeDados;

import java.sql.*;

public class ConexaoBancoDeDados {
    public void inserirDadosContaBancaria(String NomeCliente, String emailCliente, String senhaCliente, int numeroContaCliente) throws SQLException {
        Connection conexao1 = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","database123");
            Statement statement = conexao1.createStatement();
            PreparedStatement preparedStatement;
            String sql;
            sql = "use bancodedados;";
            preparedStatement = conexao1.prepareStatement(sql);
            preparedStatement.execute();
            //String sql = "INSERT INTO ContaBancaria VALUES "+"("+NomeCliente+","+emailCliente+","+senhaCliente+","+numeroContaCliente+","+0+");";
            sql = "INSERT INTO ContaBancaria (NomeCliente, emailCliente, senhaCliente, numeroContaCliente, saldoCliente) VALUES (?,?,?,?,?);";
            preparedStatement = conexao1.prepareStatement(sql);
            preparedStatement.setString(1,NomeCliente);
            preparedStatement.setString(2,emailCliente);
            preparedStatement.setString(3,senhaCliente);
            preparedStatement.setInt(4,numeroContaCliente);
            preparedStatement.setDouble(5,0);
            preparedStatement.execute();
            System.out.println("Conectado!");
        }
        catch (ClassNotFoundException ex){
            System.out.println("Driver do Banco de dados não localizado!");
        }
        catch (SQLException ex){
            System.out.println("Erro durante a conexão com o banco de dados! Erro:"+ex.getMessage());
        }
        finally {
            if(conexao1 != null){
                conexao1.close();
            }
        }
    }
    public boolean realizarLogin(String NomeCliente, String emailCliente, String senhaCliente) throws SQLException{
        Connection conexao1 = null;
        boolean logado = false;
        try {
            ResultSet resultSet;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "database123");
            Statement statement = conexao1.createStatement();
            PreparedStatement preparedStatement;
            String sql;
            sql = "use bancodedados;";
            preparedStatement = conexao1.prepareStatement(sql);
            preparedStatement.execute();
            sql = "SELECT NomeCliente, emailCliente, senhaCliente from ContaBancaria where NomeCliente =? and emailCliente=? and senhaCliente=?;";
            preparedStatement = conexao1.prepareStatement(sql);
            preparedStatement.setString(1, NomeCliente);
            preparedStatement.setString(2,emailCliente);
            preparedStatement.setString(3,senhaCliente);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
//                System.out.println(resultSet.getString("NomeCliente"));
//                System.out.println(resultSet.getString("emailCliente"));
//                System.out.println(resultSet.getString("senhaCliente"));
                System.out.println("Logado atraves do banco de dados!");
                logado = true;
            }else{System.out.println("Falha no login, credenciais erradas!");}

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do Banco de dados não localizado!");
        } catch (SQLException ex) {
            System.out.println("Erro durante a conexão com o banco de dados! Erro:" + ex.getMessage());
        } finally {
            if (conexao1 != null) {
                conexao1.close();
            }
        }
        return logado;
    }
    public void consultarInformacoesBanco(){}
}
