/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Thiago
 */
public class ModeloProdutos {
    
    private int id_produto;
    private String nome_produto;
    private String gtin_produto;
    private String gtin_embalagem;
    private int estoquema;
    private int estoquemi;
    private String unidade_produto;    
    private Double qtda_caixa;
    private Double preco_venda;
    private int cod_produto;
    private int cod_fornecedor;
    private String data;
    private Double preco_custo;
    private int cod_item;
    private Double qtda_item;
    private String categoria;
    private Double estoque;
    private int BtnAlterar;
    private int BtnAlterarLista;
    private String fantasia_fornecedor;

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
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
     * @return the gtin_produto
     */
    public String getGtin_produto() {
        return gtin_produto;
    }

    /**
     * @param gtin_produto the gtin_produto to set
     */
    public void setGtin_produto(String gtin_produto) {
        this.gtin_produto = gtin_produto;
    }

    /**
     * @return the gtin_embalagem
     */
    public String getGtin_embalagem() {
        return gtin_embalagem;
    }

    /**
     * @param gtin_embalagem the gtin_embalagem to set
     */
    public void setGtin_embalagem(String gtin_embalagem) {
        this.gtin_embalagem = gtin_embalagem;
    }

    /**
     * @return the estoquema
     */
    public int getEstoquema() {
        return estoquema;
    }

    /**
     * @param estoquema the estoquema to set
     */
    public void setEstoquema(int estoquema) {
        this.estoquema = estoquema;
    }

    /**
     * @return the estoquemi
     */
    public int getEstoquemi() {
        return estoquemi;
    }

    /**
     * @param estoquemi the estoquemi to set
     */
    public void setEstoquemi(int estoquemi) {
        this.estoquemi = estoquemi;
    }

    /**
     * @return the unidade_produto
     */
    public String getUnidade_produto() {
        return unidade_produto;
    }

    /**
     * @param unidade_produto the unidade_produto to set
     */
    public void setUnidade_produto(String unidade_produto) {
        this.unidade_produto = unidade_produto;
    }   

    /**
     * @return the qtda_caixa
     */
    public Double getQtda_caixa() {
        return qtda_caixa;
    }

    /**
     * @param qtda_caixa the qtda_caixa to set
     */
    public void setQtda_caixa(Double qtda_caixa) {
        this.qtda_caixa = qtda_caixa;
    }

    /**
     * @return the preco_venda
     */
    public Double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
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
     * @return the cod_fornecedor
     */
    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    /**
     * @param cod_fornecedor the cod_fornecedor to set
     */
    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the preco_custo
     */
    public Double getPreco_custo() {
        return preco_custo;
    }

    /**
     * @param preco_custo the preco_custo to set
     */
    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }

    /**
     * @return the cod_item
     */
    public int getCod_item() {
        return cod_item;
    }

    /**
     * @param cod_item the cod_item to set
     */
    public void setCod_item(int cod_item) {
        this.cod_item = cod_item;
    }

    /**
     * @return the qtda_item
     */
    public Double getQtda_item() {
        return qtda_item;
    }

    /**
     * @param qtda_item the qtda_item to set
     */
    public void setQtda_item(Double qtda_item) {
        this.qtda_item = qtda_item;
    }

    /**
     * @return the BtnAlterar
     */
    public int getBtnAlterar() {
        return BtnAlterar;
    }

    /**
     * @param BtnAlterar the BtnAlterar to set
     */
    public void setBtnAlterar(int BtnAlterar) {
        this.BtnAlterar = BtnAlterar;
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the estoque
     */
    public Double getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the fantasia_fornecedor
     */
    public String getFantasia_fornecedor() {
        return fantasia_fornecedor;
    }

    /**
     * @param fantasia_fornecedor the fantasia_fornecedor to set
     */
    public void setFantasia_fornecedor(String fantasia_fornecedor) {
        this.fantasia_fornecedor = fantasia_fornecedor;
    }
   
    
}
