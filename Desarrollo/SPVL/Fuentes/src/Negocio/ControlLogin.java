package Negocio;

import Datos.DAO.UsuarioDAO;
import Datos.Entidades.Usuario;
import java.util.List;

/**
 *
 * @author sortizu
 */
public class ControlLogin {
    public static Object[][] mostrarListaDeUsuarios(){
        UsuarioDAO udao = new UsuarioDAO();
        List<Usuario> usuarios = udao.listar();
        Object[][] datosUsuario= new Object[usuarios.size()][2];
        for (int i = 0; i < usuarios.size(); i++) {
            datosUsuario[i][0]=((Usuario)(usuarios.get(i))).getIdUsuario();
            datosUsuario[i][1]=((Usuario)(usuarios.get(i))).getNombre();
        }
        return datosUsuario;
    }
}
