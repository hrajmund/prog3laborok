import java.util.Comparator;
public class NameComparator implements Comparator<Beer>{
    @Override
    public int compare(Beer lhs, Beer rhs){
        return lhs.getName().compareTo(rhs.getName());
    }
}
