package DAO;

import Modelo.Clinica;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ClinicaDAO extends ExecuteSQL{

    public ClinicaDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Clinica(Clinica cl){
        String sql = "insert into clinica values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
}
