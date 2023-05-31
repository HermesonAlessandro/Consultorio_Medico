package DAO;
import Modelo.Secretaria;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.SecretariaDTO;
import java.util.ArrayList;
public class SecretariaDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Secretaria> lista = new ArrayList<>();
    
    
    public SecretariaDAO(Connection con) {
        super(con);
    }
    
    
    public void Cadastrar_Secretaria(Secretaria s){
        String sql = "insert into secretaria values(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,s.getCpf());
            ps.setString(2,s.getNome());
            ps.setInt(3,s.getRg());
            ps.setInt(4,s.getTel());
            ps.setString(5,s.getEnd());
            ps.setString(6,s.getSexo());
            ps.setString(7,s.getSenha());
            ps.setInt(8, s.getRg_adm());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
    public ResultSet autenticacaoSec(SecretariaDTO objSecDto){       
            
            con = new ConexaoDAO().AbrirConexao();
    
            try {
                
                String sql = "select * from secretaria where rg = ? and senha = ?";
                
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setInt(1, objSecDto.getRg_sec());
                pstm.setString(2, objSecDto.getSenha_sec());
                
                ResultSet rs = pstm.executeQuery();
                return rs;
                
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SecretariaDAO " +  e);
                return null;
            }
    }
    
    
    
    public ArrayList<Secretaria>ListarSecretaria(){
             String sql = "select * from secretaria";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                 Secretaria objsecretaria = new Secretaria();
                objsecretaria.setCpf(rs.getInt("cpf"));
                objsecretaria.setNome(rs.getString("nome"));
                objsecretaria.setRg(rs.getInt("rg"));
                objsecretaria.setTel(rs.getInt("tel"));
                objsecretaria.setEnd(rs.getString("end"));
                objsecretaria.setSexo(rs.getString("sexo"));
                objsecretaria.setSenha(rs.getString("senha"));
                objsecretaria.setRg_adm(rs.getInt("rg_adm"));
                
                  lista.add(objsecretaria);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar o medico" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
    public void AlterarSecretaria(Secretaria objsecretaria){
    String sql = "update secretaria set nome = ?, rg = ?, tel = ?, end = ?, sexo = ?,  senha = ? where cpf = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objsecretaria.getNome());
        pstm.setInt(2, objsecretaria.getRg());
        pstm.setInt(3, objsecretaria.getTel());
        pstm.setString(4, objsecretaria.getEnd());
        pstm.setString(5, objsecretaria.getSexo());
        pstm.setString(6, objsecretaria.getSenha());
        pstm.setInt(7, objsecretaria.getCpf());
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Secretaria alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Secretaria nao alterado!"+e.getMessage());
    
    
    }
   
   } 
        
}
