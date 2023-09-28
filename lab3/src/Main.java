import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Commands {
    public static void main(String[] args) throws IOException {
        String wd = System.getProperty("user.dir");
        File f = new File(wd);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = br.readLine()) != null){
            String[] cmd = line.split(" ");
            if(cmd[0].equals(("exit"))){
                exit(cmd);
            }else if(cmd[0].equals("pwd")){
                pwd(cmd,f);
            }else if(cmd[0].equals("ls")){
                ls(cmd,f);
            }else if(cmd[0].equals("cd")){
                cd(cmd,f);
            }else if(cmd[0].equals("rm")){
                rm(cmd,f);
            }else if(cmd[0].equals("mkdir")){
                mkdir(cmd,f);
            }else if(cmd[0].equals("mv")){
                mv(cmd,f);
            }else if(cmd[0].equals("cp")){
                cp(cmd,f);
            }else if(cmd[0].equals("cat")){
                cat(cmd,f);
            }
        }
    }
}