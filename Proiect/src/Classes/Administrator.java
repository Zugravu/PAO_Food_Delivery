package Classes;


public class Administrator extends User
{
    private String firstName;
    private String lastName;

    public Administrator()
    {
        this.firstName = "";
        this.lastName = "";
    }

    public Administrator(String UserName, String Password,String Email, String first_name, String last_name)
    {
        super(UserName, Password, Email);
        this.firstName = first_name;
        this.lastName = last_name;
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


}
