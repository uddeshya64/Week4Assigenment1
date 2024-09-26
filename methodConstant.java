/***
 * Task: MethodConstant class is used to perform operation like Conversion and Mathematical Operation.
 * @author Uddeshya Patidar
 * Date: 26/09/2024
 */
package practice.java;

public class methodConstant{
	
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
	public static int hexadecimalToDecimal(String hexadecimal) throws NumberFormatException {
	    if (!hexadecimal.matches("[0-9A-Fa-f]+")) {
	        throw new NumberFormatException("Invalid hexadecimal input.");
	    }
	    return Integer.parseInt(hexadecimal, 16);
	}

	// Method to check if input is valid
	public static boolean isValidInput(String input) {
	    input = input.replaceAll(" ", ""); // Remove all spaces
	    return !input.isEmpty() && input.matches("[0-9A-Fa-f]+");
	}


	
}


