package week2.Zad3;

public class Number {
    public static void main(String[] args) {
        int countTargetedNumber = 0;
        int countTargetedNumberAndIsDividedBy12 = 0;
        for(int i = 10000; i < 100000; i++){
            if(i / 10000 >= 3){
                int secondDigit = (i / 1000) % 10;
                if(secondDigit >= 2 && secondDigit <= 8){
                    int thirdDigit = (i / 100) % 10;
                    if(thirdDigit >= 4){
                        int fourthDigit = (i / 10) % 10;
                        if(fourthDigit >= 1 && fourthDigit <= 6){
                            int fifthDigit = i % 10;
                            if(fifthDigit >= 6){
                                if(i % 12 == 0){
                                    countTargetedNumberAndIsDividedBy12++;
                                }
                                countTargetedNumber++;
                            }
                        }
                    }
                }
            }

        }
        double probability = countTargetedNumberAndIsDividedBy12 / 89000.0;
        String result = String.format("Probability: %f\nCount of eligible numbers: %d\nCount of eligible numbers that can be divided by 12: %d", probability, countTargetedNumber, countTargetedNumberAndIsDividedBy12);
        System.out.println(result);

    }
}
