package repository;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;


public class connection {
    static String db = "C:\\Development\\DB\\my_project.db";
    static String url = "jdbc:sqlite:"+db;
    protected static Connection cn = null;


    public static void connect_db(){

        File dbFile = new File(db);
        if(!dbFile.exists()){
            System.out.println("Banco de dados nao encontrado");
            return;
        }
        try{
            cn = DriverManager.getConnection(url); // Se a conexao falhar, cn é null
            if(cn != null){
                System.out.println("DB: Conected\n");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
        }
    }

    static public void disconnect_db(){
        if(cn != null){
            try{
                cn.close();
                System.out.printf("\nDB: Desconected");
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println(e.getErrorCode());
                System.out.println(e.getSQLState());
            }
        }else{
            System.out.println("Banco de dados nao encontrado");
        }
    }
}

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class App {
//     public static void main(String[] args) {
//         String url = "jdbc:sqlite:C:\\Development\\DB\\my_project.db";

//         Connection conexao = null;

//         try {
            
//             conexao = DriverManager.getConnection(url);
//             System.out.println("Conexao com o SQLite bem-sucedida!");

//             Statement stmt = conexao.createStatement();

//             String query = "SELECT * FROM login";
//             ResultSet response = stmt.executeQuery(query);

//             // Processar os resultados da consulta
//             while (response.next()) {
//                 // Obter os valores das colunas
//                 int id = response.getInt("id");
//                 String email = response.getString("email");
//                 String password = response.getString("password");

//                 // Exibir os dados
//                 System.out.println("ID: " + id + ", Email: " + email + ", Password: " + password);
//             }

//         } catch (SQLException e) {
//             System.err.println("Erro ao conectar ao banco de dados ou executar consulta: " + e.getMessage());
//         } finally {
//             // Fechar a conexão
//             try {
//                 if (conexao != null) {
//                     conexao.close();
//                     System.out.println("Conexao fechada.");
//                 }
//             } catch (SQLException e) {
//                 System.err.println("Erro ao fechar a conexão: " + e.getMessage());
//             }
//         }
//     }
// }
