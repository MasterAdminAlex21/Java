import java.io.*;
import java.net.*;

public class serv2{
 public static void main(String args[]) throws Exception{
  ServerSocket server = new ServerSocket(12345);
	System.out.println("Server is started");
	while(true) {
	Socket socket = server.accept();			
	DataInputStream dis = new 
	DataInputStream(socket.getInputStream());
	DataOutputStream dos = new 
	DataOutputStream(socket.getOutputStream());
	String name = dis.readUTF();
	System.out.println("I see " + name);
	dos.writeUTF("Hello " + name);
	socket.close();			
	}

 }
}