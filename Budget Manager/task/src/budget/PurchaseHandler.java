package budget;


public class PurchaseHandler {

    static void printPurchaseMenu() {
        System.out.println("Choose the type of purchase");

        for (Category category : Category.getTypes(false)) {
            System.out.printf("%d) %s\n", category.getId(), category.getName());
        }

        System.out.println("5) Back");
    }


    private static void createPurchaseRecord(Category category) {
        System.out.println("Enter purchase name:");
        String name = SystemUtility.readData();

        System.out.println("Enter its price:");
        float price = Float.parseFloat(SystemUtility.readData());

        Purchase purchase = new Purchase(category, name, price);

        PurchasesListHandler.updatePurchasesList(purchase);
        BalanceHandler.updateBalance(-price);

        System.out.println("Purchase was added!\n");
    }


    static void startPurchaseMenu() {
        while (true) {
            printPurchaseMenu();

            int selectedOptionInt = Integer.parseInt(SystemUtility.readData());
            System.out.println();

            if (selectedOptionInt == 5) break;

            Category selectedOptionCategory = Category.getTypeById(selectedOptionInt);

            createPurchaseRecord(selectedOptionCategory);
        }
    }
}
