package Services;

import Classes.Customer;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CustomerService extends UserService
{
    private Map<String , Customer> customerList = new TreeMap<>();

    public Customer getCustomerList(String Username) {
        return customerList.get(Username);
    }

    public Map<String, Customer> getCustomerList() {
        return customerList;
    }

    public void createCustomer()
    {
        Customer customer = new Customer();
        if(!readUser(customer))
            System.out.println("WARNING  Username already exists");
        else
            readCustomer(customer);
    }
    public void readCustomer(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Lastname: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("ADDRESS: ");
        System.out.println("Road Name: ");
        customer.getAdress().setRoad_name(scanner.nextLine());
        System.out.println("Building number: ");
        customer.getAdress().setBlNr(scanner.nextLine());
        System.out.println("Apartment number: ");
        customer.getAdress().setApNr(scanner.nextLine());
        customerList.put(customer.getUsername() ,customer);
    }

    public void changePassword(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Password: ");
        String password = scanner.nextLine();
        customer.setPassword(password);
    }

    public void changeAdress(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Road Name: ");
        customer.getAdress().setRoad_name(scanner.nextLine());
        System.out.println("Building number: ");
        customer.getAdress().setBlNr(scanner.nextLine());
        System.out.println("Apartment number: ");
        customer.getAdress().setApNr(scanner.nextLine());
    }

    public void orderSomething(OrderService orderservice, String Customer, CourierService couriserervice, AdministratorService administratorservice, RestaurantService restaurantService)
    {
        orderservice.createOrder(Customer, couriserervice, administratorservice, restaurantService);
    }
}
