package DAO;


import Modelo.Consulta;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ConsultaDAO extends ExecuteSQL{
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Consulta> lista = new ArrayList<>();
        Connection con;

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
    
    
    public ArrayList<Consulta>PesquisarConsulta(){
             String sql = "select * from medico";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Consulta objconsulta = new Consulta();
                objconsulta.setNome_c(rs.getString("nome_c"));
                objconsulta.setData(rs.getString("data"));
                objconsulta.setFk_cpf_m(rs.getInt("fk_cpf_m"));
                objconsulta.setFk_cpf_sec(rs.getInt("fk_cpf_sec"));
                objconsulta.setFk_cpf_p(rs.getInt("fk_cpf_p"));
                objconsulta.setId(rs.getInt("id"));
                  lista.add(objconsulta);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar o medico" +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
}
