import java.io.IOException;

public interface Command {
    public void execute(String[] args) throws IOException, ClassNotFoundException;
}
