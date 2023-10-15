import java.util.Map;

public class OnZero implements Command{
    public void execute(String[] cmd){
        if(Main.stack.pop() == 0){
            int getIndex = 0;
            for(Map.Entry<String, Integer> item : Main.labels.entrySet()){
                if(item.getKey().equals(cmd[1])){
                    getIndex = item.getValue();
                }
            }
            Main.pc = getIndex - 1;
        }

    }
}
