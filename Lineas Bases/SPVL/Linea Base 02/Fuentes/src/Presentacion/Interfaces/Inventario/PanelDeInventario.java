package Presentacion.Interfaces.Inventario;

import Datos.Entidades.Departamento;
import Datos.Entidades.Entrega;
import Datos.Entidades.Producto;
import Negocio.ControlInventario;
import Presentacion.Interfaces.Buscador;
import Presentacion.Interfaces.FramePrincipal;
import Presentacion.Interfaces.Item;
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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author sortizu
 */
public class PanelDeInventario extends javax.swing.JPanel implements PropertyChangeListener{

    private int[] cursor = new int[]{0,0};
    public ArrayList<Departamento> departamentos;
    public ArrayList<Producto> productos;
    private JScrollPane scrollPaneDeListaDeItems;
    private JTable TablaListaDeItems;
    private DefaultTableModel modeloDeListaDeItems;
    private JPanel mostradorDeItems;
    public JLabel lblDepartamentoActual;
    private JSeparator separadorLblDpto;
    public Departamento departamentoSeleccionado;
    
    //Botones CRUD
    //Para departamentos
    private JLabel btnAgregarDepartamento;
    private JLabel btnVerProductos;
    private JLabel btnModificarDepartamento;
    private JLabel btnEliminarDepartamento;
    //Para productos
    private JLabel btnAgregarProducto;
    private JLabel btnIngresoProducto;
    private JLabel btnModificarProducto;
    private JLabel btnEliminarProducto;
    
    
    DefaultTableCellRenderer nuevoCellRenderer = new DefaultTableCellRenderer(){
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            if(value instanceof Item){
                Item item=(Item)value;
                return item;
            }
            
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        }
    };
    
    
    
    ScrollBarCustom scrollCustom;
    
    public PanelDeInventario() {
        initComponents();
        setOpaque(false);
        LocalDate fecha = LocalDate.now();
        
        lblDia.setText(UtilidadSesion.nombreUsuarioActual.split(" ")[0]+", "+
                fecha.format(DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' YYYY", new Locale("es", "ES"))));
        
        ((Selector)selectorVista).setFuenteDeOpcion(UtilidadesFuentes.InterRegular.deriveFont(15.0f));
        ((Selector)selectorVista).setColorDeFuente(Color.decode("#8C8C8C"));
        ((Selector)selectorVista).addPropertyChangeListener(this);
        ((Selector)selectorVista).solicitarSeleccion(0);
        ((Selector)selectorVista).setNombreDeSelector("SVista");
        
        
        ((Selector)selectorSeleccion).setFuenteDeOpcion(UtilidadesFuentes.InterRegular.deriveFont(15.0f));
        ((Selector)selectorSeleccion).setColorDeFuente(Color.decode("#8C8C8C"));
        ((Selector)selectorSeleccion).addPropertyChangeListener(this);
        ((Selector)selectorSeleccion).solicitarSeleccion(0);
        ((Selector)selectorSeleccion).addColorDeOpcion(Color.decode("#72AD57"));
        ((Selector)selectorSeleccion).addColorDeOpcion(Color.decode("#AD5757"));
        ((Selector)selectorSeleccion).setNombreDeSelector("SSeleccion");
        
        ((Buscador)buscador).getTxtABuscar().setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        ((Buscador)buscador).getTxtABuscar().setForeground(Color.decode("#8C8C8C"));
        ((Buscador)buscador).setPreferredSize(new Dimension(375,37));
        ((Buscador)buscador).getTxtABuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                BuscarDeFiltro(((Buscador)buscador).getTxtABuscar().getText());
            }
            
        });
        
        //Creando tabla de items
        scrollPaneDeListaDeItems = new javax.swing.JScrollPane();
        TablaListaDeItems = new javax.swing.JTable(0,7){
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        TablaListaDeItems.setAutoscrolls(false);
        TablaListaDeItems.setCellSelectionEnabled(true);
        TablaListaDeItems.setFocusable(false);
        TablaListaDeItems.setGridColor(new java.awt.Color(0, 0, 0));
        TablaListaDeItems.setRowHeight(150);
        TablaListaDeItems.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        TablaListaDeItems.setShowGrid(false);
        scrollPaneDeListaDeItems.setViewportView(TablaListaDeItems);
        
        //Formato de Tabla
        modeloDeListaDeItems=(DefaultTableModel)TablaListaDeItems.getModel();
        TablaListaDeItems.getTableHeader().setDefaultRenderer(new RenderDeCabecera(TablaListaDeItems.getTableHeader().getDefaultRenderer()));
        TablaListaDeItems.setDefaultRenderer(Object.class, nuevoCellRenderer);
        TablaListaDeItems.getTableHeader().setBackground(Color.WHITE);
        TablaListaDeItems.getTableHeader().setReorderingAllowed(false);
        TablaListaDeItems.getTableHeader().setFont(UtilidadesFuentes.InterLight.deriveFont(20.0f));
        TablaListaDeItems.getTableHeader().setForeground(Color.decode("#8C8C8C"));
        
        
        TablaListaDeItems.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(25.0f));
        TablaListaDeItems.setForeground(Color.decode("#8C8C8C"));
        TablaListaDeItems.setSelectionBackground(Color.WHITE);
        TablaListaDeItems.setSelectionForeground(Color.WHITE);
        TablaListaDeItems.setIntercellSpacing(new Dimension(30,10));
        TablaListaDeItems.getTableHeader().setUI(null);
        
        TablaListaDeItems.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
                boolean activarFunciones=false;
                int[] columnas = TablaListaDeItems.getSelectedColumns();
                int[] filas  = TablaListaDeItems.getSelectedRows();
                for(int i=0; i< TablaListaDeItems.getColumnCount();i++){
                    for(int j=0; j< TablaListaDeItems.getRowCount();j++){
                        Item item = (Item)TablaListaDeItems.getValueAt(j, i);
                        if(item!=null){
                            item.DeseleccionarItem();
                            TablaListaDeItems.setValueAt(item, j, i);
                        }
                    }
                }
                for(int columna: columnas){
                    for(int fila: filas){
                        Item item = (Item)TablaListaDeItems.getValueAt(fila, columna);
                        if(item!=null){
                            activarFunciones=true;
                            if(!item.getSeleccionado()){
                                item.seleccionarItem();
                                TablaListaDeItems.setValueAt(item, fila, columna);
                            }
                        }
                    }
                }
                if(activarFunciones){
                    if(((Selector)selectorVista).getOpcionSeleccionada()==0){
                        activarBotonesFuncionDepartamento();
                    }else{
                        activarBotonesFuncionProducto();
                    }
                }else{
                    if(((Selector)selectorVista).getOpcionSeleccionada()==0){
                        desactivarBotonesFuncionDepartamento();
                    }else{
                        desactivarBotonesFuncionProducto();
                    }
                }
        }
        });
        TablaListaDeItems.getColumnModel().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
                boolean activarFunciones=false;
                int[] columnas = TablaListaDeItems.getSelectedColumns();
                int[] filas  = TablaListaDeItems.getSelectedRows();
                for(int i=0; i< TablaListaDeItems.getColumnCount();i++){
                    for(int j=0; j< TablaListaDeItems.getRowCount();j++){
                        Item item = (Item)TablaListaDeItems.getValueAt(j, i);
                        if(item!=null){
                            item.DeseleccionarItem();
                            TablaListaDeItems.setValueAt(item, j, i);
                        }
                    }
                }
                for(int columna: columnas){
                    for(int fila: filas){
                        Item item = (Item)TablaListaDeItems.getValueAt(fila, columna);
                        if(item!=null){
                            activarFunciones=true;
                            if(!item.getSeleccionado()){
                                item.seleccionarItem();
                                TablaListaDeItems.setValueAt(item, fila, columna);
                            }
                        }
                    }
                }
                if(activarFunciones){
                    if(((Selector)selectorVista).getOpcionSeleccionada()==0){
                        activarBotonesFuncionDepartamento();
                    }else{
                        activarBotonesFuncionProducto();
                    }
                }else{
                    if(((Selector)selectorVista).getOpcionSeleccionada()==0){
                        desactivarBotonesFuncionDepartamento();
                    }else{
                        desactivarBotonesFuncionProducto();
                    }
                }
        }
        });
        
        
        scrollPaneDeListaDeItems.setBorder(BorderFactory.createEmptyBorder());
        scrollPaneDeListaDeItems.getViewport().setBackground(Color.WHITE);
        scrollPaneDeListaDeItems.setOpaque(false);
        
        scrollCustom=new ScrollBarCustom();
        scrollCustom.setUnitIncrement(16);
        scrollPaneDeListaDeItems.setVerticalScrollBar(scrollCustom);
        
        //Añadiendo componentes al mostradorDeItems
        mostradorDeItems=new JPanel();
        mostradorDeItems.setPreferredSize(new Dimension(1200,475));
        mostradorDeItems.setOpaque(false);
        mostradorDeItems.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(10, 0, 0, 0);
        
        lblDepartamentoActual=new JLabel("DPTO: TODOS");
        lblDepartamentoActual.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblDepartamentoActual.setForeground(Color.decode("#8C8C8C"));
        lblDepartamentoActual.setHorizontalAlignment(JLabel.CENTER);
        lblDepartamentoActual.setVisible(false);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        mostradorDeItems.add(lblDepartamentoActual,gbc);
        
        separadorLblDpto = new JSeparator(javax.swing.SwingConstants.HORIZONTAL);
        separadorLblDpto.setPreferredSize(new Dimension(0,1));
        separadorLblDpto.setBorder(new LineBorder(Color.decode("#D0D0D0"),1));
        separadorLblDpto.setVisible(false);
        gbc.insets=new Insets(0, 0, 0 ,0);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1.0;
        gbc.weighty=0.0;
        mostradorDeItems.add(separadorLblDpto,gbc);
        
        gbc.insets=new Insets(10, 0, 0, 0);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        mostradorDeItems.add(scrollPaneDeListaDeItems,gbc);
        
        contenedorPrincipal.add(mostradorDeItems,new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));
        
        //Creacion de botones CRUD 
        PanelDeInventario referenciaDeInventarioPrincipal = this;
        //Para departamento
        btnAgregarDepartamento=new JLabel("AGREGAR");
        btnAgregarDepartamento.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnAgregarDepartamento.setForeground(Color.decode("#6ECD5F"));
        btnAgregarDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarDepartamento.setPreferredSize(new java.awt.Dimension(128, 65));
        btnAgregarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnAgregarDepartamento.isEnabled()){
                    AgregarDepartamento agregarDepartamento = new AgregarDepartamento(referenciaDeInventarioPrincipal);
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(agregarDepartamento);
                    agregarDepartamento.requestFocusInWindow();
                }
            }
        });
        
        btnVerProductos=new JLabel("VER PROD.");
        btnVerProductos.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnVerProductos.setForeground(Color.decode("#D9AA4F"));
        btnVerProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVerProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerProductos.setPreferredSize(new java.awt.Dimension(128, 65));
        btnVerProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnVerProductos.isEnabled()){
                    try {
                    departamentoSeleccionado = departamentos.get(TablaListaDeItems.getSelectedRow()*7+TablaListaDeItems.getSelectedColumn());
                    lblDepartamentoActual.setText("DPTO: "+departamentoSeleccionado.getNombre());
                    ((Selector)selectorVista).solicitarSeleccion(1);
                } catch (Exception e) {}
                }
            }
        });
        
        btnModificarDepartamento=new JLabel("MODIFICAR");
        btnModificarDepartamento.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnModificarDepartamento.setForeground(Color.decode("#5F7ECD"));
        btnModificarDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarDepartamento.setPreferredSize(new java.awt.Dimension(128, 65));
        btnModificarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnModificarDepartamento.isEnabled()){
                    ModificarDepartamento modificarDepartamento = new ModificarDepartamento(referenciaDeInventarioPrincipal, new int [] {TablaListaDeItems.getSelectedRow(), TablaListaDeItems.getSelectedColumn()});
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(modificarDepartamento);
                    modificarDepartamento.requestFocusInWindow();
                }
            }
        });
        
        btnEliminarDepartamento=new JLabel("ELIMINAR");
        btnEliminarDepartamento.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnEliminarDepartamento.setForeground(Color.decode("#CD5F5F"));
        btnEliminarDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarDepartamento.setPreferredSize(new java.awt.Dimension(128, 65));
        btnEliminarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnEliminarDepartamento.isEnabled()){
                    EliminarDepartamento eliminarDepartamento = new EliminarDepartamento(referenciaDeInventarioPrincipal,TablaListaDeItems.getSelectedRows(),TablaListaDeItems.getSelectedColumns());
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(eliminarDepartamento);
                    eliminarDepartamento.requestFocusInWindow();
                }
            }
        });
        
        //Para producto
        btnAgregarProducto=new JLabel("AGREGAR");
        btnAgregarProducto.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnAgregarProducto.setForeground(Color.decode("#6ECD5F"));
        btnAgregarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.setPreferredSize(new java.awt.Dimension(128, 65));
        btnAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnAgregarProducto.isEnabled()){
                   AgregarProducto agregarProducto = new AgregarProducto(referenciaDeInventarioPrincipal);
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(agregarProducto);
                    agregarProducto.requestFocusInWindow();
                }
            }
        });
        
        btnIngresoProducto=new JLabel("INGRESO");
        btnIngresoProducto.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnIngresoProducto.setForeground(Color.decode("#D9AA4F"));
        btnIngresoProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIngresoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresoProducto.setPreferredSize(new java.awt.Dimension(128, 65));
        btnIngresoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnIngresoProducto.isEnabled()){/*
                    IngresoProducto1 ingresoProducto1 = new IngresoProducto1(referenciaDeInventarioPrincipal,new Entrega(0,productos.get(TablaListaDeItems.getSelectedRow()*7+TablaListaDeItems.getSelectedColumn()),0,0,null,null));
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(ingresoProducto1);
                    ingresoProducto1.requestFocusInWindow();*/
                }
            }
        });
        
        btnModificarProducto=new JLabel("MODIFICAR");
        btnModificarProducto.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnModificarProducto.setForeground(Color.decode("#5F7ECD"));
        btnModificarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarProducto.setPreferredSize(new java.awt.Dimension(128, 65));
        btnModificarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnModificarProducto.isEnabled()){
                     ModificarProducto modificarProducto = new ModificarProducto(referenciaDeInventarioPrincipal,new int [] {TablaListaDeItems.getSelectedRow(), TablaListaDeItems.getSelectedColumn()});
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(modificarProducto);
                    modificarProducto.requestFocusInWindow();
                }
            }
        });
        
        btnEliminarProducto=new JLabel("ELIMINAR");
        btnEliminarProducto.setFont(UtilidadesFuentes.InterRegular.deriveFont(20.0f));
        btnEliminarProducto.setForeground(Color.decode("#CD5F5F"));
        btnEliminarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.setPreferredSize(new java.awt.Dimension(128, 65));
        btnEliminarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(btnEliminarProducto.isEnabled()){
                   EliminarProducto eliminarProducto = new EliminarProducto(referenciaDeInventarioPrincipal,TablaListaDeItems.getSelectedRows(),TablaListaDeItems.getSelectedColumns());
                    ((FramePrincipal) SwingUtilities.getWindowAncestor(referenciaDeInventarioPrincipal)).mostrarPanelEmergente(eliminarProducto);
                    eliminarProducto.requestFocusInWindow();
                }
            }
        });
        
        
        //Instanciando botones CRUD para departamento
        PanelBotonesCRUD.add(btnEliminarDepartamento);
        PanelBotonesCRUD.add(btnModificarDepartamento);
        PanelBotonesCRUD.add(btnVerProductos);
        PanelBotonesCRUD.add(btnAgregarDepartamento);
        
        
        cargarListaDeDepartamentos();
        desactivarBotonesFuncionDepartamento();
        //Permite no tener focus de forma automatica en el buscador
        /*btnAgregar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JComponent component = evt.getComponent();
		component.requestFocusInWindow();
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });*/
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contenedorPrincipal = new PanelImagen("/Presentacion/Imagenes/Paneles/PanelModulos.png");
        TituloDeModulo = new javax.swing.JLabel();
        lblOrden = new javax.swing.JLabel();
        selectorVista = new Selector(new String[]{"DEPARTAMENTO","PRODUCTO"},150,37);
        lblDia = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblSeleccion = new javax.swing.JLabel();
        selectorSeleccion = new Selector(new String[]{"SI","NO"},50,37);
        PanelBotonesCRUD = new PanelImagen("/Presentacion/Imagenes/BotonesCRUD4.png");
        buscador = new Buscador();
        SeparadorTabla = new javax.swing.JSeparator();
        btnSalir = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JLabel();
        btnHome = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1360, 768));
        setLayout(new java.awt.GridBagLayout());

        contenedorPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        contenedorPrincipal.setToolTipText("");
        contenedorPrincipal.setPreferredSize(new java.awt.Dimension(1360, 690));
        contenedorPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloDeModulo.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(35.0f));
        TituloDeModulo.setForeground(new java.awt.Color(198, 201, 77));
        TituloDeModulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TituloDeModulo.setText("INVENTARIO");
        contenedorPrincipal.add(TituloDeModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 17, -1, -1));

        lblOrden.setFont(UtilidadesFuentes.InterLight.deriveFont(20.0f));
        lblOrden.setForeground(new java.awt.Color(140, 140, 140));
        lblOrden.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrden.setText("VISTA POR:");
        contenedorPrincipal.add(lblOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 89, -1, -1));
        contenedorPrincipal.add(selectorVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 82, -1, -1));

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

        PanelBotonesCRUD.setPreferredSize(new java.awt.Dimension(526, 65));
        PanelBotonesCRUD.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 0));
        contenedorPrincipal.add(PanelBotonesCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 602, -1, -1));
        contenedorPrincipal.add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 82, -1, -1));

        SeparadorTabla.setForeground(new java.awt.Color(208, 208, 208));
        SeparadorTabla.setPreferredSize(new java.awt.Dimension(1200, 1));
        contenedorPrincipal.add(SeparadorTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 595, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(contenedorPrincipal, gridBagConstraints);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/BotonSalirModulo.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(btnSalir, gridBagConstraints);

        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/BotonConfigModulo.png"))); // NOI18N
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        add(btnConfiguracion, gridBagConstraints);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/BotonHomeModulo.png"))); // NOI18N
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        add(btnHome, gridBagConstraints);
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
    
    public void desactivarBotonesFuncionDepartamento(){
        btnEliminarDepartamento.setEnabled(false);
        btnModificarDepartamento.setEnabled(false);
        btnVerProductos.setEnabled(false);
    }
    
    public void activarBotonesFuncionDepartamento(){
        btnEliminarDepartamento.setEnabled(true);
        btnModificarDepartamento.setEnabled(true);
        btnVerProductos.setEnabled(true);
    }
    
    public void desactivarBotonesFuncionProducto(){
        btnEliminarProducto.setEnabled(false);
        btnModificarProducto.setEnabled(false);
        btnIngresoProducto.setEnabled(false);
    }
    
    public void activarBotonesFuncionProducto(){
        btnEliminarProducto.setEnabled(true);
        btnModificarProducto.setEnabled(true);
        //btnIngresoProducto.setEnabled(true);
    }
    
    public void BuscarDeFiltro(String textoBusqueda){
        RowFilter<Object,Object> filtro = new RowFilter<Object, Object>(){
            private Matcher matcher=Pattern.compile("(?i)"+textoBusqueda).matcher("");
            @Override
            public boolean include(RowFilter.Entry<? extends Object, ? extends Object> entry) {
                for(int i=entry.getValueCount()-1;i>=0;i--){
                    Object obj = entry.getValue(i);
                    if(obj instanceof Item){
                        Item item = (Item)obj;
                        String nombre=item.getNombre().getText();
                        matcher.reset(nombre);
                        if(matcher.find()){
                            return true;
                        }
                    }
                }
                return false;
            }
            
        };
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modeloDeListaDeItems);
        TablaListaDeItems.setRowSorter(sorter);
        //sorter.setRowFilter(RowFilter.regexFilter("(?i)"+textoBusqueda));
        sorter.setRowFilter(filtro);
    }
    
    public void cargarListaDeDepartamentos(){
        departamentos=ControlInventario.cargarDepartamentos();
        mostrarListaDepartamentosCargadaEnTabla();
    }
    
    public void mostrarListaDepartamentosCargadaEnTabla(){
        limpiarTabla();
        cursor[0]=0;
        cursor[1]=0;
        for(Departamento departamento: departamentos){
            añadirDepartamentoATabla(departamento);
        }
    }
    
    public void mostrarListaProductosCargadaEnTabla(){
        limpiarTabla();
        cursor[0]=0;
        cursor[1]=0;
        for(Producto producto: productos){
            añadirProductoATabla(producto);
        }
    }
    
    public void añadirDepartamentoATabla(Departamento departamento){
        if(cursor[0]==7){
            modeloDeListaDeItems.addRow(new Object[7]);
            cursor[0]=0;
            cursor[1]++;
        }else if(modeloDeListaDeItems.getRowCount()==0){
            modeloDeListaDeItems.addRow(new Object[7]);
        }
        Item item = new Item(departamento.getNombre(), (departamento.getCantidad()+" ITEMS"));
        modeloDeListaDeItems.setValueAt(item, cursor[1], cursor[0]++);
        actualizarScroll();
    }
    
    public void añadirProductoATabla(Producto producto){
        if(cursor[0]==7){
            modeloDeListaDeItems.addRow(new Object[7]);
            cursor[0]=0;
            cursor[1]++;
        }else if(modeloDeListaDeItems.getRowCount()==0){
            modeloDeListaDeItems.addRow(new Object[7]);
        }
        Item item = new Item(producto.getNombre(),"STOCK: "+producto.getStock());
        modeloDeListaDeItems.setValueAt(item, cursor[1], cursor[0]++);
        actualizarScroll();
    }
    
    public void limpiarTabla(){
        modeloDeListaDeItems.setRowCount(0);
    }
    
    public void modificarDepartamentoEnTabla(int[] indice, Departamento departamento){
        Item item = (Item)TablaListaDeItems.getValueAt(indice[0], indice[1]);
        item.getNombre().setText(departamento.getNombre());
        item.getSubtitulo().setText(departamento.getCantidad()+" ITEMS");
        modeloDeListaDeItems.setValueAt(item, indice[0], indice[1]);
        actualizarScroll();
    }
    
    public void modificarProductoEnTabla(int[] indice, Producto producto){
        Item item = (Item)TablaListaDeItems.getValueAt(indice[0], indice[1]);
        item.getNombre().setText(producto.getNombre());
        item.getSubtitulo().setText("STOCK: "+producto.getStock());
        modeloDeListaDeItems.setValueAt(item, indice[0], indice[1]);
        actualizarScroll();
    }
    
    
    public void actualizarScroll(){
        //Adaptando el tamaño de la barra de Scroll
        double newScrollBarHeight=Math.pow(scrollPaneDeListaDeItems.getPreferredSize().getHeight(),2)/(
                TablaListaDeItems.getRowHeight()*TablaListaDeItems.getRowCount());
        
        scrollCustom.setThumbSize((int)newScrollBarHeight);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotonesCRUD;
    private javax.swing.JSeparator SeparadorTabla;
    private javax.swing.JLabel TituloDeModulo;
    private javax.swing.JLabel btnConfiguracion;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JPanel buscador;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JPanel selectorSeleccion;
    private javax.swing.JPanel selectorVista;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Selector selectorModificado=((Selector)evt.getSource());
        String tipoSelector=selectorModificado.getNombreDeSelector();
        switch (tipoSelector) {
            case "SSeleccion":
                    try {
                        if((int)evt.getNewValue()==0){
                            TablaListaDeItems.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        }else{
                            TablaListaDeItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
            break;
            case "SVista":
                if((int)evt.getNewValue()==1){
                    int idDepartamento=-1;
                    if(departamentoSeleccionado==null){
                        lblDepartamentoActual.setText("DPTO: TODOS");    
                    }else{
                        idDepartamento=departamentoSeleccionado.getIdDepartamento();
                    }
                    lblDepartamentoActual.setVisible(true);
                    separadorLblDpto.setVisible(true);
                    productos=ControlInventario.cargarProductos(idDepartamento);
                    mostrarListaProductosCargadaEnTabla();
                    PanelBotonesCRUD.removeAll();
                    PanelBotonesCRUD.add(btnEliminarProducto);
                    PanelBotonesCRUD.add(btnModificarProducto);
                    PanelBotonesCRUD.add(btnIngresoProducto);
                    PanelBotonesCRUD.add(btnAgregarProducto);
                    activarBotonesFuncionProducto();
                    desactivarBotonesFuncionProducto();
                }else{
                    lblDepartamentoActual.setVisible(false);
                    separadorLblDpto.setVisible(false);
                    departamentoSeleccionado=null;
                    productos=null;
                    cargarListaDeDepartamentos();
                    mostrarListaDepartamentosCargadaEnTabla();
                    PanelBotonesCRUD.removeAll();
                    PanelBotonesCRUD.add(btnEliminarDepartamento);
                    PanelBotonesCRUD.add(btnModificarDepartamento);
                    PanelBotonesCRUD.add(btnVerProductos);
                    PanelBotonesCRUD.add(btnAgregarDepartamento);
                    activarBotonesFuncionDepartamento();
                    desactivarBotonesFuncionDepartamento();
                }
            break;
        }
    }
}
