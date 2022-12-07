/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Interfaces.Usuarios;

import Datos.Entidades.Usuario;
import Negocio.ControlUsuarios;
import Presentacion.Interfaces.FramePrincipal;
import Presentacion.Interfaces.PanelImagen;
import Presentacion.Interfaces.PasswordFieldRedondeado;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author sortizu
 */
public class AgregarUsuario extends PanelImagen{
    /*Selectores de permisos*/
    SelectorNombresSINO selectorVentas = new SelectorNombresSINO("Ventas", Color.decode("#8C8C8C"),
                UtilidadesFuentes.InterLight.deriveFont(25.0f),"SelectorVenta");
        SelectorNombresSINO selectorInventario = new SelectorNombresSINO("Inventario", Color.decode("#8C8C8C"),
                UtilidadesFuentes.InterLight.deriveFont(25.0f), "SelectorInventario");
        SelectorNombresSINO selectorReportes = new SelectorNombresSINO("Reportes", Color.decode("#8C8C8C"),
                UtilidadesFuentes.InterLight.deriveFont(25.0f), "SelectorReportes");
        SelectorNombresSINO selectorClientes = new SelectorNombresSINO("Clientes", Color.decode("#8C8C8C"),
                UtilidadesFuentes.InterLight.deriveFont(25.0f),"SelectorClientes");
        SelectorNombresSINO selectorProveedores = new SelectorNombresSINO("Proveedores", Color.decode("#8C8C8C"),
                UtilidadesFuentes.InterLight.deriveFont(25.0f), "SelectorProveedores");
        SelectorNombresSINO selectorUsuarios = new SelectorNombresSINO("Usuarios", Color.decode("#8C8C8C"),
                UtilidadesFuentes.InterLight.deriveFont(25.0f), "SelectorUsuarios");
    
    PanelDeUsuarios panelPrincipalDeModuloUsuarios;
        
    public AgregarUsuario(PanelDeUsuarios panelPrincipalDeModuloUsuarios) {
        super("/Presentacion/Imagenes/Paneles/Usuarios/PanelAgregarUsuarios.png");
        initComponents();
        setOpaque(false);
        addMouseListener( new MouseAdapter() { } );
        lblAlertaPass.setVisible(false);
        lblAlertaNombre.setVisible(false);
        
        txtNombre.setGrosorBorde(4);
        txtNombre.setRadioDeBorde(40);
        txtNombre.setColorBorde(Color.decode("#CACACA"));
        txtNombre.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        txtNombre.setForeground(Color.decode("#8C8C8C"));
        txtNombre.setBorder( BorderFactory.createEmptyBorder(2, 20, 0, 20) );
        
        ((PasswordFieldRedondeado)txtpassword).setGrosorBorde(4);
        ((PasswordFieldRedondeado)txtpassword).setRadioDeBorde(40);
        ((PasswordFieldRedondeado)txtpassword).setColorBorde(Color.decode("#CACACA"));
        txtpassword.setFont(UtilidadesFuentes.InterBlack.deriveFont(35.0f));
        txtpassword.setForeground(Color.decode("#8C8C8C"));

        PlainDocument documentPass = (PlainDocument) txtpassword.getDocument();
        documentPass.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                lblAlertaPass.setVisible(false);
                String string;
                if(!text.isEmpty())
                string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text.substring(text.length()-1);
                else
                    string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.length() <= 4) {
                    if(text.matches("[0-9]+")){
                        super.replace(fb, offset, length, text, attrs);
                    }else{
                        lblAlertaPass.setText("El PIN debe ser numérico");
                        lblAlertaPass.setVisible(true);
                    }
                }
            }
        });
        
        PlainDocument documentNombre = (PlainDocument) txtNombre.getDocument();
        documentNombre.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                lblAlertaNombre.setVisible(false);
                super.replace(fb, offset, length, text, attrs);
            }
        });
        
        SelectoresPermisos.setOpaque(false);
        SelectoresPermisos.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        
        gbc.gridy=0;
        gbc.gridx=0;
        
        SelectoresPermisos.add(selectorVentas,gbc);
        gbc.gridy=0;
        gbc.gridx=1;
        SelectoresPermisos.add(selectorInventario,gbc);
        gbc.gridy=1;
        gbc.gridx=0;
        SelectoresPermisos.add(selectorReportes,gbc);
        gbc.gridy=1;
        gbc.gridx=1;
        SelectoresPermisos.add(selectorClientes,gbc);
        gbc.gridy=2;
        gbc.gridx=0;
        SelectoresPermisos.add(selectorProveedores,gbc);
        gbc.gridy=2;
        gbc.gridx=1;
        SelectoresPermisos.add(selectorUsuarios,gbc);
        
        this.panelPrincipalDeModuloUsuarios=panelPrincipalDeModuloUsuarios;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        Cabecera = new javax.swing.JSeparator();
        lblAGREGARUSUARIOS1 = new javax.swing.JLabel();
        txtNombre = new Presentacion.Interfaces.TextFieldRedondeado();
        lblPIN = new javax.swing.JLabel();
        txtpassword = new PasswordFieldRedondeado();
        Pie = new javax.swing.JSeparator();
        lblPermisos = new javax.swing.JLabel();
        SelectoresPermisos = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        lblAlertaPass = new javax.swing.JLabel();
        lblAlertaNombre = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(790, 451));
        setMinimumSize(new java.awt.Dimension(790, 451));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(790, 451));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblNombre.setForeground(new java.awt.Color(140, 140, 140));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");
        lblNombre.setPreferredSize(new java.awt.Dimension(125, 30));
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 360, -1));

        Cabecera.setForeground(new java.awt.Color(208, 208, 208));
        Cabecera.setPreferredSize(new java.awt.Dimension(782, 2));
        add(Cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, -1, -1));

        lblAGREGARUSUARIOS1.setFont(UtilidadesFuentes.InterLight.deriveFont(30.0f));
        lblAGREGARUSUARIOS1.setForeground(new java.awt.Color(110, 205, 95));
        lblAGREGARUSUARIOS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAGREGARUSUARIOS1.setText("AGREGAR USUARIOS");
        lblAGREGARUSUARIOS1.setPreferredSize(new java.awt.Dimension(790, 65));
        add(lblAGREGARUSUARIOS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setToolTipText("");
        txtNombre.setPreferredSize(new java.awt.Dimension(358, 40));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 358, 50));

        lblPIN.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblPIN.setForeground(new java.awt.Color(140, 140, 140));
        lblPIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPIN.setText("PIN");
        lblPIN.setPreferredSize(new java.awt.Dimension(125, 30));
        add(lblPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 220, -1));

        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 220, 50));

        Pie.setForeground(new java.awt.Color(208, 208, 208));
        Pie.setPreferredSize(new java.awt.Dimension(782, 2));
        add(Pie, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 378, -1, -1));

        lblPermisos.setFont(UtilidadesFuentes.InterLight.deriveFont(25.0f));
        lblPermisos.setForeground(new java.awt.Color(140, 140, 140));
        lblPermisos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPermisos.setText("Permisos");
        lblPermisos.setPreferredSize(new java.awt.Dimension(125, 30));
        add(lblPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 73, -1, -1));

        javax.swing.GroupLayout SelectoresPermisosLayout = new javax.swing.GroupLayout(SelectoresPermisos);
        SelectoresPermisos.setLayout(SelectoresPermisosLayout);
        SelectoresPermisosLayout.setHorizontalGroup(
            SelectoresPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        SelectoresPermisosLayout.setVerticalGroup(
            SelectoresPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        add(SelectoresPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 330, 230));

        btnAceptar.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnAceptar.setForeground(new java.awt.Color(108, 197, 100));
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setText("✓");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setPreferredSize(new java.awt.Dimension(90, 63));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 378, -1, -1));

        btnCancelar.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnCancelar.setForeground(new java.awt.Color(174, 174, 174));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setText("×");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setPreferredSize(new java.awt.Dimension(90, 63));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 378, -1, -1));

        lblAlertaPass.setFont(UtilidadesFuentes.InterRegular.deriveFont(17.0f));
        lblAlertaPass.setForeground(new java.awt.Color(224, 130, 130));
        lblAlertaPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlertaPass.setText("El PIN debe tener 4 digitos");
        add(lblAlertaPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 360, 30));

        lblAlertaNombre.setFont(UtilidadesFuentes.InterRegular.deriveFont(17.0f));
        lblAlertaNombre.setForeground(new java.awt.Color(224, 130, 130));
        lblAlertaNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlertaNombre.setText("Asegúrese de poner un nombre");
        add(lblAlertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 360, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        ((FramePrincipal)((JFrame) SwingUtilities.getWindowAncestor(this))).cerrarPanelesEmergentes();
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        if(txtpassword.getPassword().length==4){
            if(txtNombre.getText().isBlank()){
                lblAlertaNombre.setVisible(true);
            }else{
                Usuario nuevoUsuario = new Usuario(ControlUsuarios.obtenerUltimoID()+1,txtNombre.getText(),
                Integer.parseInt(new String(txtpassword.getPassword())),selectorVentas.getValorDeSelector(),
                selectorUsuarios.getValorDeSelector(),selectorProveedores.getValorDeSelector(),
                selectorClientes.getValorDeSelector(),selectorInventario.getValorDeSelector(),
                selectorReportes.getValorDeSelector());
                panelPrincipalDeModuloUsuarios.usuarios.add(nuevoUsuario);
                panelPrincipalDeModuloUsuarios.añadirUsuarioATabla(nuevoUsuario);
                ControlUsuarios.agregarUsuario(nuevoUsuario);
                ((FramePrincipal)((JFrame) SwingUtilities.getWindowAncestor(this))).cerrarPanelesEmergentes();
            }
        }else{
            lblAlertaPass.setText("El PIN debe tener 4 dígitos");
            lblAlertaPass.setVisible(true);
        }
    }//GEN-LAST:event_btnAceptarMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Cabecera;
    private javax.swing.JSeparator Pie;
    private javax.swing.JPanel SelectoresPermisos;
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel lblAGREGARUSUARIOS1;
    private javax.swing.JLabel lblAlertaNombre;
    private javax.swing.JLabel lblAlertaPass;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPIN;
    private javax.swing.JLabel lblPermisos;
    private Presentacion.Interfaces.TextFieldRedondeado txtNombre;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
    
    
   
}
