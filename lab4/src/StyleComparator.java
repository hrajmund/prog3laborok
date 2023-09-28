import java.util.Comparator;
public class StyleComparator implements Comparator<Beer>{
    @Override
    public int compare(Beer lhs, Beer rhs){
        return lhs.getStyle().compareTo(rhs.getStyle());
    }
}
