public class Jump implements Command{
    public void execute(String[] cmd){
        Main.pc = Integer.parseInt(cmd[1]) - 1;
    }
}
