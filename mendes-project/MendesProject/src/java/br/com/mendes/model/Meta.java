package br.com.mendes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Pedro
 */
@Entity
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codMeta;
    
    private String descricao;
    
    private int periodo;
    
    private double valor;
    
    @OneToMany(mappedBy = "meta")
	private List<Produto> produtos;
    
    public Meta() {
    }

    public Meta(Long codMeta, String descricao, int periodo, double valor) {
        this.codMeta = codMeta;
        this.descricao = descricao;
        this.periodo = periodo;
        this.valor = valor;
    }

    public Long getCodMeta() {
        return codMeta;
    }

    public void setCodMeta(Long codMeta) {
        this.codMeta = codMeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    
    
    
}
