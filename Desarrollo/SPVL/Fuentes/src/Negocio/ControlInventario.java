package Negocio;

<<<<<<< Updated upstream
=======
import Datos.DAO.DepartamentoDAO;
import Datos.DAO.DepartamentoProductoDAO;
import Datos.DAO.ProductoDAO;

>>>>>>> Stashed changes
import Datos.Entidades.Departamento;
import Datos.Entidades.Producto;
import java.util.ArrayList;
<<<<<<< Updated upstream
import java.util.Arrays;
=======
>>>>>>> Stashed changes
/**
 *
 * @author sortizu
 * @author Richard
 */
public class ControlInventario {
    
<<<<<<< Updated upstream
    
    
    public static ArrayList<Departamento> cargarDepartamentos(){
        /*Este metodo debe cargarme los departamentos de la BD usando
        el DAO de departamento (crearlo en base a los DAO de ejemplo)
        y me lo debe retornar. El return de abajo esta puesto porque es 
        necesario que este metodo devuelva algo.
        */
        return new ArrayList<Departamento>();
=======

    public static ArrayList<Departamento> cargarDepartamentos(){
        
        DepartamentoDAO ddao=new DepartamentoDAO();
        ArrayList<Departamento> departamento=new ArrayList<Departamento>();
        
        for(Object d: ddao.listar()){
            Departamento nuevoDepartamento;
            nuevoDepartamento = new Departamento(((Departamento)d).getIdDepartamento(),((Departamento)d).getNombre(),
            ((Departamento)d).isMostrarEnCaja(), ((Departamento)d).getFechaRegistro());
            
            
                    
            nuevoDepartamento.setCantidad(((Departamento)d).getCantidad());
            departamento.add(nuevoDepartamento);
        }
        return departamento;
>>>>>>> Stashed changes
    }
    
    public static ArrayList<Producto> cargarProductos(int idDepartamento){
<<<<<<< Updated upstream
        /*Este metodo debe cargar todos los productos dentro
        de un departamento (usando el idDepartamento)
        almacenados en la BD. El funcionamiento esperado es 
        el siguiente: 
        Si el idDepartamento es -1, debe cargar todos los 
        productos en la BD, sin criterio alguno. Sin embargo,
        si el id es 0 o mayor, debe intentar buscar los 
        productos relacionados a ese id de departamento.
        Si un departamento esta vacio (ningun producto 
        relacionado a el) este metodo debe por lo menos 
        devolver un arrayList vacio.
        OJO: Esto requiere no solo requiere la tabla
        producto, requiere tambien la tabla 
        Departamento-Producto que basicamente guarda la 
        relacion entre un producto y un departamento.
        (Buscar en el documento de especificacion de la BD,
        en el punto 5. modelo relacional)
        Seguramente esta tabla Departamento-Producto tambien
        necesite un dao y una clase. No importa la 
        implementacion que se siga, lo que importa es que 
        funcione tal como se pide.
        */
        return new ArrayList<Producto>();
=======
        
        DepartamentoProductoDAO dpdao = new DepartamentoProductoDAO();
        ProductoDAO pdao = new ProductoDAO();
        ArrayList<Producto> productos=new ArrayList<Producto>();
        
        if(idDepartamento == -1){
         
            productos=(ArrayList)pdao.listar();    
        }
        if(idDepartamento >= 0){
            
            
            for(Object dp: dpdao.obtenerIdDeProducto(idDepartamento)){
                Integer id = (Integer)dp;
                
                Producto p = pdao.obtenerProductoPorSuID(id.intValue());  
                productos.add(p);
            }
        }
        return productos;
>>>>>>> Stashed changes
    }
    
    public static void agregarDepartamento(Departamento nuevoDepartamento){
<<<<<<< Updated upstream
        /*Este metodo debe agregar un nuevo departamento a la BD 
        usando el DAO de departamento y el atributo nuevoDepartamento.
        Usar de ejemplo agregarUsuario() de ControlUsuario.
        */
=======
        
        DepartamentoDAO ddao=new DepartamentoDAO();
        ddao.add(new Object[]{
            nuevoDepartamento.getFechaRegistro(), nuevoDepartamento.getNombre(),nuevoDepartamento.getCantidad(),
            nuevoDepartamento.isMostrarEnCaja()}    
        );
>>>>>>> Stashed changes
    }
    
    public static void agregarProducto(Producto nuevoProducto){
<<<<<<< Updated upstream
        /*Este metodo debe hacer los mismo que agregarDepartamento
        */
=======
        
        ProductoDAO pdao=new ProductoDAO();
        pdao.add(new Object[]{
            nuevoProducto.getNombre(),nuevoProducto.getPrecio(),nuevoProducto.getCosto(),
            nuevoProducto.getStock(),nuevoProducto.isPrecioVariable(),
            nuevoProducto.isActivarDescuentos(),nuevoProducto.isMostrarEnCaja(),
            nuevoProducto.getFechaRegistro(), nuevoProducto.isIGV(), nuevoProducto.isISC(),});
>>>>>>> Stashed changes
    }
    
    public static void agregarProductoEnDepartamento(int idProducto, int idDepartamento){
<<<<<<< Updated upstream
        /*Este metodo debe registrar la relacion entre un producto (idProducto)
        y un departamento (idDepartamento). Ademas, debe obtener el departamento al que
        pertenece el producto y sumarle una unidad a su variable cantidad, y luego guardar ese 
        cambio en la BD. Esto requiere que exista la tabla Departamento-Producto. 
        Seguir las indicaciones de cargarProductos()
        */
=======
        
        Departamento_Producto nuevoDepPro = new Departamento_Producto(idDepartamento, idProducto);
        DepartamentoProductoDAO dpdao = new DepartamentoProductoDAO();
        dpdao.add(new Object[]{
            nuevoDepPro.getIdDepartamento(), nuevoDepPro.getIdProducto()});
        
        for(Departamento d: cargarDepartamentos()){
            
            if(d.getIdDepartamento() == idDepartamento){
               
                d.setCantidad(d.getCantidad() + 1);
                modificarDepartamento(d);
                
                break;  
            }

        }
>>>>>>> Stashed changes
    }
    
    public static void eliminarProductoDeDepartamento(int idProducto){
<<<<<<< Updated upstream
        /*Este metodo debe borrar el registro que hay entre un departamento 
        y un producto en la BD usando el idProducto. Ademas, debe obtener el departamento al que
        pertenece cada producto y restarle una unidad a su variable cantidad, y luego guardar ese 
        cambio en la BD.
        Este metodo seguramente deba trabajar con entidades parecidas a las de 
        agregarProductoEnDepartamento().
        */
    }
    
    public static void modificarDepartamento(Departamento departamentoModificado){
        /*Este metodo debe usar la funcion actualizar del
        dao de departamento. Dentro de departamentoModificado
        encontraremos el id del departamento modificado y
        los nuevos datos con el que actualizaremos el departamento en la BD. 
        Usar de ejemplo el mismo metodo en ControlUsuarios.
        Es algo diferente pero puede ayudar a hacerse una idea.
        */
=======
        
        DepartamentoProductoDAO dpdao = new DepartamentoProductoDAO();
        DepartamentoDAO ddao = new DepartamentoDAO();
        
        for (Object x: dpdao.listar()) {
            Departamento_Producto dp = (Departamento_Producto)x;
            
            if(dp.getIdProducto() == idProducto){
                dpdao.eliminar(dp.getIdDepartamentoProducto());
                
                for (Object n: ddao.listar()){
                    
                    Departamento d = (Departamento)n;
                    if(d.getIdDepartamento() == dp.getIdDepartamento()){
                    d.setCantidad(d.getCantidad()-1);  
                 
                    modificarDepartamento(d);
                    }
                }
            }
        }
    }

    public static void modificarDepartamento(Departamento departamentoModificado){
        
        DepartamentoDAO ddao=new DepartamentoDAO();
        Object[] datos={departamentoModificado.getFechaRegistro(),departamentoModificado.getNombre(),
            departamentoModificado.getCantidad(), departamentoModificado.isMostrarEnCaja(),
        departamentoModificado.getIdDepartamento()};
        
        ddao.actualizar(datos);
>>>>>>> Stashed changes
    }
    
    public static void modificarProducto(Producto productoModificado){
<<<<<<< Updated upstream
        /*Este metodo debe hacer lo mismo que modificarDepartamento()
        */
=======
        
        ProductoDAO pdao=new ProductoDAO();
        Object[] datos={productoModificado.getNombre(),productoModificado.getPrecio(),
            productoModificado.getCosto(), productoModificado.getStock(),productoModificado.isPrecioVariable(),
            productoModificado.isActivarDescuentos(), productoModificado.isMostrarEnCaja(),
            productoModificado.getFechaRegistro(), productoModificado.isIGV(), productoModificado.isISC(),
            productoModificado.getIdProducto()};
        
            pdao.actualizar(datos);
>>>>>>> Stashed changes
    }
    
    public static void eliminarDepartamentos(ArrayList<Departamento> departamentosABorrar){
<<<<<<< Updated upstream
        /*Este metodo debe borrar todos los departamentos que pase por el arrayList
        departamentosABorrar usando el dao de departamento. (Usar de ejemplo eliminarUsuario() en ControlUsuarios)
        Ademas, debe considerar lo siguiente: Se debe borrar las relaciones que existe entre
        este departamente y sus productos de la "supuesta" tabla Departamento-Producto.
        Para ello una sugerencia: Podria cargar todos los productos de un departamento
        usando cargarProductos(), esto se hace uno por uno con cada departamento dentro de la
        lista departamentosABorrar. En el proceso de recorrer uno por uno los departamentos a borrar
        , cuando consiga los productos de un departamento puede llamar al metodo eliminarProductos(),
        el cual se supone que ya se encarga de borrar las referencias entre el departamento y el producto
        (Ver la descripcion de dicho metodo). Finalmente, como es obvio, debe 
        eliminar el registro de los departamentos de la BD. Ademas, no debe olvidar implementar
        los metodos antes referenciados antes que este.
        */
=======
        
        DepartamentoDAO ddao=new DepartamentoDAO();
        for (Departamento departamento: departamentosABorrar) {
            ddao.eliminar(departamento.getIdDepartamento());
            System.out.println("El id del dep es"+departamento.getNombre());
            eliminarProductos(cargarProductos(departamento.getIdDepartamento()));
        }
>>>>>>> Stashed changes
    }
    
    public static void eliminarProductos(ArrayList<Producto> productosABorrar){
<<<<<<< Updated upstream
        /*Este metodo debe borrar todos los productos que pase por el arrayList
        productosABorrar usando el dao de producto. (Usar de ejemplo eliminarUsuario() en ControlUsuarios)
        Sin embargo, se debe considerar lo siguiente: Ademas de borrar los productos
        pasados por parametro (productosABorrar) de la BD, tambien debe borrar la relacion que existe
        entre esos productos y su correspondiente departamento. Para ello este metodo
        deberia llamar al metodo eliminarProductoDeDepartamento() que se encuentra
        en esta misma clase. Puede usar un bucle for y recorrer todos los productos a borrar
        y pasarle uno por uno el id de los productos a borrar. Y luego borrar los productos que se mandaron
        en productosABorrar. Para ello lo mejor seria implementar
        ese metodo antes que este. Esta implementacion es una sugerencia, pero la funcion que se 
        describe debe funcionar tal como se pide.
        */
=======
        
        ProductoDAO pdao=new ProductoDAO();
        for (Producto producto: productosABorrar) {
            pdao.eliminar(producto.getIdProducto());
            eliminarProductoDeDepartamento(producto.getIdProducto());
            
        }
>>>>>>> Stashed changes
    }
    
    public static int obtenerUltimoIDDepartamento(){
<<<<<<< Updated upstream
        /*Este metodo debe devolverme el mayor id
        de la lista de departamentos almacenada en la BD
        Usar de ejemplo el mismo metodo en ControlUsuarios
        */
        return 0;
=======
        DepartamentoDAO ddao=new DepartamentoDAO();
        return ddao.setLastId();
>>>>>>> Stashed changes
    }
    public static int obtenerUltimoIDProducto(){
<<<<<<< Updated upstream
        /*Este metodo debe hacer lo mismo que 
        obtenerUltimoIDDepartamento, pero con productos
        obviamente jeje
        */
        return 0;
=======
        
        ProductoDAO pdao=new ProductoDAO();
        return pdao.setLastId();
>>>>>>> Stashed changes
    }
}
