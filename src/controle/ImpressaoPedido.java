/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ImpressaoPedido {  
    ConectaBanco conn = new ConectaBanco();
    Impressao impressao = new Impressao();
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();  
    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");    
    String pedido = "";
    Double valorTotal = 0.0;
    Double desconto = 0.0;
    Double saldo = 0.0;
    Double valorPago = 0.0;
    Double troco = 0.0;
    String formaPagamento = "";
    String obs_pedido = "";
    int codCliente = 0;
    

    public void gerarImpressao (int codPedido) {
        
        try {
            conn.conexao();
            conn.executaSQL("select pedido.cod_cliente,pedido.cod_pedido,pedido.local,pedido.data_agendada,pedido.hora_agendada,clientes.nome_cliente,clientes.endereco_cliente,clientes.numero_cliente,clientes.complemento_cliente,clientes.empresa_cliente,clientes.telefone_cliente,clientes.celular_cliente,pedido.valor_total,pedido.desconto,pedido.valor_pago,pedido.troco,pedido.forma_pagamento,pedido.obs_pedido from pedido,clientes where pedido.cod_cliente = clientes.id_cliente and pedido.cod_pedido = '"+ codPedido +"' ");
            
            if(!conn.rs.next()) {
                
            } else {
                conn.rs.first();
                valorTotal = conn.rs.getDouble("valor_total");
                desconto = conn.rs.getDouble("desconto");
                valorPago = conn.rs.getDouble("valor_pago");
                troco = conn.rs.getDouble("troco");
                formaPagamento = conn.rs.getString("forma_pagamento");
                obs_pedido = conn.rs.getString("obs_pedido");
                codCliente = conn.rs.getInt("cod_cliente");                        
                
                pedido = "----------------------------------------\n\r"
                         +"        Sabor Trivial "+" -  "+ conn.rs.getString("local") +"\n\r"
                         +"        "+ formataData.format(conn.rs.getDate("dataEntrada")) +" - "+ conn.rs.getString("horaEntrada") +"\n\r\n\r";
                
                if (conn.rs.getTime("hora_agendada") != null) {
                  pedido +="    ------------------------------\n\r"
                          +"    |          AGENDADO          |\n\r"
                          +"    |   "+ formataData.format(conn.rs.getDate("data_agendada")) +" - "+ conn.rs.getTime("hora_agendada") +"    |\n\r"
                          +"    ------------------------------\n\r";
               }                
                
                pedido += "Pedido: "+ conn.rs.getInt("cod_pedido") +"\n\r"                                               
                         +"Dados do Cliente\n\r"
                         +"Nome: "+ conn.rs.getString("nome_cliente")+"\n\r"
                         +"Endereco: "+ conn.rs.getString("endereco_cliente") +", "+ conn.rs.getInt("numero_cliente")+"\n\r"                       
                         +"Complemento: "+ conn.rs.getString("complemento_cliente")+"\n\r"
                         +"Empresa: "+ conn.rs.getString("empresa_cliente")+"\n\r"
                         +"Tel: "+ conn.rs.getString("telefone_cliente")+"\n\r"
                         +"Celular: "+ conn.rs.getString("celular_cliente")+"\n\r"                                 
                         +"\n\r\n\rItens do Pedido\n\r"
                         +"Qtda   Item                       Preco\n\r";
                
                conn.executaSQL("select itens_pedido.qtda_produto,produtos.nome_produto,itens_pedido.valor_un,itens_pedido.obs_produto from pedido,itens_pedido,produtos where pedido.cod_pedido = itens_pedido.cod_pedido and itens_pedido.cod_produto = produtos.id_produto and itens_pedido.cod_pedido = '"+ codPedido +"' ");
                conn.rs.first();               
                   
                do{
                    pedido += conn.rs.getDouble("qtda_produto")+"   "+ conn.rs.getString("nome_produto")+"            "+ formatoMoeda.format(conn.rs.getDouble("qtda_produto")*conn.rs.getDouble("valor_un"))+"\n\r"
                           +"     "+ conn.rs.getString("obs_produto") +"\n\r";
                }while(conn.rs.next()); 
                
                pedido += "\n\r                   Sub-Total: "+ formatoMoeda.format(valorTotal)+"\n\r";
                pedido += "----------------------------------------\n\r";                
                if (desconto != 0) {
                        pedido += "                    Desconto: "+ formatoMoeda.format(desconto)+"\n\r";
                }       
                
                conn.executaSQL("select SUM(valor_pago)-(SUM(valor_total)-SUM(desconto)) as TOTAL from pedido where status = 'Finalizado' and cod_cliente = " + codCliente + "");                  
                conn.rs.first();
                saldo = conn.rs.getDouble("TOTAL");
                
                if ( saldo != 0 || saldo != -0) {
                    if (saldo < 0) {                        
                        pedido += "                    Debito: "+ formatoMoeda.format(saldo)+"\n\r";
                    } else {                        
                        pedido += "             Saldo anterior: "+ formatoMoeda.format(saldo)+"\n\r";   
                    }                     
                }
                
                if (( valorTotal - saldo - desconto ) < 0) {                    
                       pedido +="                    Credito: "+ formatoMoeda.format( saldo - valorTotal - desconto )+"\n\r";  
                } else {                    
                       pedido +="               Total a pagar: "+ formatoMoeda.format( valorTotal - saldo - desconto )+"\n\r";      
                }                
                
                if ( valorPago != 0) {
                    pedido += "                   Valor Pago: "+ formatoMoeda.format(valorPago)+"\n\r";
                }
                  
                if ( troco != 0) {
                    pedido += "                Troco para: "+ formatoMoeda.format(troco)+"\n\r";
                    pedido += "                Enviar troco: "+ formatoMoeda.format( troco -( valorTotal - saldo - desconto))+"\n\r";                                            
                }
                
                pedido += "\n\rForma de Pagamento\n\r"
                          + formaPagamento +"\n\r\n\r"
                          +"Observacao Pedido\n\r"
                          + obs_pedido +"\n\r\n\r\n\r\n\r\n\r";
                //          + ""+(char)27+(char)109;   
                
                
                
                impressao.detectaImpressoras();
                impressao.imprime(pedido);
                impressao.qrCode();
                impressao.acionarGuilhotina();
            }
          conn.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ImpressaoPedido.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }
}
