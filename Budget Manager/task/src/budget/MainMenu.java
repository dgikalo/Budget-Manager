package budget;

public class MainMenu {
    public static void displayMainMenuOptions() {
        String mainMenuOptions = """
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                0) Exit""";

        SystemOperations.printData(mainMenuOptions);
    }
}
