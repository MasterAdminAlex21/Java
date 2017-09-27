import java.net.Socket;

public class sock{
 
 public static void main(String args[]) throws Exception{
  Socket sock=new Socket("www.google.com",80);
  System.out.println("Conection to:"+" "+sock.getInetAddress()+" on port: "+sock.getLocalPort()+" of "+sock.getLocalAddress());
  sock.close();
 }
}