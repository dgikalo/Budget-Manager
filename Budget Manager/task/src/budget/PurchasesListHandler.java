package budget;


import java.util.List;
import java.util.LinkedList;


public class PurchasesListHandler {

    private static final List<Purchase> purchasesList = new LinkedList<>();


    private static void printPurchasesListMenu() {
        List<String> purchasesListOptions = new LinkedList<>();
        purchasesListOptions.add("Choose the type of purchases");

        for (Type type : Type.getTypes(true)) {
            purchasesListOptions.add(String.format("%d) %s", type.getId(), type.getName()));
        }

        purchasesListOptions.add("6) Back");

        IODataHandler.printData(purchasesListOptions);
    }


    public static boolean isListIsEmpty(Type type) {
        return (type.equals(Type.ALL))
                ? purchasesList.isEmpty()
                : purchasesList.stream()
                        .noneMatch(purchase -> purchase.type() == type);
    }


    public static void updatePurchasesList(Purchase purchase) {
        purchasesList.add(purchase);

        float price = purchase.price();

        TotalSumHandler.updateTotalSum(purchase.type(), price);
    }


    private static void printPurchasesList(Type type) {
        List<String> listForPrinting = new LinkedList<>();

        System.out.println(type.getName() + ":");

        if (Type.ALL.equals(type)) {
            purchasesList.forEach(purchase -> {
                listForPrinting.add(String.format("%s $%.2f", purchase.name(), purchase.price()));
            });

        } else {
            purchasesList.stream()
                    .filter(purchase -> purchase.type() == type)
                    .forEach(purchase -> {
                        listForPrinting.add(String.format("%s $%.2f", purchase.name(), purchase.price()));
                    });
        }

        IODataHandler.printData(listForPrinting);

        System.out.printf("Total sum: $%.2f\n\n", TotalSumHandler.getTotalSum(type).get(type));
    }


    public static List<Purchase> getPurchasesList() {
        return purchasesList;
    }


    public static void startPurchasesListMenu() {
        while (true) {
            if (isListIsEmpty(Type.ALL)) {
                IODataHandler.printEmptyError();
                break;
            }

            printPurchasesListMenu();

            int selectedOptionInt = IODataHandler.getSelectedOption();
            System.out.println();

            if (selectedOptionInt == 6) break;

            Type type = Type.getTypeById(selectedOptionInt);

            switch (type) {
                case FOOD, CLOTHES, ENTERTAINMENT, OTHER -> {
                    if (isListIsEmpty(type)) {
                        IODataHandler.printEmptyError();
                        break;
                    }

                    printPurchasesList(type);
                }
                default -> printPurchasesList(Type.ALL);
            }
        }
    }
}
