package Services;

import Classes.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class OrderService extends Order
{
    private Map<Integer, Order> orderList = new HashMap<>();
    private int count = 0;

    public Map<Integer, Order> getOrderList()
    {
        return orderList;
    }
    public Order getOrderList(Integer index)
    {
        return orderList.get(index);
    }

    public void createOrder(String customer, CourierService couriserervice, AdministratorService administratorservice, RestaurantService restaurantService)
    {
        Order order = new Order();
        readOrder(order, customer, couriserervice, administratorservice, restaurantService);
    }

    public void readOrder(Order order, String Customer, CourierService couriserervice, AdministratorService administratorservice, RestaurantService restaurantService)
    {
        Scanner scanner = new Scanner(System.in);
        order.setCustomerUsername(Customer);

        System.out.println("Choose Classes.Courier Username: ");
        administratorservice.showAllCouriersUsernameAvailable(couriserervice);
        String courierUsername = scanner.nextLine();
        order.setCourierUsername(courierUsername);
        couriserervice.setCourierBusy(courierUsername);


        System.out.println("Choose Classes.Restaurant");
        administratorservice.showAllRestaurants(restaurantService);
        String restaurant = scanner.nextLine();
        order.setRestaurantName(restaurant);

        System.out.println("Add the products and their amount you want to order from the list below");
        restaurantService.showMenuOfRestaurant(restaurant);

        System.out.println("Product: ");
        String product = scanner.nextLine();
        System.out.println("Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        order.setPrice(amount * restaurantService.getProductPrice(restaurantService.getRestaurantList(restaurant), product));
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

            order.setPrice(amount * restaurantService.getProductPrice(restaurantService.getRestaurantList(restaurant), product));
            order.setProducts(product, amount);
        }
        if(count == 10000)//voi reseta count ul cand ajunge la 10000, deoarece nu voi avea niciodata mai mult de 1000 de comenzi deodata
            count = 0;
        orderList.put(++count, order);
        System.out.println("Classes.Order Complet");
    }


}
