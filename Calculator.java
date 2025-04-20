import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class Calculator extends UnicastRemoteObject implements ICalculator {
    public Calculator() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        System.out.println("Received add request from client: " + a + " + " + b);
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        System.out.println("Received subtract request from client: " + a + " - " + b);
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
        System.out.println("Received multiply request from client: " + a + " * " + b);
        return a * b;
    }

    public double divide(int a, int b) throws RemoteException {
        System.out.println("Received divide request from client: " + a + " / " + b);
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            // Create an RMI registry (use default port 1099)
            Registry registry = LocateRegistry.createRegistry(1099);
            // Bind the remote object (calculator) to the RMI registry
            registry.rebind("CalculatorService", calculator);
            System.out.println("Calculator server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}