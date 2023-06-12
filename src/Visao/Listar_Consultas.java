/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Visao;
import DAO.ConexaoDAO;
import DAO.ConsultaDAO;
import javax.swing.JOptionPane;
import Modelo.Consulta; 
import java.util.ArrayList;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Listar_Consultas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Listar_Consultas1
     */
    public Listar_Consultas() {
        initComponents();
        try {
            Consulta objconsulta = new Consulta();
            Connection con = ConexaoDAO.AbrirConexao();
            ConsultaDAO dao = new ConsultaDAO(con);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            ArrayList<Consulta> lista = dao.ListarConsulta();
            int num = 0;
            for(Consulta c :lista){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getId(), num, 0);
                jTable1.setValueAt(c.getNome_c(), num, 1);
                jTable1.setValueAt(c.getData(), num, 1);
                num++;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                "Não foi possivel o encontrar um Consulta!: "+e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 0, 24)); // NOI18N
        jLabel1.setText("Listar Consultas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel2.setText("ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel3.setText("Nome_c:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DATA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 489, 290));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 446, -1));

        jTextField2.setEnabled(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 446, -1));

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        jLabel7.setText("Data:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 446, -1));

        jButton3.setText("Caregar Campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jButton4.setText("Limpar Dados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/aaa (2).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents
          private void CarregarCampos(){
          jTextField1.setEnabled(false);
          jTextField2.setEnabled(true);
          jTextField3.setEnabled(true);
          int setar = jTable1.getSelectedRow();
          jTextField1.setText(jTable1.getModel().getValueAt(setar, 0).toString());
          jTextField2.setText(jTable1.getModel().getValueAt(setar, 1).toString());
          jTextField3.setText(jTable1.getModel().getValueAt(setar, 2).toString());     
        }
          
          private void LimparDados(){
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
        }
          
          
            private void AlterarConsulta(){                  
            String nome_c;
            String data;
            int id;
            
            
            nome_c = jTextField2.getText();
            data = jTextField3.getText();
            id = Integer.valueOf(jTextField1.getText());
            
            
            Consulta objconsulta = new Consulta();
            objconsulta.setNome_c(nome_c);
            objconsulta.setData(data);
            objconsulta.setId(id);
            
           
            
            ConsultaDAO objconsultadao = new ConsultaDAO(ConexaoDAO.AbrirConexao());
            objconsultadao.AlterarConsulta(objconsulta);
        }
            
            private void ExcluirConsulta(){
            int id;
               
            id = Integer.valueOf(jTextField1.getText());
               
            Consulta objconsulta = new Consulta();
            objconsulta.setId(id);
               
            ConsultaDAO objconsultadao = new ConsultaDAO(ConexaoDAO.AbrirConexao());
            objconsultadao.ExcluirConsulta(objconsulta);
            }
                
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       CarregarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LimparDados();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlterarConsulta();
        ConsultaDAO dao = new ConsultaDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Consulta> ListaConsulta = dao.ListarConsulta();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Consulta c : ListaConsulta){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getId(), num, 0);
                jTable1.setValueAt(c.getNome_c(), num, 1);
                jTable1.setValueAt(c.getData(), num, 2);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ExcluirConsulta();
        ConsultaDAO dao = new ConsultaDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Consulta> ListaConsulta = dao.ListarConsulta();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Consulta c : ListaConsulta){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getId(), num, 0);
                jTable1.setValueAt(c.getNome_c(), num, 1);
                jTable1.setValueAt(c.getData(), num, 2);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int id = 0;
        if(!jTextField1.getText().equals("")){
            id = Integer.valueOf(jTextField1.getText());
        }
        
        
        ConsultaDAO objconsultadao = new ConsultaDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Consulta> ListaConsulta = objconsultadao.BuscarConsulta(id);
        ConsultaDAO dao = new ConsultaDAO(ConexaoDAO.AbrirConexao());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Consulta c : ListaConsulta){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getId(), num, 0);
                jTable1.setValueAt(c.getNome_c(), num, 1);
                jTable1.setValueAt(c.getData(), num, 2);
                
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
