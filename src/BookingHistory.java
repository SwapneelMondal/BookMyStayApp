import java.util.*;

public class BookingHistory {

    private List<Reservation> confirmedBookings;

    public BookingHistory() {
        confirmedBookings = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedBookings.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return confirmedBookings;
    }
}