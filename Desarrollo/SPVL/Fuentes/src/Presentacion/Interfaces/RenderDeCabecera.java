/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Interfaces;

import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author USER
 */
public class RenderDeCabecera implements TableCellRenderer{
    private final TableCellRenderer baseRenderer;

    public RenderDeCabecera(TableCellRenderer baseRenderer) {
        ((DefaultTableCellRenderer)baseRenderer).setHorizontalAlignment(JLabel.LEFT);
        this.baseRenderer = baseRenderer; 
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent c = (JComponent)baseRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#8C8C8C")));
        return c;
    }
}
