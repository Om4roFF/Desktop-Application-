package sample;
import java.io.Serializable;

public class Computers implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String login;
    private String password;
    private int money;


    public Computers() {
    }

    public Computers(int id, String login, int money) {
        this.id = id;
        this.login = login;
        this.money = money;
    }

    public Computers(String login) {
        this.login = login;
    }

    public Computers(String login, int money) {
        this.login = login;
        this.money = money;
    }

    public Computers(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Computers(int id, String login, String password, int money) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.money=money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
