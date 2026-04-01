import java.io.*;
import java.util.List;

public class PersistenceService {

    private static final String FILE_NAME = "hotel_data.ser";

    /**
     * Save system state to file
     */
    public void save(RoomInventory inventory, List<Reservation> bookings) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(bookings);

            System.out.println("✅ Data saved successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    /**
     * Load system state from file
     */
    public Object[] load() {

        File file = new File(FILE_NAME);

        // Handle missing file (VERY IMPORTANT)
        if (!file.exists()) {
            System.out.println("⚠ No previous data found. Starting fresh.");
            return null;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) ois.readObject();
            List<Reservation> bookings = (List<Reservation>) ois.readObject();

            System.out.println("✅ Data loaded successfully!");

            return new Object[]{inventory, bookings};

        } catch (Exception e) {
            System.out.println("❌ Error loading data (corrupted file). Starting fresh.");
            return null;
        }
    }
}