import java.util.*;

public class CancellationService {

    private Stack<String> rollbackStack; // stores released room IDs

    public CancellationService() {
        rollbackStack = new Stack<>();
    }

    public void cancelBooking(String reservationId,
                              Map<String, Reservation> reservationMap,
                              Map<String, Integer> inventory)
            throws InvalidBookingException {

        // ✅ Validate existence
        if (!reservationMap.containsKey(reservationId)) {
            throw new InvalidBookingException("Reservation not found: " + reservationId);
        }

        Reservation reservation = reservationMap.get(reservationId);

        // ✅ Prevent double cancellation
        if (reservation.getStatus().equals("CANCELLED")) {
            throw new InvalidBookingException("Reservation already cancelled.");
        }

        String roomType = reservation.getRoomType();

        // ✅ Rollback logic (LIFO)
        rollbackStack.push(reservationId);

        // ✅ Restore inventory
        inventory.put(roomType, inventory.getOrDefault(roomType, 0) + 1);

        // ✅ Update status
        reservation.setStatus("CANCELLED");

        System.out.println("Booking cancelled successfully for ID: " + reservationId);
    }

    // View rollback stack
    public void displayRollbackStack() {
        System.out.println("\nRollback Stack (Recent Cancellations):");
        for (String id : rollbackStack) {
            System.out.println(id);
        }
    }
}