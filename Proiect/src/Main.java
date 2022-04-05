import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        UserService userService = new UserService();
        AdministratorService administratorService = new AdministratorService();
        CustomerService customerService = new CustomerService();
        CourierService courierService = new CourierService();
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();

        restaurantService.CreateRestaurant();
        restaurantService.CreateRestaurant();

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int option;
        while(run)
        {
            option = Options();
            if(option == 1)
            {
                customerService.CreateCustomer();
            }
            if(option == 2)
            {
                courierService.CreateCourier();
            }
            if(option == 3)
            {
                administratorService.CreateAdministrator();
            }
            if(option == 4)
            {
                System.out.println("Write the Username of the Customer that wants to order something");
                administratorService.ShowAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                customerService.OrderSomething(orderService, customer, courierService, administratorService, restaurantService);
            }
            if(option == 5)
            {
                System.out.println("Write the Username of the Customer you want to change the password");
                administratorService.ShowAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                customerService.ChangePassword(customerService.getCustomer_list(customer));
            }
            if(option == 6)
            {
                System.out.println("Write the Username of the Customer you want to change the address");
                administratorService.ShowAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                customerService.ChangeAdress(customerService.getCustomer_list(customer));
            }
            if(option == 7)
            {
                administratorService.ShowAllCustomers(customerService);
            }
            if(option == 8)
            {
                administratorService.ShowAllCouriers(courierService);
            }
            if(option == 9)
            {
                administratorService.ShowAllOrders(orderService);
            }
            if(option == 10)
            {
                administratorService.ShowAllRestaurants(restaurantService);
            }
            if(option == 11)
            {
                System.out.println("Write the Username of the Customer you want to delete");
                administratorService.ShowAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                administratorService.DeleteCustomer(customerService, customer);
            }
            if(option == 12)
            {
                System.out.println("Write the Name of the Restaurant you want to delete");
                administratorService.ShowAllRestaurantsName(restaurantService);
                String customer = scanner.nextLine();
                administratorService.DeleteRestaurant(restaurantService, customer);
            }
            if(option == 13)
            {
                administratorService.AddRestaurant(restaurantService);
            }
            if(option == 100)
                run=false;
        }
    }
    public static int Options()
    {
        System.out.println("Type 100 end program");
        System.out.println("Type 1 to create a Customer");
        System.out.println("Type 2 to create a Courier");
        System.out.println("Type 3 to create a Administrator");
        System.out.println("Type 4 to make a Order");
        System.out.println("Type 5 to change a Customer password");
        System.out.println("Type 6 to change a Customer address");
        System.out.println("Type 7 to show all Customers");
        System.out.println("Type 8 to show all Couriers");
        System.out.println("Type 9 to show all Orders");
        System.out.println("Type 10 to show all Restaurant");
        System.out.println("Type 11 to remove a Customer");
        System.out.println("Type 12 to remove a Restaurant");
        System.out.println("Type 13 to create a new Restaurant");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}
