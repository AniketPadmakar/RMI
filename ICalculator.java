import java.rmi.*;

public interface ICalculator extends Remote {
    // Remote method to add two numbers
    public int add(int a, int b) throws RemoteException;

    // Remote method to subtract two numbers
    public int subtract(int a, int b) throws RemoteException;

    // Remote method to multiply two numbers
    public int multiply(int a, int b) throws RemoteException;

    // Remote method to divide two numbers
    public double divide(int a, int b) throws RemoteException;
}