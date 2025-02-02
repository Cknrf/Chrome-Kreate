
import CustomPanels.CustomBorderPostStack;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomFriendSuggestionPanel extends javax.swing.JPanel {

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
            Logger.getLogger(CustomFriendSuggestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomFriendSuggestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CustomFriendSuggestionPanel(ImageIcon icon, String name, int userID, int friendID, FacebookInterface facebook) {
        this.icon = icon;
        this.name = name;
        this.userID = userID;
        this.friendID = friendID;
        this.facebook = facebook;
        initComponents();
        Connect();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userProfilePicture = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(27, 39, 48));
        jPanel1.setMaximumSize(new java.awt.Dimension(54, 16));
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 16));

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
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
                try {
                    pst = con.prepareStatement("INSERT INTO friendship_table (user_id, friend_id, status) VALUES (?, ?, ?)");
                    pst.setInt(1, userID);
                    pst.setInt(2, friendID);
                    pst.setString(3, "Pending");
                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(facebook, "Friend request sent successfully");
                        facebook.LoadProfile();
                        facebook.displayFriendSuggestion();
                    } else {
                        JOptionPane.showMessageDialog(facebook, "Sending friend request failed");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CustomFriendSuggestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CustomFriendSuggestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

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
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        // Prevent the panel from stretching vertically
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void btnUserNameMouseClicked(java.awt.event.MouseEvent evt) {
        facebook.verticalScrollBar.setValue(facebook.verticalScrollBar.getMinimum());
        NonFriendProfilePanel nonFriendProfile = new NonFriendProfilePanel(userID, friendID, facebook);
        facebook.postInnerContainer.removeAll();
        facebook.postInnerContainer.add(nonFriendProfile);
        CustomBorderPostStack customBorder = new CustomBorderPostStack();
        facebook.postInnerContainer.add(customBorder);
        CustomNoPost noPost = new CustomNoPost("Unable to view post. You are not friends.");
        facebook.postInnerContainer.add(noPost);
        facebook.revalidate();
        facebook.repaint();
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel UserName;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel userProfilePicture;
    // End of variables declaration
}
