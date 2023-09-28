import java.io.*;

public class Commands {
    protected static void exit(String[] cmd){
        System.exit(0);
    }
    protected static void pwd(String[] cmd, File wd) throws IOException {
        try{
            System.out.println(wd.getCanonicalPath());
        }catch (IOException e){
            System.out.println("Rossz mappa");
        }

        File[] names = wd.listFiles();
        System.out.println(names.length);
    }
    protected static void ls(String[] cmd, File wd){
        File[] names = wd.listFiles();
        try{
            if(cmd.length > 1 && cmd[1].equals("-l")){
                for(int i = 0; i < names.length; i++){
                    System.out.print(names[i].getName() + " ");
                    System.out.print(names[i].length() + " KB ");
                    System.out.print(names[i].isDirectory() ? "d\n" : "f\n");
                }
            }else{
                for(int i = 0; i < names.length; i++){
                    System.out.println(names[i].getName());
                }
            }
        } catch(NullPointerException e){
            System.out.println("Nem talalhato a mappa!");
        }
    }
    protected static void cd(String[] cmd, File wd){
        try{
            if(cmd.length > 1 && cmd[1].equals("..")){
                wd = wd.getParentFile();
            }else{
                for(File files : wd.listFiles()){
                    if(cmd[1].equals(files)){
                        wd = new File(wd, cmd[1]);
                    } else{
                        throw new NullPointerException();
                    }
                }
            }
        }catch(NullPointerException e){
            System.out.println("Ilyen mappa nem letezik!");
        }
    }
    protected static void rm(String[] cmd, File wd){
        for(int i = 1; i < cmd.length-1;i++){
            try{
                File f = new File(wd + cmd[i]);
                if(f.delete()){
                    System.out.println(cmd[i]);
                }
            }catch(NullPointerException e){
                System.out.println("Ilyen mappa vagy file nem letezik!");
            }
        }
    }
    protected static void mkdir(String[] cmd, File wd){
        try{
            File f = new File(cmd[1]);
            for(File file : wd.listFiles()){
                if(f.getName().equals(file.getName()))
                    throw new NullPointerException();
                else
                    f.mkdir();

            }
        }catch(NullPointerException e){
            System.out.println("Ilyen mappa mar letezik!");
        }
    }
    protected static void mv(String[] cmd, File wd) throws IOException{
        try{
            if(cmd.length > 2){
                File src = new File(cmd[1]);
                File dest = new File(cmd[2]);
                src.renameTo(dest);
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Hianyzo parameter(ek)!");
        }
    }
    protected static void cp(String[] cmd, File wd) throws IOException{
        try{
            FileInputStream in = new FileInputStream(cmd[1]);
            FileOutputStream out = new FileOutputStream(cmd[2]);
            int c;
            while((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
    protected static void cat(String[] cmd, File wd) throws IOException{
        try{
            File f = new File(cmd[1]);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null)
                System.out.println(line);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
