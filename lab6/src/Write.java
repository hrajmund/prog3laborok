public class Write implements Command{
    public void execute(String[] cmd){
        System.out.println(Main.stack.peek());
        Main.stack.pop();
    }
}
