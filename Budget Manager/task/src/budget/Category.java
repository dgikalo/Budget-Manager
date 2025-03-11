package budget;


import java.util.Arrays;


public enum Category {

    FOOD("Food", 1),
    CLOTHES("Clothes", 2),
    ENTERTAINMENT("Entertainment", 3),
    OTHER("Other", 4),
    ALL("All", 5);


    private final String name;
    private final int id;


    Category(String name, int id) {
        this.name = name;
        this.id = id;
    }


    String getName() {
        return name;
    }


    int getId() {
        return id;
    }


    static Category[] getTypes(boolean isExtended) {
        return (isExtended)
                ? Category.values()
                : new Category[]{FOOD, CLOTHES, ENTERTAINMENT, OTHER};
    }


    static Category getTypeById(int id) {
        return Arrays
                .stream(getTypes(true))
                .filter(category -> category.id == id)
                .findFirst()
                .orElse(null);
    }
}
