package DAO;

import Modelo.Relatorio;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RelatorioDAO extends ExecuteSQL{
     Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Relatorio> lista = new ArrayList<>();

    public RelatorioDAO(Connection con) {
        super(con);
    }
    
    public void Emitir_Relatorio(Relatorio r){
        String sql = "insert into relatorio values(0, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,r.getDescricao());
            ps.setInt(2,r.getFk_cpf_m());
            
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
            public ArrayList<Relatorio>ListarRelatorio(){
             String sql = "select * from relatorio";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Relatorio objrelatorio = new Relatorio();
                objrelatorio.setId(rs.getInt("id"));
                objrelatorio.setDescricao(rs.getString("descricao"));
          
                
                  lista.add(objrelatorio);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar o relatorio" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
            
    public void AlterarRelatorio(Relatorio objrelatorio){
    String sql = "update relatorio set descricao = ? where id = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objrelatorio.getDescricao());
        pstm.setInt(2, objrelatorio.getId());
    
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Relatorio alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Relatorio nao alterado!"+e.getMessage());
    
    
    }
   
   }
    
    public void ExcluirRelatorio(Relatorio objrelatorio){
        String sql = "delete from relatorio where id = ?";
        Connection con = ConexaoDAO.AbrirConexao();
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objrelatorio.getId());
            
            ps.execute();
            ps.close();
            
        JOptionPane.showMessageDialog(null, "Relatorio Excluido!");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Relatorio não excluido!"+e.getMessage());
        }
    }
    
    public void BuscarRelatorio(Relatorio objrelatorio){
    
    }
}
