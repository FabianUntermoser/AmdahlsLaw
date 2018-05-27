package ui.views;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

public class AmdahlsLawChart {

    private static final int MAX_PROCESSORS = 1024;

    private LineChartModel lineChart;

    public AmdahlsLawChart() {
        createLineModel();
    }

    public int getMaxProcessors() {
        return MAX_PROCESSORS;
    }

    public LineChartModel getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChartModel lineChart) {
        this.lineChart = lineChart;
    }

    private void createLineModel() {
        lineChart = initLinearModel();
        lineChart.setTitle("Amdahls Law");
        lineChart.setZoom(true);
        lineChart.setLegendPosition("e");
        Axis yAxis = lineChart.getAxis(AxisType.Y);
        yAxis.setLabel("Speedup");

        Axis xAxis = lineChart.getAxis(AxisType.X);
        xAxis.setLabel("Number of Processors");
        xAxis.setMin(0);
        xAxis.setMax(MAX_PROCESSORS);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        LineChartSeries series2 = new LineChartSeries();
        LineChartSeries series3 = new LineChartSeries();

        series1.setLabel("Series 1");
        series2.setLabel("Series 2");
        series3.setLabel("Series 3");

        double f1 = 0.3;
        double f2 = 0.5;
        double f3 = 0.7;
        for (int processors = 0; processors < MAX_PROCESSORS; processors++) {
            series1.set(processors, calcAmdahlsLaw(f1, processors));
            series2.set(processors, calcAmdahlsLaw(f2, processors));
            series3.set(processors, calcAmdahlsLaw(f3, processors));
        }

        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);

        return model;
    }

    private double calcAmdahlsLaw(double parallelizable, int numberOfProcessors) {
        return 1 / (parallelizable + ((1 - parallelizable) / numberOfProcessors));
    }


}
