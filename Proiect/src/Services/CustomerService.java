package Services;

import Classes.Customer;

import java.io.*;
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

    public void readCustomerFromFile()
    {
        String path = "src/Files/Customers.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while((line = br.readLine()) != null){
                Customer customer = new Customer();
                String[] values = line.split(",");
                customer.setUsername(values[0]);
                customer.setPassword(values[1]);
                customer.setEmail(values[2]);
                customer.setFirstName(values[3]);
                customer.setLastName(values[4]);
                customer.getAdress().setRoad_name(values[5]);
                customer.getAdress().setBlNr(values[6]);
                customer.getAdress().setApNr(values[7]);
                customerList.put(customer.getUsername() ,customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCustomerInFiles()
    {
        String filepath = "src/Files/Customers.csv";
        try {
            FileWriter fw = new FileWriter(filepath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("username" + "," + "password" + "," + "email" + "," + "firstName" + "," + "lastName" + "," + "road_name" + "," + "blNr" + "," + "apNr");
            for (Map.Entry<String, Customer> entry : customerList.entrySet()) {
                pw.println(entry.getValue().getUsername()+","+entry.getValue().getPassword()+","+entry.getValue().getEmail()+","+entry.getValue().getFirstName()+","+entry.getValue().getLastName()+","+entry.getValue().getAdress().getRoad_name()+","+entry.getValue().getAdress().getBlNr()+","+entry.getValue().getAdress().getApNr());

            }
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

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
