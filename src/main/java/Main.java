class TestThread1 extends Thread {
    public void run() {

        while (true){
            try {
                Thread.sleep(500);
                System.out.println("Test1");
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("I am interrupted - Test1");

    }
}
class TestThread2 extends Thread {
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Test2");
        }
        System.out.println("I am interrupted - Test2");
    }
}

public class Main  {


    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1();
        TestThread2 t2 = new TestThread2();

        t1.start();
        try {
            t1.interrupt();
        }
        catch ( Exception e ) {
            System.out.println("Exception handled \n" + e);

        }
        t2.start();
        t2.interrupt();
    }
}


