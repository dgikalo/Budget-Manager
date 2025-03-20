package budget;


import java.util.Arrays;


public enum Type {

    FOOD("Food", 1),
    CLOTHES("Clothes", 2),
    ENTERTAINMENT("Entertainment", 3),
    OTHER("Other", 4),
    ALL("All", 5);


    private final String name;
    private final int id;


    Type(String name, int id) {
        this.name = name;
        this.id = id;
    }


    String getName() {
        return name;
    }


    int getId() {
        return id;
    }


    static Type[] getTypes(boolean isExtended) {
        return (isExtended)
                ? Type.values()
                : new Type[]{FOOD, CLOTHES, ENTERTAINMENT, OTHER};
    }


    static Type getTypeById(int id) {
        return Arrays.stream(getTypes(true))
                .filter(category -> category.id == id)
                .findFirst()
                .orElse(null);
    }
}
