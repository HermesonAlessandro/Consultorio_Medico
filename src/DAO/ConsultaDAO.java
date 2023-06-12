package DAO;
import Modelo.Consulta;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ConsultaDAO extends ExecuteSQL{
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Consulta> lista = new ArrayList<>();
        Connection con;

    public ConsultaDAO(Connection con) {
        super(con);
        }
    
    public void Cadastrar_Consulta(Consulta co){
        String sql = "insert into consulta values(?, ?, ?, ?, ?, 0)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,co.getNome_c());
            ps.setString(2,co.getData());
            ps.setInt(3,co.getFk_cpf_m());
            ps.setInt(4,co.getFk_cpf_sec());
            ps.setInt(5,co.getFk_cpf_p());
          
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Consulta cadastrada com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel o cadastrar uma Consulta!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
    
    public ArrayList<Consulta>ListarConsulta(){
             String sql = "select * from consulta";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Consulta objconsulta = new Consulta();
                objconsulta.setNome_c(rs.getString("nome_c"));
                objconsulta.setData(rs.getString("data"));
                objconsulta.setFk_cpf_m(rs.getInt("fk_cpf_m"));
                objconsulta.setFk_cpf_sec(rs.getInt("fk_cpf_sec"));
                objconsulta.setFk_cpf_p(rs.getInt("fk_cpf_p"));
                objconsulta.setId(rs.getInt("id"));
                  lista.add(objconsulta);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar a consulta: " +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    public void AlterarConsulta(Consulta objcconsulta){
    String sql = "update consulta set nome_c = ?, data = ? where id = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objcconsulta.getNome_c());
        pstm.setString(2, objcconsulta.getData());
        pstm.setInt(3, objcconsulta.getId());
                
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Consulta alterado com sucesso!");
        
    }catch(Exception e){
        
    JOptionPane.showMessageDialog(null, "Consulta não alterado!"+e.getMessage());
    }
   
   }
    
    public void ExcluirConsulta(Consulta objconsulta){
        String sql = "delete from consulta where id = ?";
        Connection con = ConexaoDAO.AbrirConexao();
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objconsulta.getId());
            
            ps.execute();
            ps.close();
            
        JOptionPane.showMessageDialog(null, "Consulta Excluida!");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Consulta não Excluida!: "+e.getMessage());
            
        }
    }
    
    public ArrayList<Consulta>BuscarConsulta(int id){
        String sql ="";
        if(id == 0){
            sql = "select * from consulta";
        }else{
             sql = "select * from consulta where id = "+id;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Consulta objconsulta = new Consulta();
                    objconsulta.setId(rs.getInt("id"));
                    objconsulta.setNome_c(rs.getString("nome_c"));
                    objconsulta.setData(rs.getString("data"));
                    
           
                  lista.add(objconsulta);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar um Consulta: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
    
}
