import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 * Manages centralized room availability using HashMap.
 * Now supports thread-safe operations for concurrent booking.
 *
 * @version 4.0 (Thread-Safe)
 */
public class RoomInventory {

    // Centralized inventory storage (shared resource)
    private HashMap<String, Integer> inventory;

    /**
     * Constructor initializes the inventory map
     */
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    /**
     * Register a room type with availability
     */
    public synchronized void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /**
     * Get current availability
     */
    public synchronized int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Update availability
     */
    public synchronized void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    /**
     * ✅ NEW METHOD: Thread-safe room allocation
     * This is the CRITICAL SECTION for concurrency
     */
    public synchronized boolean allocateRoom(String roomType) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            inventory.put(roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " allocated 1 " + roomType + " room. Remaining: " + (available - 1));

            return true;
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED to allocate " + roomType + " (No rooms left)");

            return false;
        }
    }

    /**
     * Display entire inventory
     */
    public synchronized void displayInventory() {

        System.out.println("\nCurrent Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}