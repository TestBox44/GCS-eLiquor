package Negocio;

import Datos.DAO.ProveedorDAO;
import Datos.Entidades.Proveedor;
import Datos.Entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class ControlProveedores {
    public static ArrayList<Proveedor> cargarListaDeProveedores(){
        ProveedorDAO pdao=new ProveedorDAO();
        ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
        for(Object p: pdao.listar()){
            Proveedor nuevoProveedor=new Proveedor(((Proveedor)p).getIdProveedor(),((Proveedor)p).getRazonSocial(),((Proveedor)p).getCorreo(),((Proveedor)p).getTelefono(),((Proveedor)p).getFechaRegistro());
            proveedores.add(nuevoProveedor);
        }
        return proveedores;
    }
    
    public static void agregarProveedor(Proveedor proveedor){
        ProveedorDAO pdao=new ProveedorDAO();
        pdao.add(new Object[]{proveedor.getRazonSocial(),proveedor.getCorreo(),proveedor.getTelefono(),proveedor.getFechaRegistro(),proveedor.getIdProveedor()});
    }
    
    public static void eliminarProveedores(ArrayList<Proveedor> proveedores){
        ProveedorDAO pdao=new ProveedorDAO();
        for (Proveedor proveedor: proveedores) {
            pdao.eliminacionLogica(proveedor.getIdProveedor());
        }
    }
    
    public static void modificarProveedor(Proveedor proveedor){
        ProveedorDAO pdao=new ProveedorDAO();
        Object[] datos={proveedor.getRazonSocial(),proveedor.getCorreo(),proveedor.getTelefono(),proveedor.getFechaRegistro(),proveedor.getIdProveedor()};
        pdao.actualizar(datos);
    }
    
    public static int obtenerUltimoID(){
        ProveedorDAO pdao=new ProveedorDAO();
        return pdao.setLastId();
    }
}
