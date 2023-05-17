package DAO;

import Modelo.Receita;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReceitaDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Receita> lista = new ArrayList<>();

    public ReceitaDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Receita(Receita rc){
        String sql = "insert into receita values(0, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,rc.getDescricao());
            ps.setInt(2,rc.getFk_cpf_m());
            ps.setInt(3,rc.getFk_cpf_p());
            
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
            public ArrayList<Receita>ListarReceita(){
             String sql = "select * from receita";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Receita objreceita = new Receita();
                objreceita.setId(rs.getInt("id"));
                objreceita.setDescricao(rs.getString("descricao"));
               
                
                  lista.add(objreceita);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar a receita" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
    
    
}
