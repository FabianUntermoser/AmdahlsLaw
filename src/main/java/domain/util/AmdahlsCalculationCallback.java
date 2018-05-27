package domain.util;

import java.util.Map;

public interface AmdahlsCalculationCallback {
    void onCalculationFinished(
            String name,
            Map<Integer, Double> speedupMap
    );
}
