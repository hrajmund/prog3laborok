public class Consumer extends Thread{
    Fifo f;
    String s;
    int n;
    public Consumer(Fifo f, String s, int n) {
        this.f = f;
        this.s = s;
        this.n = n;
    }
    public void go() throws InterruptedException{
        long time = System.currentTimeMillis();
        while(true){
            if(f.data.isEmpty()){
                try{
                    System.out.println("Consumed " + s + " " + f + " " + time);
                    Thread.sleep(n);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }

}
