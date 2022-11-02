/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.DAO.UsuarioDAO;
import Datos.Entidades.Usuario;
import java.util.List;

/**
 *
 * @author sortizu
 */
public class ControlMenu {
    public static boolean [] cargarPermisosDeUsuario(int id){
        UsuarioDAO udao = new UsuarioDAO();
        int idx=id-1;
        List<Usuario> usuarios = udao.listar();
        boolean [] permisos = {usuarios.get(idx).isGestionarVentas(),
            usuarios.get(idx).isGestionarUsuarios(), usuarios.get(idx).isGestionarProveedores(),
            usuarios.get(idx).isGestionarClientes(), usuarios.get(idx).isGestionarInventario(),
            usuarios.get(idx).isGenerarReportes()};
        return permisos;
    }
}
