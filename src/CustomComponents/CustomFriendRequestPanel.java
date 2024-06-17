
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

public class CustomFriendRequestPanel extends javax.swing.JPanel {

    private String name;
    private ImageIcon icon;
    private int friendID;
    private int userID;
    private FacebookInterface facebookInterface;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/facebook", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomFriendRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomFriendRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CustomFriendRequestPanel(ImageIcon icon, String name, int userID, int friendID, FacebookInterface facebookInterface) {
        this.icon = icon;
        this.name = name;
        this.userID = userID;
        this.friendID = friendID;
        this.facebookInterface = facebookInterface;
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

        UserName.setForeground(new Color(115,130,144));
        UserName.setText(name);

        addButton.setBackground(new java.awt.Color(153, 153, 255));
        addButton.setText("Confirm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
                try (PreparedStatement pst = con.prepareStatement("UPDATE friendship_table SET status = 'Accepted' WHERE user_id = ? AND friend_id = ? AND status = 'Pending'")) {
                    pst.setInt(1, friendID);
                    pst.setInt(2, userID);

                    int k = pst.executeUpdate();

                    if (k > 0) {
                        JOptionPane.showMessageDialog(facebookInterface, "Friend request accepted successfully");
                        facebookInterface.displayPendingRequest();
                    } else {
                        JOptionPane.showMessageDialog(facebookInterface, "Failed to accept the friend request");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CustomFriendRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(facebookInterface, "An error occurred while accepting the friend request");
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
                                //                    93
                                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                //                    Changes
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                //                    27
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel UserName;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel userProfilePicture;
    // End of variables declaration
}
