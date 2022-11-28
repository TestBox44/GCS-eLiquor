package Presentacion.Interfaces;

import Presentacion.Utilidades.UtilidadSesion;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author sortizu
 */
public class PanelModulo extends JLayeredPane{
    
    private PanelImagen panelFormaContenedor;
    private PanelContenedorComponentes panelContenedorComponentes;
    private Container parentContainer;
    
    public PanelModulo(Container parentContainer) {
        this.parentContainer = parentContainer;
        ajustarPanelAVentana();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        setOpaque(false);
        int width=getPreferredSize().width;
        int height=getPreferredSize().height;
        panelFormaContenedor=new PanelImagen("/Presentacion/Imagenes/Paneles/PanelModulo.png");
        panelFormaContenedor.setBounds(0, 0, width, (int)(0.97*height));
        add(panelFormaContenedor,JLayeredPane.DEFAULT_LAYER);
        
        panelContenedorComponentes=new PanelContenedorComponentes(this);
        panelContenedorComponentes.setOpaque(false);
        panelContenedorComponentes.setBounds(0, 0, width, height);
        add(panelContenedorComponentes,JLayeredPane.PALETTE_LAYER);
    }
    
    private void ajustarPanelAVentana(){
        try{
            JFrame framePrincipal = ((JFrame) SwingUtilities.getWindowAncestor(parentContainer));
            int basePanelHeight=1040;
            int basePanelWidth=1920;
            double basePanelAspectRatio = (double)basePanelWidth/basePanelHeight;
            double basicScreenAspectRatio = 16/9;
            int height = framePrincipal.getHeight();
            int width = framePrincipal.getWidth();
            if(width/height<=basicScreenAspectRatio){
                int newPanelWidth = width;
                int newPanelHeight = (int)(newPanelWidth/basePanelAspectRatio);
                redimensionar(newPanelWidth, newPanelHeight);
            }else{
                int newPanelHeight = height;
                int newPanelWidth = (int)(newPanelHeight*basePanelAspectRatio);
                redimensionar(newPanelWidth, newPanelHeight);
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    private void redimensionar(int width, int height){
        setPreferredSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
    }

    public PanelContenedorComponentes getPanelContenedorComponentes() {
        return panelContenedorComponentes;
    }

    public void setPanelContenedorComponentes(PanelContenedorComponentes panelContenedorComponentes) {
        this.panelContenedorComponentes = panelContenedorComponentes;
    }
    
    public void setTituloPanelModulo(String titulo, Color color){
        panelContenedorComponentes.getLbltituloModulo().setText(titulo);
        panelContenedorComponentes.getLbltituloModulo().setForeground(color);
    }

    public Container getParentContainer() {
        return parentContainer;
    }
    
    public class PanelContenedorComponentes extends JPanel{
        private JPanel cabecera;
        private JLabel lbltituloModulo;
        private JLabel lblinformacionUsuarioFecha;
        private JLabel lblHora;
        private JPanel cuerpo;
        private JPanel panelBotonesNavegacion;
        private BotonNavegacion btnSalir;
        private BotonNavegacion btnHome;
        private BotonNavegacion btnConfig;
        private Container parentContainer;
        
        public PanelContenedorComponentes(Container parentContainer) {
            this.parentContainer = parentContainer;
            iniciarComponentes();
        }
        private void iniciarComponentes(){
            int width=parentContainer.getPreferredSize().width;
            int height=parentContainer.getPreferredSize().height;
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            cabecera=new JPanel();
            cabecera.setLayout(new GridBagLayout());
            Dimension cabeceraSize = new Dimension(0,(int)(49.0/1039.0*height));
            cabecera.setPreferredSize(cabeceraSize);
            cabecera.setMinimumSize(cabeceraSize);
            cabecera.setOpaque(false);
            gbc.insets=new Insets((int)(8.0/1080.0*height), 0, 0, 0);
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.weightx=1.0;
            gbc.weighty=0;
            add(cabecera,gbc);
            
            cuerpo=new JPanel();
            cuerpo.setLayout(new GridBagLayout());
            cuerpo.setOpaque(false);
            Dimension dimCuerpo = new Dimension(0,(int)(885.0/1039.0*height));
            cuerpo.setPreferredSize(dimCuerpo);
            cuerpo.setMinimumSize(dimCuerpo);
            cuerpo.setMaximumSize(dimCuerpo);
            gbc.insets=new Insets(0, 0, 0, 0);
            gbc.gridx=0;
            gbc.gridy=1;
            //gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.weightx=1.0;
            gbc.weighty=0;
            add(cuerpo,gbc);
            
            panelBotonesNavegacion=new JPanel();
            panelBotonesNavegacion.setLayout(new FlowLayout(FlowLayout.CENTER, (int)(84.0/1920*width), 0));
            Dimension dimensionPanelBotonesNav = new Dimension(0,(int)(77.0/1039.0*height));
            panelBotonesNavegacion.setPreferredSize(dimensionPanelBotonesNav);
            panelBotonesNavegacion.setMinimumSize(dimensionPanelBotonesNav);
            panelBotonesNavegacion.setOpaque(false);
            gbc.anchor=GridBagConstraints.PAGE_START;
            gbc.gridx=0;
            gbc.gridy=2;
            gbc.fill=GridBagConstraints.BOTH;
            gbc.weightx=1.0;
            gbc.weighty=1.0;
            add(panelBotonesNavegacion,gbc);
            iniciarComponentesCabecera(width, height);
            iniciarComponentesBotones(width, height);
        }
        private void iniciarComponentesCabecera(int width, int height){
            
            GridBagConstraints gbc = new GridBagConstraints();
            lbltituloModulo = new JLabel("TITULO-MÓDULO");
            Dimension dimensionTitulo = new Dimension((int)(524.0/1920.0*width),1);
            lbltituloModulo.setPreferredSize(dimensionTitulo);
            lbltituloModulo.setMinimumSize(dimensionTitulo);
            lbltituloModulo.setFont(UtilidadesFuentes.InterRegular.deriveFont((float)Math.floor(40.0*height/1080.0)));
            lbltituloModulo.setForeground(Color.decode("#8C8C8C"));
            lbltituloModulo.setHorizontalAlignment(JLabel.CENTER);
            gbc.insets=new Insets((int)(8.0/1080.0*height), (int)(42.0/1920.0*width), 0, 0);
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.fill=GridBagConstraints.VERTICAL;
            gbc.weightx=0;
            gbc.weighty=1;
            cabecera.add(lbltituloModulo,gbc);
            
            lblinformacionUsuarioFecha = new JLabel(UtilidadSesion.nombreUsuarioActual.split(" ")[0]+", 10 de octubre de 2022  |");
            Dimension dimensionInformacion = new Dimension((int)(500.0/1920.0*width),1);
            lblinformacionUsuarioFecha.setPreferredSize(dimensionInformacion);
            lblinformacionUsuarioFecha.setMinimumSize(dimensionInformacion);
            lblinformacionUsuarioFecha.setFont(UtilidadesFuentes.InterLight.deriveFont((float)Math.floor(25*height/1080.0)));
            lblinformacionUsuarioFecha.setForeground(Color.decode("#8C8C8C"));
            lblinformacionUsuarioFecha.setHorizontalAlignment(JLabel.RIGHT);
            gbc.insets=new Insets((int)(8.0/1080.0*height), (int)(703.0/1920.0*width), 0, 0);
            gbc.gridx=1;
            gbc.gridy=0;
            gbc.fill=GridBagConstraints.VERTICAL;
            gbc.weightx=0;
            gbc.weighty=1;
            cabecera.add(lblinformacionUsuarioFecha,gbc);
            
            lblHora = new JLabel("10:30 PM");
            Dimension dimensionHora = new Dimension((int)(128.0/1920.0*width),1);
            lblHora.setPreferredSize(dimensionHora);
            lblHora.setMinimumSize(dimensionHora);
            lblHora.setFont(UtilidadesFuentes.InterLight.deriveFont((float)Math.floor(30*height/1080.0)));
            lblHora.setForeground(Color.decode("#8C8C8C"));
            lblHora.setHorizontalAlignment(JLabel.CENTER);
            gbc.insets=new Insets((int)(8.0/1080.0*height),(int)(10.0/1920.0*width),0,(int)(10.0/1920.0*width));
            gbc.gridx=2;
            gbc.gridy=0;
            gbc.fill=GridBagConstraints.VERTICAL;
            gbc.weightx=0;
            gbc.weighty=1;
            cabecera.add(lblHora,gbc);
        }
        private void iniciarComponentesBotones(int width, int height){
            btnSalir=new BotonNavegacion(BotonNavegacion.SALIR, (int)(104.0/1920.0*width), (int)(108.0/1080.0*height), this);
            panelBotonesNavegacion.add(btnSalir);
            btnHome=new BotonNavegacion(BotonNavegacion.MENU, (int)(104.0/1920.0*width), (int)(108.0/1080.0*height), this);
            panelBotonesNavegacion.add(btnHome);
            btnConfig=new BotonNavegacion(BotonNavegacion.CONFIGURACION, (int)(104.0/1920.0*width), (int)(108.0/1080.0*height), this);
            panelBotonesNavegacion.add(btnConfig);
        }

        public JPanel getCabecera() {
            return cabecera;
        }

        public void setCabecera(JPanel cabecera) {
            this.cabecera = cabecera;
        }

        public JLabel getLbltituloModulo() {
            return lbltituloModulo;
        }

        public void setLbltituloModulo(JLabel lbltituloModulo) {
            this.lbltituloModulo = lbltituloModulo;
        }

        public JLabel getLblinformacionUsuarioFecha() {
            return lblinformacionUsuarioFecha;
        }

        public void setLblinformacionUsuarioFecha(JLabel lblinformacionUsuarioFecha) {
            this.lblinformacionUsuarioFecha = lblinformacionUsuarioFecha;
        }

        public JLabel getLblHora() {
            return lblHora;
        }

        public void setLblHora(JLabel lblHora) {
            this.lblHora = lblHora;
        }

        public JPanel getCuerpo() {
            return cuerpo;
        }

        public void setCuerpo(JPanel cuerpo) {
            this.cuerpo = cuerpo;
        }

        public JPanel getPanelBotonesNavegacion() {
            return panelBotonesNavegacion;
        }

        public void setPanelBotonesNavegacion(JPanel panelBotonesNavegacion) {
            this.panelBotonesNavegacion = panelBotonesNavegacion;
        }
        
        
        
        public Container getParentContainer() {
        return parentContainer;
    }
    }
}