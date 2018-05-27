package domain.util;

import org.primefaces.model.chart.LineChartSeries;

public interface AmdahlsCalculationCallback {
    void onCalculationFinished(LineChartSeries series);
}
