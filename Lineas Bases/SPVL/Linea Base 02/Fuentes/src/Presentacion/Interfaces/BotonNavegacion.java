package Presentacion.Interfaces;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author sortizu
 */
class BotonNavegacion extends JPanel{
    
    public static final int SALIR=0;
    public static final int MENU=1;
    public static final int CONFIGURACION=2;
    public static final int AYUDA=3;
    private PanelImagen imagenBoton;
    private Container parentContainer;
    private JPanel panelModulo;
    
    public BotonNavegacion(int opcion,int width,int height,Container parentContainer) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.panelModulo=panelModulo;
        setLayout(new BorderLayout(0,0));
        setOpaque(false);
        this.parentContainer=parentContainer;
        String direccionImagen;
        switch (opcion) {
            case 1:
                direccionImagen="/Presentacion/Imagenes/BotonHomeModulo.png";
                addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        funcionMenu();
                    }
                });
                break;
            case 2:
                direccionImagen="/Presentacion/Imagenes/BotonConfigModulo.png";
                addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        funcionConfig();
                    }
                });
                break;
            case 0:
            default:
                direccionImagen="/Presentacion/Imagenes/BotonSalirModulo.png";
                addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        funcionSalir();
                    }
                });
        }
        setPreferredSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        imagenBoton = new PanelImagen(direccionImagen);
        add(imagenBoton,BorderLayout.CENTER);
    }
    
    protected void funcionSalir(){
        ((JFrame) SwingUtilities.getWindowAncestor(parentContainer)).dispose();
    }
    protected void funcionMenu(){
        PanelModulo.PanelContenedorComponentes panelContenedorComponentes = (PanelModulo.PanelContenedorComponentes)parentContainer;
        PanelModulo panelModulo = (PanelModulo)panelContenedorComponentes.getParentContainer();
        JPanel panelContenedorPrincipal = (JPanel)panelModulo.getParentContainer();
        CardLayout layout= (CardLayout) panelContenedorPrincipal.getLayout();
        layout.show(panelContenedorPrincipal, "menu");
        panelContenedorPrincipal.remove(panelModulo);
    }
    protected void funcionConfig(){}
}