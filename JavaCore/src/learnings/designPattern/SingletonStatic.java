package learnings.designPattern;

/**
 * Using static block: This is also a sub part of Eager initialization. The only difference is object is created in a static block so that we can have access on its creation, like exception handling. In this way also, object is created at the time of class loading.
 * It can be used when there is a chance of exceptions in creating object with eager initialization.
 *
 *
 * Pros:
 * Very simple to implement.
 * No need to implement getInstance() method. Instance can be accessed directly.
 * Exceptions can be handled in static block.
 * May lead to resource wastage. Because instance of class is created always, whether it is required or not.
 * CPU time is also wasted in creation of instance if it is not required.
 */
public class SingletonStatic {

    private static SingletonStatic instance;

    static {
        System.out.println("Static block triggered");
        instance = new SingletonStatic();

    }

    private SingletonStatic(){
        // making constructor as private
    }

    public static void main(String[] args) {
        System.out.println("Main method");

        SingletonStatic obj1 = SingletonStatic.instance;
        SingletonStatic obj2 = SingletonStatic.instance;

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
    }
}
