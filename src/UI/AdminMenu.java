package UI;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class AdminMenu {

    public static void adminMenuUI(){

        boolean keepRunning = true;

        try ( Scanner scanner = new Scanner(System.in) ){
            while(keepRunning){
                try{
                    System.out.println(" ");
                    System.out.println("Administration Menu");
                    System.out.println("--------------------------------------");
                    System.out.println("1. See All Customers");
                    System.out.println("2. See All Rooms");
                    System.out.println("3. See All Reservations");
                    System.out.println("4. Add A Room");
                    System.out.println("5. Back To Main Menu");
                    System.out.println("--------------------------------------");

                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        System.out.println(AdminResource.getAllCustomers());
                        System.out.println(" ");
                    }else if (selection == 2) {
                        System.out.println(AdminResource.getAllRooms());
                        System.out.println(" ");
                    }else if (selection == 3){
                        System.out.println(AdminResource.displayAllReservations());
                        System.out.println(" ");
                    }else if (selection == 4){
                       keepRunning = false;
                       addARoom();
                    }else if (selection == 5){
                        keepRunning = false;
                        MainMenu.mainMenuUI();
                    }else if (selection == 9){
                        System.out.println("Number 9");
                        System.out.println("Number 9");
                        System.out.println("Spinning up rooms and customers");
                        System.out.println("---------------------------------");
                        System.out.println(" ");
                        initializeData();
                    }else{
                        System.out.println("Please Enter A Number Between 1 and 5");
                    }
                } catch(Exception ex){
                    System.out.println("Bloop Bleep Blop " + ex);
                }
            }
        } catch (Exception ex){
            System.out.println("Does not Compute! " + ex);
        }
    }

    public static void addARoom(){
        boolean keepRunning = true;

        try ( Scanner scanner = new Scanner(System.in) ){
            while(keepRunning){
                String roomNumber = "";
                RoomType roomType = null;
                Double dailyRate = null;
                boolean isValidRoomNumber = false;
                boolean isValidRoomType = false;
                boolean isValidDailyRate = false;

                // Get roomNumber    could contain letters. 1A.
                while(!isValidRoomNumber){
                    System.out.println("Enter New Room Number");
                    roomNumber = (scanner.nextLine());

                    if(HotelResource.getRoom(roomNumber) == null){
                        isValidRoomNumber = true;
                    } else {
                        System.out.println("This room number already exists.");
                    }
                }

                // Get roomType: SINGLE DOUBLE
                while(!isValidRoomType){
                    System.out.println("Is the room a single or a double? Enter 1 or 2.");
                    System.out.println("1. Single");
                    System.out.println("2. Double");

                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        roomType = RoomType.SINGLE;
                        isValidRoomType = true;
                    }else if (selection == 2) {
                        roomType = RoomType.DOUBLE;
                        isValidRoomType = true;
                    }else{
                        System.out.println("Please Enter A Number Between 1 and 2");
                    }
                }

                while(!isValidDailyRate){
                    System.out.println("What is the daily rate? Enter a number only.");
                    System.out.println("Or enter 0 if the room is free.");

                    String input = (scanner.nextLine());
                    boolean isNumericInput = isNumeric(input);

                    if(isNumericInput){
                        dailyRate = Double.parseDouble(input);
                        isValidDailyRate = true;
                    } else {
                        System.out.println("You entered " + input);
                        System.out.println(input + " is not a number.");
                    }
                }

                IRoom room = new Room (roomNumber, dailyRate, roomType);
                AdminResource.addRoom(room);

                System.out.println("New Room Successfully Created.");
                System.out.println(room);
                System.out.println(" ");
                keepRunning = false;
                adminMenuUI();
            }
        } catch (Exception ex){
            System.out.println("Does not Compute! in addARoom " + ex);
        }
    }

    // add reservations to this
    public static void initializeData(){

        // add Customers
        api.HotelResource.createACustomer("Marty", "McFly","calvinklein@timesout.com");
        api.HotelResource.createACustomer("Emmitt", "Brown","doc@greatscott.com");
        api.HotelResource.createACustomer("Biff", "Tannen","bufford@maddog.com");

        // add rooms
        Room room1 = new Room ("123", 99d, RoomType.SINGLE);
        Room room2 = new Room ("234", 150d, RoomType.DOUBLE);
        Room room3 = new Room ("345", 105d, RoomType.SINGLE);

        api.AdminResource.addRoom(room1);
        api.AdminResource.addRoom(room2);
        api.AdminResource.addRoom(room3);

        // Setting Dates for reservations
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DATE, 3);
        Date checkInDate1 = calendar.getTime();
        calendar.set(Calendar.DATE, 10);
        Date checkOutDate1 = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DATE, 12);
        Date checkInDate2 = calendar.getTime();
        calendar.set(Calendar.DATE, 20);
        Date checkOutDate2 = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DATE, 23);
        Date checkInDate3 = calendar.getTime();
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 17);
        Date checkOutDate3 = calendar.getTime();

        // add reservations
        api.HotelResource.bookARoom("bufford@maddog.com", room1, checkInDate1, checkOutDate1 );
        api.HotelResource.bookARoom("calvinklein@timesout.com", room2, checkInDate2, checkOutDate2 );
        api.HotelResource.bookARoom("doc@greatscott.com", room3, checkInDate3, checkOutDate3 );
        api.HotelResource.bookARoom("doc@greatscott.com", room3, checkInDate2, checkOutDate2 );
    }

    public static boolean isNumeric(String stringToCheck) {
        try {
            Double.parseDouble(stringToCheck);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
