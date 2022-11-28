package Presentacion.Interfaces.Reportes;

import Presentacion.Interfaces.BotonRedondeado;
import Presentacion.Interfaces.PanelModulo;
import Presentacion.Interfaces.TextFieldRedondeado;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sortizu
 */
public class PanelDeReportes extends JPanel{
    private PanelModulo panelModuloReportes;
    private Container parent;
    private TextFieldRedondeado txtFechaInicio;
    private TextFieldRedondeado txtFechaFin;
    private BotonRedondeado btnGenerar;
    private JPanel cuerpo;
    
    public PanelDeReportes(Container parent) {
        this.parent=parent;
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        panelModuloReportes=new PanelModulo(parent);
        gbc.insets = new Insets((int)(16.0/1040.0*panelModuloReportes.getPreferredSize().getHeight()), 0, 0, 0);
        gbc.gridx=0;
        gbc.gridy=0;
        add(panelModuloReportes,gbc);
        iniciarComponentesCuerpo();
    }
    
    private void iniciarComponentesCuerpo(){
        cuerpo = panelModuloReportes.getPanelContenedorComponentes().getCuerpo();
        int width = (int)panelModuloReportes.getPreferredSize().getWidth();
        int height = (int)panelModuloReportes.getPreferredSize().getHeight();
        
        iniciarComponentesCuerpoSuperior(width, height);
        iniciarComponentesCuerpoMedio(width, height);
        iniciarComponentesCuerpoInferior(width, height);
    }
    
    private void iniciarComponentesCuerpoSuperior(int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();
        //Parte superior del cuerpo: Seleccion de fechas
        JPanel panelSeleccionFechas = new JPanel(new GridBagLayout());
        panelSeleccionFechas.setOpaque(false);
        panelSeleccionFechas.setPreferredSize(new Dimension(0,(int)(92.0/1040.0*height)));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        gbc.weighty=0;
        cuerpo.add(panelSeleccionFechas,gbc);
        
        JPanel panelSeleccionFechaInicio = new JPanel(new GridBagLayout());
        panelSeleccionFechaInicio.setOpaque(false);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.VERTICAL;
        gbc.weightx=0;
        gbc.weighty=1.0;
        panelSeleccionFechas.add(panelSeleccionFechaInicio,gbc);
        
        JLabel lblFechaInicio = new JLabel("FECHA INICIO",JLabel.CENTER);
        lblFechaInicio.setFont(UtilidadesFuentes.InterRegular.deriveFont((float)(21.0/1040.0*height)));
        lblFechaInicio.setForeground(Color.decode("#8C8C8C"));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=0;
        gbc.weighty=0;
        panelSeleccionFechaInicio.add(lblFechaInicio,gbc);
        
        txtFechaInicio=new TextFieldRedondeado(0);
        txtFechaInicio.setFont(UtilidadesFuentes.InterRegular.deriveFont((float)(28.0/1040.0*height)));
        txtFechaInicio.setForeground(Color.decode("#8C8C8C"));
        txtFechaInicio.setColorBorde(Color.decode("#8C8C8C"));
        txtFechaInicio.setRadioDeBorde((int)(50.0/1920.0*width));
        txtFechaInicio.setGrosorBorde((int)Math.ceil(4.0/1920.0*width));
        txtFechaInicio.setText("00/00/0000");
        txtFechaInicio.setHorizontalAlignment(JLabel.CENTER);
        txtFechaInicio.setPreferredSize(new Dimension((int)(216.0/1920.0*width),0));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.VERTICAL;
        gbc.weightx=0;
        gbc.weighty=1.0;
        panelSeleccionFechaInicio.add(txtFechaInicio,gbc);
        
        JLabel lblSeparacionFecha = new JLabel("   -   ",JLabel.CENTER);
        lblSeparacionFecha.setFont(UtilidadesFuentes.InterBlack.deriveFont((float)(35.0/1040.0*height)));
        lblSeparacionFecha.setForeground(Color.decode("#8C8C8C"));
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.VERTICAL;
        gbc.weightx=0;
        gbc.weighty=0;
        panelSeleccionFechaInicio.add(lblSeparacionFecha,gbc);
        
        
        JPanel panelSeleccionFechaFin = new JPanel(new GridBagLayout());
        panelSeleccionFechaFin.setOpaque(false);
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.VERTICAL;
        gbc.weightx=0;
        gbc.weighty=1.0;
        panelSeleccionFechas.add(panelSeleccionFechaFin,gbc);
        
        JLabel lblFechaFin = new JLabel("FECHA FIN",JLabel.CENTER);
        lblFechaFin.setFont(UtilidadesFuentes.InterRegular.deriveFont((float)(21.0/1040.0*height)));
        lblFechaFin.setForeground(Color.decode("#8C8C8C"));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=0;
        gbc.weighty=0;
        panelSeleccionFechaFin.add(lblFechaFin,gbc);
        
        txtFechaFin=new TextFieldRedondeado(0);
        txtFechaFin.setFont(UtilidadesFuentes.InterRegular.deriveFont((float)(28.0/1040.0*height)));
        txtFechaFin.setForeground(Color.decode("#8C8C8C"));
        txtFechaFin.setColorBorde(Color.decode("#8C8C8C"));
        txtFechaFin.setRadioDeBorde((int)(50.0/1920.0*width));
        txtFechaFin.setGrosorBorde((int)Math.ceil(4.0/1920.0*width));
        txtFechaFin.setText("00/00/0000");
        txtFechaFin.setHorizontalAlignment(JLabel.CENTER);
        txtFechaFin.setPreferredSize(new Dimension((int)(216.0/1920.0*width),0));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.VERTICAL;
        gbc.weightx=0;
        gbc.weighty=1.0;
        panelSeleccionFechaFin.add(txtFechaFin,gbc);
        
        btnGenerar = new BotonRedondeado((int)(10.0/1920.0*width), (int)Math.ceil(3.0/1920.0*width), Color.decode("#8C8C8C"),"", UtilidadesFuentes.InterBold.deriveFont((float)(21.0/1040.0*height)));
        btnGenerar.setPreferredSize(new Dimension((int)(137.0/1920.0*width),(int)(45.0/1040.0*height)));
        gbc.insets=new Insets(0,(int)(30.0/1920.0*width), 0, 0);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.NONE;
        gbc.weightx=0;
        gbc.weighty=0;
        panelSeleccionFechaFin.add(btnGenerar,gbc);
    }
    
    private void iniciarComponentesCuerpoMedio(int width, int height){}
    
    private void iniciarComponentesCuerpoInferior(int width, int height){}
}