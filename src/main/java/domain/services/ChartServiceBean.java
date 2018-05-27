package domain.services;

import domain.util.AmdahlsCalculation;
import domain.util.AmdahlsCalculationCallback;
import org.primefaces.model.chart.LineChartSeries;
import ui.views.AmdahlsLawChart;
import ui.views.ExampleLineChartView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

@Stateless
public class ChartServiceBean implements IChartService, AmdahlsCalculationCallback {

    private static final int MAX_PROCESSORS = 1024;
    private static final double parallizableAmount1 = 1 - 0.3;
    private static final double parallizableAmount2 = 1 - 0.5;
    private static final double parallizableAmount3 = 1 - 0.95;

    @Resource
    private ManagedExecutorService executorService;

    private ExampleLineChartView exampleChart;
    private AmdahlsLawChart amdahlsLawChart;

    @PostConstruct
    public void init() {
        exampleChart = new ExampleLineChartView();
        amdahlsLawChart = new AmdahlsLawChart(MAX_PROCESSORS);

        setupConcurrentAmdahlsLawCalculation("Series 1", parallizableAmount1);
        setupConcurrentAmdahlsLawCalculation("Series 2", parallizableAmount2);
        setupConcurrentAmdahlsLawCalculation("Series 3", parallizableAmount3);
    }

    @Override
    public ExampleLineChartView getExampleChart() {
        return exampleChart;
    }

    @Override
    public AmdahlsLawChart getAmdahlsLawChart() {
        return amdahlsLawChart;
    }

    @Override
    public int getMaxProcessors() {
        return MAX_PROCESSORS;
    }

    private void setupConcurrentAmdahlsLawCalculation(String name, double parallizableAmount) {
        executorService.execute(new AmdahlsCalculation(name, MAX_PROCESSORS, parallizableAmount, this));
    }

    @Override
    public void onCalculationFinished(LineChartSeries series) {
        this.amdahlsLawChart.getLineChart().addSeries(series);
    }
}
