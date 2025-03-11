package budget;


public final class MainMenuUtility {

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

        BalanceUtility.updateBalance(incomeValue);

        System.out.println("Income was added!");
    }


    private static void addPurchaseOption() {
        PurchaseUtility.startPurchaseMenu();
    }


    private static void showListOfPurchases() {
        PurchasesListUtility.startPurchaseTypesMenu();
    }


    private static void balanceOption() {
        System.out.printf("Balance: $%.2f\n", BalanceUtility.getBalance());
    }


    private static void saveOption() {
        System.out.println("Purchases were saved!");
    }


    private static void loadOption() {
        IODataHandler.readData();

        System.out.println("Purchases were loaded!");
    }


    static void startMainMenu() {
        while (true) {
            printMainMenu();

            int selectedOptionInt = Integer.parseInt(SystemUtility.readData());

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
