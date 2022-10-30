package Datos.DAO;
import java.util.List;
/**
 *
 * @author sortizu
 */
public interface CRUD {
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(String id);
    public List listar();
}
