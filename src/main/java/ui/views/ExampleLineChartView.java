package ui.views;

import org.primefaces.model.chart.*;

public class ExampleLineChartView {

    private LineChartModel lineChart;

    public ExampleLineChartView() {
        createLineModel();
    }

    public LineChartModel getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChartModel lineChart) {
        this.lineChart = lineChart;
    }

    private void createLineModel() {
        lineChart = initLinearModel();
        lineChart.setTitle("Linear Chart");
        lineChart.setLegendPosition("e");
        Axis yAxis = lineChart.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }
}
