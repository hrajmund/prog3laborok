public class Robot extends Jatekos {
    private static int count = 1;
    private int id;
    public Robot(){
        id = count++;
    }
    public void lep(){
        System.out.println(toString());
        System.out.println(asztal.getKor() + ".kor");
    }
    public String toString(){ return "Robot" + id;}
}
