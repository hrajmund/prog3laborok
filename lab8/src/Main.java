public class Main {
    public static void main(String[] args) {
        CaesarFrame cf = new CaesarFrame();
        cf.setVisible(true);
    }

    public String caesarCode(String input, char offset){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String output = "";

        int offsetCount = alphabet.indexOf(offset);

        input = input.toUpperCase();
        for(int i = 0; i < input.length(); i++){
            char newCharacter = (char) (input.charAt(i) + offsetCount);
            if(newCharacter > 90){
                output += (char) (input.charAt(i) - (26 - offsetCount));
            }else{
                output += (char) (input.charAt(i) - offsetCount);
            }
        }
        return output;
    }
}