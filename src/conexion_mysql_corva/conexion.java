import java.sql.*;


public class conexion {
    public Connection conex;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conex=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
            System.out.println("Conexion Establecida");
        }catch(Exception e){
            
        }
    }
}