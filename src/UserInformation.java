
import javax.swing.ImageIcon;

public class UserInformation {

    private ImageIcon icon;
    private String name;
    private int friendID;

    // Default constructor
    public UserInformation() {
    }

    public UserInformation(String name) {
        this.name = name;
    }

    // Parameterized constructor
    public UserInformation(ImageIcon icon, String name, int friendID) {
        this.icon = icon;
        this.name = name;
        this.friendID = friendID;
    }

    // Getters and setters
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFriendID() {
        return friendID;
    }

    public void setFriendID(int friendID) {
        this.friendID = friendID;
    }
}
