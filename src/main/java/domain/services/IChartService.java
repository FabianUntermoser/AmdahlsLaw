package domain.services;

import ui.views.AmdahlsLawChart;
import ui.views.ExampleLineChartView;

public interface IChartService {
    ExampleLineChartView getExampleChart();

    AmdahlsLawChart getAmdahlsLawChart();

    int getMaxProcessors();
}
