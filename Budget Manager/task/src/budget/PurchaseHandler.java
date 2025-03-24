package budget;


import java.util.List;
import java.util.LinkedList;


public class PurchaseHandler {

    public static void printPurchaseMenu() {
        List<String> purchasesMenu = new LinkedList<>();
        purchasesMenu.add("Choose the type of purchase");

        for (Type type : Type.getTypes(false)) {
            purchasesMenu.add(String.format("%d) %s\n", type.getId(), type.getName()));
        }

        purchasesMenu.add("5) Back");

        IODataHandler.printData(purchasesMenu);
    }


    private static void createPurchaseRecord(Type type) {
        System.out.println("Enter purchase name:");
        String name = IODataHandler.getInputValue();

        System.out.println("Enter its price:");
        float price = Float.parseFloat(IODataHandler.getInputValue());

        Purchase purchase = new Purchase(type, name, price);

        PurchasesListHandler.updatePurchasesList(purchase);
        BalanceHandler.updateBalance(-price);

        System.out.println("Purchase was added!\n");
    }


    static void startPurchaseMenu() {
        while (true) {
            printPurchaseMenu();

            int selectedOptionInt = IODataHandler.getSelectedOption();
            System.out.println();

            if (selectedOptionInt == 5) break;

            Type selectedOptionCategory = Type.getTypeById(selectedOptionInt);

            createPurchaseRecord(selectedOptionCategory);
        }
    }
}
