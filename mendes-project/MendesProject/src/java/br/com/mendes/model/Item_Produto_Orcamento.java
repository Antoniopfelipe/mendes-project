package br.com.mendes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Pedro
 */
@Entity
public class Item_Produto_Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codItemProdutoOrcamento;
    //@OneToOne
    private Long codProduto;
    //@ManyToOne
    private Long codOrcamento;
    private int quantidade;

    public Item_Produto_Orcamento() {
    }

    public Item_Produto_Orcamento(Long codItemProdutoOrcamento, Long codProduto, Long codOrcamento, int quantidade) {
        this.codItemProdutoOrcamento = codItemProdutoOrcamento;
        this.codProduto = codProduto;
        this.codOrcamento = codOrcamento;
        this.quantidade = quantidade;
    }

    public Long getCodItemProdutoOrcamento() {
        return codItemProdutoOrcamento;
    }

    public void setCodItemProdutoOrcamento(Long codItemProdutoOrcamento) {
        this.codItemProdutoOrcamento = codItemProdutoOrcamento;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public Long getCodOrcamento() {
        return codOrcamento;
    }

    public void setCodOrcamento(Long codOrcamento) {
        this.codOrcamento = codOrcamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}

