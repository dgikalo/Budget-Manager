package budget;


public class PurchaseHandler {

    static void printPurchaseMenu() {
        String purchaseTypeMenu = """
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) Back""";

        SystemOperations.printData(purchaseTypeMenu);
    }


    private static void createPurchaseRecord(PurchaseType type) {
        SystemOperations.printData("Enter purchase name:");
        String purchaseName = SystemOperations.readData();

        SystemOperations.printData("Enter its price:");
        float purchaseCost = Float.parseFloat(SystemOperations.readData());

        PurchasesListHandler.updatePurchasesList(new Purchase(type, purchaseName, purchaseCost));
    }


    static void runPurchaseMenu() {
        while (true) {
            printPurchaseMenu();

            int selectedOptionInt = Integer.parseInt(SystemOperations.readData());

            if (selectedOptionInt == 5) break;

            PurchaseType selectedOptionType = PurchaseType.getPurchaseTypeById(selectedOptionInt);

            switch (selectedOptionType) {
                case FOOD -> createPurchaseRecord(PurchaseType.FOOD);
                case CLOTHES -> createPurchaseRecord(PurchaseType.CLOTHES);
                case ENTERTAINMENT -> createPurchaseRecord(PurchaseType.ENTERTAINMENT);
                case OTHER -> createPurchaseRecord(PurchaseType.OTHER);
            }
        }
    }
}
