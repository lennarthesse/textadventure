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
        } else if (input.equalsIgnoreCase("ls")) {
            ls();
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

    void ls() {

    }
}