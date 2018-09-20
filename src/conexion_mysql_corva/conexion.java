import java.sql.*;


public class conexion {
    public Connection conex;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            
        }
    }
}