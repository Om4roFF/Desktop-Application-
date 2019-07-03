package sample;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OutStreamHandler{
    private static ObjectOutputStream outStream;
    private static ObjectInputStream inStream;

    static {
        try {
            outStream = new ObjectOutputStream(Main.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            inStream = new ObjectInputStream(Main.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeRequest(String requestType,Computers comp) throws IOException {
        outStream.writeObject(new Request(requestType, comp));
    }

    public void writeRequestWithLogin(String requestType,String login) throws IOException {
        outStream.writeObject(new Request(requestType,login));
    }

    public void writeRequestWithInt(String requestType,int a) throws IOException {
        outStream.writeObject(new Request(requestType,a));
    }

    public ArrayList<Computers> GetAllRequest(String operationType) throws IOException {
        ArrayList<Computers> comp = new ArrayList<>();
        try {
            Request request;
            request = (Request) inStream.readObject();
            if(request.getOperationType().equals(operationType))
            {
                comp.add(request.getComp());
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
        return comp;
    }





}
