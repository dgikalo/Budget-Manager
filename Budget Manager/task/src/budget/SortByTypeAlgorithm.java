package budget;


import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;


public class SortByTypeAlgorithm implements SortSelectionAlgorithm {

    private Map<Type, Float> sort(Map<Type, Float> totalSumByType) {
        return totalSumByType.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (prevValue, newValue) -> prevValue,
                        LinkedHashMap::new
                ))
                .reversed();
    }


    @Override
    public List<String> getSortedList(Map<Type, Float> totalSumByType) {
        List<String> result = new LinkedList<>();

        sort(totalSumByType).forEach((type, price) -> {
            String textTemplate = type.getName() + " - $";

            textTemplate += (price != 0)
                    ? String.format("%.2f", price)
                    : "0";

            result.add(textTemplate);
        });

        return result;
    }
}
