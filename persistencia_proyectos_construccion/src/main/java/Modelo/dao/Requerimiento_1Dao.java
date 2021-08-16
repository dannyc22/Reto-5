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

import Modelo.vo.Requerimiento_1;

public class Requerimiento_1Dao {   

    public ArrayList<Requerimiento_1> requerimiento1()  throws SQLException {
        
        ArrayList<Requerimiento_1> respuesta= new ArrayList<Requerimiento_1>();

        Connection Conexion= JDBCUtilities.getConnection();

        try{

            String consulta =   "select ID_Proyecto, Ciudad, Banco_Vinculado, Constructora, Clasificacion " +
                                "from proyecto " +
                                "where(Clasificacion = 'Condominio' AND Fecha_Inicio>= '2020-01-01'); ";
                                
                                
            PreparedStatement statement = Conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();                    
            
            while(resultSet.next()){
                Requerimiento_1 requerimiento_1= new Requerimiento_1();
                requerimiento_1.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento_1.setCiudad(resultSet.getString("Ciudad"));
                requerimiento_1.setBanco_Vinculado(resultSet.getString("Banco_Vinculado"));
                requerimiento_1.setConstructora(resultSet.getString("Constructora"));
                requerimiento_1.setClasificacion(resultSet.getString("Clasificacion"));

                respuesta.add(requerimiento_1);
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