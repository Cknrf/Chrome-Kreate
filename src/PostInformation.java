
import javax.swing.ImageIcon;
import java.sql.Timestamp;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 63948
 */
public class PostInformation {

    private ImageIcon icon;
    private String username;
    private String content;
    private Timestamp timeStamp;
    private ImageIcon postPicture;
    private int post_id;
    private int friend_id;

    public PostInformation() {

    }

    public PostInformation(ImageIcon icon, String username, String content, Timestamp timeStamp, int post_id) {
        this.icon = icon;
        this.username = username;
        this.content = content;
        this.timeStamp = timeStamp;
        this.post_id = post_id;
    }

    public PostInformation(ImageIcon icon, String username, String content, Timestamp timeStamp, ImageIcon postPicture, int post_id) {
        this.icon = icon;
        this.username = username;
        this.content = content;
        this.timeStamp = timeStamp;
        this.postPicture = postPicture;
        this.post_id = post_id;
    }
    
    public PostInformation(ImageIcon icon, String username, String content, Timestamp timeStamp, int post_id, int friend_id){
        this.icon = icon;
        this.username = username;
        this.content = content;
        this.timeStamp = timeStamp;
        this.post_id = post_id;
        this.friend_id = friend_id;
    }
    
    public PostInformation(ImageIcon icon, String username, String content, Timestamp timeStamp, ImageIcon postPicture, int post_id, int friend_id){
        this.icon = icon;
        this.username = username;
        this.content = content;
        this.timeStamp = timeStamp;
        this.postPicture = postPicture;
        this.post_id = post_id;
        this.friend_id = friend_id;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setPostPicture(ImageIcon postPicture) {
        this.postPicture = postPicture;
    }

    public ImageIcon getPostPicture() {
        return postPicture;
    }

    public int getPostId() {
        return post_id;
    }
    
    public void setFriendID(int friend_id){
        this.friend_id = friend_id;
    }
    
    public int getFriendID(){
        return friend_id;
    }

}
