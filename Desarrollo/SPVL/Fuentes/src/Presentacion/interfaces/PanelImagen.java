package Presentacion.Interfaces;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class PanelImagen extends JPanel{
    private Image imagen;
    private String direcciondeimagen;
    public PanelImagen(String direcciondeimagen){
        super();
        this.direcciondeimagen=direcciondeimagen;
        imagen=new ImageIcon(PanelImagen.class.getResource(direcciondeimagen)).getImage();
    }
    
    public void setImagen(String direcciondeimagen){
        this.direcciondeimagen=direcciondeimagen;
        imagen=new ImageIcon(PanelImagen.class.getResource(direcciondeimagen)).getImage();
    }

    public Image getImagen() {
        return imagen;
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paintComponent(g);
    }
}
