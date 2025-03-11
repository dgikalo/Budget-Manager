package budget;


import java.util.ArrayList;
import java.util.List;


public class PurchasesListUtility {

    private static final List<Purchase> purchasesList = new ArrayList<>();


    private static void printPurchasesListMenu() {
        System.out.println("Choose the type of purchases");
        for (PurchaseCategory category : PurchaseCategory.getTypes(true)) {
            System.out.printf("%d) %s\n", category.getId(), category.getName());
        }

        System.out.println("6) Back");
    }


    private static boolean isListIsEmpty(PurchaseCategory category) {
        return (category.equals(PurchaseCategory.ALL))
                ? purchasesList.isEmpty()
                : purchasesList
                        .stream()
                        .noneMatch(purchase -> purchase.category() == category);
    }


    static void updatePurchasesList(Purchase purchase) {
        purchasesList.add(purchase);

        float price = purchase.price();

        BalanceUtility.updateBalance(-price);
        TotalSumUtility.updateTotalSum(purchase.category(), price);
    }


    private static void printPurchasesList(PurchaseCategory category) {
        System.out.println(category.getName() + ":");

        if (category.equals(PurchaseCategory.ALL)) {
            purchasesList.forEach(purchase -> System.out.printf("%s $%.2f\n", purchase.name(), purchase.price()));

        } else {
            purchasesList
                    .stream()
                    .filter(purchase -> purchase.category() == category)
                    .forEach(purchase -> System.out.printf("%s $%.2f\n", purchase.name(), purchase.price()));
        }

        System.out.printf("Total sum: $%.2f\n", TotalSumUtility.getTotalSum(category));
    }


    static List<Purchase> getPurchasesList() {
        return purchasesList;
    }


    public static void startPurchaseTypesMenu() {
        while (true) {
            if (isListIsEmpty(PurchaseCategory.ALL)) {
                System.out.println("The purchase list is empty!");
                break;
            }

            printPurchasesListMenu();

            int selectedOptionInt = Integer.parseInt(SystemUtility.readData());

            if (selectedOptionInt == 6) break;

            PurchaseCategory category = PurchaseCategory.getTypeById(selectedOptionInt);

            switch (category) {
                case FOOD, CLOTHES, ENTERTAINMENT, OTHER -> {
                    if (isListIsEmpty(category)) {
                        System.out.println("Purchase list is empty!");
                        break;
                    }

                    printPurchasesList(category);
                }
                default -> printPurchasesList(PurchaseCategory.ALL);
            }
        }
    }
}
