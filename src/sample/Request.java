package sample;
import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String operationType;
    private Computers comp;

    private int id;
    private String login;
    private int money;

    public Request(String operationType, String login, int money) {
        this.operationType = operationType;
        this.login = login;
        this.money = money;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Request() {
    }

    public Request(String operationType,Computers comp) {
        this.operationType = operationType;
        this.comp = comp;
    }

    public Request(String operationType, String login) {
        this.operationType = operationType;
        this.login = login;
    }


    public Request(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Computers getComp() {
        return comp;
    }

    public void setComp(Computers comp) {
        this.comp = comp;
    }
}

