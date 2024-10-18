package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
            element -> {
                System.out.println(element);
            },
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("done")
        );

        Disposable subscribe = ReactiveSources.userFlux().subscribe(
            element -> System.out.println(element),
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete")
        );
        try {
            Thread.sleep(3000);
            subscribe.dispose(); // force stop the subscribtion
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       

        //** Don't use the 4th Signature it's Dubricated

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
class MySubscriber<T> extends BaseSubscriber<T>{
    //** this Method is important in controlling the rate of flow */
    public void hookOnSubscribe(Subscription subscription){
        System.out.println("Subscribed");
        request(3); //** you have to ask in this model to get items with limit of you can keep up with , the hookOnNext says i'm ready
        // I'm Ok with handling 3 items give me them when they are ready - after reciving them you need to request again
    }

    public void hookOnNext(T value){
        System.out.printf("a %s value emmited \n",value.toString());
        request(2); // to request after reciving (ok to push)
    }
}