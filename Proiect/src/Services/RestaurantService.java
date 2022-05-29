package Services;

import Classes.Restaurant;

import java.io.*;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class RestaurantService
{
    private Map<String , Restaurant> restaurantList = new TreeMap<>();

    public Restaurant getRestaurantList(String Name) {
        return restaurantList.get(Name);
    }

    public Map<String, Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void createRestaurant()
    {
        Restaurant restaurant = new Restaurant();
        readRestaurant(restaurant);
    }
    public boolean readRestaurant(Restaurant restaurant){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Restaurant Name: ");
        String name = scanner.nextLine();
        if(restaurantList.get(name) != null)
            return false;
        else
        {
            restaurant.setName(name);
            System.out.println("Add the prices and products of the restaurant. When done type end");
            System.out.println("Product: ");
            String products = scanner.nextLine();
            System.out.println("Price: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            restaurant.setMenu(products, price);
            while(true)
            {
                System.out.println("Product: ");
                products = scanner.nextLine();
                if(Objects.equals(products, "end"))
                    break;

                System.out.println("Price: ");
                price = scanner.nextInt();
                scanner.nextLine();

                restaurant.setMenu(products, price);
            }
            //writeInCSV(restaurant);
            restaurantList.put(restaurant.getName(), restaurant);
            return true;
        }
    }

    public void readRestaurantsFromFile()
    {
        String path = "src/Files/Restaurant.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            line = br.readLine();
            while(true){
                String[] values = line.split(",");
                Restaurant restaurant = new Restaurant();
                restaurant.setName(values[0]);
                restaurant.setMenu(values[1],  Integer.parseInt(values[2]));
                boolean ok = false;
                while((line = br.readLine()) != null){
                    String[] values1 = line.split(",");
                    if(!Objects.equals(values1[0], values[0]))
                        {ok=true;break;}
                    else
                        restaurant.setMenu(values1[1],  Integer.parseInt(values1[2]));
                }
                restaurantList.put(restaurant.getName() ,restaurant);
                if(!ok)
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRestaurantInFiles() {
        String filepath = "src/Files/Restaurant.csv";
        try {
            FileWriter fw = new FileWriter(filepath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("name" + "," + "product" + "," + "price");
            for (Map.Entry<String, Restaurant> entry : restaurantList.entrySet()) {
                String name = entry.getKey();
                for (Map.Entry<String, Integer> entry1 : restaurantList.get(name).getMenu().getRestaurantMenu().entrySet())
                {
                    pw.println(name + "," + entry1.getKey() + "," + entry1.getValue());
                }

            }

            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showMenuOfRestaurant(String name)
    {
            System.out.println(restaurantList.get(name));
    }


    public int getProductPrice(Restaurant restaurant, String product)
    {
        return restaurant.getMenu().getProductPrice(product);
    }


    /*
    public void writeInCSV(Restaurant restaurant)
    {
        try
        {
            PrintWriter pw = new PrintWriter("C:\\Users\\Zugra\\IdeaProjects\\Proiect\\src\\Files\\Restaurant.csv");
            StringBuilder sb = new StringBuilder();
            sb.append(restaurant.getName());
            sb.append(",");
            for(Map.Entry<String, Integer> entry : restaurant.getRestaurantMenu().entrySet())
            {
                sb.append(entry.getKey());
                sb.append(",");
                sb.append(entry.getValue());
                sb.append(",");
                sb.append("\r\n");
            }
            pw.write(sb.toString());
            System.out.print("finish");
        }
        catch (Exception e)
        {
            //
        }
    }
     */

}
