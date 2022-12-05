/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Interfaces.Configuracion;

import Presentacion.Interfaces.Configuracion.*;
import Presentacion.Interfaces.PanelModulo;
import Presentacion.Interfaces.TextFieldRedondeado;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sortizu
 */
public class PanelDeConfiguracion extends JPanel{
    private PanelModulo panelModuloConfiguracion;
    private PanelDeConfiguracion panelPrincipalConfiguracion;
    private Container parent;
    private JPanel cuerpo;
    
    private TextFieldRedondeado txtRazonSocial;
    private TextFieldRedondeado txtRUC;
    private TextFieldRedondeado txtNumTerminal;
    private TextFieldRedondeado txtCodigoTienda;
    private TextFieldRedondeado txtTelefono;
    private TextFieldRedondeado txtPronvincia;
    private TextFieldRedondeado txtDistrito;
    private TextFieldRedondeado txtCiudad;
    private TextFieldRedondeado txtDireccion;
    
    public PanelDeConfiguracion(Container parent) {
        this.parent=parent;
        panelPrincipalConfiguracion=this;
        iniciarComponentes();
        cargarListaDeConfiguracion();
    }
    private void iniciarComponentes(){
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        panelModuloConfiguracion=new PanelModulo(parent);
        panelModuloConfiguracion.setTituloPanelModulo("C O N F I G U R A C I Ó N", Color.decode("#8C8C8C"));
        gbc.insets = new Insets((int)(8.0/panelModuloConfiguracion.basePanelHeight*panelModuloConfiguracion.getPreferredSize().getHeight()), 0, 0, 0);
        gbc.gridx=0;
        gbc.gridy=0;
        add(panelModuloConfiguracion,gbc);
        iniciarComponentesCuerpo();
    }

    private void iniciarComponentesCuerpo(){
        cuerpo = panelModuloConfiguracion.getPanelContenedorComponentes().getCuerpo();
        int width = (int)panelModuloConfiguracion.getPreferredSize().getWidth();
        int height = (int)panelModuloConfiguracion.getPreferredSize().getHeight();
        
        iniciarComponentesCuerpoSuperior(width, height);
        iniciarComponentesCuerpoInferior(width, height);
    }
    
    private void iniciarComponentesCuerpoSuperior(int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();
        Insets insetTxt = new Insets(0, 45, 5, 45);
        Insets insetLbl = new Insets(0, 75, 5, 45);
        
        JLabel lblRazonSocial=new JLabel("Nombre");
        lblRazonSocial.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblRazonSocial.setForeground(Color.decode("#8C8C8C"));
        lblRazonSocial.setHorizontalAlignment(JLabel.LEFT);
        gbc.insets=insetLbl;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        cuerpo.add(lblRazonSocial,gbc);
        
        Dimension dimtxtRazonSocial=new Dimension(530,45);
        
        txtRazonSocial=new TextFieldRedondeado(0);
        txtRazonSocial.setGrosorBorde(4);
        txtRazonSocial.setRadioDeBorde(40);
        txtRazonSocial.setColorBorde(Color.decode("#CACACA"));
        txtRazonSocial.setFont(UtilidadesFuentes.InterLight.deriveFont(22.0f));
        txtRazonSocial.setForeground(Color.decode("#8C8C8C"));
        txtRazonSocial.setHorizontalAlignment(JLabel.CENTER);
        txtRazonSocial.setBorder( BorderFactory.createEmptyBorder(2, 20, 0, 20) );
        txtRazonSocial.setPreferredSize(dimtxtRazonSocial);
        gbc.insets=insetTxt;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.NONE;
        gbc.weightx=0;
        cuerpo.add(txtRazonSocial,gbc);
        
    }
    
    private void iniciarComponentesCuerpoInferior(int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();
       
    }

    public void cargarListaDeConfiguracion(){
    }
 
}
