package data.repositories;

import ui.views.AmdahlsLawChart;

public class ChartRepository {

    private static AmdahlsLawChart amdahlsLawChart;

    public static AmdahlsLawChart getAmdahlsLawChart() {
        return amdahlsLawChart;
    }

    public static void setAmdahlsLawChart(AmdahlsLawChart amdahlsLawChart) {
        ChartRepository.amdahlsLawChart = amdahlsLawChart;
    }
}