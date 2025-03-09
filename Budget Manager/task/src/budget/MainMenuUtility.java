package budget;


public final class MainMenuHandler {

    private static void printMainMenu() {
        String mainMenuOptions = """
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                0) Exit""";

        SystemOperations.printData(mainMenuOptions);
    }


    private static void addIncomeOption() {
        SystemOperations.printData("Enter income:");

        float incomeValue = Float.parseFloat(SystemOperations.readData());

        Balance.updateBalance(incomeValue);

        SystemOperations.printData("Income was added!");
        System.out.println();
    }


    private static void balanceOption() {
        float balanceValue = Balance.getBalance();

        SystemOperations.printData(String.format("Balance: $%.2f", balanceValue));
        System.out.println();
    }


    private static void addPurchaseOption() {
        PurchaseHandler.runPurchaseMenu();
    }


    private static void showListOfPurchases() {
        PurchasesListHandler.runPurchaseTypesMenu();
    }


    private static void exitOption() {
        SystemOperations.printData("Bye!");

        System.exit(0);
    }


    static void runMainMenu() {
        while (true) {
            MainMenuHandler.printMainMenu();

            int selectedMainMenuOption = Integer.parseInt(SystemOperations.readData());
            System.out.println();

            if (selectedMainMenuOption == 0) break;

            switch (selectedMainMenuOption) {
                case 1 -> addIncomeOption();
                case 2 -> addPurchaseOption();
                case 3 -> showListOfPurchases();
                case 4 -> balanceOption();
            }
        }

        exitOption();
    }
}
