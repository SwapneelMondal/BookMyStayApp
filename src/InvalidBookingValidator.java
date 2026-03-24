import java.util.*;

public class InvalidBookingValidator {

    // Allowed room types
    private static final Set<String> VALID_ROOM_TYPES = new HashSet<>(
            Arrays.asList("Single Room", "Double Room", "Suite Room")
    );

    // Validate reservation input
    public static void validateReservation(Reservation reservation) throws InvalidBookingException {

        // Null check
        if (reservation == null) {
            throw new InvalidBookingException("Reservation cannot be null.");
        }

        // Guest name validation
        if (reservation.getGuestName() == null || reservation.getGuestName().trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Room type validation
        if (!VALID_ROOM_TYPES.contains(reservation.getRoomType())) {
            throw new InvalidBookingException(
                    "Invalid room type: " + reservation.getRoomType()
            );
        }
    }

    // Validate inventory before allocation
    public static void validateInventory(int availableRooms) throws InvalidBookingException {
        if (availableRooms <= 0) {
            throw new InvalidBookingException("No rooms available for booking.");
        }
    }
}