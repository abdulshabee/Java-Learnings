package learnings.classAndObjs;

import java.util.function.BiFunction;

/**
 * There are four kinds of method references:
 * <table border="1" cellpadding="5">
 *   <caption>Method Reference Types</caption>
 *   <thead>
 *     <tr>
 *       <th>Kind</th>
 *       <th>Syntax</th>
 *       <th>Examples</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>Reference to a static method</td>
 *       <td>{@code ContainingClass::staticMethodName}</td>
 *       <td>
 *         {@code Person::compareByAge}<br>
 *         {@code MethodReferencesExamples::appendStrings}
 *       </td>
 *     </tr>
 *     <tr>
 *       <td>Reference to an instance method of a particular object</td>
 *       <td>{@code containingObject::instanceMethodName}</td>
 *       <td>
 *         {@code myComparisonProvider::compareByName}<br>
 *         {@code myApp::appendStrings2}
 *       </td>
 *     </tr>
 *     <tr>
 *       <td>Reference to an instance method of an arbitrary object of a particular type</td>
 *       <td>{@code ContainingType::methodName}</td>
 *       <td>
 *         {@code String::compareToIgnoreCase}<br>
 *         {@code String::concat}
 *       </td>
 *     </tr>
 *     <tr>
 *       <td>Reference to a constructor</td>
 *       <td>{@code ClassName::new}</td>
 *       <td>{@code HashSet::new}</td>
 *     </tr>
 *   </tbody>
 * </table>
 */
public class MethodReferenceExample {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger){
        return merger.apply(a, b);
    }

    // static
    public static String append1 (String a, String b){
        return  a + b;
    }

    // non static method
    public  String append2(String a, String b){
        return a + b;
    }

    public static void main(String[] args) {

        MethodReferenceExample app = new MethodReferenceExample();

        // Calling the method mergeThings with a lambda expression
        System.out.println(MethodReferenceExample.mergeThings("Hello", "World!", (a, b) -> a + b));

        // Reference to a static method
        System.out.println(MethodReferenceExample.mergeThings("Hello", "World!", MethodReferenceExample::append1));

        // Reference to an instance method of a particular object
        System.out.println(MethodReferenceExample.mergeThings("Hello", "World!", app::append2));

        // Reference to an instance method of an arbitrary object of a
        // particular type
        System.out.println(MethodReferenceExample.
                mergeThings("Hello ", "World!", String::concat));


    }
}
