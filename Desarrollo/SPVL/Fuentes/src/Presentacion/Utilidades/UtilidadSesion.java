package Presentacion.Utilidades;

import Datos.Entidades.Configuracion;
import Negocio.ControlConfiguracion;

/**
 *
 * @author sortizu
 */
public class UtilidadSesion {
    public static int idUsuarioActual;
    public static String nombreUsuarioActual;
    public static Configuracion configuracionActual;
    
    static {
        Configuracion tempConf=ControlConfiguracion.cargarConfiguracion();
        if(tempConf==null){
            configuracionActual=new Configuracion();
        }else{
            configuracionActual=tempConf;
        }
    }
}
