class TestThread1 extends Thread {
    public void run() {
        try {
            Thread.sleep(5000);
            for (int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
//class TestThread2 extends Thread {
//    public void run() {
//        System.out.println("Test2");
//    }
//}

public class Main  {    

    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1();
        TestThread1 t2 = new TestThread1();

        t1.start();
        try {
            t1.interrupt();
        }
        catch ( Exception e ) {
            System.out.println("Exception handled \n" + e);

        }
        t2.start();

    }
}


