package Vista;

import java.util.ArrayList;

import Controlador.ElControladorDeRequerimientos;

import Modelo.vo.Requerimiento_1;
import Modelo.vo.Requerimiento_2;
import Modelo.vo.Requerimiento_3;

public class VistaRequerimientos {

    public static final ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();

    public static void requerimiento1(){
        
        try {
            ArrayList<Requerimiento_1> lista_1 = controlador.consultarRequerimiento1();

            for (Requerimiento_1 reque :lista_1){
                System.out.printf("%d %s %s %s %s %n",
                reque.getID_Proyecto(),
                reque.getCiudad(),
                reque.getBanco_Vinculado(),
                reque.getConstructora(),
                reque.getClasificacion()
                );
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){
        
        try {
            ArrayList<Requerimiento_2> lista_2 = controlador.consultarRequerimiento2();
            for (Requerimiento_2 reque :lista_2){
                System.out.printf("%s %s %s %s %d %n",
                reque.getNombre(),
                reque.getPrimer_Apellido(),
                reque.getCiudad_Residencia(),
                reque.getCargo(),
                reque.getSalario()
                );
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento3(){
        try {
            ArrayList<Requerimiento_3> lista_3 = controlador.consultarRequerimiento3();
            for (Requerimiento_3 reque :lista_3){
                System.out.printf("%s %s %s %n",
                reque.getProveedor(),
                reque.getPagado(),
                reque.getConstructora()
                );
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }
}
