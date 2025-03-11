package budget;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;


public class FileUtility {

    static final String filePath = "purchases.txt";


    static List<String> readFileData() {
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


    static void fillPurchaseList(List<String> fileData) {
        for (String string : fileData) {
            String[] tmpString = string.split(";");
            int categoryId = Integer.parseInt(tmpString[0]);

            Purchase  purchase = new Purchase(
                    PurchaseCategory.getTypeById(categoryId),
                    tmpString[1],
                    Float.parseFloat(tmpString[2])
            );

            PurchasesListUtility.updatePurchasesList(purchase);
        }
    }


    static void writePurchaseData(Purchase purchase) {
        int categoryId = purchase.category().getId();
        String name = purchase.name();
        float price = purchase.price();
        String template = String.format("%s;%s;%.2f\n", categoryId, name, price);

        File file = new File(filePath);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(template);

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
