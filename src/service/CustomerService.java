package service;

import model.Customer;
import java.util.*;

public class CustomerService {

    static Map<String, Customer> mapOfCustomers = new HashMap<String, Customer>();
    static Collection<Customer> listOfCustomers = new ArrayList<Customer>();

    public static void addCustomer(String firstName, String lastName, String email){
        Customer customerToAdd = new Customer(firstName, lastName, email);
        listOfCustomers.add(customerToAdd);
        mapOfCustomers.put(email, customerToAdd);
    }

    public static Customer getCustomer(String customerEmail){
        return mapOfCustomers.get(customerEmail);
    }


    public static Collection<Customer> getAllCustomers(){

        return mapOfCustomers.values();

    }



}
