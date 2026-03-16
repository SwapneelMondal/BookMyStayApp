/**
 * UseCase1HotelBookingApp
 *
 * This class represents the entry point of the Hotel Booking Management System.
 * It demonstrates how a Java application starts execution using the main() method
 * and prints a welcome message along with the application name and version.
 *
 * @author Swapneel Mondal
 * @version 1.0
 */
public class Main {

    /**
     * The main method is the starting point of the Java application.
     * The JVM invokes this method when the program is executed.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Printing welcome message to the console
        System.out.println("=====================================");
        System.out.println("   Welcome to Hotel Booking System   ");
        System.out.println("        Version: v1.0                ");
        System.out.println("=====================================");

        // Inform user that the application started successfully
        System.out.println("Application started successfully.");

        // Application ends after displaying the welcome message
        System.out.println("Thank you for using the system!");

        // ================================
        // Use Case 2: Room Initialization
        // ================================

        System.out.println("\nHotel Room Initialization\n");

        // Creating room objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display Single Room
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails(singleAvailable);
        System.out.println();

        // Display Double Room
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails(doubleAvailable);
        System.out.println();

        // Display Suite Room
        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails(suiteAvailable);
    }
}


/**
 * ============================================================
 * ABSTRACT CLASS - Room
 * ============================================================
 * Represents a generalized room type in the hotel.
 * Defines common properties shared by all room types.
 *
 * @version 2.1
 */
abstract class Room {

    protected int beds;
    protected int size;
    protected double price;

    /**
     * Constructor to initialize room attributes
     */
    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    /**
     * Displays room details and availability
     */
    public void displayRoomDetails(int availability) {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + availability);
    }
}


/**
 * ============================================================
 * CLASS - SingleRoom
 * ============================================================
 * Represents a single room in the hotel.
 *
 * @version 2.1
 */
class SingleRoom extends Room {

    /**
     * Initializes a SingleRoom with predefined attributes
     */
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


/**
 * ============================================================
 * CLASS - DoubleRoom
 * ============================================================
 * Represents a double room in the hotel.
 *
 * @version 2.1
 */
class DoubleRoom extends Room {

    /**
     * Initializes a DoubleRoom with predefined attributes
     */
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


/**
 * ============================================================
 * CLASS - SuiteRoom
 * ============================================================
 * Represents a suite room in the hotel.
 *
 * @version 2.1
 */
class SuiteRoom extends Room {

    /**
     * Initializes a SuiteRoom with predefined attributes
     */
    public SuiteRoom() {
        super(3, 600, 5000.0);
    }
}