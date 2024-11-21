/* Item class
 */
public class Item {

    // Attributes

    private String name;
    private ItemType type;

    // Constructor

    /**
     * Constructor for Item class
     * @param name name of item
     * @param type type of item that is one of: FOOD, ENERGY, GROWTH, SHRINKAGE
     */
    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the name of an Item
     * @return an Item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of an Item
     * @return Item type that is one of: FOOD, ENERGY, GROWTH, SHRINKAGE
     */
    public String getType() {
        return String.valueOf(type);
    }

    /**
     * Returns a properly formatted String containing information about an Item
     * @return a String containing an Item description
     */
    public String toString() {
        return "This " + (name + " appears to be an item of type " + type + ".").toLowerCase();
    }

    /**
     * A main function for creating an example Item
     * @param args an empty Array of Strings for storing command line arguments
     */
    public static void main(String[] args) {
        Item apple = new Item("Apple", ItemType.FOOD);
        System.out.println(apple.toString());
    }
}