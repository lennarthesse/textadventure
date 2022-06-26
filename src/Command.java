import java.util.ArrayList;

public class Command
{
    Terminal terminal;
    String input;

    Command(Terminal terminal, String input) {
        this.terminal = terminal;
        this.input = input;
        if (input.equalsIgnoreCase("disconnect")) {
            disconnect();
        } else if (input.equalsIgnoreCase("help")) {
            help();
        } else if (input.equalsIgnoreCase("pwd")) {
            pwd();
        } else if (input.contains("mkdir")) {
            mkdir(input.substring(6));
        } else if (input.equalsIgnoreCase("ls")) {
            ls();
        } else if (input.contains("cd")) {
            cd(input.substring(3));
        } else {
            System.out.println("Unknown command. Type 'help' for list of commands.");
        }
    }

    /**
     * "Disconnecting from the probe" by stopping the terminal session
     */
    void disconnect() {
        terminal.setRunning(false);
    }

    /**
     * Method for printing list of commands.
     */
    void help() {
        System.out.println("Here is a list of available commands.");
    }

    /**
     * Method for printing the name of the current working directory.
     */
    void pwd() {
        System.out.println(terminal.getCurrentDirectory().getName());
    }

    /**
     * Method for creating a new directory inside the current directory.
     * @param directoryName The name of the new directory.
     */
    void mkdir(String directoryName) {
        ArrayList<Directory> subdirectories = terminal.getCurrentDirectory().getSubdirectories();
        // If there is already a subdirectory with the passed name, output error message and stop
        for (Directory d : subdirectories) {
            if (d.getName().equalsIgnoreCase(directoryName)) {
                System.out.println("Directory with that name already exists!");
                return;
            }
        }
        // Else create a new directory with passed name,
        Directory directory = new Directory(directoryName);
        // add it to this directory's subdirectories,
        subdirectories.add(directory);
        // and set this directory as the parent of the new subdirectory
        directory.setParentDirectory(terminal.getCurrentDirectory());
    }

    /**
     * Method for listing the subdirectories of the current directory.
     */
    void ls() {
        for (Directory directory : terminal.getCurrentDirectory().getSubdirectories()) {
            System.out.println(directory.getName());
        }
    }

    /**
     * Method for changing the current working directory.
     * @param directoryName The directory to be changed to.
     */
    void cd(String directoryName) {
        // If name (cd param) is .. and there is a parent directory, change to it
        Directory parentDirectory = terminal.getCurrentDirectory().getParentDirectory();
        if (directoryName.equalsIgnoreCase("..") && parentDirectory != null) {
            terminal.setCurrentDirectory(parentDirectory);
        }
        // Else look for subdirectory with matching name, change to it, and stop
        else {
            for (Directory directory : terminal.getCurrentDirectory().getSubdirectories()) {
                if (directory.getName().equalsIgnoreCase(directoryName)) {
                    terminal.setCurrentDirectory((directory));
                    return;
                }
            }
            // No matching directory could be found
            System.out.println("No such directory!");
        }
    }
}