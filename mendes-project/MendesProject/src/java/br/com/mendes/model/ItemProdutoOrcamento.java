package br.com.mendes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Pedro
 */
@Entity
public class ItemProdutoOrcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codItemProdutoOrcamento;
    //@OneToOne
    private Long codProduto;
    
    @OneToOne
	@JoinColumn(name="ORCAMENTO_COD")
    private Orcamento orcamento;
    private int quantidade;

    public ItemProdutoOrcamento() {
    }

    public ItemProdutoOrcamento(Long codItemProdutoOrcamento, Long codProduto, Orcamento orcamento, int quantidade) {
        this.codItemProdutoOrcamento = codItemProdutoOrcamento;
        this.codProduto = codProduto;
        this.orcamento = orcamento;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
    
    
}

