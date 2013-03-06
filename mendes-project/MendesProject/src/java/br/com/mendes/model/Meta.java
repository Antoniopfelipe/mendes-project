package br.com.mendes.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_META", discriminatorType = DiscriminatorType.STRING)
public abstract class Meta implements Serializable {
    
	private static final long serialVersionUID = -6898740632390285434L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codMeta;
            
    private Double valor;
    
    @Temporal(TemporalType.TIMESTAMP)
	private Date data;
    
    public Meta() {
    }

    public Long getCodMeta() {
        return codMeta;
    }

    public void setCodMeta(Long codMeta) {
        this.codMeta = codMeta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
    
    
    
}
