package Presentacion.Interfaces;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {
    ModernScrollBarUI modernScrollBarUI;
    public ScrollBarCustom() {
        modernScrollBarUI=new ModernScrollBarUI();
        setUI(modernScrollBarUI);
        setPreferredSize(new Dimension(20, 20));
        setForeground(Color.decode("#D0D0D0"));
        setBackground(Color.WHITE);
    }

    public void setThumbSize(int thumbSize) {
        modernScrollBarUI.setThumbSize(thumbSize);
    }
    
}
