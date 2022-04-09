package Classes;

public class Courier extends User
{
    private String firstName;
    private String lastName;
    private String vehicle;
    private boolean busy;

    public Courier()
    {
        firstName = "";
        lastName = "";
        vehicle = "";
        busy=false;
    }

    public Courier(String UserName, String Password, String Email, String firstName, String last_name, String vehicle)
    {
        super(UserName, Password, Email);
        this.firstName = firstName;
        this.lastName = last_name;
        this.vehicle = vehicle;
        busy=false;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String first_name)
    {
        this.firstName = first_name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String last_name)
    {
        this.lastName = last_name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public boolean getBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public String toString()
    {
        String s;
        s = "Username: " + this.username + "\nEmail: " + this.email + "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nVehicle: " + this.vehicle;
        return s;
    }
}
