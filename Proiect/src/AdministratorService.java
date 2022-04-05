import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdministratorService extends UserService {
    private Map<String, Administrator> administrator_list = new HashMap<String, Administrator>();

    public Administrator getAdministrator_list(String Username) {
        return administrator_list.get(Username);
    }

    public void CreateAdministrator() {
        Administrator administrator = new Administrator();
        if (!ReadUser(administrator))
            System.out.println("WARNING  Username already exists");
        else
            ReadAdministrator(administrator);
    }

    public void ReadAdministrator(Administrator administrator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        administrator.setFirst_name(scanner.nextLine());
        System.out.println("Lastname: ");
        administrator.setLast_name(scanner.nextLine());
        administrator_list.put(administrator.getUsername(), administrator);
    }

    public void ChangePassword(Administrator administrator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Password: ");
        String password = scanner.nextLine();
        administrator.setPassword(password);
    }

    public void ShowAllCustomers(CustomerService customerservice) {
        System.out.println("All Customers");
        for (Map.Entry<String, Customer> entry : customerservice.getCustomer_list().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void ShowAllCustomersUsername(CustomerService customerservice) {
        System.out.println("All Customers Username");
        for (Map.Entry<String, Customer> entry : customerservice.getCustomer_list().entrySet()) {
            System.out.println(entry.getValue().getUsername());
        }
    }

    public void ShowAllCouriersUsernameAvailable(CourierService courierservice) {
        System.out.println("All Couriers Username Available");
        for (Map.Entry<String, Courier> entry : courierservice.getCourier_list().entrySet()) {
            if (!entry.getValue().getBusy())
                System.out.println(entry.getValue().getUsername());
        }
    }

    public void ShowAllCouriers(CourierService courierservice) {
        System.out.println("All Couriers");
        for (Map.Entry<String, Courier> entry : courierservice.getCourier_list().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void DeleteCustomer(CustomerService customerservice, String Username) {
        if (customerservice.getCustomer_list(Username) != null) {
            customerservice.getCustomer_list().remove(Username);
            System.out.println("The Customer has been deleted successfully");
        } else {
            System.out.println("Can't delete User because there is no User with this Username");
        }
    }

    public void DeleteCourier(CourierService courierservice, String Username) {
        if (courierservice.getCourier_list(Username) != null) {
            courierservice.getCourier_list().remove(Username);
            System.out.println("The Courier has been deleted successfully");
        } else {
            System.out.println("Can't delete User because there is no User with this Username");
        }
    }

    public void ShowAllRestaurants(RestaurantService restaurantservice) {
        for (Map.Entry<String, Restaurant> entry : restaurantservice.getRestaurant_list().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void ShowAllRestaurantsName(RestaurantService restaurantservice) {
        for (Map.Entry<String, Restaurant> entry : restaurantservice.getRestaurant_list().entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void AddRestaurant(RestaurantService restaurantservice)
    {
        restaurantservice.CreateRestaurant();
    }

    public void DeleteRestaurant(RestaurantService restaurantservice, String RestaurantName)
    {
        if(restaurantservice.getRestaurant_list(RestaurantName)!=null)
        {
            restaurantservice.getRestaurant_list().remove(RestaurantName);
            System.out.println("The CRestaurant has been deleted successfully");
        }
        else
        {
            System.out.println("Can't delete Restaurant because there is no Restaurant with this Name");
        }
    }

    public void ShowAllOrders(OrderService orderservice)
    {
        System.out.println("All Orders");
        for(Map.Entry<Integer, Order> entry : orderservice.getOrder_list().entrySet())
        {
            System.out.println("ID: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}