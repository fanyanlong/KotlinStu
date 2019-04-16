package stsfan.com.kotlinstu;

public class Mode {

    private static Thread thread;

    public static void main(String[] args) {
        thread = new Thread(() -> System.out.print("7777"));
        thread.start();
    }


}
