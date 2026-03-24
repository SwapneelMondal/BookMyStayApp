/**
 * ============================================================
 * CLASS - Reservation
 * ============================================================
 * Represents a guest booking request.
 *
 * @version 7.0
 */

public class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;
    private String status; // ✅ NEW (UC10)

    // ✅ New constructor (recommended)
    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.status = "CONFIRMED"; // default status
    }

    // ✅ Old constructor (backward compatibility)
    public Reservation(String guestName, String roomType) {
        this.reservationId = "R" + System.currentTimeMillis();
        this.guestName = guestName;
        this.roomType = roomType;
        this.status = "CONFIRMED"; // default status
    }

    // ✅ Getters
    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getStatus() {
        return status;
    }

    // ✅ Setter for status (used in cancellation)
    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Display method
    public void displayReservation() {
        System.out.println("Reservation ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room: " + roomType +
                " | Status: " + status);
    }

    // ✅ toString for reporting (UC8 + UC10)
    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room Type: " + roomType +
                ", Status: " + status;
    }
}