package budget;


import java.util.Map;
import java.util.List;
import java.util.LinkedList;


public interface SortSelectionAlgorithm {

    default List<String> getSortedList(List<Purchase> purchasesList) {
        return new LinkedList<>();
    }

    default List<String> getSortedList(List<Purchase> purchasesList, Type type) {
        return new LinkedList<>();
    }

    default List<String> getSortedList(Map<Type, Float> totalSumByType) {
        return new LinkedList<>();
    }
}
