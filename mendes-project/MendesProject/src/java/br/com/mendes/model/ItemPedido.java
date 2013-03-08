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
    private Long cod;
    
    @OneToOne
    private Item item;
    
    @OneToOne
    private Pedido pedido;
    
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Long cod, Item item, Pedido pedido, int quantidade) {
        this.cod=cod;
        this.item=item;
        this.pedido=pedido;
        this.quantidade = quantidade;
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

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}
    
    
}

