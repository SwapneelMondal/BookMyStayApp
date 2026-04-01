import java.util.ArrayList;
import java.util.List;

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("\n=== Use Case 12: Data Persistence & Recovery ===\n");

        PersistenceService service = new PersistenceService();

        RoomInventory inventory;
        List<Reservation> bookings;

        // 🔄 LOAD EXISTING DATA
        Object[] data = service.load();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            bookings = (List<Reservation>) data[1];
        } else {
            // 🆕 Fresh start
            inventory = new RoomInventory();
            bookings = new ArrayList<>();

            inventory.addRoomType("Single", 2);
            inventory.addRoomType("Double", 1);

            bookings.add(new Reservation("R1", "Alice", "Single"));
            bookings.add(new Reservation("R2", "Bob", "Double"));
        }

        // 🖨 Show current state
        inventory.displayInventory();

        System.out.println("\nBookings:");
        for (Reservation r : bookings) {
            System.out.println(r.getReservationId() + " - " +
                    r.getGuestName() + " - " + r.getRoomType());
        }

        // 💾 SAVE STATE BEFORE EXIT
        service.save(inventory, bookings);

        System.out.println("\n=== System Ready (State Persisted) ===");
    }
}