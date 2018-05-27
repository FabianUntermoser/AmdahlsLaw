package domain.util;

import java.util.HashMap;
import java.util.Map;

public class AmdahlsCalculation implements Runnable {

    private String seriesName;
    private int maxProcessors;
    private double parallizableAmount;
    private Map<Integer, Double> speedupMap;
    private AmdahlsCalculationCallback callback;

    public AmdahlsCalculation(String seriesName, int maxProcessors, double parallizableAmount, AmdahlsCalculationCallback callback) {
        this.seriesName = seriesName;
        this.maxProcessors = maxProcessors;
        this.parallizableAmount = parallizableAmount;
        this.speedupMap = new HashMap<>();
        this.callback = callback;
    }

    @Override
    public void run() {
        for (int processors = 0; processors < maxProcessors*10; processors++) {
            speedupMap.put(processors, calcAmdahlsLaw(parallizableAmount, processors));
        }
        callback.onCalculationFinished(seriesName, speedupMap);
    }

    private double calcAmdahlsLaw(double parallelizable, int numberOfProcessors) {
        return 1 / (parallelizable + ((1 - parallelizable) / numberOfProcessors));
    }
}
