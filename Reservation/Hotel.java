import java.util.ArrayList;
import java.util.Arrays;

/**
 * Creates an ArrayList waitLlist to put the people that are waiting for a room in,
 * gets the rooms and the people that are in them and places people into a room there
 * is a room open, and into the waitList if there is not one open.
 * Canels a room if requsted to and puts anybody waiting in the waitList into it if needed.
 *
 * @Nathan
 * @v1
 */
public class Hotel
{
    /**
     * each element corresponds to a room in the hotel
     * if rooms[index] is null, the room is empty;
     * otherwise, it contains a reference to the Rservation for that
     * room, such that rooms[index].getRoomNumber() returns index
     */
    private Reservation[] rooms;
    /**
     * contains names of guests who have not yet been
     * assigned a room because all rooms are full
     */
    private ArrayList waitList;
    
    /**
     * A constructer which initializes the Reservation[] array
     * and waitList ArrayList.
     */
    public Hotel(int numRooms) {
        this.rooms = new Reservation[numRooms];
        this.waitList = new ArrayList<String>();
    }
    
    /**
     * Made so that reservation objects can pass along to the cancelAndreassign method.
     * @return returns the array of Reservations
     */
    public Reservation[] getRooms() {
        return rooms;
    }
    
    /**
     * if there are any empty rooms (rooms wtih no reservation), then create a reservation
     * for an empty room for the specified guest and return the new Reservation;
     * otherwise, add the guest to the end of waitList and return null
     * @return returns the new Reservation if empty rooms
     * @return returns null if no empty room
     */
    public Reservation requestRoom(String guestName) {
        for (int i=0; i<rooms.length; i++) {
            if (rooms[i] == null) {
                rooms[i] = new Reservation(guestName, i); 
                return rooms[i];
            }
        }
        waitList.add(guestName);
        return null;
    }
    
    /**
     * release the room associated with parameter res, effectively canceling the reservation;
     * if any names are stored in waitList, remove the first name and create a Reservation
     * for this person in the room reserved by res; return that new Reservation;
     * if waitList is empty, mark the room specified by res as empty and return null
     * @precondition: res is a valid reservation for some room in this hotel
     * @return returns the new reservation or return null if there is no new reservation
     */
    public Reservation cancelAndReassign(Reservation res) {
        int roomNum = res.getRoomNumber();
        if (waitList.size()>0) {
            rooms[roomNum] = new Reservation((String)waitList.get(0), roomNum);
            waitList.remove(0);
        } else
            rooms[roomNum] = null;
        return rooms[roomNum];
    }
    
    public String toString() {
        return Arrays.toString(rooms) + "\n" + waitList;
    }
}
