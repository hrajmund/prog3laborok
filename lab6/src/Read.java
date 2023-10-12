import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read implements Command{
    public void execute(String[] cmd){
        System.out.println("Gépeld be a számokat whitespace-szel elválasztva!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try{
            line = br.readLine();
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                Main.stack.push(Integer.parseInt(number));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
