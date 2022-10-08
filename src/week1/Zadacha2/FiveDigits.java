package week1.Zadacha2;

import java.util.Scanner;

public class FiveDigits {
    public static boolean isFiveDigits(int number){
        int counter = 0;
        while(number != 0){
            number /= 10;
            counter++;
        }
        return counter == 5;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 5-digit number: ");
        int inputNumber = scanner.nextInt();
        if(!isFiveDigits(inputNumber)){
            System.err.println("Number is not five digits!");
            System.exit(1);
        }
        int originalValueNumber = inputNumber;
        int [] separatedNumbers = new int[5];
        for (int i = 0; i < 5; i++){
            int digit = inputNumber % 10;
            separatedNumbers[separatedNumbers.length-i-1]= digit;
            inputNumber /= 10;
        }
        boolean isPalindrome = true;
        for(int i = 0; i < separatedNumbers.length; i++){
            if (separatedNumbers[i] != separatedNumbers[separatedNumbers.length - i - 1]) {
                isPalindrome = false;
                break;
            }
        }
        String resultString;
        if(isPalindrome){
            resultString = originalValueNumber + " is a palindrome";
        }else{
            resultString = originalValueNumber + " is not a palindrome";
        }
        System.out.println(resultString);
    }
}
