public class User
{
    protected String username;
    protected String password;
    protected String email;

    public User()
    {
        this.username = "";
        this.password = "";
        this.email = "";
    }
    public User(String UserName, String Password, String Email)
    {
        this.username = UserName;
        this.password = Password;
        this.email = Email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String toString()
    {
        String s;
        s = "Username: " + this.username + "\nEmail: " + this.email;
        return s;
    }
}
