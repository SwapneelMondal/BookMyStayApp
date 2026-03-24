import java.util.*;

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Simulating confirmed bookings
        Reservation r1 = new Reservation("R101", "Swapneel", "Deluxe");
        Reservation r2 = new Reservation("R102", "Rahul", "Standard");
        Reservation r3 = new Reservation("R103", "Amit", "Deluxe");

        // Add to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Reporting
        BookingReportService reportService = new BookingReportService(history);

        reportService.displayAllBookings();
        reportService.generateSummary();
    }
}