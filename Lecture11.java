// ============================================
// LECTURE 11: Collections Framework & ArrayList
// Gaming Inventory System
// ============================================

// TODO: Import ArrayList from java.util package
import _________________;

// TODO: Import Scanner
import _________________;

public class Lecture11 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   GAMING INVENTORY MANAGEMENT SYSTEM");
        System.out.println("========================================\n");
        
        // ============================================
        // PART 1: Creating an ArrayList for Game Items
        // ============================================
        
        // An ArrayList is a dynamic array that grows/shrinks as needed
        // Unlike arrays, we don't need to specify size upfront!
        
        // TODO: Create an ArrayList<String> called inventory
        // Syntax: ArrayList<String> name = new ArrayList<>();
        ArrayList<String> inventory = _________________;
        
        System.out.println("--- Creating Your Gaming Inventory ---\n");
        
        // ============================================
        // PART 2: Adding Items to ArrayList using .add()
        // ============================================
        
        // The .add() method adds elements to the end of the ArrayList
        // ArrayList grows dynamically - no need to worry about size!
        
        // TODO: Add "Legendary Sword" to inventory
        inventory._________________("Legendary Sword");
        
        // TODO: Add "Health Potion" to inventory
        inventory._________________("Health Potion");
        
        // TODO: Add "Dragon Scale Armor" to inventory
        inventory._________________("Dragon Scale Armor");
        
        System.out.println("✓ Added 3 items to your inventory\n");
        
        // ============================================
        // PART 3: Displaying All Items (Loop through ArrayList)
        // ============================================
        
        System.out.println("--- Your Current Inventory ---");
        
        // TODO: Print the size of inventory using .size() method
        System.out.println("Total Items: " + inventory._________________());
        
        // Loop through ArrayList using for loop
        // inventory.size() tells us how many items we have
        // i goes from 0 to size-1 (just like array indexing)
        
        System.out.println("\nInventory List:");
        for (int i = 0; i < inventory.size(); i++) {
            // TODO: Use .get(i) to access item at index i
            // Print: "  [i+1]. " + item
            String item = inventory._________________(i);
            System.out.println("  " + (i + 1) + ". " + item);
        }
        
        System.out.println(); // Spacing
        
        // ============================================
        // PART 4: Adding Items Dynamically (User Input)
        // ============================================
        
        System.out.print("How many new items do you want to collect? ");
        // TODO: Read the number of items
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        System.out.println("\n--- Collecting New Items ---");
        
        // Loop to get items from user
        // TODO: Create a for loop that runs numItems times
        for (int _________________ = 0; _________________ < _________________; _________________++) {
            System.out.print("Item " + (i + 1) + ": ");
            // TODO: Read the item name and add it to inventory
            String newItem = scanner.nextLine();
            inventory._________________(newItem);
        }
        
        System.out.println(); // Spacing
        
        // ============================================
        // PART 5: Using .get() and .contains()
        // ============================================
        
        System.out.println("--- Inventory Operations ---");
        
        // .contains() checks if an item exists in the ArrayList
        // TODO: Check if inventory contains "Health Potion"
        if (inventory._________________("Health Potion")) {
            System.out.println("✓ Health Potion found in inventory!");
        } else {
            System.out.println("✗ Health Potion not found.");
        }
        
        // TODO: Check if inventory contains "Fire Spell"
        if (inventory._________________("Fire Spell")) {
            System.out.println("✓ Fire Spell found in inventory!");
        } else {
            System.out.println("✗ Fire Spell not found in inventory.");
        }
        
        System.out.println(); // Spacing
        
        // ============================================
        // PART 6: Accessing Elements with .get()
        // ============================================
        
        System.out.println("--- Item Details ---");
        
        // .get(index) retrieves element at specified index
        // Remember: indexing starts at 0
        
        if (inventory.size() > 0) {
            // TODO: Get first item using .get(0)
            String firstItem = inventory._________________(0);
            System.out.println("First item: " + firstItem);
        }
        
        if (inventory.size() > 1) {
            // TODO: Get second item using .get(1)
            String secondItem = inventory._________________(1);
            System.out.println("Second item: " + secondItem);
        }
        
        // TODO: Get last item using .get(size - 1)
        if (inventory.size() > 0) {
            String lastItem = inventory._________________(inventory.size() - 1);
            System.out.println("Last item: " + lastItem);
        }
        
        System.out.println(); // Spacing
        
        // ============================================
        // PART 7: Removing Items using .remove()
        // ============================================
        
        System.out.println("--- Removing Items ---");
        
        // .remove(index) removes element at specified index
        // Remaining elements shift forward to fill the gap
        
        if (inventory.size() > 0) {
            // TODO: Remove item at index 0 using .remove(0)
            String removed = inventory._________________(0);
            System.out.println("✗ Removed: " + removed);
        }
        
        System.out.println("Remaining items: " + inventory.size() + "\n");
        
        // ============================================
        // PART 8: Using Enhanced For-Each Loop
        // ============================================
        
        System.out.println("--- Final Inventory (Enhanced Loop) ---");
        
        // Enhanced for-each loop is a cleaner way to iterate through ArrayList
        // Syntax: for (Type variable : collection)
        // This automatically gets each element without managing index
        
        // TODO: Use enhanced for loop to print each item
        // Syntax: for (String item : inventory)
        int _________________ = 1;
        for (String _________________ : _________________) {
            System.out.println("  " + count + ". " + item);
            count++;
        }
        
        System.out.println("\n--- Summary ---");
        // TODO: Print total items in inventory using .size()
        System.out.println("Total items in inventory: " + inventory._________________());
        
        // ============================================
        // PART 9: Clearing ArrayList
        // ============================================
        
        // .clear() removes ALL elements from ArrayList
        // The ArrayList remains, but becomes empty
        
        System.out.print("\nClear inventory? (yes/no): ");
        String response = scanner.nextLine();
        
        if (response.equalsIgnoreCase("yes")) {
            // TODO: Clear all items using .clear()
            inventory._________________();
            System.out.println("✗ Inventory cleared!");
            System.out.println("Items remaining: " + inventory.size());
        }
        
        System.out.println("\n========================================");
        System.out.println("         Thanks for Playing!");
        System.out.println("========================================");
        
        scanner.close();
    }
}

// ============================================
// KEY ARRAYLIST METHODS REFERENCE
// ============================================
/*
 * ArrayList Methods:
 * 
 * .add(E element)           - Add element to end of list
 * .add(int index, E element)- Add element at specific index
 * .get(int index)           - Get element at index
 * .remove(int index)        - Remove element at index
 * .remove(Object o)         - Remove first occurrence of object
 * .contains(Object o)       - Check if list contains object (returns boolean)
 * .size()                   - Get number of elements
 * .clear()                  - Remove all elements
 * .isEmpty()                - Check if list is empty (returns boolean)
 * .indexOf(Object o)        - Get index of first occurrence (-1 if not found)
 * .set(int index, E element)- Replace element at index with new element
 * 
 * Why ArrayList over Array?
 * ✓ Dynamic size (grows/shrinks automatically)
 * ✓ Built-in methods (.add(), .remove(), .contains(), etc.)
 * ✓ More flexible for real-world applications
 * ✓ Part of Collections Framework
 * 
 * ArrayList vs Array:
 * Array:     fixed size, faster, lower memory, type[] name = new type[size]
 * ArrayList: dynamic, slower, more memory, ArrayList<type> name = new ArrayList<>()
 */
