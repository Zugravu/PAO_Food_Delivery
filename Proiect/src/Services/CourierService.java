package Services;

import Classes.Courier;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourierService extends UserService
{
    protected Map<String , Courier> courierList = new HashMap<>();

    public Courier getCourierList(String Username) {
        return courierList.get(Username);
    }

    public Map<String, Courier> getCourierList() {
        return courierList;
    }

    public void createCourier()
    {
        Courier courier = new Courier();
        if(!readUser(courier))
            System.out.println("WARNING  Username already exists");
        else
            readCourier(courier);
    }

    public void readCourier(Courier courier)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        courier.setFirstName(scanner.nextLine());
        System.out.println("Lastname: ");
        courier.setLastName(scanner.nextLine());
        System.out.println("Vehicle: ");
        courier.setVehicle(scanner.nextLine());
        courierList.put(courier.getUsername() ,courier);
    }

    public void changePassword(Courier courier)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Password: ");
        String password = scanner.nextLine();
        courier.setPassword(password);
    }

    public void setCourierBusy(String username)
    {
        courierList.get(username).setBusy(true);
    }

}
