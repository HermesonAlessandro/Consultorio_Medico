package DAO;

import Modelo.Cid;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CidDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Cid> lista = new ArrayList<>();

    public CidDAO(Connection con) {
        super(con);
    }
   
    public void Cadastrar_Cid(Cid ci){
        String sql = "insert into cid values(?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setInt(1,ci.getCapitulo());
              ps.setString(2,ci.getDescricao());
               ps.setString(3, ci.getCod_cid_10());
               ps.setInt(4, ci.getCod());
           
           
         
            
            
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    public ArrayList<Cid>ListarCid(){
             String sql = "select * from cid";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Cid objcid = new Cid();
                objcid.setCapitulo(rs.getInt("capitulo"));
                objcid.setDescricao(rs.getString("descricao"));
                objcid.setCod_cid_10(rs.getString("cod_cid_10"));
                objcid.setCod(rs.getInt("cod"));
                
                
                  lista.add(objcid);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar uma doença" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
}
