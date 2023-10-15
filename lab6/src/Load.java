import java.util.HashMap;
import java.util.Map;

public class Load implements Command{
    public void execute(String[] cmd){
        for(Map.Entry<String, Integer> item : Main.vars.entrySet()){
            if(item.getKey().equals(cmd[1])){
                Main.stack.push(item.getValue());
            }
        }
    }
}
