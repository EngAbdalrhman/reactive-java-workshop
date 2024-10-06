package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // StreamSources.intNumbersStream().forEach(num -> System.out.println(num)); // lamda exprission
        StreamSources.intNumbersStream().forEach(System.out::println);
        System.out.println("------------------");
        // Print numbers from intNumbersStream that are less than 5
        // StreamSources.intNumbersStream().forEach(num ->{
        //     if (num < 5) {
        //         System.out.println(num);
        //     }
        // });
        /*
        Types of Method References:
        - Reference to a static method.  Syntax ==> ContainingClass::staticMethodName  
        - Reference to an instance method.  Syntax ==> containingObject::instanceMethodName  
        - Reference to a constructor.  Syntax ==> ClassName::new  
        */
        StreamSources.intNumbersStream()
        .filter(num -> num < 5)
        .forEach(System.out::println);
        System.out.println("------------------");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // StreamSources.intNumbersStream().forEach(num ->{
        //     int c = 0 , d = 0;
        //     if (num > 5){
        //         System.out.println("num = " + num);
        //         System.out.println("c = " + c);
        //         System.out.println("d = " + d);
        //         c+=1;
        //         if(c > 1){
        //             d+=1;
        //             if(d < 3)
        //                 System.out.println(num);
        //         }
              
                // System.out.println(StreamSources.intNumbersStream().skip(1).findFirst().get());
                // System.out.println(StreamSources.intNumbersStream().skip(1).limit(2).findFirst().orElse(-1));
                // Optional<Integer> second = StreamSources.intNumbersStream().skip(1).findFirst();
                // Optional<Integer> third = StreamSources.intNumbersStream().skip(2).findFirst();
                // if(second.isPresent() && third.isPresent()){
                //     System.out.println(second.get() + ", " + third.get());
                // }else{
                //     System.out.println("No second or third numbers found");
                // }
        //     }
           
        // });
        StreamSources.intNumbersStream()
        .filter(num -> num > 5)
        .skip(1)
        .limit(2)
        .forEach(System.out::println);
        System.out.println("------------------");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        int firstGreaterThanFive = StreamSources.intNumbersStream()
        .filter(num -> num > 5)
        .findFirst()
        .orElse(-1);
        System.out.println(firstGreaterThanFive);
        System.out.println("------------------");
        // Print first names of all users in userStream
        StreamSources.userStream()
        .map(User::getFirstName)
        .forEach(System.out::println);
        // StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()) );
        System.out.println("------------------");
        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
        .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
        .map(User::getFirstName)
        .forEach(System.out::println);
    }

}
