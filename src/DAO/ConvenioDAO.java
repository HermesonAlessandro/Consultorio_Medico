package DAO;

import Modelo.Convenio;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConvenioDAO extends ExecuteSQL{

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
    
 
}

