package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myclub?useUnicode=true&serverTimezone=UTC", "root", ""
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Addusers(Computers comp) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users(id,login,password,money)" +
                    "VALUES (NULL, ?, ?, ?)");
                    statement.setString(1, comp.getLogin());
            statement.setString(2, comp.getPassword());
            statement.setInt(3,comp.getMoney());

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Computers> getAllUsers() {
        ArrayList<Computers> comp = new ArrayList<>();
        try {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");
                    int money = resultSet.getInt("money");
                    comp.add(new Computers(id, login, password, money));
                }
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comp;
    }


    public void deleteUsers(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM users WHERE login = ?"
            );
            statement.setString(1, login);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public  ResultSet getUser(Computers computers)
    {
        ResultSet resSet = null;
        try {
            String select = "SELECT * FROM users WHERE login=? AND password=?";
            PreparedStatement prSt = connection.prepareStatement(select);
            prSt.setString(1,computers.getLogin());
            prSt.setString(2,computers.getPassword());
            resSet= prSt.executeQuery();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return resSet;
    }

    public void Replenish(String login,int mon)
    {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users " +
                    "SET money = money + ? "+
                    "WHERE login = ?");
            statement.setInt(1,mon);
            statement.setString(2,login);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeOff(String login,int mon)
    {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users " +
                    "SET money = money - ? "+
                    "WHERE login = ?");
            statement.setInt(1,mon);
            statement.setString(2,login);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
