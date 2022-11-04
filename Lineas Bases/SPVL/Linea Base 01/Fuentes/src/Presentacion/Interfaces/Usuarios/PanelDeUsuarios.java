/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Interfaces.Usuarios;

import Datos.Entidades.Usuario;
import Negocio.ControlUsuarios;
import Presentacion.Interfaces.Buscador;
import Presentacion.Interfaces.FramePrincipal;
import Presentacion.Interfaces.PanelImagen;
import Presentacion.Interfaces.RenderDeCabecera;
import Presentacion.Interfaces.ScrollBarCustom;
import Presentacion.Interfaces.Selector;
import Presentacion.Utilidades.UtilidadSesion;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sortizu
 */
public class PanelDeUsuarios extends javax.swing.JPanel implements PropertyChangeListener{

    ArrayList<Usuario> usuarios;
    private DefaultTableModel modeloDeListaDeUsuarios;
    
    
    
    
    ScrollBarCustom scrollCustom;
    
    public PanelDeUsuarios() {
        initComponents();
        setOpaque(false);
        LocalDate fecha = LocalDate.now();
        
        lblDia.setText(UtilidadSesion.nombreUsuarioActual.split(" ")[0]+", "+
                fecha.format(DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' YYYY", new Locale("es", "ES"))));
        
        ((Selector)selectorOrden).setFuenteDeOpcion(UtilidadesFuentes.InterRegular.deriveFont(15.0f));
        ((Selector)selectorOrden).setColorDeFuente(Color.decode("#8C8C8C"));
        ((Selector)selectorOrden).addPropertyChangeListener(this);
        ((Selector)selectorOrden).solicitarSeleccion(0);
        ((Selector)selectorOrden).setNombreDeSelector("SOrden");
        
        
        ((Selector)selectorSeleccion).setFuenteDeOpcion(UtilidadesFuentes.InterRegular.deriveFont(15.0f));
        ((Selector)selectorSeleccion).setColorDeFuente(Color.decode("#8C8C8C"));
        ((Selector)selectorSeleccion).addPropertyChangeListener(this);
        ((Selector)selectorSeleccion).solicitarSeleccion(0);
        ((Selector)selectorSeleccion).addColorDeOpcion(Color.decode("#72AD57"));
        ((Selector)selectorSeleccion).addColorDeOpcion(Color.decode("#AD5757"));
        ((Selector)selectorSeleccion).setNombreDeSelector("SSeleccion");
        
        ((Buscador)buscador).getTxtABuscar().setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        ((Buscador)buscador).getTxtABuscar().setForeground(Color.decode("#8C8C8C"));
        
        ((Buscador)buscador).getTxtABuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarDeFiltro(((Buscador)buscador).getTxtABuscar().getText());
            }
        });
        
        //Formato de Tabla
         modeloDeListaDeUsuarios=(DefaultTableModel)TablaListaDeUsuarios.getModel();
        //((DefaultTableCellRenderer)TablaListaDeUsuarios.getDefaultRenderer(String.class)).setHorizontalAlignment(JLabel.CENTER);
        TablaListaDeUsuarios.getTableHeader().setDefaultRenderer(new RenderDeCabecera(TablaListaDeUsuarios.getTableHeader().getDefaultRenderer()));
        
        TablaListaDeUsuarios.getTableHeader().setBackground(Color.WHITE);
        TablaListaDeUsuarios.getTableHeader().setReorderingAllowed(false);
        TablaListaDeUsuarios.getTableHeader().setFont(UtilidadesFuentes.InterLight.deriveFont(20.0f));
        TablaListaDeUsuarios.getTableHeader().setForeground(Color.decode("#8C8C8C"));
        
        
        TablaListaDeUsuarios.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(25.0f));
        TablaListaDeUsuarios.setForeground(Color.decode("#8C8C8C"));
        TablaListaDeUsuarios.setSelectionBackground(Color.decode("#23A020"));
        TablaListaDeUsuarios.setSelectionForeground(Color.white);
        TablaListaDeUsuarios.setIntercellSpacing(new Dimension(0,0));
        
        TablaListaDeUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);
        }
        });
        
        
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setOpaque(false);
        
        scrollCustom=new ScrollBarCustom();
        scrollCustom.setUnitIncrement(16);
        jScrollPane1.setVerticalScrollBar(scrollCustom);
        
        cargarListaDeUsuarios();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JLabel();
        contenedorPrincipal = new PanelImagen("/Presentacion/Imagenes/Paneles/PanelModulos.png");
        TituloDeModulo = new javax.swing.JLabel();
        lblOrden = new javax.swing.JLabel();
        selectorOrden = new Selector(new String[]{"ID","FECHA REGIS."},123,37);
        lblDia = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblSeleccion = new javax.swing.JLabel();
        selectorSeleccion = new Selector(new String[]{"SI","NO"},50,37);
        PanelBotonesCRUD = new PanelImagen("/Presentacion/Imagenes/Botones CRUD.png");
        btnEliminar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        buscador = new Buscador();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaListaDeUsuarios = new javax.swing.JTable();
        btnHome = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1360, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/Boton Salir.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });
        add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 689, -1, 80));

        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/Boton Config.png"))); // NOI18N
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1265, 688, -1, 80));

        contenedorPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        contenedorPrincipal.setToolTipText("");
        contenedorPrincipal.setPreferredSize(new java.awt.Dimension(1360, 690));
        contenedorPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloDeModulo.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(35.0f));
        TituloDeModulo.setForeground(new java.awt.Color(157, 64, 64));
        TituloDeModulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TituloDeModulo.setText("USUARIOS");
        contenedorPrincipal.add(TituloDeModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 17, -1, -1));

        lblOrden.setFont(UtilidadesFuentes.InterLight.deriveFont(20.0f));
        lblOrden.setForeground(new java.awt.Color(140, 140, 140));
        lblOrden.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrden.setText("ORDEN:");
        contenedorPrincipal.add(lblOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 89, -1, -1));
        contenedorPrincipal.add(selectorOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 82, -1, -1));

        lblDia.setFont(UtilidadesFuentes.InterLight.deriveFont(20.0f));
        lblDia.setForeground(new java.awt.Color(140, 140, 140));
        lblDia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDia.setText("Usuario, 10 de octubre de 2022");
        lblDia.setMaximumSize(new java.awt.Dimension(350, 24));
        lblDia.setMinimumSize(new java.awt.Dimension(350, 24));
        lblDia.setPreferredSize(new java.awt.Dimension(350, 24));
        contenedorPrincipal.add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 26, -1, -1));

        lblHora.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(30.0f));
        lblHora.setForeground(new java.awt.Color(140, 140, 140));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("11:30 AM");
        lblHora.setMaximumSize(new java.awt.Dimension(200, 16));
        lblHora.setPreferredSize(new java.awt.Dimension(130, 36));
        contenedorPrincipal.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1208, 20, -1, -1));

        lblSeleccion.setFont(UtilidadesFuentes.InterLight.deriveFont(20.0f));
        lblSeleccion.setForeground(new java.awt.Color(140, 140, 140));
        lblSeleccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSeleccion.setText("SELECCIÓN MÚLTIPLE:");
        lblSeleccion.setPreferredSize(new java.awt.Dimension(225, 24));
        contenedorPrincipal.add(lblSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 89, -1, -1));
        contenedorPrincipal.add(selectorSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 82, -1, -1));

        PanelBotonesCRUD.setPreferredSize(new java.awt.Dimension(390, 65));
        PanelBotonesCRUD.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        btnEliminar.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnEliminar.setForeground(new java.awt.Color(205, 95, 95));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(130, 65));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEliminarMouseReleased(evt);
            }
        });
        PanelBotonesCRUD.add(btnEliminar);

        btnModificar.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnModificar.setForeground(new java.awt.Color(95, 126, 205));
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setText("MODIFICAR");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setPreferredSize(new java.awt.Dimension(130, 65));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnModificarMouseReleased(evt);
            }
        });
        PanelBotonesCRUD.add(btnModificar);

        btnAgregar.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnAgregar.setForeground(new java.awt.Color(110, 205, 95));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setText("AGREGAR");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setPreferredSize(new java.awt.Dimension(130, 65));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAgregarMouseReleased(evt);
            }
        });
        PanelBotonesCRUD.add(btnAgregar);

        contenedorPrincipal.add(PanelBotonesCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 613, -1, -1));
        contenedorPrincipal.add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 82, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1200, 460));

        TablaListaDeUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaListaDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Permisos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaListaDeUsuarios.setAutoscrolls(false);
        TablaListaDeUsuarios.setFocusable(false);
        TablaListaDeUsuarios.setGridColor(new java.awt.Color(0, 0, 0));
        TablaListaDeUsuarios.setRowHeight(50);
        TablaListaDeUsuarios.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        TablaListaDeUsuarios.setShowGrid(false);
        jScrollPane1.setViewportView(TablaListaDeUsuarios);
        if (TablaListaDeUsuarios.getColumnModel().getColumnCount() > 0) {
            TablaListaDeUsuarios.getColumnModel().getColumn(0).setResizable(false);
            TablaListaDeUsuarios.getColumnModel().getColumn(0).setPreferredWidth(200);
            TablaListaDeUsuarios.getColumnModel().getColumn(1).setResizable(false);
            TablaListaDeUsuarios.getColumnModel().getColumn(1).setPreferredWidth(800);
            TablaListaDeUsuarios.getColumnModel().getColumn(2).setResizable(false);
            TablaListaDeUsuarios.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        contenedorPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        add(contenedorPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/Boton Home.png"))); // NOI18N
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });
        add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 689, -1, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMousePressed
        /*Utilizando utilidades de swing para obtener la ventana principal (FramePrincipal)
        y cerrar todo el programa*/
        ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
    }//GEN-LAST:event_btnSalirMousePressed

    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed
        JPanel parent = (JPanel)(getParent().getParent());
        CardLayout layout = (CardLayout) parent.getLayout();
        layout.show(parent, "menu");
        parent.remove(getParent());
    }//GEN-LAST:event_btnHomeMousePressed

    private void btnAgregarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseReleased
        AgregarUsuario agregarUsuario = new AgregarUsuario(this);
        ((FramePrincipal) SwingUtilities.getWindowAncestor(this)).mostrarPanelEmergente(agregarUsuario);
    }//GEN-LAST:event_btnAgregarMouseReleased

    private void btnModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseReleased
        ModificarUsuario modificarUsuario = new ModificarUsuario(this,TablaListaDeUsuarios.getSelectedRow());
        ((FramePrincipal) SwingUtilities.getWindowAncestor(this)).mostrarPanelEmergente(modificarUsuario);
    }//GEN-LAST:event_btnModificarMouseReleased

    private void btnEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseReleased
        if(btnEliminar.isEnabled()){
            EliminarUsuario eliminarUsuario = new EliminarUsuario(this,TablaListaDeUsuarios.getSelectedRows());
            ((FramePrincipal) SwingUtilities.getWindowAncestor(this)).mostrarPanelEmergente(eliminarUsuario);
        }
    }//GEN-LAST:event_btnEliminarMouseReleased
    public void BuscarDeFiltro(String textoBusqueda){
        TableRowSorter<DefaultTableModel> sorter =sorter = new TableRowSorter<DefaultTableModel>(modeloDeListaDeUsuarios);
        TablaListaDeUsuarios.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)"+textoBusqueda));
    }
    
    public void cargarListaDeUsuarios(){
        usuarios=ControlUsuarios.cargarListaDeUsuarios();
        for(Usuario usuario: usuarios){
            añadirUsuarioATabla(usuario);
        }
    }
    
    public void añadirUsuarioATabla(Usuario usuario){
        int npermisos=0;
        boolean [] permisos = {usuario.isGestionarVentas(),usuario.isGestionarUsuarios(),usuario.isGestionarProveedores()
        ,usuario.isGestionarClientes(),usuario.isGestionarInventario(),usuario.isGenerarReportes()};
        for(boolean permiso: permisos){
            if (permiso)
                npermisos+=1;
        }
        modeloDeListaDeUsuarios.addRow(new Object[]{usuario.getIdUsuario(),usuario.getNombre(),npermisos+"/"+permisos.length});
        //Adaptando el tamaño de la barra de Scroll
        double newScrollBarHeight=Math.pow(jScrollPane1.getPreferredSize().getHeight(),2)/(
                TablaListaDeUsuarios.getRowHeight()*TablaListaDeUsuarios.getRowCount());
        
        scrollCustom.setThumbSize((int)newScrollBarHeight);
    }
    
    public void eliminarUsuarioDeLaTabla(Usuario usuario){
        int indiceDeTabla=usuarios.indexOf(usuario);
        modeloDeListaDeUsuarios.removeRow(indiceDeTabla);
    }
    
    public void modificarUsuarioDeLaTabla(int indice, Usuario usuario){
        int npermisos=0;
        boolean [] permisos = {usuario.isGestionarVentas(),usuario.isGestionarUsuarios(),usuario.isGestionarProveedores()
        ,usuario.isGestionarClientes(),usuario.isGestionarInventario(),usuario.isGenerarReportes()};
        for(boolean permiso: permisos){
            if (permiso)
                npermisos+=1;
        }
        modeloDeListaDeUsuarios.setValueAt(usuario.getNombre(),indice ,1);
        modeloDeListaDeUsuarios.setValueAt(npermisos+"/"+permisos.length,indice ,2);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotonesCRUD;
    private javax.swing.JTable TablaListaDeUsuarios;
    private javax.swing.JLabel TituloDeModulo;
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnConfiguracion;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JPanel buscador;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JPanel selectorOrden;
    private javax.swing.JPanel selectorSeleccion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Selector selectorModificado=((Selector)evt.getSource());
        String tipoSelector=selectorModificado.getNombreDeSelector();
        switch (tipoSelector) {
            case "SSeleccion":
                    try {
                        if((int)evt.getNewValue()==0){
                            TablaListaDeUsuarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        }else{
                            TablaListaDeUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                break;
        }
    }
}
