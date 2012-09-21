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
public class ItemServicoOrcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codItemServicoOrcamento;
    //@OneToOne
    private Long codServico;
    //@ManyToOne
    private Long codOrcamento;

    public ItemServicoOrcamento() {
    }

    public ItemServicoOrcamento(Long codItemServicoOrcamento, Long codServico, Long codOrcamento) {
        this.codItemServicoOrcamento = codItemServicoOrcamento;
        this.codServico = codServico;
        this.codOrcamento = codOrcamento;
    }

    public Long getCodItemServicoOrcamento() {
        return codItemServicoOrcamento;
    }

    public void setCodItemServicoOrcamento(Long codItemServicoOrcamento) {
        this.codItemServicoOrcamento = codItemServicoOrcamento;
    }

    public Long getCodServico() {
        return codServico;
    }

    public void setCodServico(Long codServico) {
        this.codServico = codServico;
    }

    public Long getCodOrcamento() {
        return codOrcamento;
    }

    public void setCodOrcamento(Long codOrcamento) {
        this.codOrcamento = codOrcamento;
    }
    
    
}
