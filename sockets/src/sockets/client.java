import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class client{
 public static void main(String args[]) throws Exception{
  Socket sock=new Socket("74.125.138.105",7000);//the 1st arg is for the ip address or web address
  DataInputStream din=new DataInputStream(sock.getInputStream());
  String time = din.readUTF();
  System.out.println(time);
  
 }
}