package DAO;
import Modelo.Administrador; 
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.AdministradorDTO;

public class AdministradorDAO extends ExecuteSQL{
    Connection con;

    public AdministradorDAO(Connection con) {
       super(con);
    }

    
    public void Cadastrar_Administrador(Administrador a){
        String sql = "insert into administrador values(?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,a.getRg_a());
            ps.setString(2,a.getNome_func());
            ps.setInt(3,a.getCpf());
            ps.setString(4,a.getSenha());
            ps.setString(5,a.getSexo());
            ps.setString(6,a.getClin());
            ps.setInt(7,a.getTel());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
        
    }
    public ResultSet autenticacaoAdm(AdministradorDTO objAdmDto){       
            
            con = new ConexaoDAO().AbrirConexao();
    
            try {
                
                String sql = "select * from administrador where rg_a = ? and senha = ?";
                
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setInt(1, objAdmDto.getRg_adm());
                pstm.setString(2, objAdmDto.getSenha_adm());
                
                ResultSet rs = pstm.executeQuery();
                return rs;
                
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "AdminstradorDAO " +  e);
                return null;
            }
    }
}


    

