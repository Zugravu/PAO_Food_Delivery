import java.util.HashMap;
import java.util.Map;

public class MenuRestaurant
{
    protected Map<String, Integer> restaurant_menu;

    public  MenuRestaurant()
    {
        restaurant_menu = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getRestaurant_menu()
    {
        return restaurant_menu;
    }

    public int getProductPrice(String product)
    {
        return restaurant_menu.get(product);
    }

    public void setRestaurant_menu(Map<String, Integer> restaurant_menu)
    {
        this.restaurant_menu = restaurant_menu;
    }

    public void setRestaurant_menu(String name, int price)
    {
        this.restaurant_menu.put(name, price);
    }
}
