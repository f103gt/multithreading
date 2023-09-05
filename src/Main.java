//public class Main {
//    public static void main(String[] args) throws InterruptedException{
//        //Thread.currentThread().setPriority(10);
//        ChildThread childThread1 = new ChildThread();
//        //ChildThread childThread2 = new ChildThread();
//        childThread1.start();
//        //childThread2.start();
//        childThread1.join(10000);
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Main thread");
//        }
//    }
//}
//    class ChildThread extends Thread {
//        public void run() {
//            for (int i = 0; i < 6; i++) {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.getStackTrace();
//                }
//            }
//        }
//    }


//make child thread wait until the main thread finishes execution

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ChildThread.parentThread = Thread.currentThread();
        ChildThread childThread1 = new ChildThread();
        childThread1.start();
        //childThread1.join();//deadlock
        Thread.currentThread().join();//deadlock
    }
}

class ChildThread extends Thread {
    static public Thread parentThread;
    public void run() {
        try{parentThread.join();}catch(InterruptedException e){e.getStackTrace();}
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
