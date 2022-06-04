public class StartSequence
{
    StartSequence() {
        System.out.println("Starting boot sequence...");
        try {Thread.sleep(1000);} catch (InterruptedException ignored) {}
        System.out.println("Loading modules...");
        for (int module = 1; module <= 3; module++) {
            for (int percentile = 0; percentile <= 100; percentile += 9) {
                System.out.println("Module " + module + ": " + percentile + "%");
                try {Thread.sleep(100);} catch (InterruptedException ignored) {}
            }
        }
        System.out.println("Done.");
        System.out.println("Modules loaded, System up, type 'help' for list of commands.");
    }
}