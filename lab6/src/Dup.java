public class Dup implements Command{
    public void execute(String[] cmd){
        if(Main.stack.peek() != null)
            Main.stack.push(Main.stack.peek());
        else
            throw new NullPointerException();

    }
}
