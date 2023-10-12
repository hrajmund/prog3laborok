public class Push implements Command{
    public void execute(String[] cmd){
        Main.stack.push(Integer.parseInt(cmd[1]));
    }
}
