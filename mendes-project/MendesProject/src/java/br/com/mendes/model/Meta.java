package br.com.mendes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    
}
