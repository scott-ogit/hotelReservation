package model;

import java.util.Date;
import java.util.Calendar;
import java.lang.String;

public class Reservation {

    // Variables
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    // Constructor
    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        super();
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    //Other methods. getter setters...
    // getters
    public Customer getCustomer(){ return customer; }
    public IRoom getRoom(){ return room; }
    public Date getCheckInDate(){ return checkInDate; }
    public Date getCheckOutDate(){ return checkOutDate; }
    // Setters
    public void setCustomer(Customer customer){ this.customer = customer; }
    public void setRoom(IRoom room){ this.room = room; }
    public void setCheckInDate(Date checkInDate){ this.checkInDate = checkInDate; }
    public void setCheckOutDate(Date checkOutDate){ this.checkOutDate = checkOutDate; }

    // Override
    @Override
    public String toString(){
        return customer + " " + room + " " + checkInDate + " " + checkOutDate;
    }

}
