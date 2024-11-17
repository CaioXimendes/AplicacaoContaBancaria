package conexaoBancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBancoDeDados {
    public void inserirDadosContaBancaria(String NomeCliente, String emailCliente, String senhaCliente, int numeroContaCliente) throws SQLException {
        Connection conexao1 = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","database123");
            Statement statement = conexao1.createStatement();
            ResultSet resultSet = statement.executeQuery("INSERT INTO ContaBancaria (NomeCliente, emailCliente, senhaCliente, numeroContaCliente) VALUES" +"("+NomeCliente+","+emailCliente+","+senhaCliente+","+numeroContaCliente+");");
            System.out.println("Conectado!");
            if(resultSet.next()){
                System.out.println(resultSet.getString("1"));
            }
//            ResultSet resultSet = conexao1.createStatement().executeQuery("SHOW DATABASES;");
//            System.out.println(resultSet);
        }
        catch (ClassNotFoundException ex){
//            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null , ex);}
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
}
