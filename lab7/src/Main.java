import java.io.*;
import java.util.*;

public class Main extends Commands{
    public static List<Beer> beers = new ArrayList<Beer>();
    public static Map<String, Comparator<Beer>> comps;
    public static List<String> lparams;
    static{
        comps = new HashMap<>();
        lparams = new LinkedList<>();

        comps.put("name", Comparator.comparing(Beer::getName));
        comps.put("style", Comparator.comparing(Beer::getStyle));
        comps.put("strength", Comparator.comparing(Beer::getStrength));

        lparams.addAll(comps.keySet());
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<String, Command> commands = fillHashMap();
        String wd = System.getProperty("user.dir");
        File f = new File(wd);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = br.readLine()) != null){
            String[] cmd = line.split(" ");
            Command c = commands.get(cmd[0]);
            c.execute(cmd);
        }

    }
    public static void list(String[] cmd){
        if (cmd.length > 1) {
            lparams.remove(cmd[1]);
            lparams.add(0, cmd[1]);
        }
        Comparator<Beer>
                c1 = comps.get(lparams.get(0)),
                c2 = comps.get(lparams.get(1)),
                c3 = comps.get(lparams.get(2));

        beers.sort(c1.thenComparing(c2.thenComparing(c3)));

        for (Beer beer : beers) {
            System.out.println(beer);
        }

    }
    public static void load(String[] cmd) throws IOException, ClassNotFoundException{
        BufferedReader reader;
        File f = new File(System.getProperty("user.dir"), "beers.txt");
        try{
            reader = new BufferedReader(new FileReader(f));
            String line;
            while((line = reader.readLine()) != null){
                String[] records = line.split(" ");
                Beer tmp = new Beer(records[0], records[1], Double.parseDouble(records[2]));
                beers.add(tmp);
                System.out.println(tmp.toString());
            }
            reader.close();

        }catch (Exception e){
            System.err.println(e);
        }
    }
    public static void save(String[] cmd) throws IOException{
        String fw = System.getProperty("beers.txt");
        File f = new File(System.getProperty("user.dir"), "beers.txt");
        System.out.println(f.getAbsolutePath());
        FileWriter fwriter = null;
        BufferedWriter writer = null;
        try{
            fwriter = new FileWriter(f);
            writer = new BufferedWriter(fwriter);
            for(Beer item : beers){
                writer.write(item.toString() + "\n");
            }
        }catch (Exception e){
            System.err.println(e);
        }finally{
            writer.close();
            fwriter.close();
        }
    }
    public static void search(String[] cmd){
        for(Beer item : beers){
            if (item.getName().equals(cmd[1])){
                System.out.println(item.toString());
            }
        }
    }
    public static void find(String[] cmd){
        for(Beer item : beers){
            if(item.getName().contains(cmd[1])){
                System.out.println(item.toString());
            }
        }
    }
    public static void delete(String[] cmd){
        for(Beer item : beers){
            if(item.getName().equals(cmd[1])){
                beers.remove(item);
                return;
            }
        }
    }
    public static void add(String cmd[]){
        beers.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
    }
    public static void exit(String[] cmd){
        System.exit(0);
    }

    public static HashMap<String, Command> fillHashMap() throws IOException, ClassNotFoundException{
        HashMap<String, Command> tmp = new HashMap<>();

        tmp.put("list", Main::list);
        tmp.put("add", Main::add);
        tmp.put("exit", Main::exit);
        tmp.put("load", Main::load);
        tmp.put("find", Main::find);
        tmp.put("search", Main::search);
        tmp.put("delete", Main::delete);
        tmp.put("save", Main::save);

        return tmp;
    }
}