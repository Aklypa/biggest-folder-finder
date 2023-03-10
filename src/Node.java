import java.io.File;
import java.util.ArrayList;


public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;
    private long sizeLimit;

    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();
    }
    public Node(File folder, long sizeLimit) {
        this(folder);
        this.sizeLimit = sizeLimit;
    }
    private long setSizeLimit(long sizeLimit) {
        return sizeLimit;
    }
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
    private void setLevel(int level) {
        this.level = level;
    }
    public File getFolder() {
        return folder;
    }
    public void addChild(Node node) {
        node.setLevel(level + 1);
        node.setSizeLimit(sizeLimit);
        children.add(node);
    }
    public ArrayList<Node> getChildren() {
        return children;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children) {
            if (child.getSize() < sizeLimit) {
                continue;
            }
            builder.append("  ".repeat(this.level + 1) + child.toString());
        }
        return builder.toString();
    }
}
