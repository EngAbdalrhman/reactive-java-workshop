package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.irsresponsiveFlux() and ReactiveSources.irresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        String str = ReactiveSources.irresponsiveMono().block(Duration.ofSeconds(5)); // never responde (block forever) unless we enter timeout duration
        // in this case if it ends before the value so what is the value then we get an error

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}
