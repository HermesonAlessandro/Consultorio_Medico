/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import DAO.AdministradorDAO;
import DAO.MedicoDAO;
import DAO.SecretariaDAO;
import DAO.ConexaoDAO;
import DTO.AdministradorDTO;
import DTO.MedicoDTO;
import DTO.SecretariaDTO;       
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author RCR - 2022
 */
public class Tela_Login extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Login
     */
    public Tela_Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 53, 92));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Medico", "Secretaria", "" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 284, -1, 34));

        jButton1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 0, 12)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 336, 110, 42));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 336, 110, 42));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rg:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 143, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Tela de Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 16, 329, 121));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 208, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 212, 633, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 147, 630, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 800, 520));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/poggers.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        setBounds(0, 0, 1296, 726);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText().isBlank() || 
                jTextField2.getText().isBlank()){
            
            JOptionPane.showMessageDialog(null, "preencha todos os dados!");  
        }    
        
        else{   
        int rg = Integer.valueOf(jTextField1.getText());
        String senha = jTextField2.getText();
        String tipo_usu = jComboBox1.getSelectedItem().toString();
                
        if(tipo_usu == "Administrador"){

            try {

                AdministradorDTO objAdmDto = new AdministradorDTO();
                objAdmDto.setRg_adm(rg);
                objAdmDto.setSenha_adm(senha);

                Connection con = ConexaoDAO.AbrirConexao();

                AdministradorDAO objAdmDao = new AdministradorDAO(con);
                ResultSet rsAdmDao = objAdmDao.autenticacaoAdm(objAdmDto);

                if(rsAdmDao.next()){
                    //Chamar menu correspondente
                    Tela_Menu_Administrador objTela_Menu_Administrador = new Tela_Menu_Administrador();
                    objTela_Menu_Administrador.setVisible(true);
                    dispose();
                }else{
                    //Menssagem de incorrreto
                    JOptionPane.showMessageDialog(null, "Rg ou/e senha incorreto(a)(s)");
                }
            }

            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + e);
            }
        }else if(tipo_usu == "Medico"){
            try {

                MedicoDTO objMedicDto = new MedicoDTO();
                objMedicDto.setRg(rg);
                objMedicDto.setSenha(senha);

                Connection con = ConexaoDAO.AbrirConexao();

                MedicoDAO objMedicDao = new MedicoDAO(con);
                ResultSet rsMedicDao = objMedicDao.autenticacaoMedic(objMedicDto);

                if(rsMedicDao.next()){
                    //Chamar menu correspondente
                    Tela_Menu_Medico objTela_Menu_Medico = new Tela_Menu_Medico();
                    objTela_Menu_Medico.setVisible(true);
                    dispose();
                }else{
                    //Menssagem de incorrreto
                    JOptionPane.showMessageDialog(null, "Rg ou/e senha incorreto(a)(s)");
                }
            }

            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + e);
            }
        }else if(tipo_usu == "Secretaria"){
            try {

                SecretariaDTO objSecDto = new SecretariaDTO();
                objSecDto.setRg_sec(rg);
                objSecDto.setSenha_sec(senha);

                Connection con = ConexaoDAO.AbrirConexao();

                SecretariaDAO objSecDao = new SecretariaDAO(con);
                ResultSet rsSecDao = objSecDao.autenticacaoSec(objSecDto);

                if(rsSecDao.next()){
                    //Chamar menu correspondente
                    Tela_Menu_Secretaria objTela_Menu_Sec = new Tela_Menu_Secretaria();
                    objTela_Menu_Sec.setVisible(true);
                    dispose();
                }else{
                    //Menssagem de incorrreto
                    JOptionPane.showMessageDialog(null, "Rg ou/e senha incorreto(a)(s)");
                }
            }

            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + e);
            }
        }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
