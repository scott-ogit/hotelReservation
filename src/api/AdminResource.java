package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;


public class AdminResource {

    public static Customer getCustomer(String email){ return CustomerService.getCustomer(email); }

    // Udacity calls for a List, but I like this as a Map
    public static void addRoom(IRoom room){ ReservationService.addRoom(room); }

    public static Collection<IRoom> getAllRooms(){ return ReservationService.getAllRooms(); }

    public static Collection<Customer> getAllCustomers(){ return CustomerService.getAllCustomers(); }

    public static Collection<Reservation> displayAllReservations(){
        return ReservationService.getListOfReservations();
    }

}
