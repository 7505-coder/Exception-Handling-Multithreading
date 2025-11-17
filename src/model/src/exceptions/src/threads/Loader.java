package threads;

public class Loader implements Runnable {

    @Override
    public void run() {
        System.out.print("Loading");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
        System.out.println();
    }
}
