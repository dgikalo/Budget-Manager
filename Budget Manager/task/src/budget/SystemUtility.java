package budget;

import java.util.Scanner;

public class SystemOperations {

    public static String readData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    static void printError() {
        System.out.println("The purchase list is empty!");
    }
}
