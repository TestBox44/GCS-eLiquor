package Presentacion.Interfaces.Login;

import Negocio.ControlLogin;
import Negocio.ControlMenu;
import Presentacion.Interfaces.PanelImagen;
import Presentacion.Interfaces.PasswordFieldRedondeado;
import Presentacion.Utilidades.UtilidadSesion;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Presentacion.Utilidades.UtilidadesFuentes;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author sortizu
 */
public class LoginPIN extends javax.swing.JPanel {

    private int idUsuarioSeleccionado;
    private int indiceSeleccion;
    public LoginPIN() {
        initComponents();
        setOpaque(false);
        ((PasswordFieldRedondeado)txtpassword).setGrosorBorde(5);
        ((PasswordFieldRedondeado)txtpassword).setRadioDeBorde(60);
        ((PasswordFieldRedondeado)txtpassword).setColorBorde(Color.decode("#CACACA"));
        txtpassword.setFont(UtilidadesFuentes.InterBlack.deriveFont(35.0f));
        txtpassword.setForeground(Color.decode("#8C8C8C"));
        txtpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPassword();
            }
            
        });
        PlainDocument document = (PlainDocument) txtpassword.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                lblAlerta.setVisible(false);
                String string;
                System.out.println(text);
                if(text.matches("[0-9]+")){
                    
                    if(!text.isEmpty()){
                        string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text.substring(text.length()-1);
                    }    
                    else{
                        string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                    }
                    
                    if (fb.getDocument().getLength() < 4) {
                       super.replace(fb, offset, length, text, attrs);
                    }

                }else{
                    if(text.isEmpty()){
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            }

            
            
        });
        lblAlerta.setVisible(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTeclado = new PanelImagen("/Presentacion/Imagenes/Paneles/Login/TecladoNumerico.png");
        btnUno = new javax.swing.JLabel();
        btnDos = new javax.swing.JLabel();
        btnTres = new javax.swing.JLabel();
        btnCuatro = new javax.swing.JLabel();
        btnCinco = new javax.swing.JLabel();
        btnSeis = new javax.swing.JLabel();
        btnSiete = new javax.swing.JLabel();
        btnOcho = new javax.swing.JLabel();
        btnNueve = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JLabel();
        btnCero = new javax.swing.JLabel();
        btnValidar = new javax.swing.JLabel();
        PanelPIN = new PanelImagen("/Presentacion/Imagenes/Paneles/Login/PanelListaDeUsuarios.png");
        btnAtras = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nombreDeUsuarioSeleccionado = new javax.swing.JLabel();
        txtpassword = new PasswordFieldRedondeado();
        lblAlerta = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1360, 768));
        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTeclado.setBackground(new java.awt.Color(255, 255, 255));
        PanelTeclado.setPreferredSize(new java.awt.Dimension(284, 368));
        PanelTeclado.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        btnUno.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnUno.setForeground(Color.decode("#AEAEAE"));
        btnUno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUno.setText("1");
        btnUno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUno.setPreferredSize(new java.awt.Dimension(90, 90));
        btnUno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUnoMousePressed(evt);
            }
        });
        PanelTeclado.add(btnUno);

        btnDos.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnDos.setForeground(Color.decode("#AEAEAE"));
        btnDos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDos.setText("2");
        btnDos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDos.setPreferredSize(new java.awt.Dimension(90, 90));
        btnDos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDosMousePressed(evt);
            }
        });
        PanelTeclado.add(btnDos);

        btnTres.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnTres.setForeground(Color.decode("#AEAEAE"));
        btnTres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTres.setText("3");
        btnTres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTres.setPreferredSize(new java.awt.Dimension(90, 90));
        btnTres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTresMousePressed(evt);
            }
        });
        PanelTeclado.add(btnTres);

        btnCuatro.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnCuatro.setForeground(Color.decode("#AEAEAE"));
        btnCuatro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCuatro.setText("4");
        btnCuatro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCuatro.setPreferredSize(new java.awt.Dimension(90, 90));
        btnCuatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCuatroMousePressed(evt);
            }
        });
        PanelTeclado.add(btnCuatro);

        btnCinco.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnCinco.setForeground(Color.decode("#AEAEAE"));
        btnCinco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCinco.setText("5");
        btnCinco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCinco.setPreferredSize(new java.awt.Dimension(90, 90));
        btnCinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCincoMousePressed(evt);
            }
        });
        PanelTeclado.add(btnCinco);

        btnSeis.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnSeis.setForeground(Color.decode("#AEAEAE"));
        btnSeis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSeis.setText("6");
        btnSeis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeis.setPreferredSize(new java.awt.Dimension(90, 90));
        btnSeis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSeisMousePressed(evt);
            }
        });
        PanelTeclado.add(btnSeis);

        btnSiete.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnSiete.setForeground(Color.decode("#AEAEAE"));
        btnSiete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSiete.setText("7");
        btnSiete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiete.setPreferredSize(new java.awt.Dimension(90, 90));
        btnSiete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSieteMousePressed(evt);
            }
        });
        PanelTeclado.add(btnSiete);

        btnOcho.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnOcho.setForeground(Color.decode("#AEAEAE"));
        btnOcho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOcho.setText("8");
        btnOcho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOcho.setPreferredSize(new java.awt.Dimension(90, 90));
        btnOcho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOchoMousePressed(evt);
            }
        });
        PanelTeclado.add(btnOcho);

        btnNueve.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnNueve.setForeground(Color.decode("#AEAEAE"));
        btnNueve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNueve.setText("9");
        btnNueve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNueve.setPreferredSize(new java.awt.Dimension(90, 90));
        btnNueve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNueveMousePressed(evt);
            }
        });
        PanelTeclado.add(btnNueve);

        btnBorrar.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnBorrar.setForeground(Color.decode("#AEAEAE"));
        btnBorrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBorrar.setText("×");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.setPreferredSize(new java.awt.Dimension(90, 90));
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBorrarMousePressed(evt);
            }
        });
        PanelTeclado.add(btnBorrar);

        btnCero.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnCero.setForeground(Color.decode("#AEAEAE"));
        btnCero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCero.setText("0");
        btnCero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCero.setPreferredSize(new java.awt.Dimension(90, 90));
        btnCero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCeroMousePressed(evt);
            }
        });
        PanelTeclado.add(btnCero);

        btnValidar.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnValidar.setForeground(Color.decode("#6CC564"));
        btnValidar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnValidar.setText("✓");
        btnValidar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValidar.setPreferredSize(new java.awt.Dimension(90, 90));
        btnValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnValidarMousePressed(evt);
            }
        });
        PanelTeclado.add(btnValidar);

        add(PanelTeclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 187, -1, -1));

        PanelPIN.setBackground(new java.awt.Color(255, 255, 255));
        PanelPIN.setPreferredSize(new java.awt.Dimension(435, 768));
        PanelPIN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtras.setFont(UtilidadesFuentes.InterBlack.deriveFont(30.0f));
        btnAtras.setForeground(Color.decode("#AEAEAE"));
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtras.setText("←");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setPreferredSize(new java.awt.Dimension(70, 70));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtrasMousePressed(evt);
            }
        });
        PanelPIN.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(208, 208, 208));
        jSeparator1.setPreferredSize(new java.awt.Dimension(350, 10));
        PanelPIN.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 370, -1));

        nombreDeUsuarioSeleccionado.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(30.0f));
        nombreDeUsuarioSeleccionado.setForeground(Color.decode("#8C8C8C"));
        nombreDeUsuarioSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreDeUsuarioSeleccionado.setText("Sebastian Ortiz");
        PanelPIN.add(nombreDeUsuarioSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 370, 50));

        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelPIN.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 220, 60));

        lblAlerta.setFont(UtilidadesFuentes.InterRegular.deriveFont(17.0f));
        lblAlerta.setForeground(new java.awt.Color(224, 130, 130));
        lblAlerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlerta.setText("PIN incorrecto");
        PanelPIN.add(lblAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 370, 30));

        jSeparator2.setForeground(new java.awt.Color(208, 208, 208));
        jSeparator2.setPreferredSize(new java.awt.Dimension(350, 10));
        PanelPIN.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 370, -1));

        jLabel2.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(24.0f));
        jLabel2.setForeground(Color.decode("#8C8C8C"));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USUARIO:");
        PanelPIN.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 370, -1));

        jLabel1.setFont(UtilidadesFuentes.InterExtraLight.deriveFont(25.0f));
        jLabel1.setForeground(new java.awt.Color(140, 140, 140));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PIN");
        PanelPIN.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 220, 30));

        add(PanelPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 0, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Imagenes/BotonSalirModulo.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });
        add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 674, -1, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        JPanel parent = (JPanel)getParent();
        CardLayout layout = (CardLayout) parent.getLayout();
        layout.show(parent, "loginUsuarios");
        
    }//GEN-LAST:event_btnAtrasMousePressed

    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged
         JComponent component = (JComponent)evt.getSource();
        if ((HierarchyEvent.SHOWING_CHANGED & evt.getChangeFlags()) != 0
        &&  component.isShowing())
        {
            Login contenedorLogin = ((Login)getParent());
            nombreDeUsuarioSeleccionado.setText(contenedorLogin.getNombreDeUsuarioSeleccionado());
            idUsuarioSeleccionado=contenedorLogin.getIdUsuarioSeleccionado();
            indiceSeleccion=contenedorLogin.getIndiceSeleccion();
            txtpassword.requestFocus();
            txtpassword.setText("");
        }
    }//GEN-LAST:event_formHierarchyChanged

    private void btnNueveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNueveMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"9");
    }//GEN-LAST:event_btnNueveMousePressed

    private void btnOchoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOchoMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"8");
    }//GEN-LAST:event_btnOchoMousePressed

    private void btnSieteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSieteMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"7");
    }//GEN-LAST:event_btnSieteMousePressed

    private void btnSeisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeisMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"6");
    }//GEN-LAST:event_btnSeisMousePressed

    private void btnCincoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCincoMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"5");
    }//GEN-LAST:event_btnCincoMousePressed

    private void btnCuatroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuatroMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"4");
    }//GEN-LAST:event_btnCuatroMousePressed

    private void btnTresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTresMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"3");
    }//GEN-LAST:event_btnTresMousePressed

    private void btnDosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDosMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"2");
    }//GEN-LAST:event_btnDosMousePressed

    private void btnUnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnoMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"1");
    }//GEN-LAST:event_btnUnoMousePressed

    private void btnBorrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMousePressed
        txtpassword.setText("");
    }//GEN-LAST:event_btnBorrarMousePressed

    private void btnCeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCeroMousePressed
        txtpassword.setText(String.valueOf(txtpassword.getPassword())+"0");
    }//GEN-LAST:event_btnCeroMousePressed

    private void btnValidarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidarMousePressed
        verificarPassword();
    }//GEN-LAST:event_btnValidarMousePressed

    private void btnSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMousePressed
        /*Utilizando utilidades de swing para obtener la ventana principal (FramePrincipal)
        y cerrar todo el programa*/
        ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
    }//GEN-LAST:event_btnSalirMousePressed
    
    private void verificarPassword(){
        try{
            int ps = Integer.parseInt(String.valueOf(txtpassword.getPassword()).trim());
            if(ControlLogin.verificarPassword(indiceSeleccion, ps)){
                UtilidadSesion.idUsuarioActual=idUsuarioSeleccionado;
                UtilidadSesion.nombreUsuarioActual=nombreDeUsuarioSeleccionado.getText();
                JPanel parent = (JPanel)getParent();
                CardLayout layout = (CardLayout) parent.getParent().getLayout();
                //Instanciando el panel contenedor del menu y los otros modulos
                Presentacion.Interfaces.Menu.Menu menu=
                        new Presentacion.Interfaces.Menu.Menu(nombreDeUsuarioSeleccionado.getText(),ControlMenu.cargarPermisosDeUsuario(indiceSeleccion));
                parent.getParent().add("menu",menu);
                layout.show(parent.getParent(), "menu");
                ((CardLayout)parent.getLayout()).show(parent, "loginUsuarios");
            }else{
                throw new Exception("La contraseña no coincide");
            }
        }catch(Exception e){
            System.err.println(e);
            lblAlerta.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPIN;
    private javax.swing.JPanel PanelTeclado;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnBorrar;
    private javax.swing.JLabel btnCero;
    private javax.swing.JLabel btnCinco;
    private javax.swing.JLabel btnCuatro;
    private javax.swing.JLabel btnDos;
    private javax.swing.JLabel btnNueve;
    private javax.swing.JLabel btnOcho;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnSeis;
    private javax.swing.JLabel btnSiete;
    private javax.swing.JLabel btnTres;
    private javax.swing.JLabel btnUno;
    private javax.swing.JLabel btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAlerta;
    private javax.swing.JLabel nombreDeUsuarioSeleccionado;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
