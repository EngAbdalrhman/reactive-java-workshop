package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
       ReactiveSources.intNumbersFlux()
       .count()
       .subscribe(System.out::println); //** returns mono long of size when the flux completed

        // Collect all items of intNumbersFlux into a single list and print it
        ReactiveSources.intNumbersFlux()
        .collectList()//** returns Mono List of items when finished
        .subscribe(System.out::println);
        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
        .buffer(2)//** take 2 cumulative numbers to do an operation on them (every 2 number of main flux returns 1 event of the new flux)
        .map(list -> list.get(0) + list.get(1)) //** get the sum
        .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
