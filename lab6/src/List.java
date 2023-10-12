public class List implements Command{
    public void execute(String[] cmd){
        for(int item : Main.stack){
            System.out.println(item);
        }
    }
}
