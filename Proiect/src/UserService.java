import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserService
{
    private Map<String ,User> user_list = new TreeMap<>();

    public User getUser_list(String Username) {
        return user_list.get(Username);
    }

    public Map<String, User> getUser_list() {
        return user_list;
    }

    public void CreateUser()
    {
        User user = new User();
        ReadUser(user);
    }
    public boolean ReadUser(User user)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        if(user_list.get(username) != null)
            return false;
        user.setUsername(username);
        System.out.println("Password: ");
        user.setPassword(scanner.nextLine());
        System.out.println("Email: ");
        user.setEmail(scanner.nextLine());
        user_list.put(user.username, user);
        return true;
    }


}
