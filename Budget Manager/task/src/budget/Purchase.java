package budget;

public class Purchase {
    private final PurchaseType purchaseType;
    private final String purchaseName;
    private final float purchaseCost;


    public Purchase(PurchaseType purchaseType, String purchaseName, float purchaseCost) {
        this.purchaseType = purchaseType;
        this.purchaseName = purchaseName;
        this.purchaseCost = purchaseCost;
    }


    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public float getPurchaseCost() {
        return purchaseCost;
    }
}
