import java.util.*;
import java.io.*;
public class Main {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{

        String wd = System.getProperty("user.dir");
        File f = new File(wd);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = br.readLine()) != null){
            String[] cmd = line.split(" ");
            if(cmd[0].equals("exit")) {
                Exit exit = new Exit();
                exit.execute(cmd);
            }else if(cmd[0].equals("list")){
                List list = new List();
                list.execute(cmd);
            }else if(cmd[0].equals("push") && cmd.length == 2){
                Push push = new Push();
                push.execute(cmd);
            }else if(cmd[0].equals("pop")){
                Pop pop = new Pop();
                pop.execute(cmd);
            }else if(cmd[0].equals("dup")){
                Dup dup = new Dup();
                dup.execute(cmd);
            }else if(cmd[0].equals("read")){

            }else if(cmd[0].equals("write")){

            }
        }
    }
}