package bsu.strings.rabincarp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp("cat");
        String text = "cat is a home pat, cat ! asd, cat";
        System.out.println(rabinKarp.count(text, rabinKarp.getPat()));
        System.out.println(Arrays.toString(rabinKarp.searchAll(text, rabinKarp.getPat())));
    }
}
