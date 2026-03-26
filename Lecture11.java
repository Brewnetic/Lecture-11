// ============================================
// LECTURE 11: Collections Framework & ArrayList
// Gaming Inventory System
// ============================================

// Import ArrayList from java.util
// The full path is java.util.ArrayList
// java.util is the package, ArrayList is the class inside it
// Rule: always import before the class declaration
import java.util.ArrayList;
import java.util.Scanner;

public class Lecture11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   GAMING INVENTORY MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        // ============================================
        // PART 1: Creating an ArrayList for Game Items
        // ============================================

        // Breaking this down piece by piece:
        //
        //   ArrayList<String>   — the TYPE of variable being declared
        //                         <String> is the generic type parameter
        //                         this means the list will ONLY hold String objects
        //
        //   inventory           — the variable name (follows the same naming rules as any variable)
        //
        //   =                   — assignment operator
        //
        //   new ArrayList<>()   — creates a new, empty ArrayList object
        //                         the <> on the right (diamond operator) is left empty
        //                         because Java already knows the type from the left side
        //
        // KEY DIFFERENCE FROM ARRAYS:
        //   Array:     String[] inventory = new String[10];   // must declare size upfront
        //   ArrayList: ArrayList<String> inventory = new ArrayList<>();  // no size needed!
        //
        // The ArrayList starts completely empty and grows automatically as items are added.

        ArrayList<String> inventory = new ArrayList<>();

        System.out.println("--- Creating Your Gaming Inventory ---\n");

        // ============================================
        // PART 2: Adding Items to ArrayList using .add()
        // ============================================

        // .add(element) appends the element to the END of the list
        //
        // After each .add(), here is what the list looks like:
        //   After add("Legendary Sword"):    ["Legendary Sword"]
        //   After add("Health Potion"):      ["Legendary Sword", "Health Potion"]
        //   After add("Dragon Scale Armor"): ["Legendary Sword", "Health Potion", "Dragon Scale Armor"]
        //
        // The list automatically resizes — no index management needed.
        // Internally, ArrayList doubles its capacity when full, but this is invisible to you.

        inventory.add("Legendary Sword");
        inventory.add("Health Potion");
        inventory.add("Dragon Scale Armor");

        System.out.println("✓ Added 3 items to your inventory\n");

        // ============================================
        // PART 3: Displaying All Items (Loop through ArrayList)
        // ============================================

        System.out.println("--- Your Current Inventory ---");

        // .size() returns the current number of elements in the list as an int
        //
        // COMMON MISTAKE — do NOT confuse these two:
        //   Arrays:    myArray.length    — no parentheses, it is a field (property)
        //   ArrayList: myList.size()     — parentheses required, it is a method call
        //
        // At this point inventory.size() returns 3

        System.out.println("Total Items: " + inventory.size());

        // A traditional for loop is used here (not for-each) because the index i
        // is needed to display numbering: "1.", "2.", "3." etc.
        //
        // .get(index) retrieves the element at the given index
        //
        // IMPORTANT — ArrayList uses ZERO-BASED indexing, just like arrays:
        //   inventory.get(0) → "Legendary Sword"    (first item)
        //   inventory.get(1) → "Health Potion"      (second item)
        //   inventory.get(2) → "Dragon Scale Armor" (third item)
        //
        // The loop runs: i = 0, 1, 2  (i < 3, since size is 3)
        // The display shows: (i+1) = 1, 2, 3 — offset by 1 so it reads naturally

        System.out.println("\nInventory List:");
        for (int i = 0; i < inventory.size(); i++) {
            String item = inventory.get(i);
            System.out.println("  " + (i + 1) + ". " + item);
        }

        System.out.println();

        // ============================================
        // PART 4: Adding Items Dynamically (User Input)
        // ============================================

        System.out.print("How many new items do you want to collect? ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Clear buffer — required after nextInt() before nextLine()

        // WHY scanner.nextLine() after nextInt()?
        // nextInt() reads the number but leaves the newline character '\n' in the buffer.
        // The next nextLine() call would immediately read that leftover '\n' as an empty string.
        // Calling scanner.nextLine() once right after nextInt() discards that leftover character.

        System.out.println("\n--- Collecting New Items ---");

        // The loop variable is named i (standard convention for index counters)
        // The loop runs exactly numItems times — once per new item the user wants to add
        // Inside the loop:
        //   - scanner.nextLine() reads a full line of text (the item name)
        //   - inventory.add(newItem) appends it to the end of the list
        //
        // Because ArrayList is dynamic, there is no concern about running out of space —
        // the list expands automatically with each .add() call.

        for (int i = 0; i < numItems; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            String newItem = scanner.nextLine();
            inventory.add(newItem);
        }

        System.out.println();

        // ============================================
        // PART 5: Using .contains()
        // ============================================

        System.out.println("--- Inventory Operations ---");

        // .contains(object) scans the list and returns:
        //   true  — if the object is found anywhere in the list
        //   false — if it is not found
        //
        // The search uses .equals() internally, so String comparison is case-sensitive:
        //   "Health Potion"  → found   ✓
        //   "health potion"  → NOT found  ✗
        //
        // "Health Potion" was added in Part 2, so this will print the ✓ message.
        // "Fire Spell" was never added, so this will print the ✗ message.
        //
        // .contains() does NOT tell you WHERE the item is — only whether it exists.
        // To find the index, use .indexOf(object) instead (returns -1 if not found).

        if (inventory.contains("Health Potion")) {
            System.out.println("✓ Health Potion found in inventory!");
        } else {
            System.out.println("✗ Health Potion not found.");
        }

        if (inventory.contains("Fire Spell")) {
            System.out.println("✓ Fire Spell found in inventory!");
        } else {
            System.out.println("✗ Fire Spell not found in inventory.");
        }

        System.out.println();

        // ============================================
        // PART 6: Accessing Elements with .get()
        // ============================================

        System.out.println("--- Item Details ---");

        // .get(index) retrieves the element at the given index WITHOUT removing it
        //
        // WHY check inventory.size() > 0 first?
        //   Calling .get() on an empty list throws an IndexOutOfBoundsException.
        //   Always guard .get() calls with a size check when the list could be empty.
        //
        // GETTING THE LAST ELEMENT:
        //   inventory.get(inventory.size() - 1)
        //   If there are 5 items, valid indices are 0–4.
        //   inventory.size() returns 5, so size - 1 = 4 = the last valid index.
        //   This pattern works regardless of how many items are in the list.

        if (inventory.size() > 0) {
            String firstItem = inventory.get(0);
            System.out.println("First item: " + firstItem);
        }

        if (inventory.size() > 1) {
            String secondItem = inventory.get(1);
            System.out.println("Second item: " + secondItem);
        }

        if (inventory.size() > 0) {
            String lastItem = inventory.get(inventory.size() - 1);
            System.out.println("Last item: " + lastItem);
        }

        System.out.println();

        // ============================================
        // PART 7: Removing Items using .remove()
        // ============================================

        System.out.println("--- Removing Items ---");

        // .remove(int index) does two things:
        //   1. Removes the element at the given index
        //   2. Returns the removed element (so it can be stored/printed)
        //
        // WHAT HAPPENS TO THE REST OF THE LIST after removal?
        //   All elements AFTER the removed index shift LEFT by one position to fill the gap.
        //
        //   Before: ["Legendary Sword", "Health Potion", "Dragon Scale Armor"]
        //            index 0              index 1          index 2
        //
        //   After remove(0):
        //           ["Health Potion", "Dragon Scale Armor"]
        //            index 0           index 1
        //
        // IMPORTANT — there are TWO versions of .remove():
        //   .remove(int index)   — removes by position
        //   .remove(Object o)    — removes by value (first match found)
        //   For a list of Strings, Java uses .remove(int) when given a number.

        if (inventory.size() > 0) {
            String removed = inventory.remove(0);
            System.out.println("✗ Removed: " + removed);
        }

        System.out.println("Remaining items: " + inventory.size() + "\n");

        // ============================================
        // PART 8: Using Enhanced For-Each Loop
        // ============================================

        System.out.println("--- Final Inventory (Enhanced Loop) ---");

        // The enhanced for-each loop is a simpler way to iterate through a collection
        // when the index is NOT needed.
        //
        // SYNTAX BREAKDOWN:
        //   for (String item : inventory)
        //         ------       ---------
        //         |            the collection being looped through
        //         the variable that holds each element on each iteration
        //
        // HOW IT WORKS:
        //   On each iteration, 'item' is automatically assigned the next element.
        //   The loop stops when all elements have been visited.
        //   No need to call .get(i) manually — the loop handles retrieval.
        //
        // WHEN TO USE WHICH LOOP:
        //   Traditional for loop  → when the index is needed (e.g., numbered display)
        //   Enhanced for-each     → when only the value matters (e.g., printing each item)
        //
        // A manual counter variable (count) is used here for display numbering
        // since the for-each loop does not provide an index automatically.

        int count = 1;
        for (String item : inventory) {
            System.out.println("  " + count + ". " + item);
            count++;
        }

        System.out.println("\n--- Summary ---");

        // .size() is called again here — the value reflects any removals made in Part 7
        System.out.println("Total items in inventory: " + inventory.size());

        // ============================================
        // PART 9: Clearing ArrayList
        // ============================================

        // .clear() removes ALL elements from the ArrayList in one call.
        //
        // IMPORTANT DISTINCTION:
        //   inventory.clear()   — empties the list, but the list STILL EXISTS
        //   inventory = null    — the variable no longer points to any list object
        //
        // After .clear():
        //   inventory.size()    → 0
        //   inventory.isEmpty() → true
        //   inventory itself    → still a valid, usable ArrayList (just empty)
        //
        // .clear() is more efficient than removing elements one by one in a loop.

        System.out.print("\nClear inventory? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            inventory.clear();
            System.out.println("✗ Inventory cleared!");
            System.out.println("Items remaining: " + inventory.size()); // prints 0
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
 * .add(E element)            - Add element to end of list
 * .add(int index, E element) - Insert element at specific index (shifts others right)
 * .get(int index)            - Get element at index (does NOT remove it)
 * .remove(int index)         - Remove element at index, returns the removed element
 * .remove(Object o)          - Remove first occurrence of object, returns boolean
 * .contains(Object o)        - Returns true if object exists in list, false otherwise
 * .size()                    - Returns current number of elements (NOT .length!)
 * .clear()                   - Removes all elements (list still exists, just empty)
 * .isEmpty()                 - Returns true if size is 0
 * .indexOf(Object o)         - Returns index of first occurrence, or -1 if not found
 * .set(int index, E element) - Replaces element at index with new element
 *
 * QUICK COMPARISON — ArrayList vs Array:
 *
 *   Feature         Array                        ArrayList
 *   -------         -----                        ---------
 *   Size            Fixed at creation            Grows/shrinks dynamically
 *   Declaration     String[] a = new String[5]   ArrayList<String> a = new ArrayList<>()
 *   Add element     a[i] = "value"               a.add("value")
 *   Get element     a[i]                         a.get(i)
 *   Get size        a.length  (field)            a.size()  (method — needs parentheses!)
 *   Remove element  Not built-in                 a.remove(index)
 *   Check contains  Manual loop                  a.contains(object)
 *   Works with      Primitives AND objects        Objects only (use wrapper for primitives)
 *
 * AUTOBOXING REMINDER (from L10):
 *   ArrayList<Integer> nums = new ArrayList<>();
 *   nums.add(42);        // Java automatically wraps 42 as Integer — this is autoboxing
 *   int x = nums.get(0); // Java automatically unwraps Integer back to int — this is unboxing
 */