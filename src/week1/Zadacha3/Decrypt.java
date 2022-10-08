package week1.Zadacha3;

import java.util.Scanner;

public class Decrypt {
    public static int decrypt(int encryptedNumber){
        int[] encryptedDigits = new int[4];
        int index = 0;
        if(!Digit.isFourDigits(encryptedNumber)){
            index = 1;
            encryptedDigits[0] = 0;
            System.out.println("Number is not 4 digits");
        }
        for(int i = index ; i < 4; i++){
            int digit = encryptedNumber % 10;
            encryptedNumber /= 10;
            if(index == 1){
                encryptedDigits[encryptedDigits.length - i] = digit;
            }else{
                encryptedDigits[encryptedDigits.length - i - 1] = digit;
            }
        }
        int [] decryptedDigits = new int[4];
        for(int i = 0; i < encryptedDigits.length; i++){
            int cipher = (encryptedDigits[i]+3)%10;
            System.out.printf("%d -> %d\n", encryptedDigits[i], cipher);
            decryptedDigits[i] = cipher;
        }
        Digit.swap(decryptedDigits,2,0);
        Digit.swap(decryptedDigits,3,1);
        StringBuilder decryptedString = new StringBuilder();
        for (int decryptedDigit : decryptedDigits) {
            decryptedString.append(decryptedDigit);
        }
        return Integer.parseInt(decryptedString.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an encrypted number: ");
        int encryptedNumber = scanner.nextInt();
        int decrypted = decrypt(encryptedNumber);
        System.out.printf("Decrypted digit: %d", decrypted);
    }
}
