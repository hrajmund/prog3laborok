import java.util.*;
public class Asztal {
    private Jatekos[] jatekosok = new Jatekos[10];
    private double tet;
    private int kor;
    private double goal;

    public void ujJatek(){
        kor = 0;
        tet = 0;
        setGoal();
        System.out.println(goal);

    }
    public void addJatekos(Jatekos j){
        int count = 0;
        while(jatekosok[count] != null){
            count++;
            if(count == 10){
                System.out.println("Jatekosok maximalis szama megtelt!");
                throw new RuntimeException();
            }
        }
        jatekosok[count] = j;
        j.setAsztal(this);
    }

    public int getKor(){ return kor; }
    public void emel(double d){
        tet += d;
    }
    public double getTet(){return 0;}
    public void setGoal(){
        Random r = new Random();
        goal = r.nextDouble(0, 100);
    }

    public void kor() throws NincsJatekos{
        if (jatekosok[0] == null)
            throw new NincsJatekos("Nem ulnek az asztalnal");

        if(kor == -1){
            System.out.println("Vege a jateknak");
            return;
        }
        int count = 0;
        while(jatekosok[count] != null){
            jatekosok[count].lep();

            if(tet >= (goal*1.1)){
                Jatekos nyero = jatekosok[count];
                System.out.println(count++ + ". jatekos gyozott");
                kor = -1;
                return;
            }
            System.out.println("Aktualis tet: " + tet);
            count++;
            kor++;
        }

    }

}
