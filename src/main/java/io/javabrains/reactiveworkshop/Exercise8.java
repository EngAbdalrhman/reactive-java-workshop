package io.javabrains.reactiveworkshop;

import java.io.IOException;

import reactor.core.publisher.Flux;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
        .subscribe(e -> System.out.println(e), err -> System.out.println("Error : " + err.getMessage())); //** catch the error
        //** Another Method
        ReactiveSources.intNumbersFluxWithException()
        .doOnError(err -> System.out.println("Error : " + err.getMessage())) //** pass the error and do action 
        .subscribe(e -> System.out.println(e)); 

        // Print values from intNumbersFluxWithException and continue on errors
       ReactiveSources.intNumbersFluxWithException()
        .onErrorContinue((err,item) -> System.out.println("Error : " + err.getMessage())) //** continue after handling an error , and the item is who made the exception
        .subscribe(e -> System.out.println(e)); 

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
        .onErrorResume(err -> Flux.just(-1,-2)) //** when error happen , replace with a fallback sequence (switch flux)
        .subscribe(e -> System.out.println(e)); 

        System.out.println("Press a key to end");
        System.in.read();
    }

}
