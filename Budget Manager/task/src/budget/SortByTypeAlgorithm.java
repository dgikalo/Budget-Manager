package budget;


import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;


public class SortByCategoryAlgorithm extends SortCertainType implements SortSelectionAlgorithm {

    @Override
    protected List<Purchase> sort(List<Purchase> purchasesList, Type type) {
        return super.sort(purchasesList, type);
    }


    @Override
    public List<String> getSortedList(List<Purchase> purchasesList, Map<Type, Float> totalSumByType) {
        List<String> sortedList = new LinkedList<>();
        Map<Type, Float> sortedMap = new LinkedHashMap<>();

        totalSumByType.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        for (Map.Entry<Type, Float> entry : sortedMap.entrySet()) {
            List<Purchase> tmp = sort(purchasesList, entry.getKey());

            tmp.forEach(purchase -> sortedList.add(String.format("%s $%s", purchase.name(), purchase.price())));
        }

        return sortedList;
    }
}
