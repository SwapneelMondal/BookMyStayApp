public class UseCase5BookingRequestQueue /**
 * ============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ============================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Demonstrates booking request intake using Queue.
 *
 * @version 5.1
 */

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("========== Booking Request Queue ==========\n");

        // Initialize booking request queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guest booking requests
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queue
        bookingQueue.displayQueue();

        System.out.println("\nAll requests stored in FIFO order.");
        System.out.println("No inventory changes performed.");
    }
}{
}
