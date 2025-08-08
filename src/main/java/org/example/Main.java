package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        /*
        Prediction:
        The output will evaluate the `Predicate` to check if each string’s length exceeds 10 characters. For `"short"`,
        `isLong.test()` returns `false` because its length is 5. For `"This is a very long string"`, it returns `true`
        because the length is well above 10.

        Observation:
        Is 'short' long? false
        Is 'This is a very long string' long? true
         */
        Predicate<String> isLong = s -> s.length() > 10;

        String str1 = "short";
        String str2 = "This is a very long string";

        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));

        /*
        Prediction:
        This program creates a list of call signs and uses a lambda-based `Predicate` to filter those that start with
        the letter `"A"`. The `filterAndPrint` method iterates over the list, applies the predicate’s `test()` method
        to each element, and prints only those that meet the condition. As a result, the output lists
        `"Alpha"`, `"Archangel"`, and `"Avenger"` under the heading `"Call signs starting with 'A'"`, since these are
        the only entries that satisfy the `startsWith("A")` check.

        Observation:
        --- Call signs starting with 'A' ---
        Alpha
        Archangel
        Avenger
         */
        System.out.println(" ");
        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println(" ");
        filterAndPrint(callSigns, startsWithA, "Call signs starting with 'A'");


        /*
        Prediction:
        This code output builds based on the earlier predicates by creating a compound condition that checks if a call sign starts
        with `"A"` **and** has a length greater than 5. Using `and()`, the program filters and prints only
        `"Archangel"` and `"Avenger"`, as they satisfy both requirements. It then defines another predicate using
        `negate()` to find call signs that do **not** start with `"A"`, printing `"Bravo"` and `"Echo"` as the results.

        Observation:
        --- Starts with 'A' AND length > 5 ---
        Archangel
        Avenger

        --- Does NOT start with 'A' ---
        Bravo
        Echo
         */
        Predicate<String> hasLengthGreaterThan5 = s -> s.length() > 5;

        Predicate<String> complexCondition = startsWithA.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns, complexCondition, "Starts with 'A' AND length > 5");

        Predicate<String> doesNotStartWithA = startsWithA.negate();
        filterAndPrint(callSigns, doesNotStartWithA, "Does NOT start with 'A'");
    }
    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
}