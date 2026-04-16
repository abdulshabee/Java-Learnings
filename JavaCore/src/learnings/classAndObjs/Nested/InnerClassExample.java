package learnings.classAndObjs.Nested;

import java.util.Iterator;

public class InnerClassExample {

    private final static int size = 15;
    private int[] arrays = new int[size];

    public InnerClassExample(){
        for (int i = 0; i < size; i++) {
            arrays[i] = i;
        }
    }

    public static void main(String[] args) {
    InnerClassExample inner = new InnerClassExample();
    inner.print();
    }

    private void print(){
        DataStructureInterface iterator = this.new EvenIterable();

        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");

        }
        System.out.println();
    }

    interface DataStructureInterface extends Iterator<Integer>{
        // interface
    }

    private class EvenIterable implements DataStructureInterface{

        private int nextIndex = 0;
        @Override
        public boolean hasNext() {
            return (nextIndex <= size);
        }

        @Override
        public Integer next() {
            Integer nextInt = Integer.valueOf(nextIndex);

            nextIndex += 2;

            return nextInt;
        }
    }

}
