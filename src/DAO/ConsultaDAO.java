package DAO;


import Modelo.Consulta;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConsultaDAO extends ExecuteSQL{

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
            ps.setInt(6,co.getId());
            
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
