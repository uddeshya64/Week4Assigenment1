/***
 * Task: Java program to convert and perform mathematical operation on various number system.
 * @author Uddeshya Patidar
 * Date: 26/09/2024
 */
package practice.java;

import java.util.Scanner;

public class Week4_Assignment1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String runAgain = "y";

        while (runAgain.equalsIgnoreCase("y")) {
            try {
                // Ask the user what they want to do
                System.out.println(Constants.Welcome);
                int action = scanner.nextInt();

                if (action == 1) {
                    // Conversion block
                    System.out.println(Constants.ConversionIndex);
                    int inputType = scanner.nextInt();

                    if (inputType < 1 || inputType > 4) {
                        System.out.println(Constants.InvalidConversionIndex);
                        continue;
                    }

                    System.out.println(Constants.UserInput);
                    String input = scanner.next(); 

                    // Check for valid input
                    if (!methodConstant.isValidInput(input)) {
                        System.out.println(Constants.ValibInputCheck);
                        continue;
                    }

                    int decimalNumber = 0;

                    // Convert input to Decimal based on input type
                    switch (inputType) {
                        case 1:
                            decimalNumber = Integer.parseInt(input);
                            break;
                        case 2:
                            decimalNumber = methodConstant.binaryToDecimal(input);
                            break;
                        case 3:
                            decimalNumber = methodConstant.octalToDecimal(input);
                            break;
                        case 4:
                            try {
                                decimalNumber = methodConstant.hexadecimalToDecimal(input);
                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                            break;
                    }

                    // Check if the number is negative
                    if (decimalNumber < 0) {
                        System.out.println(Constants.NegtiveInput);
                        continue; 
                    }

                    System.out.println(Constants.ReturnTypeIndex);
                    int conversionChoice = scanner.nextInt();

                    switch (conversionChoice) {
                        case 1:
                            System.out.println("Decimal of " + input + " is: " + decimalNumber);
                            break;
                        case 2:
                            System.out.println("Binary of " + decimalNumber + " is: " + methodConstant.decimalToBinary(decimalNumber));
                            break;
                        case 3:
                            System.out.println("Octal of " + decimalNumber + " is: " + methodConstant.decimalToOctal(decimalNumber));
                            break;
                        case 4:
                            System.out.println("Hexadecimal of " + decimalNumber + " is: " + methodConstant.decimalToHexadecimal(decimalNumber));
                            break;
                        default:
                            System.out.println("Invalid conversion choice.");
                    }

                } else if (action == 2) {
                    // Arithmetic operation block
                    System.out.println(Constants.ArthemticOperationIndex);
                    int inputType = scanner.nextInt();

                    if (inputType < 1 || inputType > 4) {
                        System.out.println(Constants.InvalidConversionIndex);
                        continue;
                    }

                    int[] decimalNumbers = new int[100]; // Adjust size as needed
                    int count = 0;

                    String input;
                    while (true) {
                        System.out.println(Constants.EnterNumber);
                        input = scanner.next();

                        if (input.equalsIgnoreCase("done")) {
                            break;
                        }

                        // Check for valid input
                        if (!methodConstant.isValidInput(input)) {
                            System.out.println(Constants.InvalidInput);
                            continue;
                        }

                        // Convert input to decimal based on the number type
                        int decimalNumber = 0;
                        switch (inputType) {
                            case 1:
                                decimalNumber = Integer.parseInt(input);
                                break;
                            case 2:
                                decimalNumber = methodConstant.binaryToDecimal(input);
                                break;
                            case 3:
                                decimalNumber = methodConstant.octalToDecimal(input);
                                break;
                            case 4:
                                try {
                                    decimalNumber = methodConstant.hexadecimalToDecimal(input);
                                } catch (NumberFormatException e) {
                                    System.out.println(e.getMessage());
                                    continue;
                                }
                                break;
                        }

                        // Check for negative numbers
                        if (decimalNumber < 0) {
                            System.out.println(Constants.InvalidInput);
                            continue;
                        }

                        decimalNumbers[count++] = decimalNumber; // Store the number and increment count
                    }

                    // Ask the user for arithmetic operation
                    System.out.println(Constants.ArthemticOptions);
                    int operation = scanner.nextInt();

                    int result = decimalNumbers[0];

                    // Perform the selected arithmetic operation on multiple numbers
                    for (int i = 1; i < count; i++) {
                        switch (operation) {
                            case 1:
                                result += decimalNumbers[i];
                                break;
                            case 2:
                                result -= decimalNumbers[i];
                                break;
                            default:
                                System.out.println(Constants.ArthemticInvalidOption);
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
                    System.out.println(Constants.ArthemticOperationIndex);
                    int conversionChoice = scanner.nextInt();

                    // Convert the result as per the user's choice
                    switch (conversionChoice) {
                        case 1:
                            System.out.println("Result in decimal: " + result);
                            break;
                        case 2:
                            System.out.println("Result in binary: " + methodConstant.decimalToBinary(result));
                            break;
                        case 3:
                            System.out.println("Result in octal: " + methodConstant.decimalToOctal(result));
                            break;
                        case 4:
                            System.out.println("Result in hexadecimal: " + methodConstant.decimalToHexadecimal(result));
                            break;
                        default:
                            System.out.println("Invalid conversion choice.");
                    }
                } else {
                    System.out.println(Constants.ArthemticInvalidOption);
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear the scanner buffer
            }

            // Ask the user if they want to run the program again
            System.out.println(Constants.RunAgain);
            runAgain = scanner.next();
        }
        scanner.close();
    }
}
