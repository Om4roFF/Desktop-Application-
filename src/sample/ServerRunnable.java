package sample;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerRunnable extends Thread {

    private Socket socket;
    public ServerRunnable(Socket socket){
        this.socket = socket;
    }
    private Request request = new Request();
    DBManager dbManager = new DBManager();
    Controller controller = new Controller();
    @Override
    public void run(){
        try
        {
            dbManager.connect();
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

            while ((request = (Request) inStream.readObject()) != null)
            {
                if(request.getOperationType().equals("ADD_USERS"))
                {
                    dbManager.Addusers(request.getComp());
                }
                else if(request.getOperationType().equals("LIST_USERS"))
                {
                    try
                    {
                        outStream.writeObject(dbManager.getAllUsers());
                    }
                    catch (Exception e)
                    {
                        outStream.writeObject("EMPTY");
                    }
                }
                else if(request.getOperationType().equals("DELETE"))
                {
                    dbManager.deleteUsers(request.getLogin());
                }
                else if(request.getOperationType().equals("Replenish"))
                {
                    dbManager.Replenish(request.getComp().getLogin(),request.getComp().getMoney());
                }
                else if(request.getOperationType().equals("WRITE-OFF"))
                {
                    dbManager.writeOff(request.getComp().getLogin(),request.getComp().getMoney());
                }
                else if(request.getOperationType().equals("TIME"))
                {

                }

            }
            inStream.close();
            outStream.close();
            socket.close();
            System.exit(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}