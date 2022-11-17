package Datos.Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sortizu
 */
public class Venta {
    private int idVenta;
    private Cliente cliente;
    private Usuario usuario;
    private ArrayList<DetalleVenta> detallesVenta;
    private LocalDate fechaRegistro;
    private double pagoCliente;
    private double cambio;
    private double ventaBruta;
    private double totalCosto;
    private double totalImpuestos;
    private int totalCantidad;
    private double totalDescuento;

    public Venta() {
        detallesVenta=new ArrayList<DetalleVenta>();
    }

    public Venta(int idVenta, Cliente cliente, Usuario usuario, LocalDate fechaRegistro, double pagoCliente, double cambio) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.pagoCliente = pagoCliente;
        this.cambio = cambio;
        detallesVenta=new ArrayList<DetalleVenta>();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(ArrayList<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getPagoCliente() {
        return pagoCliente;
    }

    public void setPagoCliente(double pagoCliente) {
        this.pagoCliente = pagoCliente;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public double getVentaBruta() {
        double nuevaVentaBruta=0;
        for(DetalleVenta dv:detallesVenta){
            nuevaVentaBruta+=dv.getSubTotal();
        }
        return nuevaVentaBruta;
    }

    public double getTotalCosto() {
        double nuevoCosto=0;
        for(DetalleVenta dv:detallesVenta){
            nuevoCosto+=dv.getProducto().getCosto();
        }
        return nuevoCosto;
    }

    public double getTotalImpuestos() {
        double nuevoImpuesto=0;
        for(DetalleVenta dv:detallesVenta){
            nuevoImpuesto+=dv.getImpuestos();
        }
        return nuevoImpuesto;
    }

    public int getTotalCantidad() {
        int nuevaCantidad=0;
        for(DetalleVenta dv:detallesVenta){
            nuevaCantidad+=dv.getCantidad();
        }
        return nuevaCantidad;
    }

    public double getTotalDescuento() {
        double nuevoDescuento=0;
        for(DetalleVenta dv:detallesVenta){
            nuevoDescuento+=dv.getDescuento();
        }
        return nuevoDescuento;
    }
    
    
}
