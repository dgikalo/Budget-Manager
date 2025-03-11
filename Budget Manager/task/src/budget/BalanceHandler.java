package budget;


public class BalanceHandler {

    private static float balance = 0;


    public static float getBalance() {
        return balance;
    }


    public static void updateBalance(float value) {
        balance += value;
    }
}
