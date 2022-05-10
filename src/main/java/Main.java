import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:db_lu");
            System.out.println("Подключение выполнено");
            String query = "CREATE TABLE 'users'(name char," +
                    "surname char," +
                    "money integer," +
                    "birthday datetime);";
            String query2 = "CREATE TABLE 'cars'(name char," +
                    "color char," +
                    "model char," +
                    "speed char);";
            String query3 = "CREATE TABLE 'shops'(name char," +
                    "address char);";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            System.out.println("Таблицы: users, cars, shops добавлены");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
