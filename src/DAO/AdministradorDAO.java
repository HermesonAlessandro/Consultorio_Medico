package DAO;
import Modelo.Administrador; 
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.AdministradorDTO;
import java.util.ArrayList;

public class AdministradorDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Administrador> lista = new ArrayList<>();

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
    
    public ArrayList<Administrador>ListarAdministrador(){
             String sql = "select * from administrador";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Administrador objadministrador = new Administrador();
                objadministrador.setRg_a(rs.getInt("rg_a"));
                objadministrador.setNome_func(rs.getString("nome_func"));
                objadministrador.setCpf(rs.getInt("cpf"));
                objadministrador.setSenha(rs.getString("senha"));
                objadministrador.setSexo(rs.getString("sexo"));
                objadministrador.setClin(rs.getString("clin"));
                objadministrador.setTel(rs.getInt("tel"));
                
                  lista.add(objadministrador);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar o administrador" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
   public void AlterarAdministrador(Administrador objadministrador){
    String sql = "update administrador set nome_func = ?, cpf = ?, senha = ?, sexo = ?, clin = ?,  tel = ? where rg_a = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objadministrador.getNome_func());
        pstm.setInt(2, objadministrador.getCpf());
        pstm.setString(3, objadministrador.getSenha());
        pstm.setString(4, objadministrador.getSexo());
        pstm.setString(5, objadministrador.getClin());
        pstm.setInt(6, objadministrador.getTel());
        pstm.setInt(7, objadministrador.getRg_a());
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Administrador alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Administrador nao alterado!"+e.getMessage());
    
    
    }
   
   }
   
   public void ExcluirAdministrador(Administrador objadministrador){
       String sql = "delete from administrador where rg_a = ?";
       Connection con = ConexaoDAO.AbrirConexao();
       
       try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objadministrador.getRg_a());
            
            ps.execute();
            ps.close();
           
           JOptionPane.showMessageDialog(null, "Administrador Excluido!");
           
       }catch (Exception e){
           
           JOptionPane.showMessageDialog(null, "Administrador não Excluido!: "+e.getMessage());
       }
   }
   
   
   
    public ArrayList<Administrador>BuscarAdministrador(String nome_func){
        String sql ="";
        if(nome_func.equals("")){
            sql = "select * from administrador";
        
        }else{
            sql = "select * from administrador where nome_func like '%"+nome_func+"%'";
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Administrador objadministrador = new Administrador();
                    objadministrador.setRg_a(rs.getInt("rg_a"));
                    objadministrador.setNome_func(rs.getString("nome_func"));
                    objadministrador.setCpf(rs.getInt("cpf"));
                    objadministrador.setSenha(rs.getString("senha"));
                    objadministrador.setSexo(rs.getString("sexo"));
                    objadministrador.setClin(rs.getString("clin"));
                    objadministrador.setTel(rs.getInt("tel"));
                    
                
                  lista.add(objadministrador);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar o Administrador!: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
}


    

