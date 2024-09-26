package practice.java;

import java.util.ArrayList;

import java.util.Scanner;

public class Week4_Assignment1 {

    // Decimal to Binary
    public static String decimalToBinary(int decimal) {
        String binary = "";
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary;
    }

    // Decimal to Octal
    public static String decimalToOctal(int decimal) {
        String octal = "";
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            octal = (decimal % 8) + octal;
            decimal /= 8;
        }
        return octal;
    }

    // Decimal to Hexadecimal
    public static String decimalToHexadecimal(int decimal) {
        String hexadecimal = "";
        if (decimal == 0) {
            return "0";
        }
        char[] hexDigits = "0123456789ABCDEF".toCharArray();
        while (decimal > 0) {
            hexadecimal = hexDigits[decimal % 16] + hexadecimal;
            decimal /= 16;
        }
        return hexadecimal;
    }

    // Binary to Decimal
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    // Octal to Decimal
    public static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    // Hexadecimal to Decimal
    public static int hexadecimalToDecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String runAgain = "y";

        while (runAgain.equalsIgnoreCase("y")) {

            try {
                // Ask the user what they want to do: Convert or Perform Operation
                System.out.println("What would you like to do?");
                System.out.println("1. Convert a number between systems");
                System.out.println("2. Perform an arithmetic operation (Addition/Subtraction)");
                int action = scanner.nextInt();

                if (action == 1) {
                    // Conversion block
                    System.out.println("Enter the type of input number:");
                    System.out.println("1. Decimal");
                    System.out.println("2. Binary");
                    System.out.println("3. Octal");
                    System.out.println("4. Hexadecimal");
                    int inputType = scanner.nextInt();

                    if (inputType < 1 || inputType > 4) {
                        System.out.println("Invalid input type. Please enter a number between 1 and 4.");
                        continue;
                    }

                    System.out.println("Enter the number to convert: ");
                    String input = scanner.next(); // Taking input as String for non-decimal formats

                    if (input.isEmpty()) {
                        System.out.println("Input cannot be empty. Please enter a valid number.");
                        continue;
                    }

                    int decimalNumber = 0;

                    // Convert input to Decimal based on input type
                    switch (inputType) {
                        case 1:
                            decimalNumber = Integer.parseInt(input);
                            break;
                        case 2:
                            decimalNumber = binaryToDecimal(input);
                            break;
                        case 3:
                            decimalNumber = octalToDecimal(input);
                            break;
                        case 4:
                            decimalNumber = hexadecimalToDecimal(input);
                            break;
                    }

                    // Ask the user for the desired conversion
                    System.out.println("Convert the number to:");
                    System.out.println("1. Decimal");
                    System.out.println("2. Binary");
                    System.out.println("3. Octal");
                    System.out.println("4. Hexadecimal");
                    int conversionChoice = scanner.nextInt();

                    switch (conversionChoice) {
                        case 1:
                            System.out.println("Decimal of " + input + " is: " + decimalNumber);
                            break;
                        case 2:
                            System.out.println("Binary of " + decimalNumber + " is: " + decimalToBinary(decimalNumber));
                            break;
                        case 3:
                            System.out.println("Octal of " + decimalNumber + " is: " + decimalToOctal(decimalNumber));
                            break;
                        case 4:
                            System.out.println("Hexadecimal of " + decimalNumber + " is: " + decimalToHexadecimal(decimalNumber));
                            break;
                        default:
                            System.out.println("Invalid conversion choice.");
                    }

                } else if (action == 2) {
                    // Arithmetic operation block
                    System.out.println("Enter the type of input number:");
                    System.out.println("1. Decimal");
                    System.out.println("2. Binary");
                    System.out.println("3. Octal");
                    System.out.println("4. Hexadecimal");
                    int inputType = scanner.nextInt();

                    if (inputType < 1 || inputType > 4) {
                        System.out.println("Invalid input type. Please enter a number between 1 and 4.");
                        continue;
                    }

                    // Enter multiple numbers
                    ArrayList<Integer> decimalNumbers = new ArrayList<>();
                    String input = "";
                    while (true) {
                        System.out.println("Enter a number (or type 'done' to finish): ");
                        input = scanner.next();
                        if (input.equalsIgnoreCase("done")) {
                            break;
                        }

                        if (input.isEmpty()) {
                            System.out.println("Input cannot be empty. Please enter a valid number.");
                            continue;
                        }

                        // Convert input to decimal based on the number type
                        int decimalNumber = 0;
                        switch (inputType) {
                            case 1:
                                decimalNumber = Integer.parseInt(input);
                                break;
                            case 2:
                                decimalNumber = binaryToDecimal(input);
                                break;
                            case 3:
                                decimalNumber = octalToDecimal(input);
                                break;
                            case 4:
                                decimalNumber = hexadecimalToDecimal(input);
                                break;
                        }
                        decimalNumbers.add(decimalNumber);
                    }

                    // Ask the user for arithmetic operation
                    System.out.println("What operation would you like to perform:");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    int operation = scanner.nextInt();

                    int result = decimalNumbers.get(0);

                    // Perform the selected arithmetic operation on multiple numbers
                    for (int i = 1; i < decimalNumbers.size(); i++) {
                        switch (operation) {
                            case 1:
                                result += decimalNumbers.get(i);
                                break;
                            case 2:
                                result -= decimalNumbers.get(i);
                                break;
                            default:
                                System.out.println("Invalid operation. Please select 1 or 2.");
                                continue;
                        }
                    }

                    // Notify the user if the result is negative
                    if (result < 0) {
                        System.out.println("The result is negative: " + result + ". Please enter valid numbers or check your operation.");
                        continue;
                    } else {
                        System.out.println("Result in decimal: " + result);
                    }

                    // Ask the user for the desired conversion of the result
                    System.out.println("Convert the result to:");
                    System.out.println("1. Decimal");
                    System.out.println("2. Binary");
                    System.out.println("3. Octal");
                    System.out.println("4. Hexadecimal");
                    int conversionChoice = scanner.nextInt();

                    // Convert the result as per the user's choice
                    switch (conversionChoice) {
                        case 1:
                            System.out.println("Result in decimal: " + result);
                            break;
                        case 2:
                            System.out.println("Result in binary: " + decimalToBinary(result));
                            break;
                        case 3:
                            System.out.println("Result in octal: " + decimalToOctal(result));
                            break;
                        case 4:
                            System.out.println("Result in hexadecimal: " + decimalToHexadecimal(result));
                            break;
                        default:
                            System.out.println("Invalid conversion choice.");
                    }

                } else {
                    System.out.println("Invalid action. Please choose 1 or 2.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            // Ask the user if they want to run the program again
            System.out.println("Do you want to perform another operation? (y/n)");
            runAgain = scanner.next();
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}
