package budget;


import java.util.Map;
import java.util.HashMap;


public class TotalSumHandler {

    private static final Map<Type, Float> totalSum = new HashMap<>();


    static {
        for (Type type : Type.getTypes(true)) {
            totalSum.put(type, 0F);
        }
    }


    public static void updateTotalSum(Type type, float price) {
        totalSum.merge(type, price, Float::sum);
        totalSum.replace(Type.ALL, calculateTotalSum());
    }


    public static Map<Type, Float> getTotalSum(Type type) {
        return Map.of(type, totalSum.get(type));
    }


    private static float calculateTotalSum() {
        return totalSum.entrySet().stream()
                .filter(entry -> entry.getKey() != Type.ALL)
                .map(Map.Entry::getValue)
                .reduce(0.0F, Float::sum);
    }
}
