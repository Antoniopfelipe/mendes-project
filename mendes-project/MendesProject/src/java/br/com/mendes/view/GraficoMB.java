package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.mendes.dto.ClientesPeriodoDTO;
import br.com.mendes.service.ClienteService;


@Component("graficoMB")
@Scope(value="request")
public class GraficoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CartesianChartModel linearModel;
		
	@Autowired
	private ClienteService clienteService;
	
	private Integer maxY;
	
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
				
		List<ClientesPeriodoDTO> clientesPorPeriodo = clienteService.obterQtdeClientesPorPeriodo();
		
		if(clientesPorPeriodo.isEmpty())
			return;
				
		//Cria obj Gráfico
		linearModel = new CartesianChartModel();
						
		criarLinhaHomens(linearModel, clientesPorPeriodo);
		
	}
	
	private void criarLinhaHomens(CartesianChartModel linearModel, List<ClientesPeriodoDTO> clientesPorPeriodo) {
		
		//Cria obj que representa uma linha		
		ChartSeries linhaHomens = new ChartSeries();
				
		//Add descrição para a linha
		linhaHomens.setLabel("Clientes");
		
		maxY = 0;
		
		//Adiciona pontos na linha
		for(ClientesPeriodoDTO dto : clientesPorPeriodo) {			
			
			if(maxY < dto.getQtde().intValue()) {
				maxY = dto.getQtde().intValue();
			}
			
			String periodo = dto.getMes() + "/" + dto.getAno();
			linhaHomens.set(periodo , dto.getQtde().intValue());		
		}
		
		//MaxY divisivel por 6 para indice não ficar com decimal quebrado
		maxY = (maxY+6) - ( maxY % 6);
		
		//Adiciona linha ao Gráfico
		linearModel.addSeries(linhaHomens);
	}

	public Integer getMaxY() {
		return maxY;
	}

	public void setMaxY(Integer maxY) {
		this.maxY = maxY;
	}
	

	
}
