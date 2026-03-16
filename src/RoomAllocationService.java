import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RoomAllocationService {

    private HashMap<String, Set<String>> allocatedRooms;

    public RoomAllocationService() {
        allocatedRooms = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            System.out.println("No available rooms for " + reservation.getGuestName());
            return;
        }

        // Generate unique room ID
        String roomId = roomType.replace(" ", "") + "-" + (available);

        // Ensure map entry exists
        allocatedRooms.putIfAbsent(roomType, new HashSet<>());

        Set<String> assignedRooms = allocatedRooms.get(roomType);

        // Prevent duplicate room IDs
        if (assignedRooms.contains(roomId)) {
            System.out.println("Duplicate room allocation prevented.");
            return;
        }

        assignedRooms.add(roomId);

        // Update inventory
        inventory.updateAvailability(roomType, available - 1);

        System.out.println("Reservation Confirmed:");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + roomType);
        System.out.println("Room ID: " + roomId);
        System.out.println();
    }
}