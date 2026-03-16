import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 * Manages centralized room availability using HashMap.
 *
 * @version 3.0
 */
public class RoomInventory {

    // Centralized inventory storage
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
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /**
     * Get current availability
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Update availability
     */
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    /**
     * Display entire inventory
     */
    public void displayInventory() {

        System.out.println("Current Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}