package model;

import java.lang.String;
import java.lang.Double;
import java.util.Date;
import java.util.Calendar;

public class Tester {

    public static void main(String[] args) {
        // make 2 dates
        // Calendar has after(), before(), and clear() methods
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        // Month seems to start at index 0 like an array
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 8);
        Date checkInDateTest = calendar.getTime();
        calendar.set(Calendar.DATE, 10);
        Date checkOutDateTest = calendar.getTime();

        Room roomTest = new Room ("12345", 99.99d, RoomType.SINGLE);
        Customer customer = new Customer("John", "Connar", "terminator@aol.com");
        FreeRoom freeRoom = new FreeRoom("0000", RoomType.DOUBLE);
        Reservation reservation = new Reservation(customer, roomTest, checkInDateTest, checkOutDateTest);


//        System.out.println(roomTest.toString());
//        System.out.println(customer.toString());
//        System.out.println(freeRoom.toString());
//        System.out.println(reservation.toString());
//        System.out.println(reservation.getCheckInDate());
//        System.out.println(reservation.getCheckOutDate());

    }

}
