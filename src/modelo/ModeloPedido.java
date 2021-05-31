/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author thiag
 */
public class ModeloPedido {           
   
    private int cod_pedido;
    private int cod_cliente;
    private String status;
    private String forma_pagamento;
    private BigDecimal desconto;
    private BigDecimal valor_pago;
    private String data_agendada;
    private String hora_agendada;
    private String obs_pedido;
    private BigDecimal saldo;
    private int cod_produto;
    private BigDecimal qtda_produto;
    private BigDecimal valor_un;
    private String local;
    private int cod_itensPedido;
    private BigDecimal troco;
    private BigDecimal valor_total;    
    private int BtnAlterarLista;
    private String obs_produto;
    private int PgtTotal;
    private BigDecimal ctrlEstoque; 
    private Timestamp datahora_saida;
    private Timestamp datahora_entrada;
    private String entregador;
    private String nome_produto;
    
     /**
     * @return the ctrlEstoque
     */
    public BigDecimal getCtrlEstoque() {
        return ctrlEstoque;
    }

    /**
     * @param ctrlEstoque the ctrlEstoque to set
     */
    public void setCtrlEstoque(BigDecimal ctrlEstoque) {
        this.ctrlEstoque = ctrlEstoque;
    }
    
    /**
     * @return the valor_total
     */
    public BigDecimal getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }  

    
    /**
     * @return the PgtTotal
     */
    public int getPgtTotal() {
        return PgtTotal;
    }

    /**
     * @param PgtTotal the PgtTotal to set
     */
    public void setPgtTotal(int PgtTotal) {
        this.PgtTotal = PgtTotal;
    }
    
    /**
     * @return the obs_produto
     */
    public String getObs_produto() {
        return obs_produto;
    }

    /**
     * @param obs_produto the obs_produto to set
     */
    public void setObs_produto(String obs_produto) {
        this.obs_produto = obs_produto;
    }
    
    /**
     * @return the BtnAlterarLista
     */
    public int getBtnAlterarLista() {
        return BtnAlterarLista;
    }

    /**
     * @param BtnAlterarLista the BtnAlterarLista to set
     */
    public void setBtnAlterarLista(int BtnAlterarLista) {
        this.BtnAlterarLista = BtnAlterarLista;
    }

    /**
     * @return the cod_itensPedido
     */
    public int getCod_itensPedido() {
        return cod_itensPedido;
    }

    /**
     * @param cod_itensPedido the cod_itensPedido to set
     */
    public void setCod_itensPedido(int cod_itensPedido) {
        this.cod_itensPedido = cod_itensPedido;
    }

    /**
     * @return the troco
     */
    public BigDecimal getTroco() {
        return troco;
    }

    /**
     * @param troco the troco to set
     */
    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }
    
    /**
     * @return the cod_pedido
     */
    public int getCod_pedido() {
        return cod_pedido;
    }

    /**
     * @param cod_pedido the cod_pedido to set
     */
    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    /**
     * @return the cod_cliente
     */
    public int getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the forma_pagamento
     */
    public String getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * @param forma_pagamento the forma_pagamento to set
     */
    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    /**
     * @return the desconto
     */
    public BigDecimal getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the valor_pago
     */
    public BigDecimal getValor_pago() {
        return valor_pago;
    }

    /**
     * @param valor_pago the valor_pago to set
     */
    public void setValor_pago(BigDecimal valor_pago) {
        this.valor_pago = valor_pago;
    }

    /**
     * @return the data_agendada
     */
    public String getData_agendada() {
        return data_agendada;
    }

    /**
     * @param data_agendada the data_agendada to set
     */
    public void setData_agendada(String data_agendada) {
        this.data_agendada = data_agendada;
    }

    /**
     * @return the hora_agendada
     */
    public String getHora_agendada() {
        return hora_agendada;
    }

    /**
     * @param hora_agendada the hora_agendada to set
     */
    public void setHora_agendada(String hora_agendada) {
        this.hora_agendada = hora_agendada;
    }

    /**
     * @return the obs_pedido
     */
    public String getObs_pedido() {
        return obs_pedido;
    }

    /**
     * @param obs_pedido the obs_pedido to set
     */
    public void setObs_pedido(String obs_pedido) {
        this.obs_pedido = obs_pedido;
    }

    /**
     * @return the saldo
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the cod_produto
     */
    public int getCod_produto() {
        return cod_produto;
    }

    /**
     * @param cod_produto the cod_produto to set
     */
    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    /**
     * @return the qtda_produto
     */
    public BigDecimal getQtda_produto() {
        return qtda_produto;
    }

    /**
     * @param qtda_produto the qtda_produto to set
     */
    public void setQtda_produto(BigDecimal qtda_produto) {
        this.qtda_produto = qtda_produto;
    }

    /**
     * @return the valor_un
     */
    public BigDecimal getValor_un() {
        return valor_un;
    }

    /**
     * @param valor_un the valor_un to set
     */
    public void setValor_un(BigDecimal valor_un) {
        this.valor_un = valor_un;
    }  
    
    /**
     * @return the datahora_saida
     */
    public Timestamp getDatahora_saida() {
        return datahora_saida;
    }

    /**
     * @param datahora_saida the datahora_saida to set
     */
    public void setDatahora_saida(Timestamp datahora_saida) {
        this.datahora_saida = datahora_saida;
    }

    /**
     * @return the entregador
     */
    public String getEntregador() {
        return entregador;
    }

    /**
     * @param entregador the entregador to set
     */
    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }
    
    /**
     * @return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
    
     /**
     * @return the datahora_entrada
     */
    public Timestamp getDatahora_entrada() {
        return datahora_entrada;
    }

    /**
     * @param datahora_entrada the datahora_entrada to set
     */
    public void setDatahora_entrada(Timestamp datahora_entrada) {
        this.datahora_entrada = datahora_entrada;
    }
      
    
}
