package Singleton;

public class SingletonTest {
    public static void main(String[] args) throws InterruptedException {

        Thread[] t = new Thread[5000];
        for (int i = 0; i < 5000; i++) {
            t[i] = new Thread(new ClassInOtherThread());
            t[i].start();
        }
        for (int i = 0; i < 5000; i++) {
            t[i].join();
        }
        System.out.println("Приватный конструкто синглтона сработал: " + Singleton.counter + " раз");
    }
}

class ClassInOtherThread implements Runnable {

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    public static int counter;
    private static volatile Singleton instance;

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}