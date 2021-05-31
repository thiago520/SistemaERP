/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.ModeloPedido;

/**
 *
 * @author thiag
 */
public class ModeloItensTable extends AbstractTableModel {
    
    private List<ModeloPedido> dados = new ArrayList<>();    
    private String[] colunas = {"Produto","Observação","Qtda","Custo","Total"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna) {
            case 0:
                return dados.get(linha).getNome_produto();
            case 1:
                return dados.get(linha).getObs_produto();
            case 2:
                return dados.get(linha).getQtda_produto().setScale(3,RoundingMode.UP);
            case 3:
                return dados.get(linha).getValor_un().setScale(2,RoundingMode.UP);
            case 4:                
                return dados.get(linha).getValor_un().multiply(dados.get(linha).getQtda_produto()).setScale(2,RoundingMode.UP);                        
                        
        }
        
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
        switch(coluna) {
            case 0:
                dados.get(linha).setNome_produto((String) valor);
                break;
            case 1:
                dados.get(linha).setObs_produto((String) valor);
                break;
            case 2:
                dados.get(linha).setQtda_produto((BigDecimal) valor);
                break;
            case 3:
                dados.get(linha).setValor_un((BigDecimal) valor);
                break;           
        }
        
        this.fireTableRowsUpdated(linha, linha);        
    }
    
    
    
    public void addRow(ModeloPedido p) {
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);        
    }
    
    public void limpaTabela() {
        int size = getRowCount();
        dados.clear();
        fireTableRowsDeleted(0, size);        
    }
    
}
