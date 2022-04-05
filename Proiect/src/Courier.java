public class Courier extends User
{
    private String first_name;
    private String last_name;
    private String vehicle;
    private boolean busy;

    public Courier()
    {
        first_name = "";
        last_name = "";
        vehicle = "";
        busy=false;
    }

    public Courier(String UserName, String Password,String Email, String first_name, String last_name, String vehicle)
    {
        super(UserName, Password, Email);
        this.first_name = first_name;
        this.last_name = last_name;
        this.vehicle = vehicle;
        busy=false;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
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
        s = "Username: " + this.username + "\nEmail: " + this.email + "\nFirst Name: " + this.first_name + "\nLast Name: " + this.last_name + "\nVehicle: " + this.vehicle;
        return s;
    }
}
