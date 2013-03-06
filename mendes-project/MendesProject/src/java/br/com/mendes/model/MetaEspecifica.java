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
public class MetaEspecifica extends Meta implements Serializable {
    
	private static final long serialVersionUID = 3618918025061048331L;
	
	private TipoMetaEspecifica tipoMetaEspecifica;
    
   
    public MetaEspecifica() {
    }


	public TipoMetaEspecifica getTipoMetaEspecifica() {
		return tipoMetaEspecifica;
	}


	public void setTipoMetaEspecifica(TipoMetaEspecifica tipoMetaEspecifica) {
		this.tipoMetaEspecifica = tipoMetaEspecifica;
	}
    
}
