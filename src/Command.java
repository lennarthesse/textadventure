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

    void disconnect() {
        terminal.setRunning(false);
    }

    void help() {
        System.out.println("Here is a list of available commands.");
    }

    void pwd() {
        System.out.println(terminal.getCurrentDirectory().getName());
    }

    void mkdir(String directoryName) {
        Directory directory = terminal.getCurrentDirectory();
        directory.mkdir(directoryName);
    }

    void ls() {
        for (Directory directory : terminal.getCurrentDirectory().getSubdirectories()) {
            System.out.println(directory.getName());
        }
    }

    void cd(String directoryName) {
        for (Directory directory : terminal.getCurrentDirectory().getSubdirectories()) {
            if (directory.getName().equalsIgnoreCase(directoryName)) {
                terminal.setCurrentDirectory(directory);
                break;
            } else {
                System.out.println("No such directory!");
            }
        }
    }
}