import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main extends Commands{
    public static List<Beer> beers = new ArrayList<Beer>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String wd = System.getProperty("user.dir");
        File f = new File(wd);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = br.readLine()) != null){
            String[] cmd = line.split(" ");
            if(cmd[0].equals("add") && cmd.length == 4){
                add(cmd, beers);
            }else if(cmd[0].equals("exit")){
                exit(cmd);
            }else if(cmd[0].equals("list")){
                list(cmd, beers);
            }else if(cmd[0].equals("load")){
                beers = load(cmd,wd);
            }else if(cmd[0].equals("save")){
                save(cmd, wd, beers);
            }else if(cmd[0].equals("search")){
                search(cmd, beers);
            }else if(cmd[0].equals("find")){
                find(cmd,beers);
            }else if(cmd[0].equals("delete")){
                delete(cmd,beers);
            }
        }

    }
}