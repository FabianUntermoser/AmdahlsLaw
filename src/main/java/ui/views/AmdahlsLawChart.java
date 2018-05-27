package ui.views;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import java.util.Map;

public class AmdahlsLawChart {

    private int maxProcessors;
    private LineChartModel lineChart;

    public AmdahlsLawChart(int maxProcessors) {
        this.maxProcessors = maxProcessors;
        lineChart = createLineModel("Amdahls Law", "Speedup", "Number of Processors");
    }

    public LineChartModel getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChartModel lineChart) {
        this.lineChart = lineChart;
    }

    private LineChartModel createLineModel(String chartTitle, String yAxisTitle, String xAxisTitle) {
        LineChartModel model = new LineChartModel();
        model.setTitle(chartTitle);
        model.setZoom(true);
        model.setLegendPosition("e");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel(yAxisTitle);
        yAxis.setMin(0);

        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel(xAxisTitle);
        xAxis.setMin(0);
        xAxis.setMax(maxProcessors);

        return model;
    }

    public void addChartSeries(String name, Map<Integer, Double> speedupMap) {
        LineChartSeries series = new LineChartSeries();
        series.setLabel(name);
        speedupMap.forEach(series::set);
        lineChart.addSeries(series);
    }

}