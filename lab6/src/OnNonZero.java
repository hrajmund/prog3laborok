public class OnNonZero implements Command{
    public void execute(String[] cmd){
        if(Main.stack.pop() != 0){
            Main.pc = Integer.parseInt(cmd[1]) - 1;
        }
    }
}
