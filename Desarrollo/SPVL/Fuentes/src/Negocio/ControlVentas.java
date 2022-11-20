package Negocio;

import Datos.Entidades.Venta;

/**
 *
 * @author sortizu
 */
public class ControlVentas {
    public static void registrarVenta(Venta venta){
        /*
        Este metodo debe usar el parametro "venta" para 
        registrar una nueva venta en la BD. Para ello
        es necesario crear un DAO venta y que la tabla 
        "Venta" tambien exista en la BD (revisar documento
        de especificacion de la BD, punto 5: modelo 
        relacional) .Ademas, el DAO deben encargarse de 
        asignar un id diferente a cada venta (El dao 
        de usuario funciona de la misma manera, tomarlo 
        de ejemplo si es necesario.)
        Por otro lado, ademas de la venta tambien tiene que
        registrarse la relacion entre la venta y los 
        productos que contiene. Los productos se pueden 
        obtener recorriendo el ArrayList de "DetalleVenta"
        que tiene la venta, y por cada detalleVenta obtener
        los productos. La relacion entre una venta y un 
        producto se registra en la tabla Venta-Producto
        (ver modelo relacional), que obviamente tambien
        debe ser creado. Si es necesario separar ese registro
        como otra funcion dentro de esta clase, y crearle su
        propia clase a Venta-Producto y su DAO tambien si es
        necesario.
        OJO: Antes de intentar registrar las relaciones,
        verificar si "cliente" o "usuario" son null, si lo 
        son, no registrar esos datos junto a la venta en la
        BD.
        */
    }
}
