package learnings.classAndObjs.Nested;

public class HelloWorldAnonymousClass {

    interface HelloWorld{
        void great();
        void greatSomeone(String name);
    }

    public static void sayHello(){
         class EnglishHelloWorld implements HelloWorld{

             @Override
             public void great() {
                 System.out.println("hello");
             }

             @Override
             public void greatSomeone(String name) {
                System.out.println("Hello, " + name);
             }
         }

         HelloWorld englishHello = new EnglishHelloWorld();
         englishHello.great();
         englishHello.greatSomeone("Shabeer");


         HelloWorld tamilHello = new HelloWorld() {
             @Override
             public void great() {
                 System.out.println("vanakkam");
             }

             @Override
             public void greatSomeone(String name) {
                System.out.println("Vannakam, " + name);
             }
         };

         tamilHello.great();
         tamilHello.greatSomeone("Abdul");
    }

    public static void main(String[] args) {
        sayHello();
    }
}
