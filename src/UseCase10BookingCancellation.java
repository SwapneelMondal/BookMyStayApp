import java.util.*;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("=== Use Case 10: Booking Cancellation & Rollback ===");

        // Simulated inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 1);

        // Reservation storage
        Map<String, Reservation> reservationMap = new HashMap<>();

        // Create bookings
        Reservation r1 = new Reservation("R301", "Alice", "Single Room");
        Reservation r2 = new Reservation("R302", "Bob", "Double Room");

        reservationMap.put(r1.getReservationId(), r1);
        reservationMap.put(r2.getReservationId(), r2);

        CancellationService cancellationService = new CancellationService();

        try {
            // ✅ Cancel valid booking
            cancellationService.cancelBooking("R301", reservationMap, inventory);

            // ❌ Try cancelling same again
            cancellationService.cancelBooking("R301", reservationMap, inventory);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // ❌ Cancel non-existent booking
            cancellationService.cancelBooking("R999", reservationMap, inventory);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Show rollback stack
        cancellationService.displayRollbackStack();

        // Show updated inventory
        System.out.println("\nUpdated Inventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }

        // Show reservation states
        System.out.println("\nReservation Status:");
        for (Reservation r : reservationMap.values()) {
            System.out.println(r);
        }
    }
}