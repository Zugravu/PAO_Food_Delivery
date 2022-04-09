package Classes;

public class Customer extends User
{
    private String firstName;
    private String lastName;
    protected CustomerAdress address;

    public Customer()
    {
        this.firstName = "";
        this.lastName = "";
        address = new CustomerAdress();
    }

    public Customer(String UserName, String Password, String Email, String first_name, String lastName, String Roadname, String Blnr, String Apnr)
    {
        super(UserName, Password, Email);
        this.firstName = first_name;
        this.lastName = lastName;
        address = new CustomerAdress(Roadname, Blnr, Apnr);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
        s = "Username: " + this.username + "\nEmail: " + this.email + "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nRoad Name: " + this.address.getRoad_name() + "\nBuilding Number: " + this.address.getBlNr() + "\nApartment Number: " + this.address.getApNr();
        return s;

    }
}
