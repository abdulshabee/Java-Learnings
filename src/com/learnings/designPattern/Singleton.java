package com.learnings.designPattern;

// Jave Code to create simple Singleton class by Eager initialization

/**
 * Eager initialization: This is the simplest method of creating a singleton class.
 * In this, object of class is created when it is loaded to the memory by JVM.
 * It is done by assigning the reference of an instance directly.
 * It can be used when program will always use instance of this class,
 * or the cost of creating the instance is not too large in terms of resources and time
 *
 * Very simple to implement.
 * <Br>May lead to resource wastage. Because instance of class is created always, whether it is required or not.</br>
 * CPU time is also wasted in creation of instance if it is not required.
 * Exception handling is not possible.
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton(){
        // Constructor to create object on first initiate
        System.out.println("****** Objects Created *****");
    }

    public static Singleton getInstance(){
        return instance;
    }

    // Here you can easy call the constructor and created object. we're suppose to do outside of class
    // For learning purpose, I have created main method in same class.
    public static void main(String[] args) {
        System.out.println("*** Main Method ****");
        Singleton object1 = Singleton.getInstance();
        Singleton object2 = Singleton.getInstance();

        System.out.println(object1.toString());
        System.out.println(object2.toString());
    }
}


