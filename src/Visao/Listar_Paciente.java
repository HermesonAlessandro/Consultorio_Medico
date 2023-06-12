/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Visao;
import DAO.ConexaoDAO;
import DAO.PacienteDAO;
import javax.swing.JOptionPane;
import Modelo.Paciente; 
import java.util.ArrayList;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Listar_Paciente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Listar_Paciente1
     */
    public Listar_Paciente() {
        initComponents();
        try {
            Paciente objpaciente = new Paciente();
            Connection con = ConexaoDAO.AbrirConexao();
            PacienteDAO dao = new PacienteDAO(con);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setNumRows(0);

            ArrayList<Paciente> lista = dao.ListarPaciente();
            int num = 0;
            for(Paciente p :lista){
                model.addRow(new String[num]);
                jTable2.setValueAt(p.getCpf(), num, 0);
                jTable2.setValueAt(p.getNome(), num, 1);
                jTable2.setValueAt(p.getEnd(), num, 2);
                jTable2.setValueAt(p.getTel(), num, 3);
                jTable2.setValueAt(p.getRg(), num, 4);
                jTable2.setValueAt(p.getSexo(), num, 5);
                jTable2.setValueAt(p.getConvenio(), num, 6);
                num++;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                "nao foi possivel o encontrar um Paciente!: "+e.getMessage());
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 0, 24)); // NOI18N
        jLabel1.setText("Listar Paciente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 17, -1, -1));

        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 90, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 450, -1));

        jTextField2.setEnabled(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 450, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "NOME", "END", "TEL", "RG", "SEXO", "CONVENIO"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 540, 200));

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        jLabel7.setText("End:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel8.setText("Tel:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 150, -1, -1));

        jLabel9.setText("Sexo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 180, -1, -1));

        jLabel10.setText("Rg:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 210, -1, -1));

        jLabel11.setText("Convenio:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jTextField3.setEnabled(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 450, -1));

        jTextField4.setEnabled(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 450, -1));

        jTextField6.setEnabled(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 450, -1));

        jTextField7.setEnabled(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 450, -1));

        jButton3.setText("Carregar Campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jButton4.setText("Limpar Dados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", " " }));
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 0, 510, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 100, 520, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/aaa (2).png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents
             private void CarregarCampos(){
          jTextField1.setEnabled(false);
          jTextField2.setEnabled(true);
          jTextField3.setEnabled(true);
          jTextField4.setEnabled(true);
          jComboBox1.setEnabled(true);
          jTextField6.setEnabled(true);
          jTextField7.setEnabled(true);
          int setar = jTable2.getSelectedRow();
          jTextField1.setText(jTable2.getModel().getValueAt(setar, 0).toString());
          jTextField2.setText(jTable2.getModel().getValueAt(setar, 1).toString());
          jTextField3.setText(jTable2.getModel().getValueAt(setar, 2).toString());
          jTextField4.setText(jTable2.getModel().getValueAt(setar, 3).toString());
          String sexo = jTable2.getModel().getValueAt(setar, 5).toString();
          jTextField6.setText(jTable2.getModel().getValueAt(setar, 4).toString());
          jTextField7.setText(jTable2.getModel().getValueAt(setar, 6).toString()); 
          
          if("M".equals(sexo)){
              jComboBox1.setSelectedIndex(0);
          }
          
          else{
          jComboBox1.setSelectedIndex(1);
          }
             }
             
             private void LimparDados(){
             jTextField1.setText("");
             jTextField2.setText("");
             jTextField3.setText("");
             jTextField4.setText("");
             jTextField6.setText("");
             jTextField7.setText(""); 
             }
             
             
            private void AlterarPaciente(){                  
            int cpf;
            String nome;
            String end;
            int tel;
            int rg;
            String sexo;
            String convenio;
            
            cpf = Integer.valueOf(jTextField1.getText());
            nome = jTextField2.getText();
            end = jTextField3.getText();
            tel = Integer.valueOf(jTextField4.getText());
            rg = Integer.valueOf(jTextField6.getText());
            sexo = jComboBox1.getSelectedItem().toString();
            
            convenio = jTextField7.getText();
            
            
            Paciente objpaciente = new Paciente();
            objpaciente.setCpf(cpf);
            objpaciente.setNome(nome);
            objpaciente.setEnd(end);
            objpaciente.setTel(tel);
            objpaciente.setRg(rg);
            objpaciente.setSexo(sexo);
            objpaciente.setConvenio(convenio);
           
            
            PacienteDAO objpacientedao = new PacienteDAO(ConexaoDAO.AbrirConexao());
            objpacientedao.AlterarPaciente(objpaciente);
       }
            
            
               private void ExcluirPaciente(){
               int cpf;
                
               cpf = Integer.valueOf(jTextField1.getText());
               
               Paciente objpaciente = new Paciente();
               objpaciente.setCpf(cpf);
               
               PacienteDAO objpacientedao = new PacienteDAO(ConexaoDAO.AbrirConexao());
               objpacientedao.ExcluirPaciente(objpaciente);
            }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       LimparDados();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlterarPaciente();
        PacienteDAO dao = new PacienteDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Paciente> ListaPaciente = dao.ListarPaciente();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Paciente p : ListaPaciente){
                model.addRow(new String[num]);
                jTable2.setValueAt(p.getCpf(), num, 0);
                jTable2.setValueAt(p.getNome(), num, 1);
                jTable2.setValueAt(p.getEnd(), num, 2);
                jTable2.setValueAt(p.getTel(), num, 3);
                jTable2.setValueAt(p.getRg(), num, 4);
                jTable2.setValueAt(p.getSexo(), num, 5);
                jTable2.setValueAt(p.getConvenio(), num, 6);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ExcluirPaciente();
        PacienteDAO dao = new PacienteDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Paciente> ListaPaciente = dao.ListarPaciente();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Paciente p : ListaPaciente){
                model.addRow(new String[num]);
                jTable2.setValueAt(p.getCpf(), num, 0);
                jTable2.setValueAt(p.getNome(), num, 1);
                jTable2.setValueAt(p.getEnd(), num, 2);
                jTable2.setValueAt(p.getTel(), num, 3);
                jTable2.setValueAt(p.getRg(), num, 4);
                jTable2.setValueAt(p.getSexo(), num, 5);
                jTable2.setValueAt(p.getConvenio(), num, 6);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int cpf = 0;
        if(!jTextField1.getText().equals("")){
            cpf = Integer.valueOf(jTextField1.getText());
        }
        
        
        PacienteDAO objpacientedao = new PacienteDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Paciente> ListaPaciente = objpacientedao.BuscarPaciente(cpf);
        PacienteDAO dao = new PacienteDAO(ConexaoDAO.AbrirConexao());
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Paciente p : ListaPaciente){
                model.addRow(new String[num]);
                jTable2.setValueAt(p.getCpf(), num, 0);
                jTable2.setValueAt(p.getNome(), num, 1);
                jTable2.setValueAt(p.getEnd(), num, 2);
                jTable2.setValueAt(p.getTel(), num, 3);
                jTable2.setValueAt(p.getRg(), num, 4);
                jTable2.setValueAt(p.getSexo(), num, 5); 
                jTable2.setValueAt(p.getConvenio(), num, 6);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
