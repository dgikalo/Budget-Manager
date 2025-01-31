package budget;


import java.util.LinkedHashMap;
import java.util.Map;

public class Purchases {
    private static final Map<String, Float> purchasesList = new LinkedHashMap<>();

    public static void addPurchase(String purchaseName, float purchaseCost) {
        purchasesList.put(purchaseName, purchaseCost);

        System.out.println("Purchase was added!");
    }

    public static void displayPurchasesList() {
        if (purchasesList.isEmpty()) {
            SystemOperations.printData("The purchase list is empty!");
            return;
        }

        for (Map.Entry<String, Float> entry : purchasesList.entrySet()) {
            System.out.printf("%s $%.2f\n", entry.getKey(), entry.getValue());
        }
    }
}
