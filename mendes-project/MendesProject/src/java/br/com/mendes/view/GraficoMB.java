package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.mendes.model.Categoria;
import br.com.mendes.service.CategoriaService;


@Component("graficoMB")
@Scope(value="request")
public class GraficoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CartesianChartModel linearModel;
	private List<Categoria> categorias;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostConstruct
	public void iniciar() {
		//categorias = categoriaService.obterTodasCategorias();
	}

	public GraficoMB(){
		createLinearModel();
	}
	
	public CartesianChartModel getLinearModel() {
		return linearModel;
	}

	private void createLinearModel() {
		linearModel = new CartesianChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Homens");
		
		Categoria cate = new Categoria();
		cate = criarCategoria(cate);
		series1.set(1, cate.getCodCategoria() );
		
	
		linearModel.addSeries(series1);
	}

	public Categoria criarCategoria(Categoria cat){
		 cat = new Categoria();
		cat.setCodCategoria(100L);
		cat.setDescricao("TESTE");
		return cat;
		
	}

}
