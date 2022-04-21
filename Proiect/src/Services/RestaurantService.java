package Services;

import Classes.Restaurant;

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
    public boolean readRestaurant(Restaurant restaurant)
    {
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
            restaurantList.put(restaurant.getName(), restaurant);
            return true;
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


}
