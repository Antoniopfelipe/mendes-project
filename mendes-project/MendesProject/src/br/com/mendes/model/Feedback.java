package br.com.mendes.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro
 */
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFeedback;
    @ManyToOne
    private Long codCliente;
    @OneToOne
    private Long codProduto;
    @OneToOne
    private Long codServico;
    private double nota;
    private String tipoAtendimento;
    private String observa��o;
    @Temporal(TemporalType.DATE)
    private Date dataFeedback;

    public Feedback() {
    }

    public Feedback(Long codFeedback, Long codCliente, Long codProduto, Long codServico, double nota, String tipoAtendimento, String observa��o, Date dataFeedback) {
        this.codFeedback = codFeedback;
        this.codCliente = codCliente;
        this.codProduto = codProduto;
        this.codServico = codServico;
        this.nota = nota;
        this.tipoAtendimento = tipoAtendimento;
        this.observa��o = observa��o;
        this.dataFeedback = dataFeedback;
    }

    public Long getCodFeedback() {
        return codFeedback;
    }

    public void setCodFeedback(Long codFeedback) {
        this.codFeedback = codFeedback;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public Long getCodServico() {
        return codServico;
    }

    public void setCodServico(Long codServico) {
        this.codServico = codServico;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getObserva��o() {
        return observa��o;
    }

    public void setObserva��o(String observa��o) {
        this.observa��o = observa��o;
    }

    public Date getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(Date dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}
