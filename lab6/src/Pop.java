public class Pop implements Command{
    public void execute(String[] cmd){
        Main.stack.pop();
    }
}
