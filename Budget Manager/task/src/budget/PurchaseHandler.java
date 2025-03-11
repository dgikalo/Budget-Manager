package budget;


public class PurchaseUtility {

    static void printPurchaseMenu() {
        System.out.println("Choose the type of purchase");

        for (PurchaseCategory category : PurchaseCategory.getTypes(false)) {
            System.out.printf("%d) %s\n", category.getId(), category.getName());
        }

        System.out.println("5) Back");
    }


    private static void createPurchaseRecord(PurchaseCategory category) {
        System.out.println("Enter purchase name:");
        String name = SystemUtility.readData();

        System.out.println("Enter its price:");
        float price = Float.parseFloat(SystemUtility.readData());

        Purchase purchase = new Purchase(category, name, price);

        PurchasesListUtility.updatePurchasesList(purchase);

        System.out.println("Purchase was added!");
    }


    static void startPurchaseMenu() {
        while (true) {
            printPurchaseMenu();

            int selectedOptionInt = Integer.parseInt(SystemUtility.readData());

            if (selectedOptionInt == 5) break;

            PurchaseCategory selectedOptionCategory = PurchaseCategory.getTypeById(selectedOptionInt);

            createPurchaseRecord(selectedOptionCategory);
        }
    }
}
