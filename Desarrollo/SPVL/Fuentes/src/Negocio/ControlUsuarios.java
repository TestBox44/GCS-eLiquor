/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.DAO.UsuarioDAO;
import Datos.Entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author sortizu
 */
public class ControlUsuarios {
    public static ArrayList<Usuario> cargarListaDeUsuarios(){
        UsuarioDAO udao=new UsuarioDAO();
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        for(Object u: udao.listar()){
            Usuario nuevoUsuario=new Usuario(((Usuario)u).getIdUsuario(),
            ((Usuario)u).getNombre(),0,((Usuario)u).isGestionarVentas(),((Usuario)u).isGestionarUsuarios()
            ,((Usuario)u).isGestionarProveedores(),((Usuario)u).isGestionarClientes(), 
            ((Usuario)u).isGestionarInventario(),((Usuario)u).isGenerarReportes());
            usuarios.add(nuevoUsuario);
        }
        return usuarios;
    }
}
