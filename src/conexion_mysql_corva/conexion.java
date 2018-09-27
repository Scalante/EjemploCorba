package conexion_mysql_corva;
import java.sql.*;


public class conexion {
    public Connection conex;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conex=DriverManager.getConnection("jdbc:mysql://localhost/conexioncorba","root","");
            System.out.println("Conexion Establecida");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return conex;
    }
}