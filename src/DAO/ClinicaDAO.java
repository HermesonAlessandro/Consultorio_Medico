package DAO;

import Modelo.Clinica;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClinicaDAO extends ExecuteSQL{
     Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Clinica> lista = new ArrayList<>();

    public ClinicaDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Clinica(Clinica cl){
        String sql = "insert into clinica values(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,cl.getCnpj());
            ps.setString(2,cl.getNome());
            ps.setString(3,cl.getEnd());
            ps.setInt(4,cl.getTel());
            ps.setInt(5,cl.getFk_cpf_sec());
            ps.setInt(6,cl.getFk_cpf_m());
            ps.setInt(7,cl.getFk_cpf_p());
            ps.setInt(8,cl.getFk_rg_a());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
     public ArrayList<Clinica>Listarclinica(){
             String sql = "select * from clinica";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Clinica objclinica = new Clinica();
                objclinica.setCnpj(rs.getInt("cnpj"));
                objclinica.setNome(rs.getString("nome"));
                objclinica.setEnd(rs.getString("end"));
                objclinica.setTel(rs.getInt("tel"));
                objclinica.setFk_cpf_sec(rs.getInt("fk_cpf_sec"));
                objclinica.setFk_cpf_m(rs.getInt("fk_cpf_m"));
                objclinica.setFk_cpf_p(rs.getInt("FK_cpf_p"));
                objclinica.setFk_rg_a(rs.getInt("fk_rg_a"));
                
                  lista.add(objclinica);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar a clinica" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
    
    
    
    
    
    
    
}
