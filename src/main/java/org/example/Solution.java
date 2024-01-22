package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class Solution {
    public static void main(String[] args) {
        //------------------------------------------------------------------------
        Consumer<Integer> squareConsumer = (Integer number) -> {
            int square = number * number;
            System.out.println("Square of " + number + " is: " + square);
        };
        squareConsumer.accept(7);
        //------------------------------------------------------------------------
        Supplier<String> stringSupplier = () -> "Hello, World!";
        String result = stringSupplier.get();
        System.out.println(result);
        //-----------------------------------------------------------------------
        List<Integer> numbersList = Arrays.asList(1,2,3,4,5);
        numbersList.parallelStream().forEach(x-> System.out.println(x));
        //-----------------------------------------------------------------------
        Predicate<Integer> isEven = num ->  num*2==0;
        System.out.println(isEven.test(4));
        //-----------------------------------------------------------------------
        BiFunction<String, String, String> concatenateFunction = (str1, str2) -> str1 + str2;
        System.out.println(concatenateFunction.apply("Karthik"," Addanki"));
        //----------------------------------------------------------------------

    }


}
