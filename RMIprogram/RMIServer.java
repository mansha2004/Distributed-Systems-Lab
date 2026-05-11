package rmi;

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
public class RMIServer { 
public static void main(String[] args) { 
        try { 
            MyService service = new MyServiceImpl(); 
            Registry registry = LocateRegistry.createRegistry(1099); 
            registry.rebind("MyService", service); 
            System.out.println("Server started..."); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
