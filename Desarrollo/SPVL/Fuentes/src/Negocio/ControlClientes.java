package Negocio;

import Datos.DAO.ClienteDAO;
import Datos.Entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class ControlClientes {
    public static ArrayList<Cliente> cargarListaDeClientes(){
        ClienteDAO cdao=new ClienteDAO();
        ArrayList<Cliente> clientes=new ArrayList<Cliente>();
        for(Object c: cdao.listar()){
            Cliente nuevoCliente=new Cliente(((Cliente)c).getIdCliente(),((Cliente)c).getNombre(),((Cliente)c).getCorreo(),((Cliente)c).getTelefono(),((Cliente)c).getFechaRegistro());
            clientes.add(nuevoCliente);
        }
        return clientes;
    }
    
    public static void agregarCliente(Cliente Cliente){
        ClienteDAO cdao=new ClienteDAO();
        cdao.add(new Object[]{Cliente.getNombre(),Cliente.getCorreo(),Cliente.getTelefono(),Cliente.getFechaRegistro(),Cliente.getIdCliente()});
    }
    
    public static void eliminarClientes(ArrayList<Cliente> Clientes){
        ClienteDAO cdao=new ClienteDAO();
        for (Cliente Cliente: Clientes) {
            cdao.eliminar(Cliente.getIdCliente());
        }
    }
    
    public static void modificarCliente(Cliente Cliente){
        ClienteDAO cdao=new ClienteDAO();
        Object[] datos={Cliente.getNombre(),Cliente.getCorreo(),Cliente.getTelefono(),Cliente.getFechaRegistro(),Cliente.getIdCliente()};
        cdao.actualizar(datos);
    }
    
    public static int obtenerUltimoID(){
        ClienteDAO cdao=new ClienteDAO();
        return cdao.setLastId();
    }
}
