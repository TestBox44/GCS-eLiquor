/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.interfaces;

import Datos.DAO.UsuarioDAO;
import Datos.Entidades.Usuario;
import Presentacion.interfaces.Login.Login;
import Presentacion.interfaces.Login.LoginUsuarios;

/**
 *
 * @author sortizu
 */
public class main {
    public static void main(String[] args) {
       Login login=new Login();
       login.setVisible(true);
    }
}
