package DAO;

import Modelo.Receita;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ReceitaDAO extends ExecuteSQL{

    public ReceitaDAO(Connection con) {
        super(con);
    }
    
    public void Emitir_Receita(Receita rc){
        String sql = "insert into receita values(0, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,rc.getId());
            ps.setString(2,rc.getDescricao());
            ps.setInt(3,rc.getFk_cpf_m());
            ps.setInt(4,rc.getFk_cpf_p());
            
            
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
