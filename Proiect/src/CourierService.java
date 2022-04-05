import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourierService extends UserService
{
    protected Map<String ,Courier> courier_list = new HashMap<String ,Courier>();

    public Courier getCourier_list(String Username) {
        return courier_list.get(Username);
    }

    public Map<String, Courier> getCourier_list() {
        return courier_list;
    }

    public void CreateCourier()
    {
        Courier courier = new Courier();
        if(!ReadUser(courier))
            System.out.println("WARNING  Username already exists");
        else
            ReadCourier(courier);
    }

    public void ReadCourier(Courier courier)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        courier.setFirst_name(scanner.nextLine());
        System.out.println("Lastname: ");
        courier.setLast_name(scanner.nextLine());
        System.out.println("Vehicle: ");
        courier.setVehicle(scanner.nextLine());
        courier_list.put(courier.getUsername() ,courier);
    }

    public void ChangePassword(Courier courier)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Password: ");
        String password = scanner.nextLine();
        courier.setPassword(password);
    }

    public void SetCourierBusy(String username)
    {
        courier_list.get(username).setBusy(true);
    }

}
