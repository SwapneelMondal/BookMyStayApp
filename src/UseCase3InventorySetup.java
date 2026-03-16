/**
 * ============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates replacing scattered availability variables
 * with a centralized HashMap-based inventory system.
 *
 * @version 3.1
 */

public class UseCase3InventorySetup {

    /**
     * Application entry point
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("========== Centralized Room Inventory System ==========\n");

        // Create room objects (domain models)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 2);

        // Display room details with inventory
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails(inventory.getAvailability("Single Room"));
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails(inventory.getAvailability("Double Room"));
        System.out.println();

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails(inventory.getAvailability("Suite Room"));
        System.out.println();

        // Show centralized inventory
        inventory.displayInventory();

        // Update availability example
        System.out.println("\nUpdating inventory after booking a Single Room...\n");

        int updated = inventory.getAvailability("Single Room") - 1;
        inventory.updateAvailability("Single Room", updated);

        inventory.displayInventory();
    }
}