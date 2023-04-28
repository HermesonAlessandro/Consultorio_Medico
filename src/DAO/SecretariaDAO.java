package DAO;
import Modelo.Secretaria;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.SecretariaDTO;
public class SecretariaDAO extends ExecuteSQL{

    Connection con;
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
    
 
}
