import java.util.Comparator;
public class StrengthComparator implements Comparator<Beer>{
    @Override
    public int compare(Beer lhs, Beer rhs){
        return Double.compare(lhs.getStrength(), rhs.getStrength());
    }
}
