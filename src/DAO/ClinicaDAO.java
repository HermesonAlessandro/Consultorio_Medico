package DAO;

import Modelo.Clinica;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClinicaDAO extends ExecuteSQL{
     Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Clinica> lista = new ArrayList<>();

    public ClinicaDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Clinica(Clinica cl){
        String sql = "insert into clinica values(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,cl.getCnpj());
            ps.setString(2,cl.getNome());
            ps.setString(3,cl.getEnd());
            ps.setInt(4,cl.getTel());
            ps.setInt(5,cl.getFk_cpf_sec());
            ps.setInt(6,cl.getFk_cpf_m());
            ps.setInt(7,cl.getFk_cpf_p());
            ps.setInt(8,cl.getFk_rg_a());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Clinica cadastrada com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel o cadastrar uma Clinica!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
     public ArrayList<Clinica>Listarclinica(){
             String sql = "select * from clinica";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Clinica objclinica = new Clinica();
                objclinica.setCnpj(rs.getInt("cnpj"));
                objclinica.setNome(rs.getString("nome"));
                objclinica.setEnd(rs.getString("end"));
                objclinica.setTel(rs.getInt("tel"));
                objclinica.setFk_cpf_sec(rs.getInt("fk_cpf_sec"));
                objclinica.setFk_cpf_m(rs.getInt("fk_cpf_m"));
                objclinica.setFk_cpf_p(rs.getInt("FK_cpf_p"));
                objclinica.setFk_rg_a(rs.getInt("fk_rg_a"));
                
                  lista.add(objclinica);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar a clinica: " +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
     
     public void AlterarClinica(Clinica objclinica){
    String sql = "update clinica set nome = ?, end = ?, tel = ? where cnpj = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objclinica.getNome());
        pstm.setString(2, objclinica.getEnd());
        pstm.setInt(3, objclinica.getTel());
        pstm.setInt(4, objclinica.getCnpj());
        
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Clinica alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Clinica não alterado!: "+e.getMessage());
    
    
    }
   
   }
     
     public void ExcluirClinica(Clinica objclinica){
         String sql = "delete from clinica where cnpj = ?";
         Connection con = ConexaoDAO.AbrirConexao();
         
         
         try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objclinica.getCnpj());
            
            ps.execute();
            ps.close();
             
         JOptionPane.showMessageDialog(null, "Clinica Excluida!");
         
         }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Clinica não Excluida!"+e.getMessage());
            
         }
     }
     
      public ArrayList<Clinica>BuscarClinica(int cnpj){
        String sql ="";
        if(cnpj == 0){
            sql = "select * from clinica";
        }else{
             sql = "select * from clinica where cnpj = "+cnpj;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Clinica objclinica = new Clinica();
                    objclinica.setCnpj(rs.getInt("cnpj"));
                    objclinica.setNome(rs.getString("nome"));
                    objclinica.setEnd(rs.getString("end"));
                    objclinica.setTel(rs.getInt("tel"));
           
                  lista.add(objclinica);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar uma Clinica: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
     
}
