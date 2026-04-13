package learnings.designPattern;

/**
 * In this mechanism, we overcome the overhead problem of synchronized code.
 * In this method, getInstance is not synchronized but the block which creates instance is synchronized so
 * that minimum number of threads have to wait and that's only for first time.
 *
 * Lazy initialization is possible.
 * It is also thread safe.
 * Performance overhead gets reduced because of synchronized keyword.
 * First time, it can affect performance.
 */
public class SingletonThreadWaitLess {

    /**
     * JDK5 and later extends the semantics for volatile so that the system will not allow a write of a volatile to be
     * reordered with respect to any previous read or write, and a read of a volatile cannot be reordered with respect
     * to any following read or write. See this entry in Jeremy Manson's blog for more details.
     */
    private static volatile SingletonThreadWaitLess instance;

    private SingletonThreadWaitLess(){
        System.out.println("Constructor");
    }

    public static SingletonThreadWaitLess getInstance(){

        if(instance == null){
            synchronized (SingletonThreadWaitLess.class){
                if(instance == null){
                    instance = new SingletonThreadWaitLess();
                }
            }
        }

        return  instance;
    }
}
