import java.io.*;
import java.util.List;
import java.util.*;

public class Commands {
    protected static void add(String cmd[], List<Beer> beers){
        beers.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
    }
    protected static void exit(String[] cmd){
        System.exit(0);
    }
    protected static void list(String[] cmd, List<Beer> beers){
        Comparator<Beer> comparator;
        if(cmd.length > 1){
            switch (cmd[1]){
                case "name": comparator = new NameComparator(); break;
                case "style": comparator = new StyleComparator(); break; 
                case "strength": comparator = new StrengthComparator(); break;
                default: comparator = null; break;
            }
            if(comparator == null){
                System.out.println("nem jo");
            }else{
                Collections.sort(beers, comparator);
            for(Beer item : beers){
                System.out.println(item);
            }
            }
            
        }else{
            for(Beer item : beers){
                System.out.println(item);
            }
        }
        
    }
    protected static List<Beer> load(String[] cmd, String file) throws IOException, ClassNotFoundException{
        BufferedReader reader;
        File f = new File(file, "beers.txt");
        List<Beer> beers = new ArrayList<Beer>();
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
            return beers;
        }catch (Exception e){
            System.err.println(e);
        }

        return null;
    }

    protected static void save(String[] cmd, String file, List<Beer> beers) throws IOException{
        String fw = System.getProperty("beers.txt");
        File f = new File(file, "beers.txt");
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
    protected static void search(String[] cmd, List<Beer> beers){
        for(Beer item : beers){
            if (item.getName().equals(cmd[1])){
                System.out.println(item.toString());
            }
        }
    }
    protected static void find(String[] cmd, List<Beer> beers){
        for(Beer item : beers){
            if(item.getName().contains(cmd[1])){
                System.out.println(item.toString());
            }
        }
    }
    protected static void delete(String[] cmd, List<Beer> beers){
        for(Beer item : beers){
            if(item.getName().equals(cmd[1])){
                beers.remove(item);
                return;
            }
        }
    }
}
