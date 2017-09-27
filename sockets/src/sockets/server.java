import java.io.DataOutputStream;
import java.net.*;
import java.util.Date;

public class server{
 public static void main(String args[]) throws Exception{
  ServerSocket server=new ServerSocket(7000);
  System.out.println("Server started");
  while(true){
   Socket sock=server.accept();
   DataOutputStream dos=new DataOutputStream(sock.getOutputStream());
   String time= new Date().toString();
   dos.writeUTF(time);
   sock.close();
  }
 }
}