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
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
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
                         "nao foi possivel encontrar o convenio" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
 
}

