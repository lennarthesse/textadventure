import java.util.ArrayList;

/**
 * A directory in the folder hierarchy.
 */
public class Directory
{
    private final String name;
    private final ArrayList<Directory> subdirectories;
    private Directory parentDirectory;

    /**
     * Manually creates a new directory without a parent directory.
     * @param name The name of the directory.
     */
    Directory(String name) {
        this.name = name;
        this.subdirectories = new ArrayList<>();
    }

    /**
     * Allows to read the name of the directory.
     * @return The name of the directory.
     */
    public String getName() {
        return name;
    }

    /**
     * Allows to read the subdirectories.
     * @return A list of the subdirectories of this directory.
     */
    public ArrayList<Directory> getSubdirectories() {
        return subdirectories;
    }

    /**
     * Allows to set the parent directory of this directory.
     * @param directory The parent directory.
     */
    public void setParentDirectory(Directory directory) {
        parentDirectory = directory;
    }

    /**
     * Allows to read the parent directory.
     * @return The parent directory of this directory.
     */
    public Directory getParentDirectory() {
        return parentDirectory;
    }
}