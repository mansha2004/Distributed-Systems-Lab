package ds;
import java.io.*; 
import java.net.*; 
public class Server { 
public static void main(String[] args) { 
try { 
ServerSocket serverSocket = new ServerSocket(6000); 
System.out.println("Server is waiting for client..."); 
Socket socket = serverSocket.accept(); 
System.out.println("Client connected!"); 
BufferedReader input = new BufferedReader(new 
InputStreamReader(socket.getInputStream())); 
PrintWriter output = new PrintWriter(socket.getOutputStream(), true); 
String clientMessage = input.readLine(); 
System.out.println("Client says: " + clientMessage); 
output.println("Hello from Server!"); 
socket.close(); 
serverSocket.close(); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
}