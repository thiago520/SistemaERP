/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCardapio;

/**
 *
 * @author Thiago
 */
public class ControleCardapio {
    ConectaBanco connCardapio = new ConectaBanco();
    
    public void InserirCardapio(ModeloCardapio mod){
        connCardapio.conexao();
        try {
                PreparedStatement pst = connCardapio.conn.prepareStatement("insert into cardapio (data,salada1,salada2,salada3,salada4,salada5,prato1,prato2,prato3,guarnicao1,guarnicao2,guarnicao3,salada_marmita1,salada_marmita2) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,mod.getData());
                pst.setString(2,mod.getSalada1());
                pst.setString(3,mod.getSalada2());
                pst.setString(4,mod.getSalada3());
                pst.setString(5,mod.getSalada4());
                pst.setString(6,mod.getSalada5());
                pst.setString(7,mod.getPrato1());
                pst.setString(8,mod.getPrato2());
                pst.setString(9,mod.getPrato3());
                pst.setString(10,mod.getGuarnicao1());
                pst.setString(11,mod.getGuarnicao2());
                pst.setString(12,mod.getGuarnicao3());
                pst.setString(13,mod.getSalada_marmita1());
                pst.setString(14,mod.getSalada_marmita2());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                                         
            } catch (SQLException ex) {
            
                JOptionPane.showMessageDialog(null, "Erro na inserção de dados!\n Erro: "+ ex);
        }
            connCardapio.desconecta();
    }
    
    public void ExcluiCardapio(ModeloCardapio mod){
        connCardapio.conexao();
        try {
            PreparedStatement pst = connCardapio.conn.prepareStatement("delete from cardapio where data=?");
            pst.setString(1, mod.getData());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }      
        connCardapio.desconecta();
    }
    
    public void AlteraCardapio(ModeloCardapio mod){
        connCardapio.conexao();
        try {
             PreparedStatement pst = connCardapio.conn.prepareStatement("update cardapio set salada1 = ?, salada2 = ?, salada3 = ?, salada4 = ?, salada5 = ?, prato1 = ?, prato2 = ?, prato3 = ?, guarnicao1 = ?, guarnicao2 = ?, guarnicao3 = ?, salada_marmita1 = ?, salada_marmita2 =? where data = ?");
             pst.setString(1,mod.getSalada1());
             pst.setString(2,mod.getSalada2());
             pst.setString(3,mod.getSalada3());
             pst.setString(4,mod.getSalada4());
             pst.setString(5,mod.getSalada5());
             pst.setString(6,mod.getPrato1());
             pst.setString(7,mod.getPrato2());
             pst.setString(8,mod.getPrato3());
             pst.setString(9,mod.getGuarnicao1());
             pst.setString(10,mod.getGuarnicao2());
             pst.setString(11,mod.getGuarnicao3());
             pst.setString(12,mod.getSalada_marmita1());
             pst.setString(13,mod.getSalada_marmita2());
             pst.setString(14,mod.getData());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\n Erro: "+ ex);
        }
        connCardapio.desconecta();
    }
}
