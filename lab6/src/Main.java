import java.util.*;
import java.io.*;
public class Main {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        HashMap<String, Command> map = new HashMap<>();
        map = fillHashMap();
        String wd = System.getProperty("user.dir");
        File f = new File(wd);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = br.readLine()) != null){
            String[] cmd = line.split(" ");
            Command c = map.get(cmd[0]);
            c.execute(cmd);
        }
    }

    public static HashMap<String, Command> fillHashMap(){
        HashMap<String, Command> map = new HashMap<>();

        map.put("exit", new Exit());
        map.put("dup", new Dup());
        map.put("list", new List());
        map.put("pop", new Pop());
        map.put("push", new Push());
        map.put("read", new Read());
        map.put("write", new Write());
        map.put("add", new Add());
        map.put("mult", new Mult());
        map.put("div", new Div());
        map.put("sub", new Sub());

        return map;
    }
}