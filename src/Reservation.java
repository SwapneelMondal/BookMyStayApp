import java.io.Serializable;

/**
 * ============================================================
 * CLASS - Reservation
 * ============================================================
 * Represents a guest booking request.
 * Supports:
 * 1. Concurrency (used by multiple threads safely)
 * 2. Persistence (Serializable for file storage)
 *
 * @version 6.0 (Thread-Compatible + Persistent)
 */
public class Reservation implements Serializable {

    // Recommended for Serializable classes
    private static final long serialVersionUID = 1L;

    private String reservationId;
    private String guestName;
    private String roomType;

    /**
     * Constructor to initialize reservation
     */
    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    /**
     * Get Reservation ID
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * Get Guest Name
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Get Room Type
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Display reservation details
     */
    public void displayReservation() {
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Guest Name   : " + guestName);
        System.out.println("Room Type    : " + roomType);
        System.out.println("-----------------------------");
    }

    /**
     * Override toString() for easy printing
     */
    @Override
    public String toString() {
        return reservationId + " | " + guestName + " | " + roomType;
    }
}