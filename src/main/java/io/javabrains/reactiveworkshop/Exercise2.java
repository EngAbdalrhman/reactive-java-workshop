package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // ReactiveSources.intNumbersFlux().toIterable().forEach(element -> System.err.println(element)); //**  X don't wait for it and keep finindg all elements (sync)
        ReactiveSources.intNumbersFlux().subscribe(element -> System.err.println(element)); //**  stream emits data and subscripe for event (async)
        // ** Whenever new event emitted then the data is pushed

        // Print all users in the ReactiveSources.userFlux stream
        // ReactiveSources.userFlux().toIterable().forEach(element -> System.err.println(element));
        ReactiveSources.userFlux().subscribe(element -> System.err.println(element));

        //**  Important to force java wait till strams push data
        System.out.println("Press a key to end");
        System.in.read();
    }

}
