package budget;


import java.util.Map;
import java.util.LinkedHashMap;


public class TotalSumUtility {

    private static final Map<PurchaseCategory, Float> totalSumByCategory = new LinkedHashMap<>();


    static {
        for (PurchaseCategory category : PurchaseCategory.getTypes(false)) {
            totalSumByCategory.put(category, 0F);
        }
    }


    static float getTotalSum(PurchaseCategory category) {
        return (!category.equals(PurchaseCategory.ALL))
                ? totalSumByCategory.get(category)
                : totalSumByCategory
                        .values()
                        .stream()
                        .reduce(0.0F, Float::sum);
    }


    static void updateTotalSum(PurchaseCategory category, float price) {
        totalSumByCategory.merge(category, price, Float::sum);
    }
}
