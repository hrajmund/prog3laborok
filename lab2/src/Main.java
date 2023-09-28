public class Main {
    public static void main(String[] args) {
        Asztal a = new Asztal();
        int robotCount = 0;

        a.addJatekos(new Kezdo("Rajmund"));
        a.addJatekos(new Kezdo("Bence"));
        a.addJatekos(new Robot());

        try{
            a.ujJatek();
        }catch (Exception e){
            System.out.println("Hiba:" + e);
        }

        try{
            while(a.getKor() != -1){
                a.kor();
            }
        }catch (Exception e){
            System.out.println("Hiba:" + e);
        }

    }
}