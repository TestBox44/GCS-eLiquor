package Datos.Entidades;

/**
 *
 * @author sortizu
 */
public class DetalleVenta {
    private Producto producto;
    private int cantidad;
    private double precio; //Reemplaza al del producto
    private double descuento;
    private double impuestos=-1;
    private double total;
    private boolean IGV; //Reemplaza al del producto
    private boolean ISC; //Reemplaza al del producto

    public DetalleVenta() {
    }

    public DetalleVenta(Producto producto, int cantidad, double precio, double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        IGV=producto.isIGV();
        ISC=producto.isISC();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean isIGV() {
        return IGV;
    }

    public void setIGV(boolean IGV) {
        this.IGV = IGV;
    }

    public boolean isISC() {
        return ISC;
    }

    public void setISC(boolean ISC) {
        this.ISC = ISC;
    }
    
    
    
    /*Si se asigna un nuevo impuesto con setImpuesto
    y este nuevo valor es cero o mayor, se devolvera 
    ese valor asignado. Caso contrario, se devolvera
    el valor de impuesto en base a las variables IGV
    e ISC de producto
    */
    public double getImpuestos() {
        double nuevoImpuesto=0;
        if(impuestos>=0){
            nuevoImpuesto=impuestos;
        }else{
            if(IGV){
                nuevoImpuesto+=0.17*precio*cantidad;
            }
            if(ISC){
                nuevoImpuesto+=2.72*cantidad;
            }
        }
        return nuevoImpuesto;
    }

    //EL "SUBTOTAL" es la cantidad por el precio
    public double getSubTotal() {
        double nuevoSubTotal=cantidad*precio;
        return nuevoSubTotal;
    }
    //El "TOTAL" valor del subtotal menos el descuento
    public double getTotal() {
        double nuevoTotal=getSubTotal()-descuento;
        return nuevoTotal;
    }

}
