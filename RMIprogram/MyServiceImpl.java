package rmi;

import java.rmi.server.UnicastRemoteObject; 
import java.rmi.RemoteException; 
public class MyServiceImpl extends UnicastRemoteObject implements MyService { 
    protected MyServiceImpl() throws RemoteException { 
        super(); 
    } 
    @Override 
    public synchronized String sayHello(String name) throws RemoteException { 
        System.out.println("Request from: " + name + 
                " | Thread: " + Thread.currentThread().getName()); 
        try { 
            Thread.sleep(2000); // simulate processing 
        } catch (InterruptedException e) {} 
        return "Hello " + name + " from server!"; 
    } 
} 
