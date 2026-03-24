import java.util.*;

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddOnServiceManager manager = new AddOnServiceManager();

        // Sample reservation ID (from previous use case)
        System.out.print("Enter Reservation ID: ");
        String reservationId = sc.nextLine();

        while (true) {
            System.out.println("\nSelect Add-On Service:");
            System.out.println("1. Breakfast (₹500)");
            System.out.println("2. Airport Pickup (₹1000)");
            System.out.println("3. Extra Bed (₹800)");
            System.out.println("4. Done");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.addService(reservationId, new AddOnService("Breakfast", 500));
                    break;
                case 2:
                    manager.addService(reservationId, new AddOnService("Airport Pickup", 1000));
                    break;
                case 3:
                    manager.addService(reservationId, new AddOnService("Extra Bed", 800));
                    break;
                case 4:
                    System.out.println("Service selection completed.");
                    displaySummary(manager, reservationId);
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void displaySummary(AddOnServiceManager manager, String reservationId) {
        System.out.println("\nSelected Services:");

        List<AddOnService> services = manager.getServices(reservationId);

        for (AddOnService s : services) {
            System.out.println("- " + s);
        }

        double total = manager.calculateTotalCost(reservationId);
        System.out.println("Total Add-On Cost: ₹" + total);
    }
}