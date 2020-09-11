package com.challanges;

public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones j = new JewelsAndStones();
        System.out.println(j.numJewelsInStones("abS", "bcS"));
    }

    public int numJewelsInStones(String j, String s) {

        int numberOfJeewelres = 0;
        for (int i = 0; i < j.length(); i++) {
            if (j.isEmpty()) {
                break;
            }
            if (s.contains(j.substring(i, i))) {
               for(char c : s.toCharArray()) {
                   if(c == j.charAt(i)) {
                       numberOfJeewelres++;
                   }
               }
            }
        }

        return numberOfJeewelres;
    }
}
