package DAO;

import Modelo.Atestado;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AtestadoDAO extends ExecuteSQL{

    public AtestadoDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Atestado(Atestado at){
        String sql = "insert into atestado values(0, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,at.getId());
            ps.setString(2,at.getDias_ausentes());
            ps.setInt(3,at.getFk_cpf_m());
            ps.setInt(4,at.getFk_cpf_p());
           
            
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
