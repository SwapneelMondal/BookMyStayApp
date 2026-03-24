/**
 * ============================================================
 * CLASS - Reservation
 * ============================================================
 * Represents a guest booking request.
 *
 * @version 6.0
 */

public class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;

    // ✅ New constructor (recommended)
    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // ✅ Old constructor (backward compatibility - FIXES YOUR ERROR)
    public Reservation(String guestName, String roomType) {
        this.reservationId = "R" + System.currentTimeMillis(); // auto-generate ID
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Reservation ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room: " + roomType);
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room Type: " + roomType;
    }
}