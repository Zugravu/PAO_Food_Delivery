package Services;

import Classes.Courier;

import java.io.*;
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

    public void readCourierFromFile()
    {
        String path = "src/Files/Couriers.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while((line = br.readLine()) != null){
                Courier courier = new Courier();
                String[] values = line.split(",");
                courier.setUsername(values[0]);
                courier.setPassword(values[1]);
                courier.setEmail(values[2]);
                courier.setFirstName(values[3]);
                courier.setLastName(values[4]);
                courier.setVehicle(values[5]);
                courier.setBusy(false);
                courierList.put(courier.getUsername() ,courier);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCourierInFiles()
    {
        String filepath = "src/Files/Couriers.csv";
        try {
            FileWriter fw = new FileWriter(filepath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("username" + "," + "password" + "," + "email" + "," + "firstName" + "," + "lastName" + "," + "vehicle");
            for (Map.Entry<String, Courier> entry : courierList.entrySet()) {
                pw.println(entry.getValue().getUsername()+","+entry.getValue().getPassword()+","+entry.getValue().getEmail()+","+entry.getValue().getFirstName()+","+entry.getValue().getLastName()+","+entry.getValue().getVehicle());

            }
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


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
