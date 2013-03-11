package br.com.mendes.dto;

import java.io.Serializable;

public class QtdePeriodoDTO implements Serializable{

	private static final long serialVersionUID = 7054586594614000311L;
	
	private Long qtde;
	private Integer mes;
	private Integer ano;
	
	public QtdePeriodoDTO() {
		
	}
	
	public QtdePeriodoDTO(Long qtde, Integer mes, Integer ano) {
		super();
		this.qtde = qtde;
		this.mes = mes;
		this.ano = ano;
	}
	public Long getQtde() {
		return qtde;
	}
	public void setQtde(Long qtde) {
		this.qtde = qtde;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
