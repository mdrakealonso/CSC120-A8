public class Item {

    // Attributes

    private String name;
    private ItemType type;

    // Constructor

    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return String.valueOf(type);
    }

    public String toString() {
        return "This " + (name + " appears to be an item of type " + type + ".").toLowerCase();
    }

    public static void main(String[] args) {
        Item apple = new Item("Apple", ItemType.FOOD);
        System.out.println(apple.toString());
    }
}