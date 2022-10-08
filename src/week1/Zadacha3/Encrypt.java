package week1.Zadacha3;

import java.util.Scanner;


public class Encrypt {

    public static int encrypt(int number){
        int[] encryptedDigits = new int[4];
        for(int i = 0 ; i < 4; i++){
            int digit = number % 10;
            number /= 10;
            int cipher = (digit+7)%10;
            encryptedDigits[encryptedDigits.length-i-1] = cipher;
        }
        Digit.swap(encryptedDigits, 0, 2);
        Digit.swap(encryptedDigits, 1, 3);
        StringBuilder encryptedString = new StringBuilder();
        for (int encryptedDigit : encryptedDigits) {
            encryptedString.append(encryptedDigit);
        }
        return Integer.parseInt(encryptedString.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 4-digit number: ");
        int packet = scanner.nextInt();
        if(!Digit.isFourDigits(packet)){
            System.err.println("Digit is not four digits!");
            System.exit(1);
        }
        int encrypted = encrypt(packet);
        System.out.printf("Encrypted digit: %d", encrypted);
    }
}
