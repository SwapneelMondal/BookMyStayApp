import java.util.LinkedList;
import java.util.Queue;

public class UseCase11CurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("\n=== Use Case 11: Concurrent Booking Simulation ===\n");

        // Shared resources
        Queue<Reservation> bookingQueue = new LinkedList<>();
        RoomInventory inventory = new RoomInventory();

        // Initialize inventory
        inventory.addRoomType(
                "Single", 2);
        inventory.addRoomType("Double", 1);

        // Add booking requests
        bookingQueue.add(new Reservation("R1", "Alice", "Single"));
        bookingQueue.add(new Reservation("R2", "Bob", "Single"));
        bookingQueue.add(new Reservation("R3", "Charlie", "Single"));
        bookingQueue.add(new Reservation("R4", "David", "Double"));

        // Create processor
        ConcurrentBookingProcessor processor =
                new ConcurrentBookingProcessor(bookingQueue, inventory);

        // Create threads (multiple guests)
        Thread t1 = new Thread(new GuessBookingTask(processor), "Thread-1");
        Thread t2 = new Thread(new GuessBookingTask(processor), "Thread-2");
        Thread t3 = new Thread(new GuessBookingTask(processor), "Thread-3");
        Thread t4 = new Thread(new GuessBookingTask(processor), "Thread-4");

        // Start threads (CONCURRENT EXECUTION)
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Simulation Complete ===");
    }
}