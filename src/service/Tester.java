package service;

import model.Customer;
import model.Reservation;
import model.Room;
import model.RoomType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tester {

    public static void main(String[] args){

        CustomerService.addCustomer("fred", "smith", "smith@smith.com");
        CustomerService.addCustomer("Marty", "McFly","times@out.com");
        CustomerService.addCustomer("Doc", "Brown", "Fux@capacitor.com");

//        System.out.println(CustomerService.getCustomer("smith@smith.com"));

//        System.out.println( CustomerService.getAllCustomers() );
//////////////////////////////////////////////////////////////////////////////////////////////


        Room room1 = new Room ("123", 99d, RoomType.SINGLE);
        Room room2 = new Room ("234", 150d, RoomType.DOUBLE);
        Room room3 = new Room ("345", 105d, RoomType.SINGLE);

        ReservationService.addRoom(room1);
        ReservationService.addRoom(room2);
        ReservationService.addRoom(room3);

//        System.out.println(ReservationService.getARoom("234"));
//        System.out.println("Scott try this should get null " + ReservationService.getARoom("239"));

        Customer customer1 = new Customer("Fred", "Jones", "machine@mystery.com");
        Customer customer2 = new Customer("Daphne", "Blake", "zoink@mystery.com");
        Customer customer3 = new Customer("Velma", "Dinkley", "jinkies@mystery.com");

        // Setting Dates
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 8);
        Date checkInDate1 = calendar.getTime();
        calendar.set(Calendar.DATE, 10);
        Date checkOutDate1 = calendar.getTime();
        calendar.set(Calendar.DATE, 12);
        Date checkInDate2 = calendar.getTime();
        calendar.set(Calendar.DATE, 20);
        Date checkOutDate2 = calendar.getTime();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 13);
        Date checkInDate3 = calendar.getTime();
        calendar.set(Calendar.DATE, 17);
        Date checkOutDate3 = calendar.getTime();


//        int scott = calendar.get(Calendar.MONTH);
//        System.out.println("Scott " + scott);


        ReservationService.reserveARoom(customer1, room1, checkInDate1, checkOutDate1);
        ReservationService.reserveARoom(customer2, room2, checkInDate2, checkOutDate2);
        ReservationService.reserveARoom(customer3, room3, checkInDate3, checkOutDate3);

//        System.out.println(ReservationService.getCustomersReservation(customer1));
//        ReservationService.printAllReservations();

        // Need to work on findRooms
        // With reservations this did find the appropriate rooms available...
        System.out.println(ReservationService.findRooms(checkInDate1, checkOutDate1));

    }

}
