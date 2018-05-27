package ui.controller;

import domain.services.IChartService;
import ui.views.AmdahlsLawChart;
import ui.views.ExampleLineChartView;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    @Inject
    private IChartService chartService;

    public ExampleLineChartView getLineChart() {
        return chartService.getExampleChart();
    }

    public AmdahlsLawChart getAmdahlsLawChart() {
        return chartService.getAmdahlsLawChart();
    }

    public int getMaxProcessors() {
        return chartService.getMaxProcessors();
    }

}
