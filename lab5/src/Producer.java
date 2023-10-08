import java.util.*;

public class Producer extends Thread{
    String str;
    Fifo ff;
    int sleepTime;

    Producer(String str, int sleepTime, Fifo ff){
        this.str = str;
        this.sleepTime = sleepTime;
        this.ff = ff;
    }
    public void go(){
        long time = System.currentTimeMillis();
        Date dateTime = new Date();
        long t = dateTime.getTime();
        int i = 0;
        while(true){
            try{
                synchronized (ff){
                    ff.put(str + " " + i + " " + t);
                    System.out.println(str + " " + i + " " + t);
                }
                Thread.sleep(sleepTime);
                i++;
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }

    }
    public void run(){
        this.go();
    }
}
