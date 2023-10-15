public class Store implements Command{
    public void execute(String[] cmd){
        Main.vars.put(cmd[1], Main.stack.peek());
    }
}
