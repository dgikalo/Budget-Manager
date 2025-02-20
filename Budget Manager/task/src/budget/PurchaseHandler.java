package budget;


import java.util.*;


public class PurchaseMenu {

    private static final Map<PurchaseType, Map<String, Float>> purchaseList = new HashMap<>();
    private static final PurchaseType[] purchaseTypes = PurchaseType.getPurchaseTypes();

    static void displayPurchaseTypeMenu() {
        for (PurchaseType type : purchaseTypes) {
            System.out.printf("%d) %s\n", type.getOptionId(), type.getOptionName());
        }

        System.out.println("5) Back");
    }


    private static Map<PurchaseType, Map<String, Float>> getPurchaseList() {
        return purchaseList;
    }


    static boolean isPurchaseListIsEmpty() {
        return getPurchaseList().isEmpty();
    }


    static Map<String, Float> readPurchaseData() {
        System.out.println("Enter purchase name:");
        String purchaseName = SystemOperations.readInputData();

        System.out.println("Enter its price:");
        float purchaseCost = Float.parseFloat(SystemOperations.readInputData());

        return Map.of(purchaseName, purchaseCost);
    }


    /*
    static void processPurchaseTypeMenuOption(PurchaseType purchaseType) {
        switch (purchaseType) {
            case FOOD -> System.out.println("Food");
            case CLOTHES -> System.out.println("Clothes");
            case ENTERTAINMENT -> System.out.println("Entertainment");
            case OTHER -> System.out.println("Other");
        }
    }
     */


    static void updatePurchasesList(PurchaseType type, Map<String, Float> purchaseData) {
        Float tempValue = getPurchaseList().get(type).putIfAbsent(purchaseData.);
    }
}
