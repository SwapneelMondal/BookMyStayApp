import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * CLASS - BookingRequestQueue
 * ============================================================
 * Stores booking requests in FIFO order.
 *
 * @version 5.0
 */

public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    // View queue
    public void displayQueue() {
        System.out.println("\nCurrent Booking Request Queue:\n");

        if (requestQueue.isEmpty()) {
            System.out.println("No pending booking requests.");
            return;
        }

        for (Reservation r : requestQueue) {
            r.displayReservation();
        }
    }
}