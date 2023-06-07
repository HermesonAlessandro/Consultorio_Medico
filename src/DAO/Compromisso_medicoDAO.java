package DAO;

import Modelo.Compromisso_medico;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Compromisso_medicoDAO extends ExecuteSQL{
     Connection con;
     ResultSet rs;
     PreparedStatement ps;
     ArrayList<Compromisso_medico> lista = new ArrayList<>();

    public Compromisso_medicoDAO(Connection con) {
        super(con);
    }
    
    public void Marcar_Compromisso_medico(Compromisso_medico cm){
        String sql = "insert into compromisso_medico values(0, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,cm.getDescricao());
            ps.setString(2,cm.getH_fim());
            ps.setString(3,cm.getH_ini());
            ps.setInt(4,cm.getFk_cpf_sec());
            ps.setInt(5,cm.getFk_cpf_m());
           
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
     public ArrayList<Compromisso_medico>ListarCompromisso_Medico(){
             String sql = "select * from compromisso_medico";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Compromisso_medico objcompromisso_medico = new Compromisso_medico();
                objcompromisso_medico.setId_comp_medico(rs.getInt("id_comp_medico"));
                objcompromisso_medico.setDescricao(rs.getString("descricao"));
                objcompromisso_medico.setH_fim(rs.getString("h_fim"));
                objcompromisso_medico.setH_ini(rs.getString("h_ini"));
                
                
                  lista.add(objcompromisso_medico);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar um compromisso medico" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
     
     
     public void AlterarCompromissoMedico(Compromisso_medico objcompromissomedico){
     String sql = "update compromisso_medico set descricao = ?, h_fim = ?, h_ini = ? where id_comp_medico = ?";
     Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objcompromissomedico.getDescricao());
        pstm.setString(2, objcompromissomedico.getH_fim());
        pstm.setString(3, objcompromissomedico.getH_ini());
        pstm.setInt(4, objcompromissomedico.getId_comp_medico());
                
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Compromisso Medico alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Compromisso Medico nao alterado!"+e.getMessage());
    
    
    }
   
   }
     
     public void ExcluirCompromissoMedico(Compromisso_medico objCompromissomedico){
         String sql = "delete from compromisso_medico where id_comp_medico = ?";
         Connection con = ConexaoDAO.AbrirConexao();
         
         try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objCompromissomedico.getId_comp_medico());
            
            ps.execute();
            ps.close();
             
             JOptionPane.showMessageDialog(null, "Compromisso Medico Excluido!");
             
         }catch (Exception e){
             JOptionPane.showMessageDialog(null,"Compromisso Medico não Excluido!"+e.getMessage());
             
         }
   
     }
     
     public ArrayList<Compromisso_medico>BuscarCompromissoMedico(int id_comp_medico){
        String sql ="";
        if(id_comp_medico == 0){
            sql = "select * from compromisso_medico";
        }else{
             sql = "select * from compromisso_medico where id_comp_medico = "+id_comp_medico;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Compromisso_medico objcompromissomedico = new Compromisso_medico();
                    objcompromissomedico.setId_comp_medico(rs.getInt("id_comp_medico"));
                    objcompromissomedico.setDescricao(rs.getString("descricao"));
                    objcompromissomedico.setH_fim(rs.getString("h_fim"));
                    objcompromissomedico.setH_ini(rs.getString("h_ini"));
           
                  lista.add(objcompromissomedico);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar o Compromisso Medico: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
}
