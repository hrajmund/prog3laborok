import java.util.LinkedList;

public class Fifo {
    LinkedList<String> data = new LinkedList<>();

    public synchronized void put(String in) throws InterruptedException {
        while(data.size() == 10){
            Thread.sleep(1000);
        }
        notify();
        data.add(in);
    }
    public synchronized String get() throws InterruptedException{
        while(data.isEmpty()){
            Thread.sleep(1000);
        }
        notify();

        String tmp = data.get(0);
        data.remove(0);
        return tmp;
    }
}
