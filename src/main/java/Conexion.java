import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion;
    
    
    
    public Conexion(){
        conexion = null;
    }
        
    
    
    public void abrirConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqLite:bd_estudiantes.db";
            conexion = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void cerrarConexion(){
        try {
            if(!conexion.isClosed()){
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}