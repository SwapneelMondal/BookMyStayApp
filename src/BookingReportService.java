import java.util.*;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Display all bookings
    public void displayAllBookings() {
        List<Reservation> list = history.getAllReservations();

        if (list.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("\n=== Booking History ===");
        for (Reservation r : list) {
            System.out.println(r);
        }
    }

    // Generate summary report
    public void generateSummary() {
        List<Reservation> list = history.getAllReservations();

        System.out.println("\n=== Booking Summary Report ===");
        System.out.println("Total Bookings: " + list.size());

        // Example: count by room type
        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : list) {
            String type = r.getRoomType(); // make sure this exists
            roomTypeCount.put(type, roomTypeCount.getOrDefault(type, 0) + 1);
        }

        System.out.println("Bookings by Room Type:");
        for (String type : roomTypeCount.keySet()) {
            System.out.println(type + " : " + roomTypeCount.get(type));
        }
    }
}