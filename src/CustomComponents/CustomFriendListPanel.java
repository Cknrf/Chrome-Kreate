

import CustomPanels.CirclePicture;
import CustomPanels.CustomBorderPostStack;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class CustomFriendListPanel extends javax.swing.JPanel {

    private String name;
    private ImageIcon icon;
    private int friendID;
    private int userID;
    private FacebookInterface facebook;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/facebook", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomFriendListPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomFriendListPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CustomFriendListPanel(ImageIcon icon, String name, int userID, int friendID, FacebookInterface facebook) {
        this.icon = icon;
        this.name = name;
        this.userID = userID;
        this.friendID = friendID;
        this.facebook = facebook;
        initComponents();
        Connect();
    }
    
     private ArrayList<PostInformation> getMyPost() throws IOException {

        ArrayList<PostInformation> getMyPosts = new ArrayList<PostInformation>();
        int currentUserID = friendID;

        String sql = "SELECT a.*, p.* "
                + "FROM account_table a "
                + "JOIN post_table p ON a.user_id = p.user_id "
                + "WHERE a.user_id = ? "
                + "ORDER BY p.time_stamp DESC";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, currentUserID);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Blob imageBlob = rs.getBlob("profile_picture");
                    ImageIcon icon = null;
                    if (imageBlob != null) {
                        try (InputStream inputStream = imageBlob.getBinaryStream()) {
                            BufferedImage image = ImageIO.read(inputStream);
                            CirclePicture circleImage = new CirclePicture();
                            BufferedImage circularImage = circleImage.makeCircularImage(image);
                            Image scaledImage = circularImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                            icon = new ImageIcon(scaledImage);
                        }
                    }

                    String username = rs.getString("name");
                    String postContent = rs.getString("post_content");
                    Timestamp timestamp = rs.getTimestamp("time_stamp");
                    int post_id = rs.getInt("post_id");

                    Blob postImageBlob = rs.getBlob("post_picture");
                    if (postImageBlob == null || postImageBlob.length() == 0) {
                        PostInformation postInformation = new PostInformation(icon, username, postContent, timestamp, post_id);
                        getMyPosts.add(postInformation);
                    } else {
                        try (InputStream inputStream1 = postImageBlob.getBinaryStream()) {
                            BufferedImage postImage = ImageIO.read(inputStream1);
                            Image scaledPostImage = postImage.getScaledInstance(387, 189, Image.SCALE_SMOOTH);
                            ImageIcon postPicture = new ImageIcon(scaledPostImage);
                            PostInformation postInformation = new PostInformation(icon, username, postContent, timestamp, postPicture, post_id);
                            getMyPosts.add(postInformation);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getMyPosts;
    }

    private boolean hasPost = true;

    public void displayMyPost() throws SQLException {
        int currentUserID = userID;
        try {
            ArrayList<PostInformation> posts = getMyPost();
            if (posts.isEmpty()) {
                hasPost = false;
                CustomNoPost customNoPost = new CustomNoPost("No posts in the newsfeed.");
                facebook.postInnerContainer.add(customNoPost);
            }
            for (PostInformation post : posts) {
                if (post.getPostPicture() == null) {
                    CustomViewFriendProfilePostText customPostTextPanel = new CustomViewFriendProfilePostText(post.getIcon(), post.getUsername(), post.getContent(), post.getTimeStamp(), post.getPostId(), currentUserID, facebook);
                    CustomBorderPostStack customBorder = new CustomBorderPostStack();
                    facebook.postInnerContainer.add(customPostTextPanel);
                    facebook.postInnerContainer.add(customBorder);
                    facebook.postInnerContainer.revalidate();
                    facebook.postInnerContainer.repaint();
                } else {
                    CustomViewFriendProfilePostPicture postPicturePanel = new CustomViewFriendProfilePostPicture(post.getIcon(), post.getUsername(), post.getContent(), post.getTimeStamp(), post.getPostPicture(), post.getPostId(), currentUserID, facebook);
                    CustomBorderPostStack customBorder = new CustomBorderPostStack();
                    facebook.postInnerContainer.add(postPicturePanel);
                    facebook.postInnerContainer.add(customBorder);
                    facebook.postInnerContainer.revalidate();
                    facebook.postInnerContainer.repaint();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userProfilePicture = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(27, 39, 48));
        jPanel1.setMaximumSize(new java.awt.Dimension(54, 16));
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 54));

        userProfilePicture.setIcon(icon);
        userProfilePicture.setMaximumSize(new java.awt.Dimension(30, 30));
        userProfilePicture.setPreferredSize(new java.awt.Dimension(30, 30));
        
        UserName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserName.setForeground(new Color(115,130,144));
        UserName.setText(name);
        UserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserNameMouseClicked(evt);
            }
        });


        addButton.setBackground(new java.awt.Color(153, 153, 255));
        addButton.setText("Friend");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(userProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(UserName)
                                        .addComponent(userProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        // Prevent the panel from stretching vertically
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void btnUserNameMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            facebook.verticalScrollBar.setValue(facebook.verticalScrollBar.getMinimum());
            FriendProfile friendProfile = new FriendProfile(userID ,friendID, facebook);
            facebook.postInnerContainer.removeAll();
            facebook.postInnerContainer.add(friendProfile);
            CustomBorderPostStack customBorder = new CustomBorderPostStack();
            facebook.postInnerContainer.add(customBorder);
            displayMyPost();
            facebook.revalidate();
            facebook.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(CustomPostPicturePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel UserName;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel userProfilePicture;
    // End of variables declaration
}
