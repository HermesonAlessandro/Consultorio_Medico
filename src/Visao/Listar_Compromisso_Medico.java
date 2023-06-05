/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Visao;
import DAO.ConexaoDAO;
import DAO.Compromisso_medicoDAO;
import javax.swing.JOptionPane;
import Modelo.Compromisso_medico; 
import java.util.ArrayList;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Listar_Compromisso_Medico extends javax.swing.JInternalFrame {

    /**
     * Creates new form Listar_Compromisso_Medico
     */
    public Listar_Compromisso_Medico() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Listar Compromisso Medico");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel2.setText("Id_Comp_Medico");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, 20));

        jLabel3.setText("Descriçao");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jLabel4.setText("H_Fim");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel5.setText("H_Ini");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jTextField1.setEnabled(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 400, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 402, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 400, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 400, -1));

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID_COMP_MEDICO", "DESCRIÇAO", "H_FIM", "H_INI"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 500, 300));

        jButton3.setText("Carregar Campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        jButton4.setText("Limpar Dados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Compromisso_medico objCompromisso_medico = new Compromisso_medico();
            Connection con = ConexaoDAO.AbrirConexao();
            Compromisso_medicoDAO dao = new Compromisso_medicoDAO(con);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            ArrayList<Compromisso_medico> lista = dao.ListarCompromisso_Medico();
            int num = 0;
            for(Compromisso_medico cme :lista){
                model.addRow(new String[num]);
                jTable1.setValueAt(cme.getId_comp_medico(), num, 0);
                jTable1.setValueAt(cme.getDescricao(), num, 1);
                jTable1.setValueAt(cme.getH_fim(), num, 2);
                jTable1.setValueAt(cme.getH_ini(), num, 3);
              num++;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                "nao foi possivel o encontrar um compromisso medico"+e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed
            private void CarregarCampos(){
            int setar = jTable1.getSelectedRow();
          jTextField1.setText(jTable1.getModel().getValueAt(setar, 0).toString());
          jTextField2.setText(jTable1.getModel().getValueAt(setar, 1).toString());
          jTextField3.setText(jTable1.getModel().getValueAt(setar, 2).toString());
          jTextField4.setText(jTable1.getModel().getValueAt(setar, 3).toString()); 
          }
            
            private void LimparDados(){
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            }
            
            
            private void AlterarCompromissoMedico(){                  
            int id_comp_medico;
            String descricao;
            String h_fim;
            String h_ini;
            
            id_comp_medico = Integer.valueOf(jTextField1.getText());
            descricao = jTextField2.getText();
            h_fim = jTextField3.getText();
            h_ini = jTextField4.getText();
            
            
            Compromisso_medico objcompromissomedico = new Compromisso_medico();
            objcompromissomedico.setId_comp_medico(id_comp_medico);
            objcompromissomedico.setDescricao(descricao);
            objcompromissomedico.setH_fim(h_fim);
            objcompromissomedico.setH_ini(h_ini);
            
           
            
            Compromisso_medicoDAO objcompromissomedicodao = new Compromisso_medicoDAO(ConexaoDAO.AbrirConexao());
            objcompromissomedicodao.AlterarCompromissoMedico(objcompromissomedico);
       }
            
            private void ExcluirComprmissoMedico(){
                int id_comp_medico;
                
                id_comp_medico = Integer.valueOf(jTextField1.getText());
                
                Compromisso_medico objcompromissomedico = new Compromisso_medico();
                objcompromissomedico.setId_comp_medico(id_comp_medico);
                
                Compromisso_medicoDAO objcompromissomedicodao = new Compromisso_medicoDAO(ConexaoDAO.AbrirConexao());
                objcompromissomedicodao.ExcluirCompromissoMedico(objcompromissomedico);
       
            }
            
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LimparDados();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlterarCompromissoMedico();
        Compromisso_medicoDAO dao = new Compromisso_medicoDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Compromisso_medico> Listacompromisso_medico = dao.ListarCompromisso_Medico();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Compromisso_medico cm : Listacompromisso_medico){
                model.addRow(new String[num]);
                jTable1.setValueAt(cm.getId_comp_medico(), num, 0);
                jTable1.setValueAt(cm.getDescricao(), num, 1);
                jTable1.setValueAt(cm.getH_fim(), num, 2);
                jTable1.setValueAt(cm.getH_ini(), num, 3);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ExcluirComprmissoMedico();
        Compromisso_medicoDAO dao = new Compromisso_medicoDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Compromisso_medico> ListaCompromissoMedico = dao.ListarCompromisso_Medico();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Compromisso_medico cm : ListaCompromissoMedico){
                model.addRow(new String[num]);
                jTable1.setValueAt(cm.getId_comp_medico(), num, 0);
                jTable1.setValueAt(cm.getDescricao(), num, 1);
                jTable1.setValueAt(cm.getH_fim(), num, 2);
                jTable1.setValueAt(cm.getH_ini(), num, 3);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
