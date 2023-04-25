package DAO;

import Modelo.Medico;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class MedicoDAO extends ExecuteSQL{

    public MedicoDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Medico(Medico m){
        String sql = "insert into medico values(?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,m.getCpf());
            ps.setString(2,m.getNome());
            ps.setInt(3,m.getRg());
            ps.setInt(4,m.getTel());
            ps.setString(5,m.getEnd());
            ps.setString(6,m.getSexo());
            ps.setString(7,m.getSenha());
            
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

