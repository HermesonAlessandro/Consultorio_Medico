package DAO;

import Modelo.Atestado;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AtestadoDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Atestado> lista = new ArrayList<>();

    public AtestadoDAO(Connection con) {
        super(con);
    }
    
    public void Cadastrar_Atestado(Atestado at){
        String sql = "insert into atestado values(0,?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,at.getDias_ausentes());
            ps.setInt(2,at.getFk_cpf_m());
            ps.setInt(3,at.getFk_cpf_p());
           
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "nao foi possivel o cadastro!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
    
        public ArrayList<Atestado>ListarAtestado(){
             String sql = "select * from atestado";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Atestado objatestado = new Atestado();
                objatestado.setId(rs.getInt("id"));
                objatestado.setDias_ausentes(rs.getString("dias_ausentes"));
                                
                  lista.add(objatestado);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar um atestado" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
        
    public void AlterarAtestado(Atestado objatestado){
    String sql = "update atestado set dias_ausentes = ? where id = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objatestado.getDias_ausentes());
        pstm.setInt(2, objatestado.getId());
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Atestado alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Atestado nao alterado!"+e.getMessage());
    
    
    }
    
   }
   
}