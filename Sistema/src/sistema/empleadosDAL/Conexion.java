
package sistema.empleadosDAL;

import java.sql.*;

public class Conexion {
    String strConexionDB = "jdbc:sqlite:G:/Documentos/MinTIC/02 Ciclo2/Programacion/04 Unidad4/Java/Sistema/SISTEMA.db";
    Connection con = null;

    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }
    }
    public int ejecutarSentenciaSQL(String strSenteciaSQL){
        try {
            PreparedStatement ps = con.prepareStatement(strSenteciaSQL);
            ps.execute();
            return 1;
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
            PreparedStatement ps = con.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = ps.executeQuery();
            return respuesta;
            
        } catch (Exception e) {
            System.out.println("El error es: " + e);
            return null;
        }
    }
}
