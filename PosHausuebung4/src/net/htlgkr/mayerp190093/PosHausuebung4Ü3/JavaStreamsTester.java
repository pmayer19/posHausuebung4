/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mayerp190093.PosHausuebung4Ü3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mayer
 */
public class JavaStreamsTester {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("aaa");
        strings.add("ene");
        strings.add("enes");
        String seperator = ";";

        System.out.println("empty Strings: " + getCountEmptyString(strings));
        System.out.println("Strings with length of 3: " + getCountLength3(strings));
        System.out.println("deleted empty StringList:");
        for (int i = 0; i < deleteEmptyStrings(strings).size(); i++) {
            System.out.print(deleteEmptyStrings(strings).get(i));
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("MergedString: " + getMergedString(strings, seperator));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(23);
        numbers.add(44);
        numbers.add(13);
        numbers.add(4);

        System.out.println("getSquares: " + getSquares(numbers));
        System.out.println("getMax: " + getMax(numbers));
        System.out.println("getMin: " + getMin(numbers));
        System.out.println("getSum: " + getSum(numbers));
        System.out.println("getAverage: " + getAverage(numbers));
    }

    private static int getCountEmptyString(List<String> strings) {
        return strings.stream().filter(s -> s.equals("")).collect(Collectors.toList()).size();
    }

    private static int getCountLength3(List<String> strings) {
        return strings.stream().filter(s -> s.length() == 3).collect(Collectors.toList()).size();
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        return strings.stream().filter(s -> !s.equals("")).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String seperator) {
        return strings.stream().collect(Collectors.joining(seperator));
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream().map(i -> (int) Math.pow(i, 2)).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get();
    }

    private static int getMin(List<Integer> numbers) {
        return numbers.stream().min(Integer::compareTo).get();
    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream().reduce((a, b) -> a + b).get();
    }

    private static int getAverage(List<Integer> numbers) {
        return (int) Arrays.stream(numbers.stream().mapToInt(Integer::intValue).toArray()).average().getAsDouble();
    }
}
