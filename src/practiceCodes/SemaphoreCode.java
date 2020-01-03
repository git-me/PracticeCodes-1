import java.util.concurrent.Semaphore;

public class SemaphoreCode {
// https://leetcode.com/problems/print-in-order/
        private Semaphore printingSemaphore;
        private int printingIndex;

        public SemaphoreCode() {
            this.printingSemaphore = new Semaphore(1);
            this.printingIndex = 1;
        }

        private void acquireSemaphoreByIndex(int expectedIndex, Runnable print) {
            boolean hasPrinted = false;
            while (!hasPrinted) {
                boolean permit = false;
                try {
                    if (printingIndex == expectedIndex) {
                        permit = printingSemaphore.tryAcquire();
                    }
                    if (permit) {
                        hasPrinted = true;
                        printingIndex++;
                        print.run();
                    }
                } finally {
                    if (permit) {
                        printingSemaphore.release();
                    }
                }
            }
        }

        public void first(Runnable printFirst) throws InterruptedException {
            acquireSemaphoreByIndex(1, printFirst);
            System.out.println("first");
        }

        public void second(Runnable printSecond) throws InterruptedException {
            acquireSemaphoreByIndex(2, printSecond);
            System.out.println("second");
        }

        public void third(Runnable printThird) throws InterruptedException {
            acquireSemaphoreByIndex(3, printThird);
                System.out.println("third");
        }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreCode s=new SemaphoreCode();
       // SemaphoreCode s1=new SemaphoreCode();
        Thread A=new Thread();
        Thread B=new Thread();
        Thread C=new Thread();

        s.first(A); s.second(B);
        s.third(C);



    }
}
