package br.com.mendes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pedro
 */
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;
   
	@ManyToOne(optional = false)
	@JoinColumn(name="ID_CATEGORIA")
    private Categoria categoria;
	
    private String nome;
    
    private Double precoCusto;
    
    private Double precoVenda;
   	
    @ManyToOne(optional = false)
    private Meta meta;

    public Produto() {
    }

    public Produto(Long codProduto, Categoria categoria, String nome, double precoCusto, double precoVenda, Meta meta) {
        this.codProduto = codProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.meta = meta;
    }

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}


