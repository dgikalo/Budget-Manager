package budget;

public class Purchase {
    private final PurchaseType purchaseType;
    private final String purchaseName;
    private final float purchaseCost;


    public Purchase(PurchaseType type, String name, float cost) {
        this.purchaseType = type;
        this.purchaseName = name;
        this.purchaseCost = cost;
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
