package sisare.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisare.connection.ConnectionFactory;
import sisare.model.bean.Funcionario;

public class FuncionarioDAO {
    
    public List<Funcionario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSenha(rs.getString("senha"));
                funcionarios.add(funcionario);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios; 
    }
    
}