import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 * Manages centralized room availability using HashMap.
 * Supports:
 * 1. Thread-safe operations (Concurrency)
 * 2. Data persistence (Serialization)
 *
 * @version 5.0 (Thread-Safe + Persistent)
 */
public class RoomInventory implements Serializable {

    // Recommended for Serializable classes
    private static final long serialVersionUID = 1L;

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
        inventory.put(roomType, inventory.getOrDefault(roomType, 0) + count);
    }

    /**
     * Get current availability
     */
    public synchronized int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Update availability manually
     */
    public synchronized void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    /**
     * ✅ CRITICAL METHOD (Use Case 11)
     * Thread-safe room allocation
     */
    public synchronized boolean allocateRoom(String roomType) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            inventory.put(roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " allocated 1 " + roomType +
                    " room. Remaining: " + (available - 1));

            return true;
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED to allocate " + roomType +
                    " (No rooms available)");

            return false;
        }
    }

    /**
     * (Optional) Release room back to inventory
     */
    public synchronized void releaseRoom(String roomType) {

        int available = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, available + 1);

        System.out.println("Room released: " + roomType +
                " | New Count: " + (available + 1));
    }

    /**
     * Display entire inventory
     */
    public synchronized void displayInventory() {

        System.out.println("\n=== Current Inventory ===");

        if (inventory.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}