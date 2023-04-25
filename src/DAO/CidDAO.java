package DAO;

import Modelo.Cid;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CidDAO extends ExecuteSQL{

    public CidDAO(Connection con) {
        super(con);
    }
   
    public void Cadastrar_Cid(Cid ci){
        String sql = "insert into cid values(?, ?, ?, 0)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,ci.getCod_cid_10());
            ps.setString(2,ci.getDescricao());
            ps.setInt(3,ci.getCapitulo());
            ps.setInt(4,ci.getCod());
            
            
            
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
