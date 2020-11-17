/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloProdutos;

/**
 *
 * @author Thiago
 */
public class ControleProdutos {
    ConectaBanco connProdutos = new ConectaBanco();
    int codFornecedor;
    
    public void InserirProdutos(ModeloProdutos mod) {
        connProdutos.conexao();
        
        try {            
            PreparedStatement pst = connProdutos.conn.prepareStatement("insert into produtos (id_produto,nome_produto,gtin_produto,gtin_embalagem,estoquema,estoquemi,unidade_produto,qtda_caixa,preco_venda,categoria) values (?,?,?,?,?,?,?,?,?,?) ");
            pst.setInt(1,mod.getId_produto());
            pst.setString(2,mod.getNome_produto());
            pst.setString(3,mod.getGtin_produto());
            pst.setString(4,mod.getGtin_embalagem());
            pst.setInt(5,mod.getEstoquema());
            pst.setInt(6,mod.getEstoquemi());
            pst.setString(7,mod.getUnidade_produto());            
            pst.setDouble(8,mod.getQtda_caixa());
            pst.setDouble(9,mod.getPreco_venda());
            pst.setString(10,mod.getCategoria());            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n Erro: "+ ex);
        }
        
        connProdutos.desconecta();
    }
    
    public void ExluirProdutos(ModeloProdutos mod) {
        connProdutos.conexao();
        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("delete from produtos where id_produto=?");
            pst.setInt(1,mod.getId_produto());
            PreparedStatement pst1 = connProdutos.conn.prepareStatement("delete from produto_fornecedor where cod_produto=?");
            pst1.setInt(1,mod.getId_produto());
            pst.execute();
            pst1.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }        
        connProdutos.desconecta();        
        
    }
    
    public void AlterarProdutos(ModeloProdutos mod) {
        connProdutos.conexao();
        
        try {            
            PreparedStatement pst = connProdutos.conn.prepareStatement("update produtos set nome_produto = ?, gtin_produto = ?, gtin_embalagem = ?, estoquema = ?, estoquemi = ?, unidade_produto = ?, qtda_caixa = ?, preco_venda = ?, categoria = ? where id_produto = ? ");
            pst.setString(1,mod.getNome_produto());
            pst.setString(2,mod.getGtin_produto());
            pst.setString(3,mod.getGtin_embalagem());
            pst.setInt(4,mod.getEstoquema());
            pst.setInt(5,mod.getEstoquemi());
            pst.setString(6,mod.getUnidade_produto());            
            pst.setDouble(7,mod.getQtda_caixa());
            pst.setDouble(8,mod.getPreco_venda());
            pst.setString(9,mod.getCategoria());                        
            pst.setInt(10,mod.getId_produto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\n Erro: "+ ex);
        }   
        
        connProdutos.desconecta();
    }
    
    public void InserirItens(ModeloProdutos mod){
        connProdutos.conexao();
        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("insert into itens_produtos (cod_produto,qtda_item) values (?,?)");
            pst.setInt(1,mod.getId_produto());
            pst.setDouble(2,mod.getQtda_item());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n Erro: "+ ex);
        }
        
        connProdutos.desconecta();
    }
    
    public void ExcluirItens(ModeloProdutos mod){
        connProdutos.conexao();
        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("delete from itens_produtos where cod_produto=?");
            pst.setInt(1,mod.getId_produto());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }
        connProdutos.desconecta();
    }
    
    public void AlterarItens(ModeloProdutos mod){
        connProdutos.conexao();
        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("update itens_prdoutos set cod_produto = ?, qtda_item = ? where cod_item = ?");
            pst.setInt(1,mod.getCod_produto());
            pst.setDouble(2,mod.getQtda_item());
            pst.setInt(3,mod.getCod_item());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\n Erro: "+ ex);
        }        
        connProdutos.desconecta();        
    }
    
    public void InserirProForn(ModeloProdutos mod){
        connProdutos.conexao();
        buscaCodigo(mod.getFantasia_fornecedor());        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("insert into produto_fornecedor (cod_produto,cod_fornecedor,data,preco_custo) values (?,?,?,?)");
            pst.setInt(1,mod.getId_produto());
            pst.setInt(2,codFornecedor);
            pst.setString(3, mod.getData());
            pst.setDouble(4,mod.getPreco_custo());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n Erro: "+ ex);
        }
        connProdutos.desconecta();
        
    }
    
    public void ExcluirProForn(ModeloProdutos mod){
        connProdutos.conexao();       
            buscaCodigo(mod.getFantasia_fornecedor());        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("delete from produto_fornecedor where cod_produto = ? and cod_fornecedor = ?");
            pst.setInt(1,mod.getId_produto());            
            pst.setInt(2,codFornecedor);            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }
        connProdutos.desconecta();
    }
    
    public void AlterarProForn(ModeloProdutos mod){
        connProdutos.conexao();       
            buscaCodigo(mod.getFantasia_fornecedor());        
        try {
            PreparedStatement pst = connProdutos.conn.prepareStatement("update produto_fornecedor set data = ?, preco_custo = ? where cod_produto = ? and cod_fornecedor = ?");
            pst.setString(1,mod.getData());
            pst.setDouble(2,mod.getPreco_custo());
            pst.setInt(3,mod.getId_produto());
            pst.setInt(4,codFornecedor);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\n Erro: "+ ex);
        }        
        connProdutos.desconecta();        
    } 
    
    public double CalculoPrecoUn (ModeloProdutos mod) {
                
        double precoUn = (mod.getPreco_custo() / mod.getQtda_caixa());
        return precoUn;        
    }
    
    public BigDecimal ArredondaValor (Double valor) {        
        BigDecimal arred = new BigDecimal(valor);
        arred = arred.setScale(2, BigDecimal.ROUND_HALF_UP); 
        return arred;
    }  
    
    public void buscaCodigo (String nome) {
        connProdutos.conexao();
            connProdutos.executaSQL("select * from fornecedor where fantasia_fornecedor = '"+nome+"'");
            try {
                connProdutos.rs.first();
                codFornecedor = connProdutos.rs.getInt("id_fornecedor");
            } catch (SQLException ex) {
                Logger.getLogger(ControleProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }               
    }   
    
}
