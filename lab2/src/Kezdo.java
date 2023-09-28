public class Kezdo extends Jatekos {
    private String name;

    public Kezdo(String n){
        name = n;
    }

    public void lep(){
        int kor = asztal.getKor();

        System.out.println("Jatekos neve: " + name);
        System.out.println(asztal.getKor() + ".kor");
        if(kor % 2 == 0)
            asztal.emel(1);
        else
            asztal.emel(0);

    }
    public String toString(){ return name;}
}
