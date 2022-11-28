package Presentacion.Interfaces;

import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

/**
 *
 * @author sortizu
 */
public class BotonRedondeado extends PanelRedondeado{

    JTextPane textoBoton;
    
    public BotonRedondeado(int radio, int grosorBorde, Color colorBoton) {
        super(radio,grosorBorde,new Color(0,0,0,0),colorBoton);
        setLayout(new GridBagLayout());
        setOpaque(false);
        //Creando texto del boton
        textoBoton = new JTextPane();
        textoBoton.setOpaque(false);
        textoBoton.setText("");
        textoBoton.setFont(UtilidadesFuentes.InterRegular.deriveFont(10.0f));
        textoBoton.setForeground(colorBoton);
        textoBoton.setHighlighter(null);
        textoBoton.setEditable(false);
        //Añadiendo Texto al boton Cliente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(5, 5, 5, 5);
        gbc.gridx=0;
        gbc.gridy=0;
        //gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=1;
        gbc.weighty=1;
        //add(textoBoton,gbc);

        //Dando funcionalidad al boton Pago
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        java.awt.event.MouseAdapter adaptador = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                botonPresionado();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activarColorBoton();
                //textoBoton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                desactivarColorBoton();
                //textoBoton.setForeground(getColorBorde());
            }
            
        };
        addMouseListener(adaptador);
        //textoBoton.addMouseListener(adaptador);
    }

    public BotonRedondeado(int radio, int grosorBorde, Color colorBoton,String textoDeBoton, Font fuente) {
        this(radio,grosorBorde,colorBoton);
        textoBoton.setText(textoDeBoton);
        textoBoton.setFont(fuente);
    }
    
    public void botonPresionado(){
    
    }

    public void activarColorBoton(){
        setColorFondo(getColorBorde());
        repaint();
    }
    
    public void desactivarColorBoton(){
        setColorFondo(new Color(0,0,0,0));
        repaint();
    }
    
    public JTextPane getTextoBoton() {
        return textoBoton;
    }
}