package UI;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.*;

public class FindAndReserveRoomMenu {

    public static void findAndReserveARoom(){

        boolean keepRunning = true;
        boolean runCheckInYear = true;
        boolean runCheckOutYear = true;
        boolean runCheckInMonth = true;
        boolean runCheckOutMonth = true;
        boolean runCheckInDay = true;
        boolean runCheckOutDay = true;
        boolean runValidRoom = true;

        try ( Scanner scanner = new Scanner(System.in) ){
            while(keepRunning){

                try{
                    Calendar checkInDate = Calendar.getInstance();
                    Calendar checkOutDate = Calendar.getInstance();
                    IRoom hotelRoom = new Room("0", 0d, RoomType.DOUBLE);
                    String customerEmail = "notAnEmail@nope.com";

                    // Who am I dealing with? Get Customer
                    try{
                        System.out.println("--------------------------------------");
                        System.out.println(" ");
                        System.out.println("What is your email?");
                        System.out.println(" ");
                        System.out.println("--------------------------------------");

                        String email = (scanner.nextLine());

                        // should be this
                        //
                        if( AdminResource.getCustomer(email) == null){
                            System.out.println("You are not an existing customer");
                            System.out.println("Please Create an account through the Main Menu");
                            System.out.println("--------------------------------------");
                            keepRunning = false;
                            runCheckInYear = false;
                            runCheckOutYear = false;
                            runCheckInMonth = false;
                            runCheckOutMonth = false;
                            runCheckInDay = false;
                            runCheckOutDay = false;
                            runValidRoom = false;
                            MainMenu.mainMenuUI();
                        } else{
                            customerEmail = email;
                            System.out.println("Welcome " + customerEmail );
                            System.out.println(" ");
                        }
                    } catch(Exception ex) {
                        System.out.println("Bloop Bleep Blop Customer not working " + ex);
                    }


                    // Check in Year
                    try{
                        while(runCheckInYear){

                            System.out.println("--------------------------------------");
                            System.out.println(" ");
                            System.out.println("What is the year of your check in date?");
                            System.out.println("1. 2024");
                            System.out.println("2. 2025");
                            System.out.println("--------------------------------------");

                            int selection = Integer.parseInt(scanner.nextLine());

                            if (selection == 1) {
                                checkInDate.set(Calendar.YEAR, 2024);
                                runCheckInYear = false;
                            }else if (selection == 2) {
                                checkInDate.set(Calendar.YEAR, 2025);
                                runCheckInYear = false;
                            } else{
                                System.out.println("Please Enter 1 or 2.");
                            }
                        }
                    } catch(Exception ex) {
                        System.out.println("Bloop Bleep Blop this is run check in year" + ex);
                    }

                    // Check In Month
                    try{
                        while(runCheckInMonth){
                            System.out.println(" ");
                            System.out.println("What Month would you like to check in?");
                            System.out.println("Enter a number between 1 and 12.");
                            System.out.println("----------------------------------");
                            int selection = Integer.parseInt(scanner.nextLine());

                            if(selection == 1){
                                checkInDate.set(Calendar.MONTH, 0);
                                runCheckInMonth = false;
                            } else if (selection == 2){
                                checkInDate.set(Calendar.MONTH, 1);
                                runCheckInMonth = false;
                            } else if (selection == 3){
                                checkInDate.set(Calendar.MONTH, 2);
                                runCheckInMonth = false;
                            } else if (selection == 4){
                                checkInDate.set(Calendar.MONTH, 3);
                                runCheckInMonth = false;
                            } else if (selection == 5){
                                checkInDate.set(Calendar.MONTH, 4);
                                runCheckInMonth = false;
                            } else if (selection == 6){
                                checkInDate.set(Calendar.MONTH, 5);
                                runCheckInMonth = false;
                            } else if (selection == 7){
                                checkInDate.set(Calendar.MONTH, 6);
                                runCheckInMonth = false;
                            } else if (selection == 8){
                                checkInDate.set(Calendar.MONTH, 7);
                                runCheckInMonth = false;
                            } else if (selection == 9){
                                checkInDate.set(Calendar.MONTH, 8);
                                runCheckInMonth = false;
                            } else if (selection == 10){
                                checkInDate.set(Calendar.MONTH, 9);
                                runCheckInMonth = false;
                            } else if (selection == 11){
                                checkInDate.set(Calendar.MONTH, 10);
                                runCheckInMonth = false;
                            } else if (selection == 12){
                                checkInDate.set(Calendar.MONTH, 11);
                                runCheckInMonth = false;
                            } else {
                                System.out.println("Please Enter A Number Between 1 and 12");
                                System.out.println(" ");
                            }
                        }

                    } catch(Exception ex) {
                        System.out.println("Bloop Bleep Blop this is runCheckInMonth" + ex);
                    }

                    // Check In Day
                    try{
                        while(runCheckInDay){
                            System.out.println(" ");
                            System.out.println("What Day would you like to check In?");
                            System.out.println("Enter a number.");
                            System.out.println("----------------------------------");
                            int day = Integer.parseInt(scanner.nextLine());

                            if(day <= checkInDate.getActualMaximum(Calendar.DATE)){
                                checkInDate.set(Calendar.DATE, day);
                                runCheckInDay = false;
                            } else {
                                System.out.println(day + " is not a valid date.");
                            }

                        }

                    } catch(Exception ex) {
                        System.out.println("Bloop Bleep Blop this is runCheckInDay " + ex);
                    }

                    System.out.println(" ");
                    System.out.println("Now Let's find a check Out date.");
                    System.out.println(" ");

                    // Check Out Year
                    if(checkInDate.get(Calendar.YEAR) == 2025){
                        System.out.println("Your check out year will be set to 2025");
                        checkOutDate.set(Calendar.YEAR, 2025);
                        runCheckOutYear = false;
                    } else {
                        try{
                            while(runCheckOutYear){

                                System.out.println("--------------------------------------");
                                System.out.println(" ");
                                System.out.println("What is the year of your check OUT date?");
                                System.out.println("1. 2024");
                                System.out.println("2. 2025");
                                System.out.println(" ");
                                System.out.println("--------------------------------------");

                                int selection = Integer.parseInt(scanner.nextLine());

                                if (selection == 1) {
                                    checkOutDate.set(Calendar.YEAR, 2024);
                                    runCheckOutYear = false;
                                } else if (selection == 2) {
                                    checkOutDate.set(Calendar.YEAR, 2025);
                                    runCheckOutYear = false;
                                } else {
                                    System.out.println("Please Enter 1 or 2.");
                                }
                            }
                        } catch(Exception ex) {
                            System.out.println("Bloop Bleep Blop this is runCheckoutYear " + ex);
                        }
                    }

                    // Check Out Month
                    try{
                        while(runCheckOutMonth){
                            System.out.println(" ");
                            System.out.println("What Month would you like to check Out?");
                            System.out.println("Enter a number between 1 and 12.");
                            System.out.println("----------------------------------");
                            int selection = Integer.parseInt(scanner.nextLine());


                            if(selection == 1){
                                checkOutDate.set(Calendar.MONTH, 0);
                            } else if (selection == 2){
                                checkOutDate.set(Calendar.MONTH, 1);
                            } else if (selection == 3){
                                checkOutDate.set(Calendar.MONTH, 2);
                            } else if (selection == 4){
                                checkOutDate.set(Calendar.MONTH, 3);
                            } else if (selection == 5){
                                checkOutDate.set(Calendar.MONTH, 4);
                            } else if (selection == 6){
                                checkOutDate.set(Calendar.MONTH, 5);
                            } else if (selection == 7){
                                checkOutDate.set(Calendar.MONTH, 6);
                            } else if (selection == 8){
                                checkOutDate.set(Calendar.MONTH, 7);
                            } else if (selection == 9){
                                checkOutDate.set(Calendar.MONTH, 8);
                            } else if (selection == 10){
                                checkOutDate.set(Calendar.MONTH, 9);
                            } else if (selection == 11){
                                checkOutDate.set(Calendar.MONTH, 10);
                            } else if (selection == 12){
                                checkOutDate.set(Calendar.MONTH, 11);
                            } else {
                                System.out.println("Please Enter A Number Between 1 and 12");
                                System.out.println(" ");
                            }


                            if(
                                    (checkInDate.get(Calendar.MONTH) <= checkOutDate.get(Calendar.MONTH) && checkInDate.get(Calendar.YEAR) == checkOutDate.get(Calendar.YEAR) ) ||
                                    checkInDate.get(Calendar.YEAR) < checkOutDate.get(Calendar.YEAR)
                            )
                            {
                                runCheckOutMonth = false;
                            } else {
                                System.out.println("The Check Out Month Cannot Be Before The Check In Month");
                            }

                        }

                    } catch(Exception ex) {
                        System.out.println("Bloop Bleep Blop this is runCheckOutMonth" + ex);
                    }


                    // Check Out Day
                    try{
                        while(runCheckOutDay){
                            System.out.println(" ");
                            System.out.println("What Day would you like to check Out?");
                            System.out.println("Enter a number.");
                            System.out.println("----------------------------------");
                            int day = Integer.parseInt(scanner.nextLine());

                            if( day <= checkInDate.getActualMaximum(Calendar.DATE) ){
                                checkOutDate.set(Calendar.DATE, day);
                                boolean inIsBeforeOut = checkInDate.before(checkOutDate);

                                if(inIsBeforeOut){
                                    runCheckOutDay = false;
                                }
                            } else {
                                System.out.println(day + " is not a valid date.");
                            }

                        }

                    } catch(Exception ex) {
                        System.out.println("Bloop Bleep Blop this is runCheckOutDay" + ex);
                    }

                    Date checkIn = checkInDate.getTime();
                    Date checkOut = checkOutDate.getTime();
                    Collection<IRoom> availableRooms = HotelResource.findARoom(checkIn, checkOut);

                    if (availableRooms.toArray().length == 0){
                        System.out.println("There are no available rooms for your Trip dates");
                        System.out.println(" ");
                    } else {

                        System.out.println("Based on your dates");
                        System.out.println("these rooms are available");
                        System.out.println(" ");
                        System.out.println(HotelResource.findARoom(checkIn, checkOut));

                        try{

                            while(runValidRoom){
                                System.out.println(" ");
                                System.out.println("What room would you like to reserve?");
                                System.out.println("Enter room number only.");
                                System.out.println("-------------------------------------");
                                String roomNumber = (scanner.nextLine());

                                for(IRoom room: availableRooms){
                                    if(room.getRoomNumber().equals(roomNumber)){
                                        hotelRoom = HotelResource.getRoom(roomNumber);
                                        runValidRoom = false;
                                    }
                                }
                                HotelResource.bookARoom(customerEmail, hotelRoom, checkIn, checkOut);
                            }

                        } catch(Exception ex) {
                            System.out.println("Bloop Bleep Blop this is runValidRoom" + ex);
                        }

                    }

                    keepRunning = false;
                    MainMenu.mainMenuUI();

                } catch(Exception ex){
                    System.out.println("Bloop Bleep Blop after keep running but everything else " + ex);
                }
            }
        } catch (Exception ex){
            System.out.println("Does not Compute! " + ex);
        }


    }

}