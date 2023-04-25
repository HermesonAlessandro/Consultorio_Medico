package DAO;

import Modelo.Compromisso_medico;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Compromisso_medicoDAO extends ExecuteSQL{

    public Compromisso_medicoDAO(Connection con) {
        super(con);
    }
    
    public void Marcar_Compromisso_medico(Compromisso_medico cm){
        String sql = "insert into compromisso_medico values(0, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,cm.getId_comp_medico());
            ps.setString(2,cm.getDescricao());
            ps.setString(3,cm.getH_fim());
            ps.setString(4,cm.getH_ini());
            ps.setInt(5,cm.getFk_cpf_sec());
            ps.setInt(6,cm.getFk_cpf_m());
           
            
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
