package Services;

import Classes.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdministratorService extends UserService {
    private Map<String, Administrator> administratorList = new HashMap<>();

    public Administrator getAdministratorList(String Username) {
        return administratorList.get(Username);
    }

    public void createAdministrator() {
        Administrator administrator = new Administrator();
        if (!readUser(administrator))
            System.out.println("WARNING  Username already exists");
        else
            readAdministrator(administrator);
    }

    public void readAdministrator(Administrator administrator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        administrator.setFirstName(scanner.nextLine());
        System.out.println("Lastname: ");
        administrator.setLastName(scanner.nextLine());
        administratorList.put(administrator.getUsername(), administrator);
    }

    public void readAdministratorFromFile()
    {
        String path = "src/Files/Administrator.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while((line = br.readLine()) != null){
                Administrator administrator = new Administrator();
                String[] values = line.split(",");
                administrator.setUsername(values[0]);
                administrator.setPassword(values[1]);
                administrator.setEmail(values[2]);
                administrator.setFirstName(values[3]);
                administrator.setLastName(values[4]);
                administratorList.put(administrator.getUsername() ,administrator);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAdministratorInFiles()
    {
        String filepath = "src/Files/Administrator.csv";
        try {
            FileWriter fw = new FileWriter(filepath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("username" + "," + "password" + "," + "email" + "," + "firstName" + "," + "lastName");
            for (Map.Entry<String, Administrator> entry : administratorList.entrySet()) {
                pw.println(entry.getValue().getUsername()+","+entry.getValue().getPassword()+","+entry.getValue().getEmail()+","+entry.getValue().getFirstName()+","+entry.getValue().getLastName());

            }
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void changePassword(Administrator administrator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Password: ");
        String password = scanner.nextLine();
        administrator.setPassword(password);
    }

    public void showAllCustomers(CustomerService customerservice) {
        System.out.println("All Customers");
        for (Map.Entry<String, Customer> entry : customerservice.getCustomerList().entrySet()) {
            System.out.println(entry.getValue());
            System.out.println("\n");
        }
    }

    public void showAllCustomersUsername(CustomerService customerservice) {
        System.out.println("All Customers Username");
        for (Map.Entry<String, Customer> entry : customerservice.getCustomerList().entrySet()) {
            System.out.println(entry.getValue().getUsername());
        }
    }

    public void showAllCouriersUsernameAvailable(CourierService courierservice) {
        System.out.println("All Couriers Username Available");
        for (Map.Entry<String, Courier> entry : courierservice.getCourierList().entrySet()) {
            if (!entry.getValue().getBusy())
                System.out.println(entry.getValue().getUsername());
        }
    }

    public void showAllCouriers(CourierService courierservice) {
        System.out.println("All Couriers");
        for (Map.Entry<String, Courier> entry : courierservice.getCourierList().entrySet()) {
            System.out.println(entry.getValue());
            System.out.println("\n");
        }
    }

    public void deleteCustomer(CustomerService customerservice, String Username) {
        if (customerservice.getCustomerList(Username) != null) {
            customerservice.getCustomerList().remove(Username);
            System.out.println("The Customer has been deleted successfully");
        } else {
            System.out.println("Can't delete User because there is no User with this Username");
        }
    }

    public void deleteCourier(CourierService courierservice, String Username) {
        if (courierservice.getCourierList(Username) != null) {
            courierservice.getCourierList().remove(Username);
            System.out.println("The Courier has been deleted successfully");
        } else {
            System.out.println("Can't delete User because there is no User with this Username");
        }
    }

    public void showAllRestaurants(RestaurantService restaurantservice) {
        for (Map.Entry<String, Restaurant> entry : restaurantservice.getRestaurantList().entrySet()) {
            System.out.println(entry.getValue());
            System.out.println("\n");
        }
    }

    public void showAllRestaurantsName(RestaurantService restaurantservice) {
        for (Map.Entry<String, Restaurant> entry : restaurantservice.getRestaurantList().entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void addRestaurant(RestaurantService restaurantservice)
    {
        restaurantservice.createRestaurant();
    }

    public void deleteRestaurant(RestaurantService restaurantservice, String RestaurantName)
    {
        if(restaurantservice.getRestaurantList(RestaurantName)!=null)
        {
            restaurantservice.getRestaurantList().remove(RestaurantName);
            System.out.println("The Restaurant has been deleted successfully");
        }
        else
        {
            System.out.println("Can't delete Restaurant because there is no Restaurant with this Name");
        }
    }

    public void showAllOrders(OrderService orderservice)
    {
        System.out.println("All Orders");
        for(Map.Entry<Integer, Order> entry : orderservice.getOrderList().entrySet())
        {
            System.out.println("ID: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}