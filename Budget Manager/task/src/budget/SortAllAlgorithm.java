package budget;


import java.util.List;
import java.util.LinkedList;


class SortAllAlgorithm implements SortSelectionAlgorithm {

    private List<Purchase> sort(List<Purchase> purchasesList) {
        return purchasesList.stream()
                .sorted((p1, p2) -> Float.compare(p1.price(), p2.price()))
                .toList()
                .reversed();
    }


    @Override
    public List<String> getSortedList(List<Purchase> purchasesList) {
        List<String> sortedList = new LinkedList<>();

        sort(purchasesList).forEach(purchase -> {
            sortedList.add(String.format("%s $%.2f", purchase.name(), purchase.price()));
        });

        return sortedList;
    }
}