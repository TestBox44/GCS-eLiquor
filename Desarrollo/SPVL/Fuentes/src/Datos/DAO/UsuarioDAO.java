package Datos.DAO;

import Datos.Entidades.Usuario;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author sortizu
 */
public class UsuarioDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public int add(Object[] o) {
        int r = 0;
        //int id=setLastId()+1;
        String sql = "insert into usuarios(idUsuario, nombre)values(?,?)";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r = ps.executeUpdate();
        }catch(SQLException e){
             System.out.println(e.toString());
         }
        return r;
    }
    

    @Override
    public List listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuarios";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                lista.add(u);
            }
        }catch(SQLException e){
             System.out.println(e.toString());
         }
        return lista;
    }

    @Override
    public void eliminar(String id) {
    }

    @Override
    public int actualizar(Object[] o) {
        return 0;
    }
    
    
    
}
