import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            //Создаем подключение к базе данных db_lu
            Connection connection = DriverManager.getConnection("jdbc:sqlite:db_lu");
            System.out.println("Подключение выполнено");
            //Создаем четыре запроса на создание таблиц
            String query = "CREATE TABLE 'users'(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name CHAR," +
                    "surname CHAR," +
                    "money INTEGER," +
                    "birthday DATETIME," +
                    "fk_users_cars INTEGER NOT NULL," +
                    "FOREIGN KEY (fk_users_cars) REFERENCES cars(id));";

            String query2 = "CREATE TABLE 'cars'(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name CHAR," +
                    "color CHAR," +
                    "model CHAR," +
                    "speed CHAR);";

            String query3 = "CREATE TABLE 'shops'(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name CHAR," +
                    "address CHAR);";

            String query4 = "CREATE TABLE 'cars_users'(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "users_id INTEGER NOT NULL," +
                    "cars_id INTEGER NOT NULL," +
                    "FOREIGN KEY (users_id) REFERENCES users(id)," +
                    "FOREIGN KEY (cars_id) REFERENCES cars(id));";
            // Обновляем нашу базу данных db_lu четырьмя таблицами
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            statement.executeUpdate(query4);
            System.out.println("Таблицы: users, cars, shops, cars_users добавлены");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
