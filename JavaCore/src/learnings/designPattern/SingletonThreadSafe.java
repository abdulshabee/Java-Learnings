package learnings.designPattern;


/**
 * A thread safe singleton is created so that singleton property is maintained even in multithreaded environment.
 * To make a singleton class thread safe, getInstance() method is made synchronized so that multiple threads can't
 * access it simultaneously.
 *
 * Pro's
 * Lazy initialization is possible.
 * It is also thread safe.
 * getInstance() method is synchronized so it causes slow performance as multiple threads can't access it simultaneously.
 */
public class SingletonThreadSafe {


    private static  SingletonThreadSafe instance;

    private SingletonThreadSafe(){
        System.out.println("Constructor");
    }

    // synchronized method to control simultaneous acess
    synchronized public static SingletonThreadSafe getInstance(){
        if (instance == null){
            instance = new SingletonThreadSafe();

        }
        return  instance;
    }

}
