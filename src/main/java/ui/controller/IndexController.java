package ui.controller;

import ui.views.AmdahlsLawChart;
import ui.views.ExampleLineChartView;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private ExampleLineChartView lineChart;
    private AmdahlsLawChart amdahlsLawChart;

    public IndexController() {
        lineChart = new ExampleLineChartView();
        amdahlsLawChart = new AmdahlsLawChart();
    }

    public ExampleLineChartView getLineChart() {
        return lineChart;
    }

    public void setLineChart(ExampleLineChartView lineChart) {
        this.lineChart = lineChart;
    }

    public AmdahlsLawChart getAmdahlsLawChart() {
        return amdahlsLawChart;
    }

    public void setAmdahlsLawChart(AmdahlsLawChart amdahlsLawChart) {
        this.amdahlsLawChart = amdahlsLawChart;
    }
}
