/**
 * ============================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.1
 */

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("========== Room Allocation Service ==========\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Double Room", 1);
        inventory.addRoomType("Suite Room", 1);

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Single Room"));

        // Allocation service
        RoomAllocationService allocator = new RoomAllocationService();

        // Process queue
        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.getNextRequest();

            allocator.allocateRoom(request, inventory);
        }

        System.out.println("All booking requests processed.");
    }
}