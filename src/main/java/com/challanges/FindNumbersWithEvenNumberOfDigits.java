package com.challanges;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits s = new FindNumbersWithEvenNumberOfDigits();
        int a[] = {123,5425,123,5555};
        System.out.println(s.findNumbers(a));
    }

    public int findNumbers(int[] nums) {
        int numberCount=0;
        for(int i = 0; i < nums.length; i++) {
            String  s = String.valueOf(nums[i]);
            if(s.length() % 2 == 0) {
                numberCount++;
            }
        }
        return numberCount;
    }
}
