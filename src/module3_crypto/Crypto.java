package module3_crypto;

import java.util.Scanner;


public class Crypto {
	public static final String unshiftedAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputLine = new Scanner(System.in);
		String originalText = "";
		int option = 0;
		int shift = 0;
		int size = 0;
		
		do {
			System.out.println();
			System.out.println("What do you want to do?");
			System.out.println("1.- Encrypt a text.");
			System.out.println("2.- Decrypt a text.");
			System.out.println("3.- Exit.");
			System.out.println();
			option = input.nextInt();
			
			switch (option) {
				case 1:
					System.out.print("Enter a text to encrypt: ");
					originalText = inputLine.nextLine();
					System.out.print("Enter shift value: ");
					shift = input.nextInt();
					System.out.print("Enter group size: ");
					size = input.nextInt();
					System.out.println("The encrypted text is: " 
										+ encryptString(originalText, shift, size));
					break;
				case 2:
					System.out.print("Enter an encrypted text to decrypt: ");
					originalText = inputLine.nextLine();
					System.out.print("Enter the shift value used to encrypt the text: ");
					shift = input.nextInt();
					System.out.println("The (normalized) decrypted text is: " 
										+ decryptString(originalText, shift));
					break;
				case 3:
					System.out.println("Bye!");
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
		} while (option != 3);
	}

	
	public static String encryptString (String originalText, int shift, int groupSize) {
		String encryptedString = "";
		
		encryptedString = normalizeText(originalText);
		encryptedString = caesarify(encryptedString, shift);
		encryptedString = groupify(encryptedString, groupSize);
		return encryptedString;
	}

	
	public static String normalizeText(String originalText) {
			String normalizedText = "";
			String currentLetter = "";
						
			for(int i = 0;i < originalText.length();++i) {
				currentLetter = originalText.substring(i, i + 1).toUpperCase();
				if (!" .,:;'¡!¿?()\"".contains(currentLetter)) {
					normalizedText += currentLetter;
				}
			}
			return normalizedText;
	}

	
	public static String shiftAlphabet (int shift) {
		String shiftedAlphabet = "";
		int alphabetLength = unshiftedAlphabet.length();
		int start = 0;
		for (int i = 0; i < alphabetLength; i++) {
			if (shift >= 0) {
				start = (i + shift) % alphabetLength; 
			} else {
				start = (alphabetLength + i + ( shift % alphabetLength) ) % alphabetLength;
			}
			shiftedAlphabet += unshiftedAlphabet.substring(start, start + 1);
		}
		return shiftedAlphabet;
	}

	
	public static String caesarify (String normalizedText, int shift) {
		String caesarifiedText = "";
		String currentLetterUnshifted = "";
		String currentLetterShifted = "";
		String shiftedAlphabet = "";
		int unshiftedLetterIndex = 0;
		
		shiftedAlphabet = shiftAlphabet(shift);
		
		for (int i = 0; i < normalizedText.length(); i++) {
			currentLetterUnshifted = normalizedText.substring(i, i + 1);
			unshiftedLetterIndex = unshiftedAlphabet.indexOf(currentLetterUnshifted);
			currentLetterShifted = shiftedAlphabet.substring(unshiftedLetterIndex, unshiftedLetterIndex + 1);
			caesarifiedText += currentLetterShifted;
		}
		return caesarifiedText;
	}

	
	public static String groupify (String caesarifiedText, int groupSize) {
		String groupifiedText = "";
		String currentLetter = "";
		int padding = 0;
		
		for (int i = 0; i < caesarifiedText.length(); i++) {
			currentLetter = caesarifiedText.substring(i, i + 1);
			groupifiedText += currentLetter;
			if ( ( (i + 1) % groupSize == 0 ) && ( (i + 1) < caesarifiedText.length() ) ) {
				groupifiedText += " ";
			}
		}
		
		if (groupSize < caesarifiedText.length() && ( (caesarifiedText.length() % groupSize) != 0 ) ) {
			padding = groupSize - (caesarifiedText.length() % groupSize);
		} else {
			padding = groupSize - caesarifiedText.length();
		}

		for (int i = 0; i < padding; i++) {
			groupifiedText += "x";
		}
		
		return groupifiedText;
	}

	
	public static String decryptString ( String originalText, int shift) {
		String decryptedText = "";
		
		decryptedText = ungroupify(originalText);
		decryptedText = normalizeText(decryptedText);
		decryptedText = caesarify(decryptedText, - shift);
		return decryptedText;
	}


	public static String ungroupify(String encryptedText) {
		String ungroupifiedText = "";
		String currentLetter = "";
					
		for(int i = 0;i < encryptedText.length();++i) {
			currentLetter = encryptedText.substring(i,i + 1);
			if (!" x".contains(currentLetter)) {
				ungroupifiedText += currentLetter;
			}
		}
		return ungroupifiedText;
	}
	
}