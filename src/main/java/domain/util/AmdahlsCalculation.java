package domain.util;

import org.primefaces.model.chart.LineChartSeries;

public class AmdahlsCalculation implements Runnable {

    private String seriesName;
    private int maxProcessors;
    private double parallizableAmount;
    private AmdahlsCalculationCallback callback;

    public AmdahlsCalculation(String seriesName, int maxProcessors, double parallizableAmount, AmdahlsCalculationCallback callback) {
        this.seriesName = seriesName;
        this.maxProcessors = maxProcessors;
        this.parallizableAmount = parallizableAmount;
        this.callback = callback;
    }

    @Override
    public void run() {
        System.out.println("calculating " + seriesName + " in Thread " + Thread.currentThread().getName());

        LineChartSeries series = new LineChartSeries();
        series.setLabel(seriesName);
        for (int processors = 0; processors < maxProcessors; processors++) {
            series.set(processors, calcAmdahlsLaw(parallizableAmount, processors));
        }

        callback.onCalculationFinished(series);
    }

    private double calcAmdahlsLaw(double parallelizable, int numberOfProcessors) {
        return 1 / (parallelizable + ((1 - parallelizable) / numberOfProcessors));
    }
}
