package br.com.mendes.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Pedro
 */
@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codOrcamento;
    //@OneToOne
    private Long codCliente;
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Temporal(TemporalType.DATE)
    private Date previsaoEntrega;
    @Transient
    private List<Produto> listaProdutos;
    @Transient
    private List<Servico> listaServicos;
    private double valorTotal;
    private boolean status;

    public Orcamento() {
    }

    public Orcamento(Long codOrcamento, Long codCliente, Date dataEmissao, Date previsaoEntrega, List<Produto> listaProdutos, List<Servico> listaServicos, double valorTotal, boolean status) {
        this.codOrcamento = codOrcamento;
        this.codCliente = codCliente;
        this.dataEmissao = dataEmissao;
        this.previsaoEntrega = previsaoEntrega;
        this.listaProdutos = listaProdutos;
        this.listaServicos = listaServicos;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Long getCodOrcamento() {
        return codOrcamento;
    }

    public void setCodOrcamento(Long codOrcamento) {
        this.codOrcamento = codOrcamento;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
