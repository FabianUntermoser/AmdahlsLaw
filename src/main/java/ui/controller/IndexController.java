package ui.controller;

import org.primefaces.model.chart.LineChartModel;
import ui.views.ExampleLineChartView;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private ExampleLineChartView lineChart;

    public IndexController() {
        lineChart = new ExampleLineChartView();
    }

    public LineChartModel getLineChart() {
        return lineChart.getLineChart();
    }

    public void setLineChart(LineChartModel lineChart) {
        this.lineChart.setLineChart(lineChart);
    }

}
