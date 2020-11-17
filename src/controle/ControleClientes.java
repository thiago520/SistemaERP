/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloClientes;

/**
 *
 * @author Thiago
 */
public class ControleClientes {
    ConectaBanco connClientes = new ConectaBanco();
    
    public void InserirClientes(ModeloClientes mod) {
        connClientes.conexao();
        
        try {
            PreparedStatement pst = connClientes.conn.prepareStatement("insert into clientes (nome_cliente,cpfcnpj_cliente,rgie_cliente,empresa_cliente,email_cliente,telefone_cliente,celular_cliente,cep_cliente,endereco_cliente,numero_cliente,complemento_cliente,bairro_cliente,cidade_cliente,uf_cliente,obs_cliente) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNome_cliente());
            pst.setString(2,mod.getCpfcnpj_cliente());
            pst.setString(3,mod.getRgie_cliente());
            pst.setString(4,mod.getEmpresa_cliente());
            pst.setString(5,mod.getEmail_cliente());
            pst.setString(6,mod.getTelefone_cliente());
            pst.setString(7,mod.getCelular_cliente());
            pst.setString(8,mod.getCep_cliente());
            pst.setString(9,mod.getEndereco_cliente());
            pst.setInt(10,mod.getNumero_cliente());
            pst.setString(11,mod.getComplemento_cliente());
            pst.setString(12,mod.getBairro_cliente());
            pst.setString(13,mod.getCidade_cliente());
            pst.setString(14,mod.getUf_cliente());
            pst.setString(15,mod.getObs_cliente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção de dados!\n Erro: "+ ex);
        }
        connClientes.desconecta();        
    }
    
    public void ExcluiClientes(ModeloClientes mod) {
        connClientes.conexao();
        
        try {
            PreparedStatement pst = connClientes.conn.prepareStatement("delete from clientes where id_cliente=?");
            pst.setInt(1,mod.getId_cliente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }
        connClientes.desconecta();
    }
    
    public void AlteraClientes(ModeloClientes mod){
        connClientes.conexao();
        
        try {
            PreparedStatement pst = connClientes.conn.prepareStatement("update clientes set nome_cliente = ?, cpfcnpj_cliente = ?, rgie_cliente = ?, empresa_cliente = ?, email_cliente = ?, telefone_cliente = ?, celular_cliente = ?, cep_cliente = ?, endereco_cliente = ?, numero_cliente = ?, complemento_cliente = ?, bairro_cliente = ?, cidade_cliente = ?, uf_cliente = ?, obs_cliente = ? where id_cliente = ?");
            pst.setString(1,mod.getNome_cliente());
            pst.setString(2,mod.getCpfcnpj_cliente());
            pst.setString(3,mod.getRgie_cliente());
            pst.setString(4,mod.getEmpresa_cliente());
            pst.setString(5,mod.getEmail_cliente());
            pst.setString(6,mod.getTelefone_cliente());
            pst.setString(7,mod.getCelular_cliente());
            pst.setString(8,mod.getCep_cliente());
            pst.setString(9,mod.getEndereco_cliente());
            pst.setInt(10,mod.getNumero_cliente());
            pst.setString(11,mod.getComplemento_cliente());
            pst.setString(12,mod.getBairro_cliente());
            pst.setString(13,mod.getCidade_cliente());
            pst.setString(14,mod.getUf_cliente());
            pst.setString(15,mod.getObs_cliente());
            pst.setInt(16,mod.getId_cliente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos dados!\n Erro: "+ ex);
        }
        connClientes.desconecta();
    }
    
}
