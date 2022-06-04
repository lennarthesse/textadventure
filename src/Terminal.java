import java.util.Scanner;

public class Terminal
{
    private boolean running;
    private Directory currentDirectory;

    Terminal() {
        running = true;
        currentDirectory = new Directory("/");
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (running) {
            System.out.print("> ");
            String input = in.nextLine();
            new Command(this, input);
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setCurrentDirectory(Directory directory) {
        currentDirectory = directory;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }
}