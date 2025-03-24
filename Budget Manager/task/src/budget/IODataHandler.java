package budget;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;


public class IODataHandler {

    private static final String filePath = "purchases.txt";


    public static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static int getSelectedOption() {
        return Integer.parseInt(getInputValue());
    }


    private static List<String> readFileData() {
        File file = new File(filePath);
        List<String> fileData = new LinkedList<>();

        try (InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String bufferedLine;

            while ((bufferedLine = bufferedReader.readLine()) != null) {
                fileData.add(bufferedLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileData;
    }


    private static void fillDataStructures(List<String> fileData) {
        float balance = Float.parseFloat(fileData.removeFirst().split(";")[1]);

        BalanceHandler.updateBalance(balance);

        for (String string : fileData) {
            String[] buffer = string.split(";");
            Purchase purchase = new Purchase(
                    Type.valueOf(buffer[0]),
                    buffer[1],
                    Float.parseFloat(buffer[2])
            );

            PurchasesListHandler.updatePurchasesList(purchase);
        }
    }


    private static void writePurchaseData(float balance, List<Purchase> purchasesList) {
        File file = new File(filePath);

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("BALANCE;" + balance);

            for (Purchase purchase : purchasesList) {
                writer.printf("%s;%s;%s\n", purchase.type().toString(), purchase.name(), purchase.price());
            }

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }


    public static void readData() {
        fillDataStructures(readFileData());
    }


    public static void writeData() {
        writePurchaseData(BalanceHandler.getBalance(), PurchasesListHandler.getPurchasesList());
    }


    public static void printData(List<String> list) {
        list.forEach(System.out::println);
    }


    public static void printEmptyError() {
        System.out.println("The purchase list is empty!\n");
    }
}
