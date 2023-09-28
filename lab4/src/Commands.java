import javax.swing.text.Style;
import java.io.*;
import java.util.List;
import java.util.*;

public class Commands {
    protected static void add(String cmd[], List<Beer> beers){
        beers.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
        System.out.println(cmd[1]);
    }
    protected static void exit(String[] cmd){
        System.exit(0);
    }
    protected static void list(String[] cmd, List<Beer> beers){
        Comparator<Beer> comparator;
        switch (cmd[1]){
            case "name": comparator = new NameComparator();
            case "style": comparator = new StyleComparator();
            case "strength": comparator = new StrengthComparator();
            default: comparator = null;
        }
        Collections.sort(beers, comparator);
        for(Beer item : beers){
            System.out.println(item);
        }
    }
    protected static List<Beer> load(String[] cmd, String file) throws IOException, ClassNotFoundException{
        String fw = System.getProperty("beers.txt");
        File f = new File(fw, file);
        try{
            if(f.exists()){
                FileInputStream fs = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fs);
                List<Beer> temp = (List<Beer>)ois.readObject();
                return temp;
            }
        }catch (Exception e){
            System.err.println(e);
        }

        return null;
    }

    protected static List<Beer> save(String[] cmd, String file) throws IOException{
        String fw = System.getProperty("beers.txt");
        File f = new File(fw, file);
        List<Beer> temp = new ArrayList<Beer>();
        try{
            if(f.exists()){
                FileOutputStream fout = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(temp);
                oos.close();
            }else
                f.createNewFile();
        }catch (Exception e){
            System.err.println(e);
        }
        return null;
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
