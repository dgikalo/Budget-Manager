package budget;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.LinkedList;


public class IODataHandler {

    static final String filePath = "purchases.txt";


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
                    Category.valueOf(buffer[0]),
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
                writer.printf("%s;%s;%s\n", purchase.category().toString(), purchase.name(), purchase.price());
            }

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }


    static void readData() {
        fillDataStructures(readFileData());
    }

    static void writeData() {
        writePurchaseData(BalanceHandler.getBalance(), PurchasesListHandler.getPurchasesList());
    }
}
