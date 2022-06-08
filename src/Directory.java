import java.util.ArrayList;

public class Directory
{
    private final String name;
    private final ArrayList<Directory> subdirectories;

    Directory(String name) {
        this.name = name;
        this.subdirectories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void mkdir(String directoryName) {
        Directory directory = new Directory(directoryName);
        subdirectories.add(directory);
    }

    public ArrayList<Directory> getSubdirectories() {
        return subdirectories;
    }
}