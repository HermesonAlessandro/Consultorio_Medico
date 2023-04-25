package DAO;

import Modelo.Relatorio;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class RelatorioDAO extends ExecuteSQL{

    public RelatorioDAO(Connection con) {
        super(con);
    }
    
    public void Emitir_Relatorio(Relatorio r){
        String sql = "insert into relatorio values(0, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,r.getId());
            ps.setString(2,r.getDescricao());
            ps.setInt(3,r.getFk_cpf_m());
            
            
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
