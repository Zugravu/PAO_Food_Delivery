import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CustomerService extends UserService
{
    private Map<String ,Customer> customer_list = new TreeMap<String ,Customer>();

    public Customer getCustomer_list(String Username) {
        return customer_list.get(Username);
    }

    public Map<String, Customer> getCustomer_list() {
        return customer_list;
    }

    public void CreateCustomer()
    {
        Customer customer = new Customer();
        if(!ReadUser(customer))
            System.out.println("WARNING  Username already exists");
        else
            ReadCustomer(customer);
    }
    public void ReadCustomer(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        customer.setFirst_name(scanner.nextLine());
        System.out.println("Lastname: ");
        customer.setLast_name(scanner.nextLine());
        System.out.println("ADDRESS: ");
        System.out.println("Road Name: ");
        customer.address.setRoad_name(scanner.nextLine());
        System.out.println("Building number: ");
        customer.address.setBl_nr(scanner.nextLine());
        System.out.println("Apartment number: ");
        customer.address.setAp_nr(scanner.nextLine());
        customer_list.put(customer.getUsername() ,customer);
    }

    public void ChangePassword(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Password: ");
        String password = scanner.nextLine();
        customer.setPassword(password);
    }

    public void ChangeAdress(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Road Name: ");
        customer.address.setRoad_name(scanner.nextLine());
        System.out.println("Building number: ");
        customer.address.setBl_nr(scanner.nextLine());
        System.out.println("Apartment number: ");
        customer.address.setAp_nr(scanner.nextLine());
    }

    public void OrderSomething(OrderService orderservice, String Customer, CourierService couriserervice, AdministratorService administratorservice, RestaurantService restaurantService)
    {
        orderservice.CreateOrder(Customer, couriserervice, administratorservice, restaurantService);
    }
}
