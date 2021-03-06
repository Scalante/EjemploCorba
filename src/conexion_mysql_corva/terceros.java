
package conexion_mysql_corva;

import java.sql.*;
import javax.swing.JOptionPane;
import terceros.*;

public class terceros extends terceroPOA {
    conexion objConec = new conexion();

    @Override
    public boolean insertartercero(String nombres, String apellidos, int telefono) {
        boolean resultado = false;
        
        try {
            String sql= "insert into terceros (nombres,apellidos,telefono)values('"+nombres+"','"+apellidos+"','"+telefono+"')";
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if (valor>0){
                resultado = true;
            }
            objConec.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizartercero(int id, String nombres, String apellidos, int telefono) {
         boolean resultado = false;
        
        try {
            String sql = "update tercero set nombres = '"+nombres+"',apellidos = '"+apellidos+"',telefono = '"+telefono+"' where id = '"+id+"'";
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminartercero(int id) {
        
         boolean resultado = false;
        
        try {
            String sql = "Delete from terceros where id = "+id;
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if (valor>0){
                resultado = true;
            }
            objConec.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }

        return resultado;
    }

    @Override
    public String consultartercero(int id) {
        String resultado = "";
        
            try {
                String sqlConsultar = "Select * from terceros where id = "+ id;
                objConec.conectar();
                Statement st = objConec.conex.createStatement();
                ResultSet rs = st.executeQuery(sqlConsultar);
                    while (rs.next()) {
                        resultado += rs.getString(2) + " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4);
            }
            //Se cierran las conexiones
            rs.close();
            objConec.conex.close();
        } catch (Exception e) {
              //  System.out.println("Error: "+ e.getMessage);
        }
        
        return resultado;    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTercero(){
        ResultSet resultado = null;
        try {
            String sql = "Select nombres, apellidos, telefono from terceros";
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
        }
        return resultado;
    }
}
