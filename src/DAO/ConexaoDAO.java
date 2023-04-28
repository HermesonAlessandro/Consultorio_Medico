package DAO;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDAO{
    public static Connection AbrirConexao(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost/consultorio_medico";
            con=DriverManager.getConnection(url, "root","eeep");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error:" + e.getMessage());
            
            
        }
        
     return con;
}
       
}
