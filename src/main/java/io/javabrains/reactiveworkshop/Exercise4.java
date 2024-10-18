package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // ReactiveSources.intNumberMono().subscribe(element -> System.out.println(element)); //** once gets 1st object its done
        ReactiveSources.intNumberMono().subscribe(
            element -> System.out.println(element),
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("done")
        );
        // Get the value from the Mono into an integer variable
        Integer num = ReactiveSources.intNumberMono().block(); //** may only contains 1 emitted elemnt / wait till it emmits (block)
        Optional<Integer> opn = ReactiveSources.intNumberMono().blockOptional(); 
        //** When blocking if nothing we got we will keep waiting so we can return events like failure event in such sitiuation or return error -> Exp 6

        System.out.println("Press a key to end");
        System.in.read();
        // flux like Mono<Mono<object>>
    }

}
