package learnings.classAndObjs.Nested;

/**
 * A nested class is a member of its enclosing class. Non-static nested classes (inner classes) have access to
 * other members of the enclosing class, even if they are declared private. Static nested classes do not have access to other members of the enclosing class. As a member of the OuterClass, a nested class can be declared private, public,
 * protected, or package private. (Recall that outer classes can only be declared public or package private.)
 */
public class NestedClass {


}


// Terminology: Nested classes are divided into two categories: non-static and static. Non-static nested classes
// are called inner classes. Nested classes that are declared static are called static nested classes.
class outerClass{
    // Inner class
    class innerClass{

    }
}

class  Outerclass1 {
    static class staticNestedClass{

    }
        }
