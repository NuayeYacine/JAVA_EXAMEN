package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

     private Connection connection;
     private PreparedStatement preparedStatement;
     private ResultSet rs;

     public void opendb() throws Exception
     {
         String url="jdbc:mysql://localhost:3306/gestion_projet";
         String mysqluser = "root";
         String mysqlpassword = "";

             Class.forName("com.mysql.jdbc.Driver");
             //ouvrit la connection
             connection= DriverManager.getConnection(url,mysqluser,mysqlpassword);
     }
 //initialiser les requette
     public  void initR(String sql) throws  Exception
     {
         preparedStatement = connection.prepareStatement(sql);
     }
//executer la requete  Insert,update,delete
    public int executeUpdate() throws  Exception
    {
        int ok = 0;
        ok = preparedStatement.executeUpdate();
        return  ok;
    }
    //executer les requete select
    public ResultSet executeSelect() throws  Exception
    {
        rs = preparedStatement.executeQuery();
        return  rs;
    }
    //get preparedStament()
    public  PreparedStatement getPreparedStament()
    {
        return preparedStatement;
    }


    public  void closedb() throws  Exception
     {
        if(connection != null)
        {
            connection.close();
        }
     }
}
