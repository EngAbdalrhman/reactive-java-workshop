package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

   

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> list = ReactiveSources.intNumbersFlux().toStream().toList(); // waiting all items to come (blocking operation) so that we don;t need the press key wait 
        System.out.println(list);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
