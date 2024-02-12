package model;

import java.lang.String;
import java.lang.Double;

public class Room implements IRoom {

    // variables
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration){
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    // Should these be Override???
    public String getRoomNumber() {
        return roomNumber;
    }

    public Double getRoomPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return enumeration;
    }

    // change later just did true for now
    public boolean isFree() {
        return this.price == 0;
    }

    @Override
    public String toString() {
      return "Room Number: " + this.roomNumber + " | Type " + this.enumeration + " | Price: " + this.price;
    };

}
