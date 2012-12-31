package br.com.mendes.view;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.stereotype.Component;

@Component("graficoMB")
@RequestScoped
public class GraficoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CartesianChartModel linearModel;

	public GraficoMB() {
		createLinearModel();
		
	}

	public CartesianChartModel getLinearModel() {
		return linearModel;
	}

	private void createLinearModel() {
		linearModel = new CartesianChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Homens");

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Mulheres");
		series2.setMarkerStyle("diamond");

		series2.set(1, 6);
		series2.set(2, 3);
		series2.set(3, 2);
		series2.set(4, 7);
		series2.set(5, 9);

		LineChartSeries series3 = new LineChartSeries();
		series3.setLabel("Filhos");

		series3.set(1, 3);
		series3.set(2, 5);
		series3.set(3, 3);
		series3.set(4, 8);
		series3.set(5, 8);

		linearModel.addSeries(series1);
		linearModel.addSeries(series2);
		linearModel.addSeries(series3);
	}

}
