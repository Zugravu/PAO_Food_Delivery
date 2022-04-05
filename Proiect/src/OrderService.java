import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class OrderService extends Order
{
    private Map<Integer, Order> order_list = new HashMap<Integer, Order>();
    private int count = 0;

    public Map<Integer, Order> getOrder_list()
    {
        return order_list;
    }
    public Order getOrder_list(Integer index)
    {
        return order_list.get(index);
    }

    public void CreateOrder(String customer, CourierService couriserervice, AdministratorService administratorservice, RestaurantService restaurantService)
    {
        Order order = new Order();
        ReadOrder(order, customer, couriserervice, administratorservice, restaurantService);
    }

    public void ReadOrder(Order order, String Customer, CourierService couriserervice, AdministratorService administratorservice, RestaurantService restaurantService)
    {
        Scanner scanner = new Scanner(System.in);
        order.setCustomerUsername(Customer);

        System.out.println("Choose Courier Username: ");
        administratorservice.ShowAllCouriersUsernameAvailable(couriserervice);
        String courierUsername = scanner.nextLine();
        order.setCourierUsername(courierUsername);
        couriserervice.SetCourierBusy(courierUsername);


        System.out.println("Choose Restaurant");
        administratorservice.ShowAllRestaurants(restaurantService);
        String restaurant = scanner.nextLine();
        order.setRestaurantName(restaurant);

        System.out.println("Add the products and their amount you want to order from the list below");
        restaurantService.ShowMenuOfRestaurant(restaurant);

        System.out.println("Product: ");
        String product = scanner.nextLine();
        System.out.println("Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        order.setPrice(amount * restaurantService.getProductPrice(restaurantService.getRestaurant_list(restaurant), product));
        order.setProducts(product, amount);
        while(true)
        {
            System.out.println("Product: ");
            product = scanner.nextLine();
            if(Objects.equals(product, "end"))
                break;

            System.out.println("Amount: ");
            amount = scanner.nextInt();
            scanner.nextLine();

            order.setPrice(amount * restaurantService.getProductPrice(restaurantService.getRestaurant_list(restaurant), product));
            order.setProducts(product, amount);
        }
        if(count == 10000)//voi reseta count ul cand ajunge la 10000, deoarece nu voi avea niciodata mai mult de 1000 de comenzi deodata
            count = 0;
        order_list.put(++count, order);
        System.out.println("Order Complet");
    }

}
