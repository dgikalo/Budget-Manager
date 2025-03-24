package budget;


import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class SortingHandler {

    private static void printSortingMenu() {
        List<String> sortingTypeOptions = List.of(
                "How do you want to sort?",
                "1) Sort all purchases",
                "2) Sort by type",
                "3) Sort certain type",
                "4) Back"
        );

        IODataHandler.printData(sortingTypeOptions);
    }


    private static void printPurchaseTypeMenu() {
        List<String> purchaseTypeOptions = new LinkedList<>();

        System.out.println("Choose the type of purchase");

        for (Type type : Type.getTypes(false)) {
            purchaseTypeOptions.add(String.format("%d) %s", type.getId(), type.getName()));
        }

        IODataHandler.printData(purchaseTypeOptions);
    }


    private static void sortAllPurchasesOption(SelectionContext context, List<Purchase> purchasesList) {
        if (PurchasesListHandler.isListIsEmpty(Type.ALL)) {
            IODataHandler.printEmptyError();
            return;
        }

        SortSelectionAlgorithm algorithm = new SortAllAlgorithm();
        context.setAlgorithm(algorithm);

        List<String> sortedList = context.sortPurchasesList(purchasesList);

        System.out.println("All:");
        IODataHandler.printData(sortedList);
        System.out.printf("Total sum: $%.2f\n\n", TotalSumHandler.getTotalSum(Type.ALL).get(Type.ALL));
    }


    private static void sortByTypeOption(SelectionContext context, Map<Type, Float> totalSumByType) {
        SortSelectionAlgorithm algorithm = new SortByTypeAlgorithm();
        context.setAlgorithm(algorithm);

        List<String> sortedList = context.sortPurchasesList(totalSumByType);

        System.out.println("Types:");
        IODataHandler.printData(sortedList);
        System.out.printf("Total sum: $%.2f\n\n", TotalSumHandler.getTotalSum(Type.ALL).get(Type.ALL));
    }


    private static void sortCertainTypeOption(SelectionContext context, List<Purchase> purchasesList) {
        printPurchaseTypeMenu();

        Type type = Type.getTypeById(IODataHandler.getSelectedOption());
        System.out.println();

        if (PurchasesListHandler.isListIsEmpty(type)) {
            IODataHandler.printEmptyError();
            return;
        }

        SortSelectionAlgorithm algorithm = new SortCertainType();
        context.setAlgorithm(algorithm);

        List<String> sortedList = algorithm.getSortedList(purchasesList, type);

        System.out.println(type.getName() + ":");
        IODataHandler.printData(sortedList);
        System.out.printf("Total sum: $%.2f\n\n", TotalSumHandler.getTotalSum(type).get(type));
    }


    public static void handleSortingMenu() {
        while (true) {
            printSortingMenu();

            int selectedOptionInt = IODataHandler.getSelectedOption();
            System.out.println();

            if (selectedOptionInt == 4) break;

            List<Purchase> purchasesList = PurchasesListHandler.getPurchasesList();
            SelectionContext context = new SelectionContext();

            switch (selectedOptionInt) {
                case 1 -> sortAllPurchasesOption(context, purchasesList);
                case 2 -> {
                    Map<Type, Float> tmp = new HashMap<>();

                    for (Type type : Type.getTypes(false)) {
                        tmp.putAll(TotalSumHandler.getTotalSum(type));
                    }

                    sortByTypeOption(context, tmp);
                }
                case 3 -> sortCertainTypeOption(context, purchasesList);
            }
        }
    }
}
