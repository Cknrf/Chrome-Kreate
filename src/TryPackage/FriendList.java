/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

import CustomPanels.CirclePicture;
import CustomPanels.RoundedPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author 63948
 */
public class FriendList extends javax.swing.JPanel {

    /**
     * Creates new form FriendList
     */
    public FriendList() {
        initComponents();
       try {
            initComponents();
            String requestPath = "/imagesIcon/darkCover.jpg";
            ImageIcon RequestIcon = new ImageIcon(getClass().getResource(requestPath));
            Image RequestImage = RequestIcon.getImage();
            Image ScaledRequest = RequestImage.getScaledInstance(466, 180, Image.SCALE_SMOOTH);
            ImageIcon ScaledRequestIcon = new ImageIcon(ScaledRequest);
            txtCoverPhoto3.setIcon(ScaledRequestIcon);
            
            String profilePath = "imagesIcon/coolAvatar.png";
//        ImageIcon profileIcon = new ImageIcon(getClass().getResource(profilePath));
//        Image profileImage = profileIcon.getImage();
//        CirclePicture circleProfile = new CirclePicture();
//        BufferedImage circularProfile = circleProfile.makeCircularImage((BufferedImage) profileImage);
//        
//        Image ScaledProfile = circularProfile.getScaledInstance(76, 76, Image.SCALE_SMOOTH);
//        ImageIcon ScaledProfileIcon = new ImageIcon(ScaledProfile);
//        txtProfilePicture.setIcon(ScaledProfileIcon);

BufferedImage profileImage = ImageIO.read(getClass().getResource(profilePath));

// Create a circular image
CirclePicture circleProfile = new CirclePicture();
BufferedImage circularProfile = circleProfile.makeCircularImage(profileImage);

// Scale the circular image
Image ScaledProfile = circularProfile.getScaledInstance(76, 76, Image.SCALE_SMOOTH);
ImageIcon ScaledProfileIcon = new ImageIcon(ScaledProfile);
txtProfilePicture3.setIcon(ScaledProfileIcon);

//
//        
//        Blob imageBlob = rs.getBlob("profile_picture");
//            InputStream inputStream = imageBlob.getBinaryStream();
//            BufferedImage image = ImageIO.read(inputStream);
//            CirclePicture circleImage = new CirclePicture();
//            BufferedImage circularImage = circleImage.makeCircularImage(image);
//
//            Image scaledImage = circularImage.getScaledInstance(43, 43, Image.SCALE_SMOOTH);
//            ImageIcon icon = new ImageIcon(scaledImage);



txtName3.setText("Haer Yve Wyert");
txtBio3.setText("HAHAHAHHA I have no bio, what you think");
txtUsername3.setText("@nays1");
        } catch (IOException ex) {
            Logger.getLogger(FriendListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtProfilePicture3 = new javax.swing.JLabel();
        txtCoverPhoto3 = new javax.swing.JLabel();
        txtName3 = new javax.swing.JLabel();
        txtBio3 = new javax.swing.JLabel();
        txtUsername3 = new javax.swing.JLabel();
        jPanel12 = new RoundedPanel(15);
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(27, 39, 48));
        setMaximumSize(new java.awt.Dimension(466, 371));
        setMinimumSize(new java.awt.Dimension(466, 371));
        setPreferredSize(new java.awt.Dimension(466, 371));

        jPanel10.setBackground(new java.awt.Color(27, 39, 48));
        jPanel10.setMaximumSize(new java.awt.Dimension(466, 371));
        jPanel10.setMinimumSize(new java.awt.Dimension(466, 371));
        jPanel10.setPreferredSize(new java.awt.Dimension(466, 371));

        jPanel11.setBackground(new java.awt.Color(27, 39, 48));
        jPanel11.setMaximumSize(new java.awt.Dimension(466, 234));
        jPanel11.setMinimumSize(new java.awt.Dimension(466, 234));
        jPanel11.setPreferredSize(new java.awt.Dimension(466, 234));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProfilePicture3.setText("jLabel2");
        txtProfilePicture3.setMaximumSize(new java.awt.Dimension(76, 76));
        txtProfilePicture3.setMinimumSize(new java.awt.Dimension(76, 76));
        txtProfilePicture3.setPreferredSize(new java.awt.Dimension(76, 76));
        jPanel11.add(txtProfilePicture3, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 150, -1, -1));

        txtCoverPhoto3.setText("jLabel1");
        txtCoverPhoto3.setMaximumSize(new java.awt.Dimension(466, 180));
        txtCoverPhoto3.setMinimumSize(new java.awt.Dimension(466, 180));
        txtCoverPhoto3.setPreferredSize(new java.awt.Dimension(466, 180));
        jPanel11.add(txtCoverPhoto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtName3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtName3.setForeground(new java.awt.Color(230, 234, 236));
        txtName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName3.setText("jLabel3");

        txtBio3.setBackground(new java.awt.Color(190, 203, 193));
        txtBio3.setForeground(new java.awt.Color(157, 167, 172));
        txtBio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBio3.setText("jLabel1");

        txtUsername3.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        txtUsername3.setForeground(new java.awt.Color(115, 130, 144));
        txtUsername3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsername3.setText("jLabel1");

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Unfriend");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName3, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(txtBio3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsername3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBio3)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel txtBio;
    private javax.swing.JLabel txtBio1;
    private javax.swing.JLabel txtBio2;
    private javax.swing.JLabel txtBio3;
    private javax.swing.JLabel txtCoverPhoto;
    private javax.swing.JLabel txtCoverPhoto1;
    private javax.swing.JLabel txtCoverPhoto2;
    private javax.swing.JLabel txtCoverPhoto3;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtName1;
    private javax.swing.JLabel txtName2;
    private javax.swing.JLabel txtName3;
    private javax.swing.JLabel txtProfilePicture;
    private javax.swing.JLabel txtProfilePicture1;
    private javax.swing.JLabel txtProfilePicture2;
    private javax.swing.JLabel txtProfilePicture3;
    private javax.swing.JLabel txtUsername;
    private javax.swing.JLabel txtUsername1;
    private javax.swing.JLabel txtUsername2;
    private javax.swing.JLabel txtUsername3;
    // End of variables declaration//GEN-END:variables
}
