package budget;

public class Balance {
    private static float balance = 0;

    public static float getBalance() {
        return balance;
    }

    public static void updateBalance(float value) {
        Balance.balance += value;
    }
}
