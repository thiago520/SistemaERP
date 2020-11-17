/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * 
 *
 * @author Thiago
 */
public class ConectaBanco {
 
    GeraLog log = new GeraLog();
    public Statement stm;
    public ResultSet rs;
    private final String driver = "org.gjt.mm.mysql.Driver";
    Dados dados = new Dados();
    
    

    public Connection conn;    
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(dados.caminho, dados.usuario, dados.senha);
          //  JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de conexão!\n Erro:"+ex.getMessage());
            log.gravaErro(ex.toString(), "conexao");
        }
        
    } 
    // rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY
    
    public void executaSQL (String sql){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de Execução SQL!\n Erro:"+ex.getMessage());
            log.gravaErro(ex.toString(), "executaSQL");
        }
    }
    
    public void executaUpdate (String sql){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int res = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de Execução SQL!\n Erro:"+ex.getMessage());
            log.gravaErro(ex.toString(), "executaUpdate");
        }
    }
    
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão!\n Erro:"+ex.getMessage());
            log.gravaErro(ex.toString(), "desconecta");           
        }
    }
}