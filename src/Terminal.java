import java.util.Scanner;

/**
 * A virtual terminal that handles user input and keeps track of the current working directory.
 */
public class Terminal
{
    private boolean running;
    private Directory currentDirectory;

    /**
     * Creates a new terminal session and initializes the working directory to the root /.
     */
    Terminal() {
        running = true;
        currentDirectory = new Directory("/");
        start();
    }

    /**
     * Actually starts the terminal functionality by initializing an input scanner and waiting for input.
     */
    public void start() {
        Scanner in = new Scanner(System.in);
        while (running) {
            System.out.print("> ");
            String input = in.nextLine();
            // Try to run command corresponding to input in current terminal
            new Command(this, input);
        }
    }

    /**
     * Allows the terminal to be manually stopped or started.
     * @param running Whether the terminal is running.
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Allows to set the current working directory.
     * @param directory The new working directory.
     */
    public void setCurrentDirectory(Directory directory) {
        currentDirectory = directory;
    }

    /**
     * Allows to read the current working directory.
     * @return The current working directory.
     */
    public Directory getCurrentDirectory() {
        return currentDirectory;
    }
}