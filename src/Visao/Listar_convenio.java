/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Visao;
import DAO.ConexaoDAO;
import DAO.ConvenioDAO;
import javax.swing.JOptionPane;
import Modelo.Convenio; 
import java.util.ArrayList;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Listar_convenio extends javax.swing.JInternalFrame {

    /**
     * Creates new form Listar_convenio1
     */
    public Listar_convenio() {
        initComponents();
         try {
             Convenio objconvenio = new Convenio();
            Connection con = ConexaoDAO.AbrirConexao();
            ConvenioDAO dao = new ConvenioDAO(con);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            ArrayList<Convenio> lista = dao.ListarConvenio();
            int num = 0;
            for(Convenio c :lista){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getCnpj(), num, 0);
                jTable1.setValueAt(c.getNome(), num, 1);
                jTable1.setValueAt(c.getTel(), num, 2);
                jTable1.setValueAt(c.getPlanos(), num, 3);
                jTable1.setValueAt(c.getEnd(), num, 4);
                num++;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                "Não foi possivel o encontrar um Convenio!: "+e.getMessage());
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
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

        jLabel1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 0, 36)); // NOI18N
        jLabel1.setText("Listar Convênios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setText("CNPJ:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 51, -1, -1));

        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "NOME", "TEL", "PLANOS", "END"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 500, 220));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 51, 450, -1));

        jTextField2.setEnabled(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 450, -1));

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jLabel7.setText("Tel:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 131, -1, -1));

        jLabel8.setText("Planos:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 171, -1, -1));

        jLabel9.setText("End:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 201, -1, -1));

        jTextField3.setEnabled(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 131, 450, -1));

        jTextField4.setEnabled(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 171, 450, -1));

        jTextField5.setEnabled(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 201, 460, -1));

        jButton3.setText("Carregar Campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        jButton4.setText("Limpar Dados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/desing (2).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 100, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/aaa (2).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

        setBounds(0, 0, 752, 557);
    }// </editor-fold>//GEN-END:initComponents
          private void CarregarCampos(){
          jTextField1.setEnabled(false);
          jTextField2.setEnabled(true);
          jTextField3.setEnabled(true);
          jTextField4.setEnabled(true);
          jTextField5.setEnabled(true);
          int setar = jTable1.getSelectedRow();    
          jTextField1.setText(jTable1.getModel().getValueAt(setar, 0).toString());
          jTextField2.setText(jTable1.getModel().getValueAt(setar, 1).toString());
          jTextField3.setText(jTable1.getModel().getValueAt(setar, 2).toString()); 
          jTextField4.setText(jTable1.getModel().getValueAt(setar, 3).toString());
          jTextField5.setText(jTable1.getModel().getValueAt(setar, 4).toString());
        }
            
          private void LimparDados(){
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
          jTextField5.setText(""); 
        }
          
          
            private void AlterarConvenio(){ 
            int cnpj;
            String nome;
            int tel;
            String planos;
            String end;
            
            
            cnpj = Integer.valueOf(jTextField1.getText());
            nome = jTextField2.getText();
            tel = Integer.valueOf(jTextField3.getText());
            planos = jTextField4.getText();
            end = jTextField5.getText();
           
           
            
            Convenio objconvenio = new Convenio();
            objconvenio.setCnpj(cnpj);
            objconvenio.setNome(nome);
            objconvenio.setTel(tel);
            objconvenio.setPlanos(planos);
            objconvenio.setEnd(end);
            
          
            ConvenioDAO objconveniodao = new ConvenioDAO(ConexaoDAO.AbrirConexao());
            objconveniodao.AlterarConvenio(objconvenio);
            }
            
            private void ExcluirConvenio(){
            int cnpj;
                
             cnpj = Integer.valueOf(jTextField1.getText());
                
             Convenio objconvenio = new Convenio();
             objconvenio.setCnpj(cnpj);
                
             ConvenioDAO objconveniodao = new ConvenioDAO(ConexaoDAO.AbrirConexao());
             objconveniodao.ExcluirConvenio(objconvenio);
          }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      CarregarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LimparDados();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlterarConvenio();
        ConvenioDAO dao = new ConvenioDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Convenio> ListaConvenio = dao.ListarConvenio();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Convenio c : ListaConvenio){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getCnpj(), num, 0);
                jTable1.setValueAt(c.getNome(), num, 1);
                jTable1.setValueAt(c.getTel(), num, 2);
                jTable1.setValueAt(c.getPlanos(), num, 3);
                jTable1.setValueAt(c.getEnd(), num, 4);
                num++;
        }
        LimparDados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ExcluirConvenio();
        ConvenioDAO dao = new ConvenioDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Convenio> ListaConvenio = dao.ListarConvenio();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Convenio c : ListaConvenio){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getCnpj(), num, 0);
                jTable1.setValueAt(c.getNome(), num, 1);
                jTable1.setValueAt(c.getTel(), num, 2);
                jTable1.setValueAt(c.getPlanos(), num, 3);
                jTable1.setValueAt(c.getEnd(), num, 4);
                num++;
        }
        LimparDados();      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       int cnpj = 0;
        if(!jTextField1.getText().equals("")){
            cnpj = Integer.valueOf(jTextField1.getText());
        }
        
        
        ConvenioDAO objconveniodao = new ConvenioDAO(ConexaoDAO.AbrirConexao());
        ArrayList<Convenio> ListaConvenio = objconveniodao.BuscarConvenio(cnpj);
        ConvenioDAO dao = new ConvenioDAO(ConexaoDAO.AbrirConexao());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        int num = 0;
        for (Convenio c : ListaConvenio){
                model.addRow(new String[num]);
                jTable1.setValueAt(c.getCnpj(), num, 0);
                jTable1.setValueAt(c.getNome(), num, 1);
                jTable1.setValueAt(c.getTel(), num, 2);
                jTable1.setValueAt(c.getPlanos(), num, 3);
                jTable1.setValueAt(c.getEnd(), num, 4);
                num++;
        }
        LimparDados();
        JOptionPane.showMessageDialog(null, "Busca feita com sucesso!");
    }//GEN-LAST:event_jButton6ActionPerformed


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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
