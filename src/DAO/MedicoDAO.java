package DAO;

import DTO.MedicoDTO;
import Modelo.Medico;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;



public class MedicoDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Medico> lista = new ArrayList<>();
    
    
    
    public MedicoDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Medico(Medico m){
        String sql = "insert into medico values(?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,m.getCpf());
            ps.setString(2,m.getNome());
            ps.setInt(3,m.getRg());
            ps.setInt(4,m.getTel());
            ps.setString(5,m.getEnd());
            ps.setString(6,m.getSexo());
            ps.setString(7,m.getSenha());
            
        
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Medico cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel o cadastrar um Medico!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    public ResultSet autenticacaoMedic(MedicoDTO objMedicDto){       
            
            con = new ConexaoDAO().AbrirConexao();
    
            try {
                
                String sql = "select * from medico where rg = ? and senha = ?";
                
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setInt(1, objMedicDto.getRg());
                pstm.setString(2, objMedicDto.getSenha());
                
                ResultSet rs = pstm.executeQuery();
                return rs;
                
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "MedicoDAO: " +  e.getMessage());
                return null;
            }
            }
    
    
    
         public ArrayList<Medico>ListarMedico(){
             String sql = "select * from medico";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Medico objmedico = new Medico();
                objmedico.setCpf(rs.getInt("cpf"));
                objmedico.setNome(rs.getString("nome"));
                objmedico.setRg(rs.getInt("rg"));
                objmedico.setTel(rs.getInt("tel"));
                objmedico.setEnd(rs.getString("end"));
                objmedico.setSexo(rs.getString("sexo"));
                objmedico.setSenha(rs.getString("senha"));
                
                  lista.add(objmedico);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar o Medico: " +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
         
    public void AlterarMedico(Medico objmedico){
    String sql = "update medico set nome = ?, rg = ?, tel = ?, end = ?, sexo = ?,  senha = ? where cpf = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objmedico.getNome());
        pstm.setInt(2, objmedico.getRg());
        pstm.setInt(3, objmedico.getTel());
        pstm.setString(4, objmedico.getEnd());
        pstm.setString(5, objmedico.getSexo());
        pstm.setString(6, objmedico.getSenha());
        pstm.setInt(7, objmedico.getCpf());
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Medico alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Medico não alterado!: "+e.getMessage());
    
    
    }
   
   }
    
    public void ExcluirMedico(Medico objmedico){
        String sql = "delete from medico where cpf = ?";
        Connection con = ConexaoDAO.AbrirConexao();
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objmedico.getCpf());
            
            ps.execute();
            ps.close();
            
        JOptionPane.showMessageDialog(null, "Medico Excluido!");
        
        }catch(Exception e){
            
        JOptionPane.showMessageDialog(null, "Medico não excluido!: "+e.getMessage());
        
        }
    }
  
    public ArrayList<Medico>BuscarMedico(int cpf){
        String sql ="";
        if(cpf == 0){
            sql = "select * from medico";
        }else{
             sql = "select * from medico where cpf = "+cpf;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Medico objmedico = new Medico();
                    objmedico.setCpf(rs.getInt("cpf"));
                    objmedico.setNome(rs.getString("nome"));
                    objmedico.setRg(rs.getInt("rg"));
                    objmedico.setTel(rs.getInt("tel"));
                    objmedico.setEnd(rs.getString("end"));
                    objmedico.setSexo(rs.getString("sexo"));
                    objmedico.setSenha(rs.getString("senha"));
           
                  lista.add(objmedico);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar um Medico: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
    
}

