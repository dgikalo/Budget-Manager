package budget;


import java.util.Map;
import java.util.HashMap;


public class TotalSumHandler {

    private static final Map<Category, Float> totalSumByCategory = new HashMap<>();


    static {
        for (Category category : Category.getTypes(false)) {
            totalSumByCategory.put(category, 0F);
        }
    }


    static float getTotalSum(Category category) {
        return (!category.equals(Category.ALL))
                ? totalSumByCategory.get(category)
                : totalSumByCategory
                        .values()
                        .stream()
                        .reduce(0.0F, Float::sum);
    }


    static void updateTotalSum(Category category, float price) {
        totalSumByCategory.merge(category, price, Float::sum);
    }
}
