import java.rmi.registry.*;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);){
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            ICalculator calculator = (ICalculator) registry.lookup("CalculatorService");

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            int sum = calculator.add(num1, num2);
            int difference = calculator.subtract(num1, num2);
            int product = calculator.multiply(num1, num2);
            double quotient = calculator.divide(num1, num2);

            System.out.println("Addition: " + sum);
            System.out.println("Subtraction: " + difference);
            System.out.println("Multiplication: " + product);
            System.out.println("Division: " + quotient);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}