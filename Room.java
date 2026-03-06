import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private String type; // "Single" or "Double"
    private boolean isOccupied;
    private String guestName;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isOccupied = false;
        this.guestName = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getGuestName() {
        return guestName;
    }

    public void checkIn(String guestName) {
        this.isOccupied = true;
        this.guestName = guestName;
    }

    public void checkOut() {
        this.isOccupied = false;
        this.guestName = null;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - " +
                (isOccupied ? "Occupied by " + guestName : "Available");
    }
}