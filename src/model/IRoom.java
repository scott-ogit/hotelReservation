package model;

import java.lang.Boolean;
import java.lang.Double;

public interface IRoom {

    // Methods
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();


}
