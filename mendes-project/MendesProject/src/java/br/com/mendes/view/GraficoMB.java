package br.com.mendes.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.mendes.dto.QtdePeriodoDTO;
import br.com.mendes.model.TipoMetaGeral;
import br.com.mendes.service.ClienteService;
import br.com.mendes.service.MetaService;


@Component("graficoMB")
@Scope(value="request")
public class GraficoMB implements Serializable {

	private static final long serialVersionUID = -2610583250767977035L;

	private CartesianChartModel painelGrafico;
		
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MetaService metaService;
	
	private Integer qtdePeriodos = 6;
	
	private Integer maxY;
	
	@PostConstruct
	public void iniciar() {
	}

	public String carregarGraficoCliente() {
		
		inicializarPainelGrafico();		
		
		Date dataInicial = getDataInicial();

		List<QtdePeriodoDTO> periodos = gerarPeriodos();
		
		criarLinhaQtdeClientes(dataInicial, periodos);
		criarLinhaMetaClientes(dataInicial, periodos);
		
		tratarAlturaDoGrafico();
		
		return "/paginas/graficoClientesConquistados.xhtml";
	}

	
	private List<QtdePeriodoDTO> gerarPeriodos() {
		
		List<QtdePeriodoDTO> periodos = new ArrayList<QtdePeriodoDTO>();
		
		Calendar cal = new GregorianCalendar();
		Integer ano = cal.get(Calendar.YEAR);
		Integer mes = cal.get(Calendar.MONTH);
		mes++;
		
		
		for(int i=0; i<qtdePeriodos; i++) {
			
			periodos.add(0,new QtdePeriodoDTO(0L,mes,ano));
			
			if(mes.equals(1)) {
				mes=12;
				ano--;
			} else {
				mes--;
			}					
		}
		
		return periodos;		
	}


	public Date getDataInicial() {
		
		Calendar cal = new GregorianCalendar();
		
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		
		cal.add(Calendar.MONTH, ((qtdePeriodos-1) *-1));
				
		return cal.getTime();
		
	}
	
	private void tratarAlturaDoGrafico() {
		maxY = (maxY+6) - ( maxY % 6);		
	}


	private void inicializarPainelGrafico() {

		painelGrafico = new CartesianChartModel();		
		maxY = 0;
		
	}


	private void criarLinhaQtdeClientes(Date dataInicial, List<QtdePeriodoDTO> periodos) {
		
		for(QtdePeriodoDTO periodo : periodos) {
			Long qtde = clienteService.obterQtdeClientesNoAnoMes(periodo.getAno(), periodo.getMes());
			periodo.setQtde(qtde);
		}
				
		gerarLinha("Clientes", periodos);
	}

	private void criarLinhaMetaClientes(Date dataInicial, List<QtdePeriodoDTO> periodos) {
		
		for(QtdePeriodoDTO periodo : periodos) {
			Long qtde = metaService.obterMetaGeralNoAnoMes(TipoMetaGeral.CLIENTE, periodo.getAno(), periodo.getMes());
			periodo.setQtde(qtde);
		}
		
		gerarLinha("Metas", periodos);		
	}

	public GraficoMB(){
		
	}
	
	public CartesianChartModel getLinearModel() {
		return painelGrafico;
	}

	private void gerarLinha(String nomeLinha, List<QtdePeriodoDTO> qtdePeriodo) {
		
		ChartSeries novaLinha = new ChartSeries();
				
		novaLinha.setLabel(nomeLinha);
				
		for(QtdePeriodoDTO dto : qtdePeriodo) {			
			
			if(maxY < dto.getQtde().intValue()) {
				maxY = dto.getQtde().intValue();
			}
			
			String periodo = dto.getMes() + "/" + dto.getAno();
			novaLinha.set(periodo , dto.getQtde().intValue());		
		}
		
		zerarPeriodos(qtdePeriodo);
		
		painelGrafico.addSeries(novaLinha);
	}

	private void zerarPeriodos(List<QtdePeriodoDTO> periodos) {

		for(QtdePeriodoDTO periodo : periodos) {
			periodo.setQtde(0L);
		}
		
	}


	public Integer getMaxY() {
		return maxY;
	}

	public void setMaxY(Integer maxY) {
		this.maxY = maxY;
	}


	public Integer getQtdePeriodos() {
		return qtdePeriodos;
	}


	public void setQtdePeriodos(Integer qtdePeriodos) {
		this.qtdePeriodos = qtdePeriodos;
	}
	

	
}
