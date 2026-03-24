public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("=== Use Case 9: Error Handling & Validation ===");

        // ✅ Valid booking
        try {
            Reservation r1 = new Reservation("R201", "Swanee", "Single Room");

            InvalidBookingValidator.validateReservation(r1);
            InvalidBookingValidator.validateInventory(2);

            System.out.println("Booking successful:");
            r1.displayReservation();

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ❌ Invalid room type
        try {
            Reservation r2 = new Reservation("R202", "Rahul", "Luxury Room");

            InvalidBookingValidator.validateReservation(r2);

            System.out.println("Booking successful:");
            r2.displayReservation();

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ❌ Invalid inventory
        try {
            Reservation r3 = new Reservation("R203", "Amit", "Double Room");

            InvalidBookingValidator.validateReservation(r3);
            InvalidBookingValidator.validateInventory(0); // No rooms

            System.out.println("Booking successful:");
            r3.displayReservation();

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nSystem is still running safely after errors ✅");
    }
}