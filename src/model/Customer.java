package model;

import java.lang.Override;
import java.lang.String;
import java.lang.Boolean;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Customer {

    // variables
    private String firstName;
    private String lastName;
    private String email;

    // Constructor
    public Customer(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        // add a regex to check email and throw exception if invalid
        String emailRegex = "^(.+)@(.+).com$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is not valid");
        }

    }

    // Methods
    // Getters
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getEmail(){ return email; }
    // Setters these were not given in docs to do...
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setEmail(String email){ this.email = email; }

    //Override
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ": " + this.email;
    }


}
