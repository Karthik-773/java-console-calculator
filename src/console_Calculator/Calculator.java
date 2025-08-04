package console_Calculator;

	import java.util.Scanner;

	public class Calculator {
	    // Method for addition
	    public double add(double num1, double num2) {
	        return num1 + num2;
	    }

	    // Method for subtraction
	    public double subtract(double num1, double num2) {
	        return num1 - num2;
	    }

	    // Method for multiplication
	    public double multiply(double num1, double num2) {
	        return num1 * num2;
	    }

	    // Method for division with divide-by-zero handling
	    public double divide(double num1, double num2) {
	        if (num2 == 0) {
	            throw new ArithmeticException("Division by zero is not allowed!");
	        }
	        return num1 / num2;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Calculator calc = new Calculator();
	        boolean continueCalculating = true;

	        System.out.println("Welcome to the Java Console Calculator!");
	        System.out.println("Available operations: +, -, *, /");
	        System.out.println("Enter 'exit' to quit.");

	        while (continueCalculating) {
	            try {
	                // Get first number
	                System.out.print("\nEnter the first number: ");
	                String input = scanner.nextLine();
	                
	                // Check for exit condition
	                if (input.equalsIgnoreCase("exit")) {
	                    continueCalculating = false;
	                    continue;
	                }
	                
	                double num1 = Double.parseDouble(input);

	                // Get operation
	                System.out.print("Enter the operation (+, -, *, /): ");
	                String operation = scanner.nextLine();

	                // Validate operation
	                if (!operation.equals("+") && !operation.equals("-") && 
	                    !operation.equals("*") && !operation.equals("/")) {
	                    System.out.println("Invalid operation! Please use +, -, *, or /.");
	                    continue;
	                }

	                // Get second number
	                System.out.print("Enter the second number: ");
	                double num2 = Double.parseDouble(scanner.nextLine());

	                // Perform calculation based on operation
	                double result;
	                switch (operation) {
	                    case "+":
	                        result = calc.add(num1, num2);
	                        System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, result);
	                        break;
	                    case "-":
	                        result = calc.subtract(num1, num2);
	                        System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, result);
	                        break;
	                    case "*":
	                        result = calc.multiply(num1, num2);
	                        System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, result);
	                        break;
	                    case "/":
	                        result = calc.divide(num1, num2);
	                        System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, result);
	                        break;
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter valid numbers.");
	            } catch (ArithmeticException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (Exception e) {
	                System.out.println("An unexpected error occurred: " + e.getMessage());
	            }
	        }

	        System.out.println("Thank you for using the Java Console Calculator!");
	        scanner.close();
	    }
	}
