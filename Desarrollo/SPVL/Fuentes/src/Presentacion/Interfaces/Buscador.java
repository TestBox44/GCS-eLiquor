/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author sortizu
 */
public class Buscador extends PanelRedondeado{
    private JLabel btnBuscar = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/lupa.png")));
    private JTextField txtABuscar=new JTextField();
    
    public Buscador() {
        super(30,3,Color.white,Color.decode("#8C8C8C"));
        setOpaque(false);
        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        this.setLayout(layout);
        
        setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 0) );
        
        txtABuscar.setPreferredSize(new Dimension(320,37));
        txtABuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtABuscar.setOpaque(false);
        
        JSeparator separador = new JSeparator(javax.swing.SwingConstants.VERTICAL);
        separador.setPreferredSize(new Dimension(getGrosorDeBorde(),37));
        separador.setBorder(new LineBorder(getColorBorde(),getGrosorDeBorde()));
        
        btnBuscar.setHorizontalAlignment(JLabel.CENTER);
        btnBuscar.setPreferredSize(new Dimension(40,37));
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(375,37));
        

        this.add(txtABuscar);
        this.add(separador);
        this.add(btnBuscar);
    }

    public JLabel getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JLabel btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JTextField getTxtABuscar() {
        return txtABuscar;
    }

    public void setTxtABuscar(JTextField txtABuscar) {
        this.txtABuscar = txtABuscar;
    }
    
}
