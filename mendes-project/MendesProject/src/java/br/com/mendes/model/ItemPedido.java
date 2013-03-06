package br.com.mendes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Pedro
 */
@Entity
public class ItemPedido {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codItemProdutoOrcamento;
    
    @OneToOne
    private Item item;
    
    @OneToOne
    private Pedido pedido;
    
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Long codItemProdutoOrcamento, Item item, Pedido pedido, int quantidade) {
        this.codItemProdutoOrcamento = codItemProdutoOrcamento;
        this.setItem(item);
        this.pedido=pedido;
        this.quantidade = quantidade;
    }

    public Long getCodItemProdutoOrcamento() {
        return codItemProdutoOrcamento;
    }

    public void setCodItemProdutoOrcamento(Long codItemProdutoOrcamento) {
        this.codItemProdutoOrcamento = codItemProdutoOrcamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
    
}

