import java.util.HashMap;
import java.util.Map;

public class Order
{
   private String CustomerUsername;
   private String CourierUsername;
   private String RestaurantName;
   private Map<String, Integer> products = new HashMap<String, Integer>();
   private float price;

   public Order()
   {
       this.CustomerUsername = "";
       this.CourierUsername = "";
       this.RestaurantName = "";
       this.price = 0;
   }

    public Order(String customerUsername, String courierUsername, String restaurantName, Map<String, Integer> products, float Price) {
        this.CustomerUsername = customerUsername;
        this.CourierUsername = courierUsername;
        this.RestaurantName = restaurantName;
        this.products = products;
        this.price = Price;
    }

    public String getCustomerUsername() {
        return this.CustomerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.CustomerUsername = customerUsername;
    }

    public String getCourierUsername() {
        return this.CourierUsername;
    }

    public void setCourierUsername(String courierUsername) {
        this.CourierUsername = courierUsername;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }

    public void setProducts(String product, int amount) {
        this.products.put(product, amount);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = this.price + price;
    }

    @Override
    public String toString()
    {
        String s;
        s = "Customer Username: " + this.CustomerUsername + "\nCourier Username: " + this.CourierUsername + "\nRestaurant Name: " + this.RestaurantName + "\nPrice: " + this.price + "\n";
        for(Map.Entry<String, Integer> entry : products.entrySet())
        {
            s = s + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return s;
    }
}
