/**
 * ============================================================
 * MAIN CLASS - UseCase4InventorySetup
 * ============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates read-only access to centralized inventory
 * so guests can view available rooms without modifying state.
 *
 * @version 4.1
 */

public class UseCase4InventorySetup {

    /**
     * Application entry point
     */
    public static void main(String[] args) {

        System.out.println("========== Room Search & Availability ==========\n");

        // Create room domain objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Register room availability
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 0); // Example: unavailable

        System.out.println("Guest searching for available rooms...\n");

        // Read availability (NO updates here)
        int singleAvailable = inventory.getAvailability("Single Room");
        int doubleAvailable = inventory.getAvailability("Double Room");
        int suiteAvailable = inventory.getAvailability("Suite Room");

        // Display only available rooms

        if (singleAvailable > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails(singleAvailable);
            System.out.println();
        }

        if (doubleAvailable > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails(doubleAvailable);
            System.out.println();
        }

        if (suiteAvailable > 0) {
            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails(suiteAvailable);
            System.out.println();
        }

        // Defensive check
        if (singleAvailable == 0 && doubleAvailable == 0 && suiteAvailable == 0) {
            System.out.println("No rooms available at the moment.");
        }

        System.out.println("\nSearch completed. Inventory state unchanged.");
    }
}