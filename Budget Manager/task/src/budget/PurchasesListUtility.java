package budget;

import java.util.HashMap;
import java.util.Map;

public class PurchasesListHandler {

    private static final Map<String, Float> foodPurchasesTypeList = new HashMap<>();
    private static final Map<String, Float> clothesPurchasesTypeList = new HashMap<>();
    private static final Map<String, Float> entertainmentPurchasesTypeList = new HashMap<>();
    private static final Map<String, Float> otherPurchasesTypeList = new HashMap<>();


    private static void printPurchasesListMenu() {
        String purchasesTypeList = """
                Choose the type of purchases
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) All
                6) Back""";

        SystemOperations.printData(purchasesTypeList);
    }


    private static boolean isPurchaseListIsEmpty(PurchaseType type) {
        boolean isPurchasesListIsEmpty;

        switch (type) {
            case FOOD -> isPurchasesListIsEmpty = foodPurchasesTypeList.isEmpty();
            case CLOTHES -> isPurchasesListIsEmpty = clothesPurchasesTypeList.isEmpty();
            case ENTERTAINMENT -> isPurchasesListIsEmpty = entertainmentPurchasesTypeList.isEmpty();
            case OTHER -> isPurchasesListIsEmpty = otherPurchasesTypeList.isEmpty();
            default -> isPurchasesListIsEmpty = foodPurchasesTypeList.isEmpty() &&
                                                clothesPurchasesTypeList.isEmpty() &&
                                                entertainmentPurchasesTypeList.isEmpty() &&
                                                otherPurchasesTypeList.isEmpty();
        }

        return isPurchasesListIsEmpty;
    }


    static void updatePurchasesList(Purchase purchase) {
        PurchaseType purchaseType = purchase.getPurchaseType();
        String purchaseName = purchase.getPurchaseName();
        float purchaseCost = purchase.getPurchaseCost();

        switch (purchaseType) {
            case FOOD -> foodPurchasesTypeList.put(purchaseName, purchaseCost);
            case CLOTHES -> clothesPurchasesTypeList.put(purchaseName, purchaseCost);
            case ENTERTAINMENT -> entertainmentPurchasesTypeList.put(purchaseName, purchaseCost);
            case OTHER -> otherPurchasesTypeList.put(purchaseName, purchaseCost);
        }

        Balance.updateBalance(-purchaseCost);
    }


    private static void printPurchasesList(PurchaseType type) {
        float totalSum = 0F;
        Map<String, Float> requestedList = new HashMap<>();

        switch (type) {
            case FOOD -> requestedList.putAll(foodPurchasesTypeList);
            case CLOTHES -> requestedList.putAll(clothesPurchasesTypeList);
            case ENTERTAINMENT -> requestedList.putAll(entertainmentPurchasesTypeList);
            case OTHER -> requestedList.putAll(otherPurchasesTypeList);
            case ALL -> {
                requestedList.putAll(foodPurchasesTypeList);
                requestedList.putAll(clothesPurchasesTypeList);
                requestedList.putAll(entertainmentPurchasesTypeList);
                requestedList.putAll(otherPurchasesTypeList);
            }
        }

        for (Map.Entry<String, Float> purchases : requestedList.entrySet()) {
            float purchaseCost = purchases.getValue();

            SystemOperations.printData(String.format("%s $%.2f", purchases.getKey(), purchaseCost));

            totalSum += purchaseCost;
        }

        SystemOperations.printData(String.format("Total sum: $%.2f", totalSum));
        System.out.println();
    }


    public static void runPurchaseTypesMenu() {
        if (isPurchaseListIsEmpty(PurchaseType.ALL)) {
            printErrorMessage();

            return;
        }

        while (true) {
            printPurchasesListMenu();

            int selectedOptionInt = Integer.parseInt(SystemOperations.readData());
            System.out.println();

            if (selectedOptionInt == 6) break;

            PurchaseType type = PurchaseType.getPurchaseTypeById(selectedOptionInt);

            SystemOperations.printData(type.getOptionName() + ":");

            switch (type) {
                case ALL -> printPurchasesList(type);
                case FOOD, CLOTHES, ENTERTAINMENT, OTHER -> {
                    if (isPurchaseListIsEmpty(type)) {
                        printErrorMessage();
                    } else {
                        printPurchasesList(type);
                    }
                }
            }
        }
    }


    private static void printErrorMessage() {
        SystemOperations.printData("The purchase list is empty!");
        System.out.println();
    }
}
