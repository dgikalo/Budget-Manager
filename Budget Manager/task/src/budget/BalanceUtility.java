package budget;

public class BalanceUtility {
    private static float balance = 0;


    public static float getBalance() {
        return balance;
    }


    public static void updateBalance(float value) {
        balance += value;
    }
}
