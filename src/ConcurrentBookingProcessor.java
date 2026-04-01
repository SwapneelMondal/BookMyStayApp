import java.util.Queue;

public class ConcurrentBookingProcessor {

    private final Queue<Reservation> bookingQueue;
    private final RoomInventory inventory;

    public ConcurrentBookingProcessor(Queue<Reservation> bookingQueue, RoomInventory inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
    }

    // Thread-safe method
    public synchronized void processBooking() {
        if (bookingQueue.isEmpty()) {
            return;
        }

        Reservation request = bookingQueue.poll();

        if (request != null) {
            System.out.println(Thread.currentThread().getName() +
                    " processing booking for " + request.getGuestName());

            // Critical Section (VERY IMPORTANT)
            synchronized (inventory) {
                boolean allocated = inventory.allocateRoom(request.getRoomType());

                if (allocated) {
                    System.out.println("✅ Room allocated to " + request.getGuestName());
                } else {
                    System.out.println("❌ No room available for " + request.getGuestName());
                }
            }
        }
    }
}