public class Application {
    public static void main(String[] args) throws InterruptedException{
        Fifo ff = new Fifo();
        Producer elso = new Producer("Producer 1", 1000, ff);
        Producer masodik = new Producer("Producer 2",1000, ff);
        Consumer proba = new Consumer(ff,"Consumer",1000);

        elso.start();
        masodik.start();
        proba.go();
    }
}
