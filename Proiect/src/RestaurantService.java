import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class RestaurantService
{
    private Map<String ,Restaurant> restaurant_list = new TreeMap<>();

    public Restaurant getRestaurant_list(String Name) {
        return restaurant_list.get(Name);
    }

    public Map<String, Restaurant> getRestaurant_list() {
        return restaurant_list;
    }

    public void CreateRestaurant()
    {
        Restaurant restaurant = new Restaurant();
        ReadRestaurant(restaurant);
    }
    public boolean ReadRestaurant(Restaurant restaurant)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Restaurant Name: ");
        String name = scanner.nextLine();
        if(restaurant_list.get(name) != null)
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
            restaurant_list.put(restaurant.getName(), restaurant);
            return true;
        }
    }

    public void ShowMenuOfRestaurant(String name)
    {
            System.out.println(restaurant_list.get(name));
    }

    public int getProductPrice(Restaurant restaurant, String product)
    {
        return restaurant.getMenu().getProductPrice(product);
    }


}
