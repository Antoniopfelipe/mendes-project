package br.com.mendes.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pedro
 */
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEvento;
    private String nome;
    private String descricao;
    //@OneToOne
    private Long codEndereco;
    //@OneToOne
    private Long codProduto;
    
    private Calendar data_evento;
    
    public Evento() {
    }

    public Evento(Long codEvento, String nome, String descricao, Long codEndereco, Long codProduto, Calendar data_evento) {
        this.codEvento = codEvento;
        this.nome = nome;
        this.descricao = descricao;
        this.codEndereco = codEndereco;
        this.codProduto = codProduto;
        this.data_evento = data_evento;
    }

    public Long getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(Long codEvento) {
        this.codEvento = codEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public Calendar getData_evento() {
        return data_evento;
    }

    public void setData_evento(Calendar data_evento) {
        this.data_evento = data_evento;
    }
}

