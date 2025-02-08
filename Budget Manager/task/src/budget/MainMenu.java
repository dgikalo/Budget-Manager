package budget;

public final class MainMenu {
    private MainMenu() {
    }


    public static void displayMainMenu() {
        String mainMenuOptions = """
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                0) Exit""";

        System.out.println(mainMenuOptions);

        int passedMainMenuOption = Integer.parseInt(SystemOperations.readInputData());

        processMainMenuOption(passedMainMenuOption);
    }


    private static void processMainMenuOption(int option) {
        switch (option) {
            case 1 -> addIncomeOption();
            case 2 -> addPurchaseOption();
            case 3 -> showListOfPurchasesOption();
            case 4 -> showBalanceOption();
            case 0 -> exitProgramOption();
        }
    }


    private static void addIncomeOption() {
        float incomeValue = Float.parseFloat(SystemOperations.readInputData());

        Balance.updateBalance(incomeValue);

        System.out.println("Income was added!");
    }


    private static void addPurchaseOption() {

    }


    private static void showListOfPurchasesOption() {

    }


    private static void showBalanceOption() {
        System.out.printf("Balance: $%.2f\n", Balance.getBalance());
    }


    private static void exitProgramOption() {
        System.out.println("Bye!");
        System.exit(0);
    }
}