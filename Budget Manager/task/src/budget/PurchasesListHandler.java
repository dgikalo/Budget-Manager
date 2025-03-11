package budget;


import java.util.List;
import java.util.ArrayList;


public class PurchasesListHandler {

    private static final List<Purchase> purchasesList = new ArrayList<>();


    private static void printPurchasesListMenu() {
        System.out.println("Choose the type of purchases");
        for (Category category : Category.getTypes(true)) {
            System.out.printf("%d) %s\n", category.getId(), category.getName());
        }

        System.out.println("6) Back");
    }


    private static boolean isListIsEmpty(Category category) {
        return (category.equals(Category.ALL))
                ? purchasesList.isEmpty()
                : purchasesList
                        .stream()
                        .noneMatch(purchase -> purchase.category() == category);
    }


    static void updatePurchasesList(Purchase purchase) {
        purchasesList.add(purchase);

        float price = purchase.price();

        TotalSumHandler.updateTotalSum(purchase.category(), price);
    }


    private static void printPurchasesList(Category category) {
        System.out.println(category.getName() + ":");

        if (category.equals(Category.ALL)) {
            purchasesList.forEach(purchase -> System.out.printf("%s $%.2f\n", purchase.name(), purchase.price()));

        } else {
            purchasesList
                    .stream()
                    .filter(purchase -> purchase.category() == category)
                    .forEach(purchase -> System.out.printf("%s $%.2f\n", purchase.name(), purchase.price()));
        }

        System.out.printf("Total sum: $%.2f\n\n", TotalSumHandler.getTotalSum(category));
    }


    static List<Purchase> getPurchasesList() {
        return purchasesList;
    }


    public static void startPurchaseTypesMenu() {
        while (true) {
            if (isListIsEmpty(Category.ALL)) {
                System.out.println("The purchase list is empty!");
                break;
            }

            printPurchasesListMenu();

            int selectedOptionInt = Integer.parseInt(SystemUtility.readData());
            System.out.println();

            if (selectedOptionInt == 6) break;

            Category category = Category.getTypeById(selectedOptionInt);

            switch (category) {
                case FOOD, CLOTHES, ENTERTAINMENT, OTHER -> {
                    if (isListIsEmpty(category)) {
                        System.out.println("The purchase list is empty!");
                        break;
                    }

                    printPurchasesList(category);
                }
                default -> printPurchasesList(Category.ALL);
            }
        }
    }
}
