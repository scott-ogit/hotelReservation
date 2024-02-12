package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    static Collection<Reservation> listOfReservations = new ArrayList<Reservation>();
    static Map<String, IRoom> mapOfRooms = new HashMap<String, IRoom>();
    static Collection<IRoom> listOfRooms = new ArrayList<>();


    public static void addRoom(IRoom room){
        mapOfRooms.put(room.getRoomNumber(), room);
    }

    public static IRoom getARoom(String roomId){
        return mapOfRooms.get(roomId);
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

       Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
       listOfReservations.add(newReservation);

       return newReservation;

    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> availableRooms = new ArrayList<IRoom>();
        Collection<String> roomNumbers = new ArrayList<>();

        // this checks the reservation system for rooms being available.
        for (Reservation reservation: listOfReservations){

            IRoom room = reservation.getRoom();
            roomNumbers.add(room.getRoomNumber());


            Date reservedRoomCheckInDate = reservation.getCheckInDate();
            Date reservedRoomCheckOutDate = reservation.getCheckOutDate();

            // this checks the rooms that are in the reservation list to see if they are available for dates.
            if(checkOutDate.before(reservedRoomCheckInDate) || checkInDate.after(reservedRoomCheckOutDate)) {
                availableRooms.add(room);
            }

        }

        Collection<IRoom> listOfRooms = getAllRooms();

        for (IRoom room: listOfRooms){
            if( roomNumbers.contains(room.getRoomNumber()) ) {

            } else {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    public static Collection<Reservation> getCustomersReservation(Customer customer){

        Collection<Reservation> reservations = new ArrayList<>();

        for (Reservation reservation: listOfReservations){
            if (customer == reservation.getCustomer()){
                reservations.add(reservation);
            }
        }

        return reservations;

    }

    public static Collection<Reservation> getListOfReservations(){
        return listOfReservations;
    }

    public static void printAllReservations(){
        System.out.println(listOfReservations);
    }

    // Udacity does not have This as a Map so converting Map to List
    public static Collection<IRoom> getAllRooms() {
        listOfRooms.clear();
        listOfRooms.addAll(mapOfRooms.values());
        return listOfRooms;
    }


}
