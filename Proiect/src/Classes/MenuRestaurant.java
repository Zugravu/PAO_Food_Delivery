package Classes;

import java.util.HashMap;
import java.util.Map;

public class MenuRestaurant
{
    protected Map<String, Integer> restaurantMenu;

    public  MenuRestaurant()
    {
        restaurantMenu = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getRestaurantMenu()
    {
        return restaurantMenu;
    }

    public int getProductPrice(String product)
    {
        return restaurantMenu.get(product);
    }

    public void setRestaurantMenu(Map<String, Integer> restaurantMenu)
    {
        this.restaurantMenu = restaurantMenu;
    }

    public void setRestaurant_menu(String name, int price)
    {
        this.restaurantMenu.put(name, price);
    }
}
