import Services.*;
import Services.Repository.UserRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserRepository userRepository = new UserRepository();
        AdministratorService administratorService = new AdministratorService();
        CustomerService customerService = new CustomerService();
        CourierService courierService = new CourierService();
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();

        customerService.readCustomerFromFile();
        courierService.readCourierFromFile();
        administratorService.readAdministratorFromFile();
        restaurantService.readRestaurantsFromFile();

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int option;
        while (run) {
            option = Options();
            if (option == 1) {
                customerService.createCustomer();
            }
            if (option == 2) {
                courierService.createCourier();
            }
            if (option == 3) {
                administratorService.createAdministrator();
            }
            if (option == 4) {
                System.out.println("Write the Username of the Customer that wants to order something");
                administratorService.showAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                customerService.orderSomething(orderService, customer, courierService, administratorService, restaurantService);
            }
            if (option == 5) {
                System.out.println("Write the Username of the Customer you want to change the password");
                administratorService.showAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                customerService.changePassword(customerService.getCustomerList(customer));
            }
            if (option == 6) {
                System.out.println("Write the Username of the Customer you want to change the address");
                administratorService.showAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                customerService.changeAdress(customerService.getCustomerList(customer));
            }
            if (option == 7) {
                administratorService.showAllCustomers(customerService);
            }
            if (option == 8) {
                administratorService.showAllCouriers(courierService);
            }
            if (option == 9) {
                administratorService.showAllOrders(orderService);
            }
            if (option == 10) {
                administratorService.showAllRestaurants(restaurantService);
            }
            if (option == 11) {
                System.out.println("Write the Username of the Customer you want to delete");
                administratorService.showAllCustomersUsername(customerService);
                String customer = scanner.nextLine();
                administratorService.deleteCustomer(customerService, customer);
            }
            if (option == 12) {
                System.out.println("Write the Name of the Restaurant you want to delete");
                administratorService.showAllRestaurantsName(restaurantService);
                String customer = scanner.nextLine();
                administratorService.deleteRestaurant(restaurantService, customer);
            }
            if (option == 13) {
                administratorService.addRestaurant(restaurantService);
            }
            //-------------------------------------------------------------------

            if(option == 14){
                userRepository.createTable();
            }
            if(option == 15){
                userService.createUser();
            }
            if(option == 16){
                System.out.println("Type the id");
                int id = scanner.nextInt();
                userRepository.getUserById(id);
            }
            if(option == 17){
                userRepository.showUsers();
            }
            if(option == 18){
                System.out.println("Type the new password");
                String password = scanner.nextLine();
                System.out.println("Type the id");
                int id = scanner.nextInt();
                userRepository.updateUserPassword(password,id);
            }
            if(option == 19){
                System.out.println("Type the id");
                int id = scanner.nextInt();
                userRepository.deleteRow(id);
            }


            if (option == 100)
                run = false;
        }
        customerService.writeCustomerInFiles();
        courierService.writeCourierInFiles();
        administratorService.writeAdministratorInFiles();
        restaurantService.writeRestaurantInFiles();
    }



    public static int Options() {
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

        System.out.println("The following commands are using the mysql database");

        System.out.println("Type 14 to create user table");
        System.out.println("Type 15 to insert user in database");
        System.out.println("Type 16 to show user from database by id");
        System.out.println("Type 17 to show all users from database");
        System.out.println("Type 18 to update password of a user in database");
        System.out.println("Type 19 to delete user by id from database");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}