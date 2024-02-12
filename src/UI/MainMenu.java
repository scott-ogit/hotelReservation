package UI;

import api.AdminResource;
import api.HotelResource;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {

    public static void mainMenuUI(){

        boolean keepRunning = true;

        try ( Scanner scanner = new Scanner(System.in) ){
            while(keepRunning){
                try{
//
                    System.out.println("Main Menu");
                    System.out.println("--------------------------------------");
                    System.out.println("1. Find And Reserve A Room");
                    System.out.println("2. See My Reservations");
                    System.out.println("3. Create An Account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("---------------------------------------");

                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        keepRunning = false;
                        FindAndReserveRoomMenu.findAndReserveARoom();
                    }else if (selection == 2) {
                        keepRunning = false;
                        findMyReservations();
                    }else if (selection == 3){
                        keepRunning = false;
                        createAccount();
                    }else if (selection == 4){
                        keepRunning = false;
                        AdminMenu.adminMenuUI();
                    }else if (selection == 5){
                        System.out.println("Good-Bye");
                        keepRunning = false;
                    }else{
                        System.out.println("Please Enter A Number Between 1 and 5");
                    }

                } catch(Exception ex){
                    System.out.println("Bloop Bleep Blop Main Menu selections " + ex);
                }
            }
        } catch (Exception ex){
            System.out.println("Does not Compute! Main Menu " + ex);
        }
    }


    public static void createAccount(){
        boolean keepRunning = true;

        try ( Scanner scanner = new Scanner(System.in) ){
            while(keepRunning){
                try{

                    // Get Email
                    System.out.println("Enter Email Format: name@domain.com");
                    String email = (scanner.nextLine());

                    String emailRegex = "^(.+)@(.+).com$";
                    Pattern pattern = Pattern.compile(emailRegex);
                    boolean isEmail = email.equals("0") || pattern.matcher(email).matches();

                    while (!isEmail) {
                        System.out.println("Pay attention to the email format and Try again, or enter 0 to return to Main Menu");
                        email = (scanner.nextLine());
                        if (pattern.matcher(email).matches() || email.equals("0")){
                            isEmail = true;
                        }
                    }

                    if(HotelResource.getCustomer(email) != null){
                        System.out.println("That email is already in our system.");
                        email = "0";
                    }

                    // escape entry if user no longer wants to enter an email.
                    if (!email.equals("0")) {

                        // Get First Name
                        System.out.println("Enter First Name");
                        String firstName = (scanner.nextLine());

                        // Get Last Name
                        System.out.println("Enter Last Name");
                        String lastName = (scanner.nextLine());

                        HotelResource.createACustomer(firstName, lastName, email);

                        System.out.println(" ");
                        System.out.println("Welcome " + firstName + " " + lastName + "! You are our newest customer!");
                        System.out.println(" ");
                    }
                    keepRunning = false;
                    mainMenuUI();

                } catch(Exception ex){
                    System.out.println("Bloop Bleep Blop in createAccount " + ex);
                }
            }
        } catch (Exception ex){
            System.out.println("Does not Compute! " + ex);
        }
    }

    public static void findMyReservations(){

        try ( Scanner scanner = new Scanner(System.in) ){
            try{
                System.out.println("--------------------------------------");
                System.out.println(" ");
                System.out.println("What is your email?");
                System.out.println(" ");
                System.out.println("--------------------------------------");

                String email = (scanner.nextLine());

                if( AdminResource.getCustomer(email) == null){
                    System.out.println(" ");
                    System.out.println("You are not an existing customer");
                    System.out.println("Please Create an account through the Main Menu");
                    System.out.println(" ");
                    System.out.println(" ");
                } else{
                    System.out.println( HotelResource.getCustomersReservations(email));
                    System.out.println(" ");
                }

                mainMenuUI();

            } catch(Exception ex) {
                System.out.println("Bloop Bleep Blop Customer not working " + ex);
            }
        } catch (Exception ex){
            System.out.println("Does not Compute! " + ex);
        }
    }

}
