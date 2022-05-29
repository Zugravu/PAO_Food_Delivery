package Services.Repository;

import Classes.User;
import Services.UserService;
import config.DatabaseConfiguration;

import java.sql.*;
import java.util.Map;

public class UserRepository {

    static UserService userService = new UserService();

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        //userRepository.createTable();
        //userService.createUser();
        //userRepository.updateUserPassword("parola",4);

        userRepository.getUserById(4);
        userRepository.getUserById(5);
        for (Map.Entry<String, User> entry : userService.getUserList().entrySet()) {
            System.out.println(entry.getValue());
            System.out.println("\n");
        }
        //userRepository.deleteRow(4);
    }



    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS user" +
                "(id int PRIMARY KEY AUTO_INCREMENT, username varchar(40), password varchar(40), email varchar(40))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void insertUser(String username, String password, String email) {
        String insertUserSql = "INSERT INTO user(username, password, email) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserSql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        String selectSql = "SELECT * FROM user WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showUsers(){
        String selectSql = "SELECT * FROM user";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                System.out.println("Username: " + resultSet.getString(2) + "\nPassword: " + resultSet.getString(3) + "\nEmail: " + resultSet.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(String password, int id) {
        String updatePasswordSql = "UPDATE user SET password=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordSql);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRow(int id)
    {
        String deleteUser = "DELETE FROM user WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void mapToUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            userService.getUserList().put(user.getUsername(),user);
        }
    }


}
