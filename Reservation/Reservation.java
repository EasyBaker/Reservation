import java.util.ArrayList;
import java.util.Arrays;

/**
 * Puts stuff in Reservation.
 *
 * @Nathan
 * @v1
 */
public class Reservation
{
    private String guestName;
    private int roomNumber;
    
    public Reservation(String guestName, int roomNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
    }
    
    public int getRoomNumber() {
        return this.roomNumber;
    }
    
    public String toString() {
        return guestName + " " + this.roomNumber;        
    }
}
