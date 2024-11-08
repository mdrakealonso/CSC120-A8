import java.util.ArrayList;

/**
 * Represents the Spellcaster class
 */
public class Spellcaster implements Contract {

    // Attributes

    private String name;
    private int size = 50;
    private int positionX = 0;
    private int positionY = 0;
    private int energy = 100;
    private ArrayList<String> inventory;
    private boolean hasBroom;

    // Constructor

    /**
     * Constructor for the Spellcaster class
     * @param name a Spellcaster's name
     * @param hasBroom true if Spellcaster has a broom
     */
    public Spellcaster(String name, boolean hasBroom) {
        this.name = name;
        this.hasBroom = hasBroom;
        this.inventory = new ArrayList<String>();
        System.out.println("A spellcaster named " + name + " has materialized!");
    }

    // Methods

    /**
     * Allows a Spellcaster to eat an item of type FOOD
     * @param item an Item with name and ItemType
     */
    public void eat(String item) {
        System.out.println(name + " has eaten a(n) " + item + " and gained a bit of energy! Mmmmm...");
        if (energy <= 90) {
            energy += 10;
        }
    }

    /**
     * Allows a Spellcaster to eat an item of type FOOD
     * @param item an Item with name and ItemType
     */
    public void eat(Item item) {
        if (!item.getType().equals("FOOD")) {
            System.out.println("This item isn't edible.");
        } else {
            System.out.println(name + " has eaten a(n) " + item.getName() + " and gained a bit of energy! Mmmmm...");
            if (energy <= 90) {
                energy += 10;
            }
        }
    }
    
    /**
     * Allows a Spellcaster to grab an item and add it to the inventory
     * @param item an item
     */
    public void grab(String item) {
        inventory.add(item);
        System.out.println(name + " has grabbed a(n) " + item + ".");
    }

    /**
     * Allows a Spellcaster to grab an Item and add it to the inventory
     * @param item an Item with name and ItemType
     */
    public void grab(Item item) {
        inventory.add(item.getName());
        System.out.println(name + " has grabbed a(n) " + item.getName() + ".");
    }

    /**
     * Allows a Spellcaster to drop an item from their inventory, provided it's contained in there
     * @param item an item
     */
    public String drop(String item) {
        if(!inventory.contains(item)) {
            System.out.println("This item cannot be located in " + name + "'s inventory.");
        }
        inventory.remove(item);
        System.out.println(name + " has dropped a(n) " + item + ".");
        return(item);
    }

    /**
     * Allows a Spellcaster to drop an Item from their inventory, provided it's contained in there
     * @param item an Item with name and ItemType
     */
    public String drop(Item item) {
        if(!inventory.contains(item.getName())) {
            System.out.println("This item cannot be located in " + name + "'s inventory.");
        }
        inventory.remove(item.getName());
        System.out.println(name + " has dropped the " + item.getName() + ".");
        return(item.getName());
    }

    /**
     * Allows a Spellcaster to examine an item
     * @param item an item
     */
    public void examine(String item) {
        System.out.println(name + " scrutinizes the " + item + ".\n'Curious... very curious...'");
    }

    /**
     * Allows a Spellcaster to learn about an Item by examining it
     * @param item an Item with name and ItemType
     */
    public void examine(Item item) {
        System.out.println(name + " scrutinizes the " + item.getName() + ".\n'Curious... very curious...'");
        item.toString();
    }

    /**
     * Allows a Spellcaster to use an item, provided they have it in their inventory
     * @param item an item
     */
    public void use(String item) {
        if(!inventory.contains(item)) {
            System.out.println(name + " doesn't have a(n) " + item + " to use.");
        } else if(item.contains("energy")) {
            energy = 100;
            System.out.println(name + " has drunk an energy elixer and fully restored their energy!");
        } else if(item.contains("grow")) {
            grow();
        } else if(item.contains("shrink")) {
            shrink();
        } else {
            eat(item);
        }
        inventory.remove(item);
    }

    /**
     * Allows a Spellcaster to use an Item, provided they have it in their inventory
     * @param item an Item with name and ItemType
     */
    public void use(Item item) {
        if(!inventory.contains(item.getName())) {
            System.out.println(name + " doesn't have a(n) " + item.getName() + " to use.");
        } else if(item.getType().equals("ENERGY")) {
            energy = 100;
            System.out.println(name + " has drunk an energy elixer and fully restored their energy!");
        } else if(item.getType().equals("FOOD")) {
            eat(item);
        } else if(item.getType().equals("GROWTH")) {
            grow();
        } else if(item.getType().equals("SHRINKAGE")) {
            shrink();
        }
        inventory.remove(item.getName());
    }

    /**
     * Allows a Spellcaster to walk in a specified direction, provided they have enough energy
     * @param direction direction to walk toward
     */
    public boolean walk(String direction) {
        if (energy == 0) {
            System.out.println(name + "'s energy is too low. Take it easy for now.");
            return false;
        }
        if (direction.equalsIgnoreCase("north")) {
            positionY ++;
        }
        else if (direction.equalsIgnoreCase("east")) {
            positionX ++;
        }
        else if (direction.equalsIgnoreCase("south")) {
            positionY --;
        }
        else if (direction.equalsIgnoreCase("west")) {
            positionX --;
        } else {
            System.out.println(name + " doesn't understand this direction. Poor " + name + ".");
            return false;
        }
        energy -= 5;
        System.out.println(name + " walks slowly " + direction + ".");
        return true;
    }

    /**
     * Allows a Spellcaster to fly, if and only if they have a broom in their possession
     * @param x intended x coordinate
     * @param y intended y coordinate
     */
    public boolean fly(int x, int y) {
        if (!hasBroom) {
            System.out.println(name + " can't fly without a broom. They'll have to travel the normie way.");
            return false;
        }
        positionX = x;
        positionY = y;
        System.out.println(name + " has used their broom to fly.");
        return true;
    }

    /**
     * Allows a Spellcaster to shrink in size with the help of a shrinkage potion
     */
    public Number shrink() {
        if (size <= 0) {
            System.out.println(name + " is already under the effects of a shrinking potion and thus this potion took no effect.");
        } else {
            size -= 50;
            System.out.println(name + " has drunk a shrinking potion and shrunk to half their size! How cute!");
        }
        return size;
    }

    /**
     * Allows a Spellcaster to grow in size with the help of a growth potion
     */
    public Number grow() {
        if (size == 100) {
            System.out.println(name + " is already under the effects of a growth potion and thus this potion took no effect.");
        } else {
            size *= 2;
            System.out.println(name + " has drunk a growth potion and doubled in size! How's the weather up there?");
        }
        return size;
    }

    /**
     * Replenishes a Spellcaster energy
     */
    public void rest() {
        energy = 100;
        System.out.println(name + " has rested and fully restored their energy.");
    }

    /**
     * Cancels the effects of a growth or shrinkage potion on a Spellcaster, provided they have recently drunk one
     */
    public void undo() {
        if (size == 50) {
            System.out.println(name + " is not currently under the effects of any potion.");
        } else {
            size = 50;
            System.out.println("With a flick of the wand, " + name + " returns to their normal size.");
        }
    }

    /**
     * Main method for the Spellcaster class
     * @param args array for command-line arguments
     */
    public static void main(String[] args) {
        Spellcaster powerfulSpellcaster =  new Spellcaster("Merlin", true);
        Item hamburger = new Item("Hamburger", ItemType.FOOD);
        Item potion = new Item("Shrinking potion", ItemType.SHRINKAGE);
        powerfulSpellcaster.fly(10, 10);
        powerfulSpellcaster.walk("east");
        powerfulSpellcaster.rest();
        powerfulSpellcaster.undo();
        powerfulSpellcaster.grab(hamburger);
        powerfulSpellcaster.examine(hamburger);
        powerfulSpellcaster.use(hamburger);
        powerfulSpellcaster.grab(potion);
        powerfulSpellcaster.examine(potion);
        powerfulSpellcaster.use(potion);
    }

}