package com.walhalla.cryptor;

import java.util.Arrays;
import java.util.Base64;

public class Cryptor {


    public static void main(String[] args) {
        encode("com.walhalla.luckypatcher.MyApp");

        String d = decode(new int[]{
                61, 61, 65, 99, 119, 70, 85, 101, 78, 53, 105, 99, 108, 104, 50, 89, 48, 70, 71, 99, 53, 116, 50, 89, 49, 120, 109, 76, 104, 120, 71, 98, 104, 104, 71, 98, 104, 100, 110, 76, 116, 57, 50, 89
        });

        System.out.println("D: " + d);
    }


    private static void encode(String message) {
        String encodedString = Base64.getEncoder().encodeToString(
                message.getBytes());

        StringBuilder step2 = new StringBuilder(encodedString).reverse();
        char[] step3 = step2.toString().toCharArray();
        int[] step4 = new int[step3.length];

        for (int i = 0; i < step3.length; i++) {
            step4[i] = (int) step3[i];
        }
        System.out.println("E: " + Arrays.toString(step4));

    }

    private static String decode(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            sb.append((char) i);
        }

        byte[] decodedBytes = Base64.getDecoder().decode(
                sb.reverse().toString()
        );
        return new String(decodedBytes);
    }

}