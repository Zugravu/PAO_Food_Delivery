
public class Administrator extends User
{
    private String first_name;
    private String last_name;

    public Administrator()
    {
        this.first_name = "";
        this.last_name = "";
    }

    public Administrator(String UserName, String Password,String Email, String first_name, String last_name)
    {
        super(UserName, Password, Email);
        this.first_name = first_name;
        this.last_name = last_name;
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


}
