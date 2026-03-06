import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void addRoom(int roomNumber, String type) {
        rooms.add(new Room(roomNumber, type));
    }

    public void checkIn(int roomNumber, String guestName) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isOccupied()) {
                room.checkIn(guestName);
                System.out.println("Check-in successful!");
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }

    public void checkOut(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isOccupied()) {
                room.checkOut();
                System.out.println("Check-out successful!");
                return;
            }
        }
        System.out.println("Room is not occupied or does not exist.");
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println(room);
            }
        }
    }

    public void searchGuest(String guestName) {
        for (Room room : rooms) {
            if (guestName.equalsIgnoreCase(room.getGuestName())) {
                System.out.println("Guest " + guestName + " is in " + room);
                return;
            }
        }
        System.out.println("Guest not found.");
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(rooms);
            System.out.println("Data saved successfully.");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            rooms = (List<Room>) ois.readObject();
            System.out.println("Data loaded successfully.");
        }
    }
}