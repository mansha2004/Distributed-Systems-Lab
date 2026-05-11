package rmi;

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
public class RMIClient implements Runnable { 
    String name; 
    RMIClient(String name) { 
        this.name = name; 
    } 
    public void run() { 
        try { 
            Registry registry = LocateRegistry.getRegistry("localhost", 1099); 
            MyService service = (MyService) registry.lookup("MyService"); 
            String reply = service.sayHello(name); 
            System.out.println(reply); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    public static void main(String[] args) { 
        // Multiple client threads 
for(int i=1;i<=5;i++) { 
new Thread(new RMIClient("Client-"+i)).start(); 
} 
} 
}