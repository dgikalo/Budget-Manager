package budget;


public enum PurchaseType {
    FOOD("Food", 1),
    CLOTHES("Clothes", 2),
    ENTERTAINMENT("Entertainment", 3),
    OTHER("Other", 4);

    private final String optionName;
    private final int optionId;

    PurchaseType(String optionName, int optionId) {
        this.optionName = optionName;
        this.optionId = optionId;
    }


    public String getOptionName() {
        return optionName;
    }


    public int getOptionId() {
        return optionId;
    }


    public static PurchaseType[] getPurchaseTypes() {
        return PurchaseType.values();
    }
    
    
    public static PurchaseType getPurchaseTypeById(int optionId) {
        PurchaseType returnPurchaseType = null;

        for (PurchaseType purchaseType : getPurchaseTypes()) {
            if (purchaseType.getOptionId() == optionId) {
                returnPurchaseType = purchaseType;
            }
        }

        return returnPurchaseType;
    }
}
