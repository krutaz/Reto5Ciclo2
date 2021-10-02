import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudiantesDAO {
    Conexion c = new Conexion();    
    
    
    
    public EstudiantesDAO(){
        c.abrirConexion();
    }
    
    
    
    public void finalizar(){
        c.cerrarConexion();
    }
    
    
    
    public void insertarEstudiante(String nombres, String apellidos, String fecha, String correo_ins, String correo_per, long num_cel, long num_fijo, String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Insert into Estudiantes values(?,?,?,?,?,?,?,?)");
            pst.setString(1, nombres);
            pst.setString(2, apellidos);
            pst.setString(3, fecha);
            pst.setString(4, correo_ins);
            pst.setString(5, correo_per);
            pst.setString(6, String.valueOf(num_cel));
            pst.setString(7, String.valueOf(num_fijo));
            pst.setString(8, programa);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
    
    
    
    public void modificarEstudiante(String correo_ins, String correo_per, long num_cel, long num_fijo, String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Update Estudiantes set Correo_Personal = ?, Numero_Celular = ?, Numero_Fijo = ?, Programa = ? where Correo_Institucional = ?");
            pst.setString(1, correo_per);
            pst.setString(2, String.valueOf(num_cel));
            pst.setString(3, String.valueOf(num_fijo));
            pst.setString(4, programa);
            pst.setString(5, correo_ins);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void eliminarEstudiante(String correo_ins){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Delete from Estudiantes where Correo_Institucional = ?");
            pst.setString(1, correo_ins);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public boolean verificarBD(String correo_ins){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Correo_Institucional = ?");
            pst.setString(1, correo_ins);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}