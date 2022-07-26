
package sistema.empleadosBL;
import java.util.Vector;
import sistema.empleadosDAL.Conexion;

public class EmpleadosBL {
    int id;
    String nombre;
    String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Vector getDatosTabla(){
        Vector datos = new Vector();
        datos.add(this.id);
        datos.add(this.nombre);
        datos.add(this.correo);
        return datos;
    }
    
    public void editarEmpleado(){
        Conexion objConexion = new Conexion();
//        objConexion.ejecutarSentenciaSQL("UPDATE Empleados \n" +
//                                        "SET Nombre = '" + this.nombre + " ', \n" +
//                                        "Correo = '" + this.correo + "'\n" +
//                                        "WHERE IdEmpleado = " + this.id + ";");
        String conSQL = String.format("UPDATE Empleados \n" +
                                        "SET Nombre = '%s', \n" +
                                        "Correo = '%s' \n" +
                                        "WHERE IdEmpleado = %d;", this.nombre,this.correo,this.id);
        objConexion.ejecutarSentenciaSQL(conSQL);
    }
    public void agregarEmpleado(){
        Integer idem = null;
        if(this.id > 0){
            idem = this.id;
        }
        Conexion objConexion = new Conexion();
//        objConexion.ejecutarSentenciaSQL("INSERT INTO Empleados(IdEmpleado, Nombre, Correo)\n"
//                + "VALUES ("+ idem + ",\n"
//                + "'"+ this.nombre +"',\n"
//                + "'"+ this.correo +"'\n"
//                + ")");
        
        String conSQL = String.format("INSERT INTO Empleados(IdEmpleado, Nombre, Correo)\n"
                + "VALUES (%d,\n"
                + "'%s',\n"
                + "'%s'\n);",idem, this.nombre, this.correo);
        objConexion.ejecutarSentenciaSQL(conSQL);
        
    }
    public void eliminaEmpleado(){
        Conexion objConexion = new Conexion();
        objConexion.ejecutarSentenciaSQL("DELETE FROM Empleados WHERE IdEmpleado = " + this.id);
    }
    
}
