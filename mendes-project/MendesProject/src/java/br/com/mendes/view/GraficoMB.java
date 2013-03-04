package br.com.mendes.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.mendes.dto.ClientesPeriodoDTO;
import br.com.mendes.model.Categoria;
import br.com.mendes.service.CategoriaService;
import br.com.mendes.service.ClienteService;


@Component("graficoMB")
@Scope(value="request")
public class GraficoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CartesianChartModel linearModel;
		
	@Autowired
	private ClienteService clienteService;
	
	@PostConstruct
	public void iniciar() {
		createLinearModel();
	}

	public GraficoMB(){
		
	}
	
	public CartesianChartModel getLinearModel() {
		return linearModel;
	}

	private void createLinearModel() {
		
		//Cria obj Gráfico
		linearModel = new CartesianChartModel();
		
		List<ClientesPeriodoDTO> clientesPorPeriodo = clienteService.obterQtdeClientesPorPeriodo();
				 
		criarLinhaHomens(linearModel, clientesPorPeriodo);
		
	}
	
	private void criarLinhaHomens(CartesianChartModel linearModel, List<ClientesPeriodoDTO> clientesPorPeriodo) {
		//Cria obj que representa uma linha
		
		ChartSeries linhaHomens = new ChartSeries();
				
		//Add descrição para a linha
		linhaHomens.setLabel("Homens");
		
		//Adiciona pontos na linha
		for(ClientesPeriodoDTO dto : clientesPorPeriodo) {			
			String periodo = dto.getMes() + "/" + dto.getAno();
			linhaHomens.set(periodo , dto.getQtde().intValue());		
		}
		
		//Adiciona linha ao Gráfico
		linearModel.addSeries(linhaHomens);
	}
	


}
