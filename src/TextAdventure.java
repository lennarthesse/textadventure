public class TextAdventure
{
    public static void main(String[] args) {

        // Initializations

        // Start of main program
        //new StartSequence();

        // Main loop
        System.out.println("\nNew crash log available! See /crash-logs for further information.");
        Terminal terminal = new Terminal();

        // End sequence
        System.out.println("Disconnecting...");
        try {Thread.sleep(1000);} catch (InterruptedException ignored) {}

        new Endscreen();
    }
}