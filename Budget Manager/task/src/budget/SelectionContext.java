package budget;


import java.util.List;
import java.util.Map;


public class SelectionContext {

    private SortSelectionAlgorithm algorithm;


    public void setAlgorithm(SortSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }


    public List<String> sortPurchasesList(List<Purchase> purchasesList) {
        return algorithm.getSortedList(purchasesList);
    }


    public List<String> sortPurchasesList(Map<Type, Float> totalSumByType) {
        return algorithm.getSortedList(totalSumByType);
    }
}
