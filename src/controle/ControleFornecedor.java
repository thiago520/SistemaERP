/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloFornecedor;

/**
 *
 * @author Thiago
 */
public class ControleFornecedor {
    ConectaBanco connFornecedor = new ConectaBanco();
    
    public void InserirFornecedor(ModeloFornecedor mod) {
        connFornecedor.conexao();
        
        try {
            PreparedStatement pst = connFornecedor.conn.prepareStatement("insert into fornecedor (razao_fornecedor,fantasia_fornecedor,cnpj_fornecedor,ie_fornecedor,cep_fornecedor,endereco_fornecedor,numero_fornecedor,complemento_fornecedor,bairro_fornecedor,cidade_fornecedor,estado_fornecedor,contato_fornecedor,telefone_fornecedor,celular_fornecedor,email_fornecedor) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getRazao_fornecedor());
            pst.setString(2,mod.getFantasia_fornecedor());
            pst.setString(3,mod.getCnpj_fornecedor());
            pst.setString(4,mod.getIe_fornecedor());
            pst.setString(5,mod.getCep_fornecedor());
            pst.setString(6,mod.getEndereco_fornecedor());
            pst.setInt(7,mod.getNumero_fornecedor());
            pst.setString(8,mod.getComplemento_fornecedor());
            pst.setString(9,mod.getBairro_fornecedor());
            pst.setString(10,mod.getCidade_fornecedor());
            pst.setString(11,mod.getEstado_fornecedor());
            pst.setString(12,mod.getContato_fornecedor());
            pst.setString(13,mod.getTelefone_fornecedor());
            pst.setString(14,mod.getCelular_fornecedor());
            pst.setString(15,mod.getEmail_fornecedor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção de dados!\n Erro: "+ ex);
        }
        connFornecedor.desconecta();        
    }
    
    public void ExcluiFornecedor(ModeloFornecedor mod) {
        connFornecedor.conexao();
        
        try {
            PreparedStatement pst = connFornecedor.conn.prepareStatement("delete from fornecedor where id_fornecedor=?");
            pst.setInt(1,mod.getId_fornecedor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }
        connFornecedor.desconecta();        
    }
    
    public void AlteraFornecedor(ModeloFornecedor mod){
        connFornecedor.conexao();
        
        try {
            PreparedStatement pst = connFornecedor.conn.prepareStatement("update fornecedor set razao_fornecedor = ?, fantasia_fornecedor = ?, cnpj_fornecedor = ?, ie_fornecedor = ?, cep_fornecedor = ?, endereco_fornecedor = ?, numero_fornecedor = ?, complemento_fornecedor = ?, bairro_fornecedor = ?, cidade_fornecedor = ?, estado_fornecedor = ?, contato_fornecedor = ?, telefone_fornecedor = ?, celular_fornecedor = ?, email_fornecedor = ? where id_fornecedor = ?");
            pst.setString(1,mod.getRazao_fornecedor());
            pst.setString(2,mod.getFantasia_fornecedor());
            pst.setString(3,mod.getCnpj_fornecedor());
            pst.setString(4,mod.getIe_fornecedor());
            pst.setString(5,mod.getCep_fornecedor());
            pst.setString(6,mod.getEndereco_fornecedor());
            pst.setInt(7,mod.getNumero_fornecedor());
            pst.setString(8,mod.getComplemento_fornecedor());
            pst.setString(9,mod.getBairro_fornecedor());
            pst.setString(10,mod.getCidade_fornecedor());
            pst.setString(11,mod.getEstado_fornecedor());
            pst.setString(12,mod.getContato_fornecedor());
            pst.setString(13,mod.getTelefone_fornecedor());
            pst.setString(14,mod.getCelular_fornecedor());
            pst.setString(15,mod.getEmail_fornecedor());
            pst.setInt(16,mod.getId_fornecedor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos dados!\n Erro: "+ ex);
        }
        connFornecedor.desconecta();
    }
}
