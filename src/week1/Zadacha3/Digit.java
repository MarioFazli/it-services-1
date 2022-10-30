package week1.Zadacha3;

public class Digit {
    public static boolean isFourDigits(int number){
        int counter = 0;
        while(number != 0){
            number /= 10;
            counter++;
        }
        return counter == 4;
    }
    public static void swap(int[] arr, int a, int b){
        int hold = arr[a];
        arr[a] = arr[b];
        arr[b] = hold;
    }
}
