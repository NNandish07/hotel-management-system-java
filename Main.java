import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        hotel.addRoom(101, "Single");
        hotel.addRoom(102, "Double");
        hotel.addRoom(103, "Single");
        hotel.addRoom(104, "Double");

        String fileName = "hotel_data.ser";

        try {
            hotel.loadFromFile(fileName);
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }

        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Display available rooms");
            System.out.println("4. Search guest by name");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int checkInRoom = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    hotel.checkIn(checkInRoom, guestName);
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int checkOutRoom = scanner.nextInt();
                    hotel.checkOut(checkOutRoom);
                    break;

                case 3:
                    hotel.displayAvailableRooms();
                    break;

                case 4:
                    System.out.print("Enter guest name: ");
                    String searchName = scanner.nextLine();
                    hotel.searchGuest(searchName);
                    break;

                case 5:
                    try {
                        hotel.saveToFile(fileName);
                    } catch (Exception e) {
                        System.out.println("Error saving data.");
                    }
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}