package budget;


import java.util.List;
import java.util.LinkedList;


public class SortCertainType implements SortSelectionAlgorithm {

    protected List<Purchase> sort(List<Purchase> purchasesList, Type type) {
        return purchasesList.stream()
                .filter(purchase -> type.equals(purchase.type()))
                .sorted((p1, p2) -> Float.compare(p1.price(), p2.price()))
                .toList()
                .reversed();
    }


    @Override
    public List<String> getSortedList(List<Purchase> purchasesList, Type type) {
        List<String> sortedList = new LinkedList<>();

        sort(purchasesList, type).forEach(purchase -> {
            sortedList.add(String.format(String.format("%s $%.2f", purchase.name(), purchase.price())));
        });

        return sortedList;
    }
}
