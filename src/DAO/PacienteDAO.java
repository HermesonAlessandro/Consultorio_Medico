package DAO;
import Modelo.Paciente;
import java.sql.*; 
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class PacienteDAO extends ExecuteSQL{

    public PacienteDAO(Connection con) {
        super(con);
    }
    
    
    public void Cadastrar_Paciente(Paciente p){
        String sql = "insert into paciente values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,p.getCpf());
            ps.setString(2,p.getNome());
            ps.setString(3,p.getEnd());
            ps.setInt(4,p.getTel());
            ps.setInt(5,p.getRg());
            ps.setString(6,p.getSexo());
            ps.setString(7,p.getConvenio());
            ps.setInt(8,p.getFk_cpf_sec());
            ps.setInt(9,p.getFk_cnpj_convenio());
            
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
    
    

