package model;


public class FreeRoom extends Room{

    // Constructor
    public FreeRoom(String roomNumber, RoomType enumeration ){
        super(roomNumber, 0d, enumeration);

    }

    // Methods
    // do we want getters and setters on this class?

    // Override
    @Override
    public String toString() {
        return "Free Room";
    };

}

