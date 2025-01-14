package DAO;
import Modelo.Paciente;
import java.sql.*; 
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteDAO extends ExecuteSQL{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Paciente> lista = new ArrayList<>();

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
                JOptionPane.showMessageDialog(null, "Paciente cadastrado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel o cadastrar um Paciente!");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error: " +e.getMessage());
           
           }
    }
   
    public ArrayList<Paciente>ListarPaciente(){
             String sql = "select * from paciente";
             Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                Paciente objpaciente = new Paciente();
                objpaciente.setCpf(rs.getInt("cpf"));
                objpaciente.setNome(rs.getString("nome"));
                objpaciente.setEnd(rs.getString("end"));
                objpaciente.setTel(rs.getInt("tel"));
                objpaciente.setRg(rs.getInt("rg"));
                objpaciente.setSexo(rs.getString("sexo"));
                objpaciente.setConvenio(rs.getString("convenio"));
                objpaciente.setFk_cpf_sec(rs.getInt("fk_cpf_sec"));
                objpaciente.setFk_cnpj_convenio(rs.getInt("fk_cnpj_convenio"));
                
                  lista.add(objpaciente);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "Não foi possivel encontrar o Paciente: " +e.getMessage());
                 
                    }
           
         return lista; 
        
  }
    
    
    
    public void AlterarPaciente(Paciente objpaciente){
    String sql = "update paciente set nome = ?, end = ?, tel = ?, rg = ?, sexo = ?,  convenio = ? where cpf = ?";
    Connection con = ConexaoDAO.AbrirConexao();
    
    try{
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, objpaciente.getNome());
        pstm.setString(2, objpaciente.getEnd());
        pstm.setInt(3, objpaciente.getTel());
        pstm.setInt(4, objpaciente.getRg());
        pstm.setString(5, objpaciente.getSexo());
        pstm.setString(6, objpaciente.getConvenio());
        pstm.setInt(7, objpaciente.getCpf());
        
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso!");
        
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Paciente não alterado!: "+e.getMessage());
    
    
    }
   
   } 
   
        public void ExcluirPaciente(Paciente objpaciente){
        String sql = "delete from paciente where cpf = ?";
        Connection con = ConexaoDAO.AbrirConexao();
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objpaciente.getCpf());
            
            ps.execute();
            ps.close();
            
        JOptionPane.showMessageDialog(null, "Paciente Excluido!");
        
        }catch(Exception e){
            
        JOptionPane.showMessageDialog(null, "Paciente não Excluido!: "+e.getMessage());
        
        }
        }
        
        public ArrayList<Paciente>BuscarPaciente(int cpf){
        String sql ="";
        if(cpf == 0){
            sql = "select * from paciente";
        }else{
             sql = "select * from paciente where cpf = "+cpf;
            
        }
        Connection con = ConexaoDAO.AbrirConexao();
             
             
             try {
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 
                 while(rs.next()){
                    Paciente objpaciente = new Paciente();
                    objpaciente.setCpf(rs.getInt("cpf"));
                    objpaciente.setNome(rs.getString("nome"));
                    objpaciente.setEnd(rs.getString("end"));
                    objpaciente.setTel(rs.getInt("tel"));
                    objpaciente.setRg(rs.getInt("rg"));
                    objpaciente.setSexo(rs.getString("sexo"));
                    objpaciente.setConvenio(rs.getString("convenio"));
           
                  lista.add(objpaciente);
        
                 }
                 
             }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,
                         "nao foi possivel encontrar um Paciente: " +e.getMessage());
                 
                    }
           
         return lista;    
    }
        
        
}
    
    

