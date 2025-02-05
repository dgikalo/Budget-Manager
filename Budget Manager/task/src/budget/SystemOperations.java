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

    public static String capitalizeFirstCharacter(String value) {
        return String
                .valueOf(value.charAt(0))
                .toUpperCase()
                .concat(value.substring(1));
    }
}
