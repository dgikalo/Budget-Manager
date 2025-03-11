package budget;


public final class MainMenuHandler {

    private static void printMainMenu() {
        String mainMenuOptions = """
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                5) Save
                6) Load
                0) Exit""";

        System.out.println(mainMenuOptions);
    }


    private static void addIncomeOption() {
        System.out.println("Enter income:");

        float incomeValue = Float.parseFloat(SystemUtility.readData());

        BalanceHandler.updateBalance(incomeValue);

        System.out.println("Income was added!\n");
    }


    private static void addPurchaseOption() {
        PurchaseHandler.startPurchaseMenu();
    }


    private static void showListOfPurchases() {
        PurchasesListHandler.startPurchasesListMenu();
    }


    private static void balanceOption() {
        System.out.printf("Balance: $%.2f\n\n", BalanceHandler.getBalance());
    }


    private static void saveOption() {
        IODataHandler.writeData();

        System.out.println("Purchases were saved!\n");
    }


    private static void loadOption() {
        IODataHandler.readData();

        System.out.println("Purchases were loaded!\n");
    }


    static void startMainMenu() {
        while (true) {
            printMainMenu();

            int selectedOptionInt = Integer.parseInt(SystemUtility.readData());
            System.out.println();

            switch (selectedOptionInt) {
                case 1 -> addIncomeOption();
                case 2 -> addPurchaseOption();
                case 3 -> showListOfPurchases();
                case 4 -> balanceOption();
                case 5 -> saveOption();
                case 6 -> loadOption();
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }
}
