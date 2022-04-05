import java.util.Map;

public class Restaurant extends MenuRestaurant
{
    private String name;
    protected MenuRestaurant menu;

    public Restaurant()
    {
        name = "";
        menu =  new MenuRestaurant();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public MenuRestaurant getMenu()
    {
        return menu;
    }

    public void setMenu(String product, int price)
    {
        this.menu.setRestaurant_menu(product, price);
    }

    public String toString()
    {
        String s;
        s = "Restaurant Name: " + this.name + "\n" + "Their Products: \n";
        for(Map.Entry<String, Integer> entry : menu.getRestaurant_menu().entrySet())
        {
            s = s + (entry.getKey() + " " + entry.getValue() + "\n");
        }
        return s;
    }


}
