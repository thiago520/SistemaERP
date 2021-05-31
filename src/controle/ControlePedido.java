/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloPedido;

/**
 *
 * @author thiag
 */
public class ControlePedido {
    ConectaBanco connPedidos = new ConectaBanco();
    GeraLog log = new GeraLog();
    
    public void InserirPedido (ModeloPedido mod) {
        connPedidos.conexao();
        
        try {            
            PreparedStatement pst = connPedidos.conn.prepareStatement("insert into pedido (cod_pedido,cod_cliente,status,forma_pagamento,desconto,data_agendada,hora_agendada,obs_pedido,local,troco,valor_total,entregador,datahora_entrada) values (?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE()) ");
            pst.setInt(1,mod.getCod_pedido());
            pst.setInt(2,mod.getCod_cliente());
            pst.setString(3,mod.getStatus());
            pst.setString(4,mod.getForma_pagamento());
            pst.setBigDecimal(5,mod.getDesconto());            
            pst.setString(6,mod.getData_agendada());            
            pst.setString(7,mod.getHora_agendada());
            pst.setString(8,mod.getObs_pedido());
            pst.setString(9,mod.getLocal());            
            pst.setBigDecimal(10,mod.getTroco());
            pst.setBigDecimal(11,mod.getValor_total());            
            pst.setString(12, mod.getEntregador());            
            pst.execute();              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n Erro: "+ ex);
        }
        
        connPedidos.desconecta();
    }  
    
    public void ExluirPedido(ModeloPedido mod) {
        connPedidos.conexao();
        
        try {
            PreparedStatement pst = connPedidos.conn.prepareStatement("delete from pedido where cod_pedido=?");
            pst.setInt(1,mod.getCod_pedido());            
            pst.execute();            
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }        
        connPedidos.desconecta();        
        
    }
    
    public void AlterarPedido (ModeloPedido mod) {
        connPedidos.conexao();
        
        try {            
            PreparedStatement pst = connPedidos.conn.prepareStatement("update pedido set cod_cliente = ?,status = ?,forma_pagamento = ?,desconto = ?,valor_pago = ?,data_agendada = ?,hora_agendada = ?,obs_pedido = ?,local = ?,valor_total = ?, troco = ? where cod_pedido  = ? ");
            pst.setInt(1,mod.getCod_cliente());
            pst.setString(2,mod.getStatus());
            pst.setString(3,mod.getForma_pagamento());
            pst.setBigDecimal(4,mod.getDesconto());
            pst.setBigDecimal(5,mod.getValor_pago());
            pst.setString(6,mod.getData_agendada());            
            pst.setString(7,mod.getHora_agendada());
            pst.setString(8,mod.getObs_pedido());
            pst.setString(9,mod.getLocal());
            pst.setBigDecimal(10,mod.getValor_total());
            pst.setBigDecimal(11,mod.getTroco());
            pst.setInt(12,mod.getCod_pedido());
            pst.execute(); 
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n Erro: "+ ex);
        }
        
        connPedidos.desconecta();
    }
    
    public void InserirItensPedido(ModeloPedido mod){
        connPedidos.conexao();
        
        try {
            PreparedStatement pst = connPedidos.conn.prepareStatement("insert into itens_pedido (cod_pedido,cod_produto,qtda_produto,valor_un,obs_produto) values (?,?,?,?,?)");
            pst.setInt(1,mod.getCod_pedido());
            pst.setInt(2,mod.getCod_produto());
            pst.setBigDecimal(3,mod.getQtda_produto());
            pst.setBigDecimal(4,mod.getValor_un());
            pst.setString(5,mod.getObs_produto());
            pst.execute();
            PreparedStatement pst2 = connPedidos.conn.prepareStatement("update produtos set estoque = ? where id_produto = ?");
            pst2.setBigDecimal(1,mod.getCtrlEstoque().subtract(mod.getQtda_produto()));
            pst2.setInt(2,mod.getCod_produto());
            pst2.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n Erro: "+ ex);
        }
        
        connPedidos.desconecta();
    }
    
    public void ExcluirItensPedido(ModeloPedido mod){
        connPedidos.conexao();
        connPedidos.executaSQL("select produtos.estoque from itens_pedido,produtos where cod_pedido = '"+ mod.getCod_pedido() +"' and itens_pedido.cod_produto = produtos.id_produto");
        
        try {
            connPedidos.rs.first();
            if (connPedidos.rs.first() != false) {  
                 mod.setCtrlEstoque(connPedidos.rs.getBigDecimal("estoque"));
             }
            
            PreparedStatement pst = connPedidos.conn.prepareStatement("delete from itens_pedido where cod_itensPedido = ?");
            pst.setInt(1,mod.getCod_itensPedido());            
            pst.execute();
            PreparedStatement pst2 = connPedidos.conn.prepareStatement("update produtos set estoque = ? where id_produto = ?");
            pst2.setBigDecimal(1,mod.getCtrlEstoque().add(mod.getQtda_produto()));
            pst2.setInt(2,mod.getCod_produto());
            pst2.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }
        connPedidos.desconecta();
    }
    
    public void ExcluirItensNSalvo(ModeloPedido mod){
        connPedidos.conexao();
        connPedidos.executaSQL("select itens_pedido.qtda_produto,itens_pedido.cod_produto,produtos.estoque from itens_pedido,produtos where cod_pedido = '"+ mod.getCod_pedido() +"' and itens_pedido.cod_produto = produtos.id_produto");                            
        try {                      
             connPedidos.rs.first();
             if (connPedidos.rs.first() != false) {   
                PreparedStatement pst2 = connPedidos.conn.prepareStatement("update produtos set estoque = ? where id_produto = ?");
                do{ 
                    pst2.setDouble(1,connPedidos.rs.getDouble("qtda_produto")+connPedidos.rs.getDouble("estoque"));
                    pst2.setInt(2,connPedidos.rs.getInt("cod_produto"));                                                           
                    pst2.execute();
                }while(connPedidos.rs.next());     
              }
            PreparedStatement pst = connPedidos.conn.prepareStatement("delete from itens_pedido where cod_pedido = ?");
            pst.setInt(1,mod.getCod_pedido());            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\n Erro: "+ ex);
        }
        connPedidos.desconecta();
    }
    
    public void AlterarItensPedido(ModeloPedido mod){        
        connPedidos.conexao();       
        connPedidos.executaSQL("select itens_pedido.qtda_produto,produtos.estoque from itens_pedido,produtos where itens_pedido.cod_itensPedido = '"+ mod.getCod_itensPedido() +"' and produtos.id_produto = '"+ mod.getCod_produto() +"'");        
        
        try {
            connPedidos.rs.first();            
            PreparedStatement pst = connPedidos.conn.prepareStatement("update itens_pedido set qtda_produto = ?, valor_un = ?, obs_produto = ?, cod_produto = ?, cod_pedido = ? where cod_itensPedido = ? ");
            pst.setBigDecimal(1,mod.getQtda_produto());
            pst.setBigDecimal(2,mod.getValor_un());
            pst.setString(3,mod.getObs_produto());
            pst.setInt(4,mod.getCod_produto());
            pst.setInt(5,mod.getCod_pedido());
            pst.setInt(6,mod.getCod_itensPedido());
            pst.execute();
            PreparedStatement pst2 = connPedidos.conn.prepareStatement("update produtos set estoque = ? where id_produto = ?");
            pst2.setBigDecimal(1,(connPedidos.rs.getBigDecimal("qtda_produto").add(connPedidos.rs.getBigDecimal("estoque")).subtract(mod.getQtda_produto())));
            pst2.setInt(2,mod.getCod_produto());
            pst2.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\n Erro: "+ ex);
        }        
        connPedidos.desconecta();        
    } 
    
    public void AlterarStatus (ModeloPedido mod) {
        connPedidos.conexao();
        
        try {            
            PreparedStatement pst = connPedidos.conn.prepareStatement("update pedido set status = ? where cod_pedido  = ? ");
            pst.setString(1,mod.getStatus());
            pst.setInt(2,mod.getCod_pedido());            
            pst.execute();                         
        } catch (SQLException ex) {            
        }
        
        connPedidos.desconecta();
    }
    
    public void FinalizaValorPago (ModeloPedido mod) {
        connPedidos.conexao();
        
        try {            
            PreparedStatement pst = connPedidos.conn.prepareStatement("update pedido set valor_pago = ? where cod_pedido  = ? ");
            pst.setBigDecimal(1,mod.getValor_pago());            
            pst.setInt(2,mod.getCod_pedido());            
            pst.execute();                         
        } catch (SQLException ex) {            
        }        
        connPedidos.desconecta();
    }
    
    public void ListaPedido (ModeloPedido mod) {
        connPedidos.conexao();
        connPedidos.executaSQL("select "
                                + "cod_pedido,status,forma_pagamento,data_agendada,hora_agendada,obs_pedido,local,troco,desconto,"
                                + "valor_pago,datahora_entrada,datahora_saida,entregador from pedido where cod_pedido = '" + mod.getCod_pedido() + "'");
        
        try {
            connPedidos.rs.first();
            mod.setCod_cliente(connPedidos.rs.getInt("cod_pedido"));
            mod.setStatus(connPedidos.rs.getString("status"));
            mod.setForma_pagamento(connPedidos.rs.getString("forma_pagamento"));
            mod.setData_agendada(connPedidos.rs.getString("data_agendada"));
            mod.setHora_agendada(connPedidos.rs.getString("hora_agendada"));
            mod.setObs_pedido(connPedidos.rs.getString("obs_pedido"));
            mod.setLocal(connPedidos.rs.getString("local"));
            mod.setTroco(connPedidos.rs.getBigDecimal("troco"));
            mod.setDesconto(connPedidos.rs.getBigDecimal("desconto"));
            mod.setValor_pago(connPedidos.rs.getBigDecimal("valor_pago"));
            mod.setDatahora_entrada(connPedidos.rs.getTimestamp("datahora_entrada"));
            mod.setDatahora_saida(connPedidos.rs.getTimestamp("datahora_saida"));
            mod.setEntregador(connPedidos.rs.getString("entregador"));
            
        } catch (SQLException ex) {
            log.gravaErro(ex.toString(), "ControlePedido.ListaPedido");
        }
        connPedidos.desconecta();
    }
    
    public BigDecimal ArredondaValor (Double valor) {        
        BigDecimal arred = new BigDecimal(valor);
        arred = arred.setScale(2, BigDecimal.ROUND_HALF_UP); 
        return arred;
    }  
    
    public BigDecimal ArredondaCusto (Double valor) {        
        BigDecimal arred = new BigDecimal(valor);
        arred = arred.setScale(3, BigDecimal.ROUND_HALF_UP); 
        return arred;
    }  
    
}
