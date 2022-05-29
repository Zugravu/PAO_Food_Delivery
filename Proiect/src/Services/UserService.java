package Services;

import Classes.User;
import Services.Repository.UserRepository;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserService
{
    private Map<String , User> userList = new TreeMap<>();
    private UserRepository userRepository = new UserRepository();

    public User getUserList(String Username) {
        return userList.get(Username);
    }

    public Map<String, User> getUserList() {
        return userList;
    }

    public void createUser()
    {
        User user = new User();
        readUser(user);
        userRepository.insertUser(user.getUsername(),user.getPassword(),user.getEmail());
    }

    public boolean readUser(User user)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        if(userList.get(username) != null)
            return false;
        user.setUsername(username);
        System.out.println("Password: ");
        user.setPassword(scanner.nextLine());
        System.out.println("Email: ");
        user.setEmail(scanner.nextLine());
        userList.put(user.getUsername(), user);
        return true;
    }


}
