public class Mult implements Command{
    public void execute(String[] cmd){
        int first = Main.stack.pop();
        int second = Main.stack.pop();
        Main.stack.push(first*second);
    }
}
