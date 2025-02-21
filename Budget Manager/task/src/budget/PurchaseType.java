package budget;


public enum PurchaseType {
    FOOD("Food", 1),
    CLOTHES("Clothes", 2),
    ENTERTAINMENT("Entertainment", 3),
    OTHER("Other", 4),
    ALL("All", 5);

    private final String optionName;
    private final int optionId;

    PurchaseType(String optionName, int optionId) {
        this.optionName = optionName;
        this.optionId = optionId;
    }


    String getOptionName() {
        return optionName;
    }


    int getOptionId() {
        return optionId;
    }


    static PurchaseType[] getPurchaseTypes() {
        return PurchaseType.values();
    }


    static PurchaseType getPurchaseTypeById(int optionId) {
        PurchaseType returnPurchaseType = null;

        for (PurchaseType purchaseType : getPurchaseTypes()) {
            if (purchaseType.getOptionId() == optionId) {
                returnPurchaseType = purchaseType;
            }
        }

        return returnPurchaseType;
    }
}
