
package conexion_mysql_corva;

import java.sql.*;
import terceros.*;

public class terceros extends terceroPOA {
    conexion objConec = new conexion();

    @Override
    public boolean insertartercero(String nombres, String apellidos, int telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizartercero(int id, String nombres, String apellidos, int telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminartercero(int id) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
            
        } catch (Exception e) {
            
        }
        
        return resultado;    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
