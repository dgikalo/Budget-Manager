package budget;

import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public final class MainMenu {

    private MainMenu() {
    }


    // Main menu options list
    static void printMainMenu() {
        String mainMenuOptions = """
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                0) Exit""";

        // Print Main menu options list
        System.out.println(mainMenuOptions);

        // Read selected option
        int passedMainMenuOption = Integer.parseInt(SystemOperations.readInputData());

        // Pass selected Main menu option
        processMainMenuOption(passedMainMenuOption);
    }


    // Process selected Main menu option's function
    private static void processMainMenuOption(int option) {
        switch (option) {
            case 1 -> addIncomeOption();
            case 2 -> addPurchaseOption();
            case 3 -> System.out.println("3"); // showListOfPurchasesOption();
            case 4 -> showBalanceOption();
            case 0 -> exitProgramOption();
        }
    }


    private static void addIncomeOption() {
        System.out.println("Enter income:");

        float incomeValue = Float.parseFloat(SystemOperations.readInputData());

        Balance.updateBalance(incomeValue);

        System.out.println("Income was added!");
    }


    private static void addPurchaseOption() {
        PurchaseMenu.displayPurchaseTypeMenu();


    }


    /*
    private static void showListOfPurchasesOption() {
        if (Purchase.isPurchaseListIsEmpty()) {
            System.out.println("The purchase list is empty!");

            return;
        }

        int selectedPurchaseTypeMenuOption = Integer.parseInt(SystemOperations.readInputData());

        if (selectedPurchaseTypeMenuOption == 5) {
            return;
        }

        PurchaseType selectedPurchaseType = PurchaseType.getPurchaseTypeById(selectedPurchaseTypeMenuOption);

        if (selectedPurchaseType != null) {
            Purchase.processPurchaseTypeMenuOption(selectedPurchaseType);
        }
    }
     */


    private static void showBalanceOption() {
        System.out.printf("Balance: $%.2f\n", Balance.getBalance());
    }


    private static void exitProgramOption() {
        System.out.println("Bye!");
        System.exit(0);
    }
}