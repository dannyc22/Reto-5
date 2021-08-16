package Modelo.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import Util.JDBCUtilities;

import Modelo.vo.Requerimiento_3;

public class Requerimiento_3Dao {
    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_3> requerimiento3()  throws SQLException {
        
        ArrayList<Requerimiento_3> respuesta= new ArrayList<Requerimiento_3>();
    
        Connection Conexion= JDBCUtilities.getConnection();

        try{
    
            String consulta =   "SELECT Compra.Proveedor, Compra.Pagado, Proyecto.Constructora " + 
                                "FROM Compra " +
                                "inner join Proyecto on Compra.ID_Proyecto = Proyecto.ID_Proyecto " +
                                "where Compra.Proveedor = 'JUMBO' AND Compra.Pagado = 'No'; ";
                                
            PreparedStatement statement = Conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();                    
            
            while(resultSet.next()){
                Requerimiento_3 requerimiento_3= new Requerimiento_3();
                requerimiento_3.setProveedor(resultSet.getString("Proveedor"));
                requerimiento_3.setPagado(resultSet.getString("Pagado"));
                requerimiento_3.setConstructora(resultSet.getString("Constructora"));

                respuesta.add(requerimiento_3);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consulltando: " +e);
        }finally{
            if(Conexion != null){
                Conexion.close();
            }
        }
        return respuesta;
              
    }
}
