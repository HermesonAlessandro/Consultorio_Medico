package DAO;

import Modelo.Receita;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReceitaDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Receita> lista = new ArrayList<>();

    public ReceitaDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Receita(Receita rc){
        String sql = "insert into receita values(0, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,rc.getDescricao());
            ps.setInt(2,rc.getFk_cpf_m());
            ps.setInt(3,rc.getFk_cpf_p());
            
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
            public ArrayList<Receita>ListarReceita(){
             String sql = "select * from receita";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Receita objreceita = new Receita();
                objreceita.setId(rs.getInt("id"));
                objreceita.setDescricao(rs.getString("descricao"));
               
                
                  lista.add(objreceita);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar a receita" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
            
    public void AlterarReceita(Receita objreceita){
    String sql = "update receita set descricao = ? where id = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objreceita.getDescricao());
        pstm.setInt(2, objreceita.getId());
    
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Receita alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Receita nao alterado!"+e.getMessage());
    
    
    }
   
   }
    
        public void ExcluirReceita(Receita objreceita){
        String sql = "delete from receita where id = ?";
        Connection con = ConexaoDAO.AbrirConexao();
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objreceita.getId());
            
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Receita Excluida!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Receita não Excluida!"+e.getMessage());
            
        }
    }
        
        public ArrayList<Receita>BuscarReceita(int id){
        String sql ="";
        if(id == 0){
            sql = "select * from receita";
        }else{
             sql = "select * from receita where id = "+id;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Receita objreceita = new Receita();
                    objreceita.setId(rs.getInt("id"));
                    objreceita.setDescricao(rs.getString("descricao"));
           
                  lista.add(objreceita);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar uma Receita: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
        
}
