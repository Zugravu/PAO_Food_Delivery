
public class Customer extends User
{
    private String first_name;
    private String last_name;
    protected CustomerAdress address;

    public Customer()
    {
        this.first_name = "";
        this.last_name = "";
        address = new CustomerAdress();
    }

    public Customer(String UserName, String Password, String Email, String first_name, String last_name, String Roadname, String Blnr, String Apnr)
    {
        super(UserName, Password, Email);
        this.first_name = first_name;
        this.last_name = last_name;
        address = new CustomerAdress(Roadname, Blnr, Apnr);
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

    public CustomerAdress getAdress() {
        return address;
    }

    public void setAddress(CustomerAdress address) {
        this.address = address;
    }




    @Override
    public String toString()
    {
        String s;
        s = "Username: " + this.username + "\nEmail: " + this.email + "\nFirst Name: " + this.first_name + "\nLast Name: " + this.last_name + "\nRoad Name: " + this.address.getRoad_name() + "\nBuilding Number: " + this.address.getBl_nr() + "\nApartment Number: " + this.address.getAp_nr();
        return s;

    }
}
