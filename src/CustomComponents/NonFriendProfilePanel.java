
import CustomPanels.RoundedPanel;
import CustomPanels.CirclePicture;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NonFriendProfilePanel extends javax.swing.JPanel {

    /**
     * Creates new form NonFriendProfilePanel
     */
    public NonFriendProfilePanel() {
        initComponents();
    }
    
    private int user_id;
    private int friend_id;
    private FacebookInterface facebook;
    
    public NonFriendProfilePanel(int user_id, int friend_id, FacebookInterface facebook){
        try {
            this.user_id = user_id;
            this.friend_id = friend_id;
            this.facebook = facebook;
            Connect();
            initComponents();
            displayFriendProfile();
            facebook.btnMyPost.setForeground(new Color(115,130,144));
            facebook.btnFriendPost.setForeground(new Color(115,130,144));
        } catch (IOException ex) {
            Logger.getLogger(NonFriendProfilePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/facebook", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FriendProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FriendProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      private void displayFriendProfile() throws IOException{
        try {
            String sql = "SELECT * FROM account_table WHERE user_id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, friend_id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                Blob profilePicture = rs.getBlob("profile_picture");
                InputStream inputStream = profilePicture.getBinaryStream();
                BufferedImage image = ImageIO.read(inputStream);
                CirclePicture profilePictureCircle = new CirclePicture();
                BufferedImage circularImageProfilePicture = profilePictureCircle.makeCircularImage(image);
                
                Image profilePictureScaled = circularImageProfilePicture.getScaledInstance(76, 76, Image.SCALE_SMOOTH);
                ImageIcon profilePictureScaledIcon = new ImageIcon(profilePictureScaled);
                txtProfilePicture.setIcon(profilePictureScaledIcon);
                
                Blob coverPhotoBlob = rs.getBlob("cover_photo");
                InputStream coverPhotoStream = coverPhotoBlob.getBinaryStream();
                BufferedImage coverBufferedImage = ImageIO.read(coverPhotoStream);
                Image coverImage = coverBufferedImage.getScaledInstance(466, 180, Image.SCALE_SMOOTH);
                ImageIcon coverIcon = new ImageIcon(coverImage);
                txtCoverPhoto.setIcon(coverIcon);
                
                
                String name = rs.getString("name");
                String bio = rs.getString("bio");
                String username = rs.getString("username");
                
                String formattedBio = formatBioText(bio, 65);
                
                
                txtName.setText(name);
                txtBio.setText(formattedBio);
                txtUsername.setText("@" + username);
                facebook.friendName.setText(name + "'s Profile");

            }
        } catch (SQLException ex) {
            Logger.getLogger(FriendProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String formatBioText(String text, int charsPerLine) {
        StringBuilder formattedText = new StringBuilder("<html>");
        int start = 0;

        if (text != null) {
            while (start < text.length()) {
                int end = Math.min(start + charsPerLine, text.length());
                formattedText.append(text, start, end);
                formattedText.append("<br/>");
                start = end;
            }
        }

        formattedText.append("</html>");
        return formattedText.toString();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtProfilePicture = new javax.swing.JLabel();
        txtCoverPhoto = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtBio = new javax.swing.JLabel();
        jPanel3 = new RoundedPanel(15);
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(27, 39, 48));
        jPanel1.setMaximumSize(new java.awt.Dimension(466, 371));
        jPanel1.setMinimumSize(new java.awt.Dimension(466, 371));

        jPanel2.setBackground(new java.awt.Color(27, 39, 48));
        jPanel2.setMaximumSize(new java.awt.Dimension(466, 234));
        jPanel2.setMinimumSize(new java.awt.Dimension(466, 234));
        jPanel2.setPreferredSize(new java.awt.Dimension(466, 234));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProfilePicture.setText("jLabel2");
        txtProfilePicture.setMaximumSize(new java.awt.Dimension(76, 76));
        txtProfilePicture.setMinimumSize(new java.awt.Dimension(76, 76));
        txtProfilePicture.setPreferredSize(new java.awt.Dimension(76, 76));
        jPanel2.add(txtProfilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 150, -1, -1));

        txtCoverPhoto.setMaximumSize(new java.awt.Dimension(466, 180));
        txtCoverPhoto.setMinimumSize(new java.awt.Dimension(466, 180));
        txtCoverPhoto.setPreferredSize(new java.awt.Dimension(466, 180));
        jPanel2.add(txtCoverPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtName.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtName.setForeground(new java.awt.Color(230, 234, 236));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("jLabel3");

        txtBio.setBackground(new java.awt.Color(190, 203, 193));
        txtBio.setForeground(new java.awt.Color(157, 167, 172));
        txtBio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBio.setText("jLabel1");
        txtBio.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setMaximumSize(new java.awt.Dimension(128, 26));
        jPanel3.setMinimumSize(new java.awt.Dimension(128, 26));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 26));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 26));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 26));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(115, 130, 144));
        txtUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsername.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(txtBio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        try {
                    pst = con.prepareStatement("INSERT INTO friendship_table (user_id, friend_id, status) VALUES (?, ?, ?)");
                    pst.setInt(1, user_id);
                    pst.setInt(2, friend_id);
                    pst.setString(3, "Pending");
                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(facebook, "Friend request sent successfully");
                        facebook.LoadProfile();
                        facebook.displayMyPost();
                        facebook.displayFriendSuggestion();
                    } else {
                        JOptionPane.showMessageDialog(facebook, "Sending friend request failed");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CustomFriendSuggestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CustomFriendSuggestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(new Color(94, 94, 255));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(153,153,255));
    }//GEN-LAST:event_jPanel3MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtBio;
    private javax.swing.JLabel txtCoverPhoto;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtProfilePicture;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
