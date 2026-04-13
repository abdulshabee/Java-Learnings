package learnings.designPattern;

/**
 * In this method, object is created only if it is needed. This may prevent resource wastage.
 * An implementation of getInstance() method is required which return the instance.
 * There is a null check that if object is not created then create, otherwise return previously created.
 * To make sure that class cannot be instantiated in any other way, constructor is made final.
 * As object is created with in a method, it ensures that object will not be created until and unless it is required.
 * Instance is kept private so that no one can access it directly.
 * It can be used in a single threaded environment because multiple threads can break singleton property as
 * they can access get instance method simultaneously and create multiple objects.
 *
 * Pros:
 * Object is created only if it is needed. It may overcome wastage of resource and  CPU time.
 * Exception handling is also possible in method.
 * Every time a condition of null has to be checked.
 * instance can't be accessed directly.
 * In multithreaded environment, it may break singleton property.
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy(){
        // empty constructor
        System.out.println("constructor");
    }

    public static SingletonLazy getInstance(){
        System.out.println("GetInstance class");
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("main method");

        SingletonLazy Obj1 = SingletonLazy.getInstance();
        SingletonLazy Obj2 = SingletonLazy.getInstance();
        System.out.println(Obj2);
        System.out.println(Obj2);


    }
}
