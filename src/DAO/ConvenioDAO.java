package DAO;

import Modelo.Convenio;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ConvenioDAO extends ExecuteSQL{;
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Convenio> lista = new ArrayList<>();

    public ConvenioDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Convenio(Convenio c){
        String sql = "insert into convenio values(?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,c.getCnpj());
            ps.setString(2,c.getNome());
            ps.setInt(3,c.getTel());
            ps.setString(4,c.getPlanos());
            ps.setString(5,c.getEnd());
            ps.setInt(6,c.getFk_cpf_sec());
            
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Convenio cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel o cadastrar um Convenio!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
    public ArrayList<Convenio>ListarConvenio(){
             String sql = "select * from convenio";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Convenio objconvenio = new Convenio();
                objconvenio.setCnpj(rs.getInt("cnpj"));
                objconvenio.setNome(rs.getString("nome"));
                objconvenio.setTel(rs.getInt("tel"));
                objconvenio.setPlanos(rs.getString("planos"));
                objconvenio.setEnd(rs.getString("end"));
                objconvenio.setFk_cpf_sec(rs.getInt("fk_cpf_sec"));
                
                  lista.add(objconvenio);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar o Convenio: " +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
    public void AlterarConvenio(Convenio objconvenio){
    String sql = "update convenio set nome = ?, tel = ?, planos = ?, end = ? where cnpj = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objconvenio.getNome());
        pstm.setInt(2, objconvenio.getTel());
        pstm.setString(3, objconvenio.getPlanos());
        pstm.setString(4, objconvenio.getEnd());
        pstm.setInt(5, objconvenio.getCnpj());
        
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Convenio alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Convenio não alterado!: "+e.getMessage());
    
    
    }
   
   } 
    
    public void ExcluirConvenio(Convenio objconvenio){
        String sql = "delete from convenio where cnpj = ?";
        Connection con = new ConexaoDAO().AbrirConexao();
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objconvenio.getCnpj());
            
            ps.execute();
            ps.close();
            
        JOptionPane.showMessageDialog(null, "Convenio Excluido!");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Convenio não excluido!"+e.getMessage());
               
        }
    }
    
     public ArrayList<Convenio>BuscarConvenio(int cnpj){
        String sql ="";
        if(cnpj == 0){
            sql = "select * from convenio";
        }else{
             sql = "select * from convenio where cnpj = "+cnpj;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Convenio objconvenio = new Convenio();
                    objconvenio.setCnpj(rs.getInt("cnpj"));
                    objconvenio.setNome(rs.getString("nome"));
                    objconvenio.setTel(rs.getInt("tel"));
                    objconvenio.setPlanos(rs.getString("planos"));
                    objconvenio.setEnd(rs.getString("end"));
           
                  lista.add(objconvenio);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar um Convenio: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
}

