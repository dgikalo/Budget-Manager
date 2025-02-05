package budget;


import java.util.LinkedHashMap;
import java.util.Map;

public class PurchaseHandler {
    private static final Map<String, Float> purchasesList = new LinkedHashMap<>();

    public static void addPurchase(String purchaseName, float purchaseCost) {
        purchasesList.put(purchaseName, purchaseCost);

        SystemOperations.printData("Purchase was added!");
    }

    public static void displayPurchasesList() {
        if (purchasesList.isEmpty()) {
            SystemOperations.printData("The purchase list is empty!");
            return;
        }

        for (Map.Entry<String, Float> entry : purchasesList.entrySet()) {
            String printValue = String.format("%s $%.2f\n", entry.getKey(), entry.getValue());

            SystemOperations.printData(printValue);
        }
    }
}
