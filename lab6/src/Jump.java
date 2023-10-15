import java.util.Map;

public class Jump implements Command{
    public void execute(String[] cmd){
        int getIndex = 0;
        for(Map.Entry<String, Integer> item : Main.labels.entrySet()){
            if(item.getKey().equals(cmd[1])){
                getIndex = item.getValue();
            }
        }
        Main.pc = getIndex - 1;
    }

}

