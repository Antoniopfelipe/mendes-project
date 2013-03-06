package br.com.mendes.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Pedro
 */
@Entity
@DiscriminatorValue(value = "ESPECIFICA")
public class MetaGeral extends Meta implements Serializable {
   	
	private static final long serialVersionUID = 2019817085394162949L;
	
	private TipoMetaGeral tipo;
   
	public TipoMetaGeral getTipo() {
		return tipo;
	}

	public void setTipo(TipoMetaGeral tipo) {
		this.tipo = tipo;
	}

    
}
