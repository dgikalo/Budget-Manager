package budget;

import java.util.Scanner;

public class SystemOperations {
    public static String readInputData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void printData(String string) {
        System.out.println(string);
    }
}
