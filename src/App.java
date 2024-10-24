import repository.*;

public class App{
    public static void main(String[] args){
        connection.connect_db();
        search.getAll();
        search.getById(1);
        connection.disconnect_db();
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
