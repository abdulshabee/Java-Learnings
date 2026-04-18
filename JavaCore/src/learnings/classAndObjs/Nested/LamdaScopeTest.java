package learnings.classAndObjs.Nested;

import java.util.function.Consumer;

public class LamdaScopeTest {

    public int x = 0;

    class FirstLevel{

        public int x = 1;

        void FirstLevelMethod(int x){

            int z = 2;
            Consumer<Integer> consumer = y -> {
                System.out.println(" x =" + x);
                System.out.println(" y =" + y);
                System.out.println(" z =" + z);
                System.out.println("this.x = " + this.x);
                System.out.println("LamdaScope.this.x = " + LamdaScopeTest.this.x );
            };

            consumer.accept(x);
        }
    }

    public static void main(String[] args) {

        LamdaScopeTest lamda = new LamdaScopeTest();
         lamda. new FirstLevel().FirstLevelMethod(23);
    }
}
