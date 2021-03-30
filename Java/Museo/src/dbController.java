import java.sql.*;

public class dbController {


    public Connection connetti(){
      Connection connessione = null;
      String url = "jdbc:mysql://127.0.0.1/museoricoale";
      String user = "root";
      String password = "";

      try{
        connessione = DriverManager.getConnection(url, user, password);
        if(connessione != null){
            System.out.println("La connessione è avvenuta con successo");
        }
      }catch(SQLException e){
        System.out.println(e);
      }
      return connessione;
    }
  
} 
