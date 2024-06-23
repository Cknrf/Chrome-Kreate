
import CustomPanels.RoundedPanel;
import CustomPanels.CirclePicture;
import CustomPanels.CustomBorderFriend;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import CustomPanels.*;
import CustomComponents.*;
import java.sql.Timestamp;
import java.util.Collections;

public class FacebookInterface extends javax.swing.JFrame {

    /**
     * Creates new form FacebookInterface
     */
    CardLayout cardLayout;
    CardLayout postLayout;
    CardLayout friendLayout;
    private String username;

    public FacebookInterface() {
        initComponents();
        FriendProfile friendList = new FriendProfile();
        postInnerContainer.add(friendList);
    }

    public FacebookInterface(String username) throws SQLException, IOException {
        this.username = username;
        initComponents();
        Connect();
        LoadProfile();
        cardLayout = (CardLayout) (RightSidePanel.getLayout());
        RightSidePanel.add(ProfilePanel, "ProfilePanel");
        RightSidePanel.add(FriendlistPanel, "FriendlistPanel");
        postLayout = (CardLayout) (PostPanelCard.getLayout());
        PostPanelCard.add(PostPanel, "PostPanel");
        PostPanelCard.add(BioPanel, "BioPanel");
        friendLayout = (CardLayout) (FriendContainer.getLayout());
        FriendContainer.add(FriendSuggestionCard, "FriendSuggestionCard");
        FriendContainer.add(FriendRequestCard, "FriendRequestCard");
        FriendContainer.add(FriendListCard, "FriendListCard");

        displayDefaultIcon();
        btnMyProfile.requestFocus();

        displayFriend();
        displayMyPost();
        try {
            displayFriendSuggestion();
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        displayProfile = new RoundedPanel(25);
        txtProfilePicture = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtUsername = new javax.swing.JLabel();
        displayFollow = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNumberFollowing = new javax.swing.JLabel();
        txtNumberFollowers = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        RightSidePanel = new RoundedPanel(40);
        ProfilePanel = new RoundedPanel(25);
        jPanel1 = new RoundedPanel(25);
        jPanel4 = new javax.swing.JPanel();
        txtUsernameRight = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        txtProfilePictureRight = new javax.swing.JLabel();
        txtBio = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnEditProfile = new RoundedPanel(20);
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnEditBio = new RoundedPanel(20);
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new RoundedPanel(25);
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        coverPhotoImage = new javax.swing.JLabel();
        editCoverPhoto = new RoundedPanel(5);
        txtCoverPhoto = new javax.swing.JLabel();
        FriendlistPanel = new RoundedPanel(25);
        jPanel8 = new RoundedPanel(25);
        ScrollPane = new ScrollPaneClass11();
        FriendContainer = new javax.swing.JPanel();
        FriendSuggestionCard = new javax.swing.JPanel();
        FriendRequestCard = new javax.swing.JPanel();
        FriendListCard = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 =  new RoundedPanel(25);
        panelFriendRequestIcon = new RoundedPanel(25);
        txtAddedFriend = new javax.swing.JLabel();
        panelFriendlistIcon = new RoundedPanel(25);
        txtFriendlist = new javax.swing.JLabel();
        panelFriendSuggestionIcon = new RoundedPanel(25);
        txtAddedFriend1 = new javax.swing.JLabel();
        SwitchPanel = new RoundedPanel(25);
        btnMyProfile = new RoundedPanel(20);
        jLabel4 = new javax.swing.JLabel();
        btnFriendlist = new RoundedPanel(20);
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new RoundedPanel(30);
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PostPanelCard = new RoundedPanel(25);
        PostPanel = new RoundedPanel(25);
        postSection = new RoundedPanel(25);
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new ScrollPaneClass11();
        postTextArea = new javax.swing.JTextArea();
        btnPost =  new RoundedPanel(10);
        jLabel15 = new javax.swing.JLabel();
        btnCancelPost =  new RoundedPanel(10);
        jLabel18 = new javax.swing.JLabel();
        txtCharacterCount1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtImageIndicator = new javax.swing.JLabel();
        profilePicturePostPanel1 = new javax.swing.JLabel();
        BioPanel = new RoundedPanel(25);
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new ScrollPaneClass11();
        bioTextArea = new javax.swing.JTextArea();
        saveBio =  new RoundedPanel(10);
        jLabel14 = new javax.swing.JLabel();
        jPanel14 =  new RoundedPanel(10);
        jLabel17 = new javax.swing.JLabel();
        txtCharacterCount = new javax.swing.JLabel();
        profilePicturePostPanel = new javax.swing.JLabel();
        jPanel16 = new RoundedPanel(25);
        jScrollPane1 = new ScrollPaneClass11();
        postInnerContainer = new javax.swing.JPanel();
        btnMyPost = new javax.swing.JLabel();
        btnFriendPost = new javax.swing.JLabel();
        friendName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(6, 20, 29));
        mainPanel.setForeground(new java.awt.Color(6, 20, 29));
        mainPanel.setMaximumSize(new java.awt.Dimension(999, 634));
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainPanelMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(6, 20, 29));
        jPanel2.setForeground(new java.awt.Color(6, 20, 29));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        displayProfile.setBackground(new java.awt.Color(27, 39, 48));
        displayProfile.setMaximumSize(new java.awt.Dimension(232, 175));

        txtProfilePicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProfilePicture.setToolTipText("");
        txtProfilePicture.setAlignmentX(0.5F);
        txtProfilePicture.setPreferredSize(new java.awt.Dimension(50, 50));

        txtName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(230, 234, 236));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("jLabel2");
        txtName.setToolTipText("");
        txtName.setAlignmentX(0.5F);

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(115, 130, 144));
        txtUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsername.setText("jLabel2");

        displayFollow.setBackground(new java.awt.Color(27, 39, 48));
        displayFollow.setBorder(new CustomTopandBottom(new Color(39, 51, 60)));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(123, 138, 151));
        jLabel7.setText("Following");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(123, 138, 151));
        jLabel10.setText("Followers");

        txtNumberFollowing.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNumberFollowing.setForeground(new java.awt.Color(255, 102, 102));
        txtNumberFollowing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNumberFollowing.setText("100");

        txtNumberFollowers.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNumberFollowers.setForeground(new java.awt.Color(255, 102, 102));
        txtNumberFollowers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNumberFollowers.setText("100");

        jPanel9.setBackground(new java.awt.Color(39, 51, 60));
        jPanel9.setMaximumSize(new java.awt.Dimension(1, 100));
        jPanel9.setMinimumSize(new java.awt.Dimension(1, 35));
        jPanel9.setPreferredSize(new java.awt.Dimension(1, 35));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout displayFollowLayout = new javax.swing.GroupLayout(displayFollow);
        displayFollow.setLayout(displayFollowLayout);
        displayFollowLayout.setHorizontalGroup(
            displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayFollowLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumberFollowing, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtNumberFollowers, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        displayFollowLayout.setVerticalGroup(
            displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayFollowLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayFollowLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(displayFollowLayout.createSequentialGroup()
                        .addGroup(displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumberFollowing)
                            .addComponent(txtNumberFollowers))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(displayFollowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addGap(9, 9, 9))))
        );

        javax.swing.GroupLayout displayProfileLayout = new javax.swing.GroupLayout(displayProfile);
        displayProfile.setLayout(displayProfileLayout);
        displayProfileLayout.setHorizontalGroup(
            displayProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(displayProfileLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(txtProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(displayFollow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        displayProfileLayout.setVerticalGroup(
            displayProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayProfileLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayFollow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        RightSidePanel.setBackground(new java.awt.Color(27, 39, 48));
        RightSidePanel.setMaximumSize(new java.awt.Dimension(235, 542));
        RightSidePanel.setPreferredSize(new java.awt.Dimension(235, 542));
        RightSidePanel.setLayout(new java.awt.CardLayout());

        ProfilePanel.setBackground(new java.awt.Color(6, 20, 29));
        ProfilePanel.setMaximumSize(new java.awt.Dimension(235, 542));

        jPanel1.setBackground(new java.awt.Color(27, 39, 48));
        jPanel1.setMaximumSize(new java.awt.Dimension(232, 32767));
        jPanel1.setPreferredSize(new java.awt.Dimension(232, 305));

        jPanel4.setBackground(new java.awt.Color(27, 39, 48));

        txtUsernameRight.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtUsernameRight.setForeground(new java.awt.Color(115, 130, 144));
        txtUsernameRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsernameRight.setText("Username");

        Name.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Name.setForeground(new java.awt.Color(230, 234, 236));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("Name");
        Name.setToolTipText("");
        Name.setAlignmentX(0.5F);

        txtProfilePictureRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProfilePictureRight.setToolTipText("");
        txtProfilePictureRight.setAlignmentX(0.5F);
        txtProfilePictureRight.setPreferredSize(new java.awt.Dimension(50, 50));

        txtBio.setForeground(new java.awt.Color(157, 167, 172));
        txtBio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBio.setText("Bio");
        txtBio.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(txtUsernameRight, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(txtProfilePictureRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtBio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtProfilePictureRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsernameRight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(27, 39, 48));

        btnEditProfile.setBackground(new java.awt.Color(40, 52, 62));
        btnEditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditProfileMouseExited(evt);
            }
        });

        jLabel11.setText("Edit Profile");

        javax.swing.GroupLayout btnEditProfileLayout = new javax.swing.GroupLayout(btnEditProfile);
        btnEditProfile.setLayout(btnEditProfileLayout);
        btnEditProfileLayout.setHorizontalGroup(
            btnEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditProfileLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel11)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        btnEditProfileLayout.setVerticalGroup(
            btnEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditProfileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        btnEditBio.setBackground(new java.awt.Color(40, 52, 62));
        btnEditBio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditBio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditBioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditBioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditBioMouseExited(evt);
            }
        });

        jLabel13.setText("Edit Bio");

        javax.swing.GroupLayout btnEditBioLayout = new javax.swing.GroupLayout(btnEditBio);
        btnEditBio.setLayout(btnEditBioLayout);
        btnEditBioLayout.setHorizontalGroup(
            btnEditBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditBioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        btnEditBioLayout.setVerticalGroup(
            btnEditBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditBioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditBio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        jPanel3.setBackground(new java.awt.Color(27, 39, 48));
        jPanel3.setMaximumSize(new java.awt.Dimension(232, 32767));

        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Chrome Kreate");

        coverPhotoImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coverPhotoImage.setMaximumSize(new java.awt.Dimension(223, 159));
        coverPhotoImage.setPreferredSize(new java.awt.Dimension(223, 159));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coverPhotoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coverPhotoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        editCoverPhoto.setBackground(new java.awt.Color(27, 39, 48));
        editCoverPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editCoverPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editCoverPhotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editCoverPhotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editCoverPhotoMouseExited(evt);
            }
        });

        txtCoverPhoto.setForeground(new java.awt.Color(181, 240, 240));
        txtCoverPhoto.setText("Edit Cover Photo");

        javax.swing.GroupLayout editCoverPhotoLayout = new javax.swing.GroupLayout(editCoverPhoto);
        editCoverPhoto.setLayout(editCoverPhotoLayout);
        editCoverPhotoLayout.setHorizontalGroup(
            editCoverPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editCoverPhotoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCoverPhoto)
                .addGap(72, 72, 72))
        );
        editCoverPhotoLayout.setVerticalGroup(
            editCoverPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCoverPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editCoverPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProfilePanelLayout.setVerticalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editCoverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RightSidePanel.add(ProfilePanel, "card2");

        FriendlistPanel.setBackground(new java.awt.Color(6, 20, 29));
        FriendlistPanel.setMaximumSize(new java.awt.Dimension(235, 542));
        FriendlistPanel.setPreferredSize(new java.awt.Dimension(235, 542));

        jPanel8.setBackground(new java.awt.Color(27, 39, 48));

        ScrollPane.setBackground(new java.awt.Color(27, 39, 48));
        ScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ScrollPane.setForeground(new java.awt.Color(27, 39, 48));
        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        FriendContainer.setBackground(new java.awt.Color(27, 39, 48));
        FriendContainer.setLayout(new java.awt.CardLayout());

        FriendSuggestionCard.setBackground(new java.awt.Color(27, 39, 48));
        FriendSuggestionCard.setLayout(new javax.swing.BoxLayout(FriendSuggestionCard, javax.swing.BoxLayout.LINE_AXIS));
        FriendSuggestionCard.setLayout(new javax.swing.BoxLayout(FriendSuggestionCard, javax.swing.BoxLayout.Y_AXIS));
        FriendContainer.add(FriendSuggestionCard, "card2");

        FriendRequestCard.setBackground(new java.awt.Color(27, 39, 48));
        FriendRequestCard.setLayout(new javax.swing.BoxLayout(FriendRequestCard, javax.swing.BoxLayout.LINE_AXIS));
        FriendRequestCard.setLayout(new javax.swing.BoxLayout(FriendRequestCard, javax.swing.BoxLayout.Y_AXIS));
        FriendContainer.add(FriendRequestCard, "card3");

        FriendListCard.setBackground(new java.awt.Color(27, 39, 48));
        FriendListCard.setLayout(new javax.swing.BoxLayout(FriendListCard, javax.swing.BoxLayout.LINE_AXIS));
        FriendListCard.setLayout(new javax.swing.BoxLayout(FriendListCard, javax.swing.BoxLayout.Y_AXIS));
        FriendContainer.add(FriendListCard, "card4");

        ScrollPane.setViewportView(FriendContainer);

        jLabel8.setForeground(new java.awt.Color(153, 153, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chrome Create");

        jPanel12.setBackground(new java.awt.Color(6, 20, 29));
        jPanel12.setMaximumSize(new java.awt.Dimension(0, 16));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(27, 39, 48));

        panelFriendRequestIcon.setBackground(new java.awt.Color(6, 20, 29));
        panelFriendRequestIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFriendRequestIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelFriendRequestIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelFriendRequestIconMouseExited(evt);
            }
        });

        txtAddedFriend.setText("jLabel7");

        javax.swing.GroupLayout panelFriendRequestIconLayout = new javax.swing.GroupLayout(panelFriendRequestIcon);
        panelFriendRequestIcon.setLayout(panelFriendRequestIconLayout);
        panelFriendRequestIconLayout.setHorizontalGroup(
            panelFriendRequestIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFriendRequestIconLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtAddedFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFriendRequestIconLayout.setVerticalGroup(
            panelFriendRequestIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFriendRequestIconLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtAddedFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFriendlistIcon.setBackground(new java.awt.Color(6, 20, 29));
        panelFriendlistIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFriendlistIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelFriendlistIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelFriendlistIconMouseExited(evt);
            }
        });

        txtFriendlist.setText("jLabel7");

        javax.swing.GroupLayout panelFriendlistIconLayout = new javax.swing.GroupLayout(panelFriendlistIcon);
        panelFriendlistIcon.setLayout(panelFriendlistIconLayout);
        panelFriendlistIconLayout.setHorizontalGroup(
            panelFriendlistIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFriendlistIconLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtFriendlist, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelFriendlistIconLayout.setVerticalGroup(
            panelFriendlistIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFriendlistIconLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtFriendlist, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFriendSuggestionIcon.setBackground(new java.awt.Color(6, 20, 29));
        panelFriendSuggestionIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFriendSuggestionIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelFriendSuggestionIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelFriendSuggestionIconMouseExited(evt);
            }
        });

        txtAddedFriend1.setText("jLabel7");

        javax.swing.GroupLayout panelFriendSuggestionIconLayout = new javax.swing.GroupLayout(panelFriendSuggestionIcon);
        panelFriendSuggestionIcon.setLayout(panelFriendSuggestionIconLayout);
        panelFriendSuggestionIconLayout.setHorizontalGroup(
            panelFriendSuggestionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFriendSuggestionIconLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtAddedFriend1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFriendSuggestionIconLayout.setVerticalGroup(
            panelFriendSuggestionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFriendSuggestionIconLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtAddedFriend1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFriendSuggestionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFriendlistIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFriendRequestIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFriendRequestIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelFriendSuggestionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelFriendlistIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ScrollPane)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout FriendlistPanelLayout = new javax.swing.GroupLayout(FriendlistPanel);
        FriendlistPanel.setLayout(FriendlistPanelLayout);
        FriendlistPanelLayout.setHorizontalGroup(
            FriendlistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FriendlistPanelLayout.setVerticalGroup(
            FriendlistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        RightSidePanel.add(FriendlistPanel, "card4");

        SwitchPanel.setBackground(new java.awt.Color(27, 39, 48));
        SwitchPanel.setMaximumSize(new java.awt.Dimension(235, 317));
        SwitchPanel.setPreferredSize(new java.awt.Dimension(235, 317));

        btnMyProfile.setBackground(new java.awt.Color(58, 58, 112));
        btnMyProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMyProfile.setMaximumSize(new java.awt.Dimension(190, 28));
        btnMyProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMyProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMyProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMyProfileMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("My Profile");

        javax.swing.GroupLayout btnMyProfileLayout = new javax.swing.GroupLayout(btnMyProfile);
        btnMyProfile.setLayout(btnMyProfileLayout);
        btnMyProfileLayout.setHorizontalGroup(
            btnMyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMyProfileLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(69, 69, 69))
        );
        btnMyProfileLayout.setVerticalGroup(
            btnMyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMyProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnFriendlist.setBackground(new java.awt.Color(6, 20, 29));
        btnFriendlist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFriendlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFriendlistMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFriendlistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFriendlistMouseExited(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Friendlist");

        javax.swing.GroupLayout btnFriendlistLayout = new javax.swing.GroupLayout(btnFriendlist);
        btnFriendlist.setLayout(btnFriendlistLayout);
        btnFriendlistLayout.setHorizontalGroup(
            btnFriendlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFriendlistLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnFriendlistLayout.setVerticalGroup(
            btnFriendlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnFriendlistLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(40, 52, 62));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });

        jLabel5.setText("Log Out");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(39, 39, 39))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SwitchPanelLayout = new javax.swing.GroupLayout(SwitchPanel);
        SwitchPanel.setLayout(SwitchPanelLayout);
        SwitchPanelLayout.setHorizontalGroup(
            SwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SwitchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(SwitchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(SwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFriendlist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMyProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SwitchPanelLayout.setVerticalGroup(
            SwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SwitchPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFriendlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Chrome Kreate");

        PostPanelCard.setBackground(new java.awt.Color(6, 20, 29));
        PostPanelCard.setMaximumSize(new java.awt.Dimension(468, 91));
        PostPanelCard.setLayout(new java.awt.CardLayout());

        PostPanel.setBackground(new java.awt.Color(27, 39, 48));
        PostPanel.setMaximumSize(new java.awt.Dimension(469, 91));
        PostPanel.setPreferredSize(new java.awt.Dimension(468, 91));

        postSection.setBackground(new java.awt.Color(27, 39, 48));
        postSection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        postSection.setMaximumSize(new java.awt.Dimension(468, 91));
        postSection.setPreferredSize(new java.awt.Dimension(468, 91));

        jPanel6.setBackground(new java.awt.Color(27, 39, 48));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        postTextArea.setBackground(new java.awt.Color(40, 52, 62));
        postTextArea.setColumns(20);
        postTextArea.setForeground(new java.awt.Color(179, 188, 193));
        postTextArea.setRows(1);
        postTextArea.setText("What's on your mind?");
        postTextArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 52, 62), 1, true));
        postTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                postTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                postTextAreaFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(postTextArea);

        btnPost.setBackground(new java.awt.Color(40, 52, 62));
        btnPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPostMouseExited(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Post");

        javax.swing.GroupLayout btnPostLayout = new javax.swing.GroupLayout(btnPost);
        btnPost.setLayout(btnPostLayout);
        btnPostLayout.setHorizontalGroup(
            btnPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPostLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        btnPostLayout.setVerticalGroup(
            btnPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        btnCancelPost.setBackground(new java.awt.Color(40, 52, 62));
        btnCancelPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelPostMouseExited(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Cancel");

        javax.swing.GroupLayout btnCancelPostLayout = new javax.swing.GroupLayout(btnCancelPost);
        btnCancelPost.setLayout(btnCancelPostLayout);
        btnCancelPostLayout.setHorizontalGroup(
            btnCancelPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelPostLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        btnCancelPostLayout.setVerticalGroup(
            btnCancelPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        txtCharacterCount1.setForeground(new java.awt.Color(125, 127, 131));

        jLabel16.setText("jLabel2");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.setMaximumSize(new java.awt.Dimension(21, 21));
        jLabel16.setMinimumSize(new java.awt.Dimension(21, 21));
        jLabel16.setPreferredSize(new java.awt.Dimension(21, 21));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        txtImageIndicator.setForeground(new java.awt.Color(125, 127, 131));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtCharacterCount1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtImageIndicator)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCharacterCount1)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtImageIndicator)))
                .addContainerGap())
        );

        profilePicturePostPanel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePicturePostPanel1.setAlignmentX(0.5F);
        profilePicturePostPanel1.setMaximumSize(new java.awt.Dimension(30, 30));
        profilePicturePostPanel1.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout postSectionLayout = new javax.swing.GroupLayout(postSection);
        postSection.setLayout(postSectionLayout);
        postSectionLayout.setHorizontalGroup(
            postSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, postSectionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(profilePicturePostPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        postSectionLayout.setVerticalGroup(
            postSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(postSectionLayout.createSequentialGroup()
                        .addComponent(profilePicturePostPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout PostPanelLayout = new javax.swing.GroupLayout(PostPanel);
        PostPanel.setLayout(PostPanelLayout);
        PostPanelLayout.setHorizontalGroup(
            PostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
            .addGroup(PostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PostPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(postSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PostPanelLayout.setVerticalGroup(
            PostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
            .addGroup(PostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PostPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(postSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PostPanelCard.add(PostPanel, "card2");

        BioPanel.setBackground(new java.awt.Color(27, 39, 48));
        BioPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BioPanel.setMaximumSize(new java.awt.Dimension(468, 91));
        BioPanel.setPreferredSize(new java.awt.Dimension(468, 91));

        jPanel5.setBackground(new java.awt.Color(27, 39, 48));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        bioTextArea.setBackground(new java.awt.Color(40, 52, 62));
        bioTextArea.setColumns(20);
        bioTextArea.setForeground(new java.awt.Color(179, 188, 193));
        bioTextArea.setRows(1);
        bioTextArea.setText("Put your bio here...");
        bioTextArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 52, 62), 1, true));
        bioTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bioTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bioTextAreaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(bioTextArea);

        saveBio.setBackground(new java.awt.Color(40, 52, 62));
        saveBio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveBioMouseExited(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Save");

        javax.swing.GroupLayout saveBioLayout = new javax.swing.GroupLayout(saveBio);
        saveBio.setLayout(saveBioLayout);
        saveBioLayout.setHorizontalGroup(
            saveBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveBioLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        saveBioLayout.setVerticalGroup(
            saveBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(40, 52, 62));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cancel");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        txtCharacterCount.setForeground(new java.awt.Color(125, 127, 131));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCharacterCount, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(saveBio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCharacterCount))
                .addContainerGap())
        );

        profilePicturePostPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePicturePostPanel.setAlignmentX(0.5F);
        profilePicturePostPanel.setMaximumSize(new java.awt.Dimension(30, 30));
        profilePicturePostPanel.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout BioPanelLayout = new javax.swing.GroupLayout(BioPanel);
        BioPanel.setLayout(BioPanelLayout);
        BioPanelLayout.setHorizontalGroup(
            BioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BioPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(profilePicturePostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        BioPanelLayout.setVerticalGroup(
            BioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BioPanelLayout.createSequentialGroup()
                        .addComponent(profilePicturePostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        PostPanelCard.add(BioPanel, "card3");

        jPanel16.setBackground(new java.awt.Color(6, 20, 29));
        jPanel16.setMaximumSize(new java.awt.Dimension(468, 443));
        jPanel16.setPreferredSize(new java.awt.Dimension(468, 443));
        jPanel16.setLayout(new java.awt.CardLayout());
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane1.setBackground(new java.awt.Color(6, 20, 29));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(6, 20, 29), 1, true));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        postInnerContainer.setBackground(new java.awt.Color(6, 20, 29));
        postInnerContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postInnerContainerMouseClicked(evt);
            }
        });
        postInnerContainer.setLayout(new javax.swing.BoxLayout(postInnerContainer, javax.swing.BoxLayout.LINE_AXIS));
        postInnerContainer.setLayout(new javax.swing.BoxLayout(postInnerContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(postInnerContainer);

        verticalScrollBar = jScrollPane1.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMinimum());

        jPanel16.add(jScrollPane1, "card2");

        btnMyPost.setForeground(new java.awt.Color(0, 167, 255));
        btnMyPost.setText("My Post");
        btnMyPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMyPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMyPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMyPostMouseExited(evt);
            }
        });

        btnFriendPost.setForeground(new java.awt.Color(115, 130, 144));
        btnFriendPost.setText("Friends' Post");
        btnFriendPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFriendPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFriendPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFriendPostMouseExited(evt);
            }
        });

        friendName.setForeground(new java.awt.Color(0, 167, 255));
        friendName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                friendNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                friendNameMouseExited(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SwitchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addComponent(displayProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(friendName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnMyPost, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFriendPost)
                        .addGap(20, 20, 20))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PostPanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
                .addComponent(RightSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMyPost)
                            .addComponent(btnFriendPost)
                            .addComponent(friendName))
                        .addGap(1, 1, 1)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RightSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(displayProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(SwitchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(PostPanelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bioTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bioTextAreaFocusGained
        if (bioTextArea.getText().equals("Put your bio here...")) {
            bioTextArea.setText("");
        }
    }//GEN-LAST:event_bioTextAreaFocusGained

    private boolean btnMyProfileIsClicked = true;
    private boolean btnFriendListIsClicked = false;

    private void btnFriendlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFriendlistMouseClicked
        btnFriendlist.setBackground(new Color(58, 58, 112));
        btnMyProfile.setBackground(new Color(6, 20, 29));
        cardLayout.show(RightSidePanel, "FriendlistPanel");
        btnFriendlist.requestFocus();
        btnMyProfileIsClicked = false;
        btnFriendListIsClicked = true;
    }//GEN-LAST:event_btnFriendlistMouseClicked

    private void btnMyProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyProfileMouseClicked
        btnFriendlist.setBackground(new Color(6, 20, 29));
        btnMyProfile.setBackground(new Color(58, 58, 112));
        cardLayout.show(RightSidePanel, "ProfilePanel");
        postLayout.show(PostPanelCard, "PostPanel");
        btnMyProfileIsClicked = true;
        btnFriendListIsClicked = false;
        mainPanel.requestFocus();
    }//GEN-LAST:event_btnMyProfileMouseClicked

    private void editCoverPhotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCoverPhotoMouseExited
        editCoverPhoto.setBackground(new Color(27, 39, 48));
        txtCoverPhoto.setForeground(new Color(181, 240, 240));
    }//GEN-LAST:event_editCoverPhotoMouseExited

    private void editCoverPhotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCoverPhotoMouseEntered
        editCoverPhoto.setBackground(new Color(58, 58, 112));
        txtCoverPhoto.setForeground(new Color(10, 10, 23));
    }//GEN-LAST:event_editCoverPhotoMouseEntered

    private void editCoverPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCoverPhotoMouseClicked
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();

            BufferedImage bi = ImageIO.read(new File(path));
            Image img = bi.getScaledInstance(223, 159, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            coverPhotoImage.setIcon(icon);

            if (path == null) {
                JOptionPane.showMessageDialog(this, "Uploading cover photo error");
            } else {
                pst = con.prepareStatement("UPDATE account_table SET cover_photo = ? WHERE username = ?");
                InputStream is = new FileInputStream(new File(path));
                pst.setBlob(1, is);
                pst.setString(2, username);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cover photo is uploaded successfully");
            }

        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editCoverPhotoMouseClicked

    private void btnEditBioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditBioMouseClicked
        postLayout.show(PostPanelCard, "BioPanel");
        try {
            LoadProfile();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getProfilePicture(30, 30, profilePicturePostPanel);
            LoadProfile();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        actionListenerBioTextArea();
        bioTextArea.setText("Put your bio here...");
    }//GEN-LAST:event_btnEditBioMouseClicked

    private void bioTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bioTextAreaFocusLost
        if (bioTextArea.getText().isEmpty()) {
            bioTextArea.setText("Put your bio here...");
        }
    }//GEN-LAST:event_bioTextAreaFocusLost

    private void saveBioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBioMouseClicked
        if (bioTextArea.getText().equals("Put your bio here...")) {
            JOptionPane.showMessageDialog(this, "You still didn't enter a bio");
        } else {
            try {
                String text = bioTextArea.getText();
                String[] words = text.split("\\s");
                String bio = String.join(" ", words);

                if (bio.length() > 99) {
                    JOptionPane.showMessageDialog(this, "Sorry, the bio should consist of less than 100 characters");
                } else {
                    pst = con.prepareStatement("UPDATE account_table SET bio = ? WHERE username = ? ");
                    pst.setString(1, bio);
                    pst.setString(2, username);
                    int r = pst.executeUpdate();

                    if (r > 0) {
                        JOptionPane.showMessageDialog(this, "Your bio has been updated successfully!");
                        LoadProfile();
                        mainPanel.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry, there was an error updating your bio. Please try again.");
                    }
                }
                postLayout.show(PostPanelCard, "PostPanel");

            } catch (SQLException ex) {
                Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_saveBioMouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        bioTextArea.setText("Put your bio here...");
        postLayout.show(PostPanelCard, "PostPanel");
    }//GEN-LAST:event_jPanel14MouseClicked

    private void btnEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProfileMouseClicked
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();

            BufferedImage bi = ImageIO.read(new File(path));
            Image img = bi.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);

            if (path == null) {
                JOptionPane.showMessageDialog(this, "Uploading profile photo error");
            } else {
                pst = con.prepareStatement("UPDATE account_table SET profile_picture = ? WHERE username = ?");
                InputStream is = new FileInputStream(new File(path));
                pst.setBlob(1, is);
                pst.setString(2, username);
                pst.executeUpdate();
                LoadProfile();
                JOptionPane.showMessageDialog(this, "Profile photo is uploaded successfully");
            }

        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditProfileMouseClicked

    private void postTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_postTextAreaFocusGained
        if (postTextArea.getText().equals("What's on your mind?")) {
            postTextArea.setText("");
        }
    }//GEN-LAST:event_postTextAreaFocusGained

    private void postTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_postTextAreaFocusLost
        if (postTextArea.getText().isEmpty()) {
            postTextArea.setText("What's on your mind?");
        }
    }//GEN-LAST:event_postTextAreaFocusLost

    private void btnPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPostMouseClicked
        int currentUserID = 0;
        try {
            currentUserID = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (postTextArea.getText().equals("What's on your mind?") || postTextArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "You still didn't enter your post");
        } else {
            try {

                if (path == null) {
                    String text = postTextArea.getText();
                    String[] words = text.split("\\s");
                    String post = String.join(" ", words);

                    pst = con.prepareStatement("INSERT INTO post_table (user_id, post_content) VALUES(?, ?)");
                    pst.setInt(1, currentUserID);
                    pst.setString(2, post);
                    int r = pst.executeUpdate();

                    if (r > 0) {
                        JOptionPane.showMessageDialog(this, "Your post was successfully posted");
                        LoadProfile();
                        displayMyPost();
                        txtImageIndicator.setText(null);
                        postTextArea.setText("What's on your mind?");
                        mainPanel.requestFocus();
                        btnMyPost.setForeground(new Color(0, 167, 255));
                        btnFriendPost.setForeground(new Color(115, 130, 144));
                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry, there was an error posting your post. Please try again.");
                    }
                } else {
                    String text = postTextArea.getText();
                    String[] words = text.split("\\s");
                    String post = String.join(" ", words);

                    pst = con.prepareStatement("INSERT INTO post_table (user_id, post_content, post_picture) VALUES(?, ?, ?)");
                    InputStream is = new FileInputStream(new File(path));
                    pst.setInt(1, currentUserID);
                    pst.setString(2, post);
                    pst.setBlob(3, is);
                    int r = pst.executeUpdate();

                    if (r > 0) {
                        JOptionPane.showMessageDialog(this, "Your post was successfully posted");
                        LoadProfile();
                        displayMyPost();
                        txtImageIndicator.setText(null);
                        postTextArea.setText("What's on your mind?");
                        path = null;
                        mainPanel.requestFocus();
                        btnMyPost.setForeground(new Color(0, 167, 255));
                        btnFriendPost.setForeground(new Color(115, 130, 144));
                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry, there was an error posting your post. Please try again.");
                    }

                }
                postLayout.show(PostPanelCard, "PostPanel");

            } catch (SQLException ex) {
                Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnPostMouseClicked

    private void btnCancelPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPostMouseClicked
        postTextArea.setText("What's on your mind?");
        path = null;
        txtImageIndicator.setText("");
        mainPanel.requestFocus();
    }//GEN-LAST:event_btnCancelPostMouseClicked

    private void btnEditProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProfileMouseEntered
        btnEditProfile.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnEditProfileMouseEntered

    private void btnEditBioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditBioMouseEntered
        btnEditBio.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnEditBioMouseEntered

    private void btnEditProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProfileMouseExited
        btnEditProfile.setBackground(new Color(40, 52, 62));
    }//GEN-LAST:event_btnEditProfileMouseExited

    private void btnEditBioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditBioMouseExited
        btnEditBio.setBackground(new Color(49, 52, 62));
    }//GEN-LAST:event_btnEditBioMouseExited

    private boolean isFriendSuggestionClicked = true;
    private boolean isFriendListClicked = false;
    private boolean isFriendRequestClicked = false;

    private void panelFriendSuggestionIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendSuggestionIconMouseEntered
        if (!isFriendSuggestionClicked) {
            panelFriendSuggestionIcon.setBackground(new Color(121, 98, 242));
        }
    }//GEN-LAST:event_panelFriendSuggestionIconMouseEntered

    private void panelFriendSuggestionIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendSuggestionIconMouseExited
        if (!isFriendSuggestionClicked) {
            panelFriendSuggestionIcon.setBackground(new Color(6, 20, 29));
        }
    }//GEN-LAST:event_panelFriendSuggestionIconMouseExited

    private void panelFriendlistIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendlistIconMouseEntered
        if (!isFriendListClicked) {
            panelFriendlistIcon.setBackground(new Color(121, 98, 242));
        }
    }//GEN-LAST:event_panelFriendlistIconMouseEntered

    private void panelFriendlistIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendlistIconMouseExited
        if (!isFriendListClicked) {
            panelFriendlistIcon.setBackground(new Color(6, 20, 29));
        }

    }//GEN-LAST:event_panelFriendlistIconMouseExited

    private void panelFriendRequestIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendRequestIconMouseEntered
        if (!isFriendRequestClicked) {
            panelFriendRequestIcon.setBackground(new Color(121, 98, 242));
        }
    }//GEN-LAST:event_panelFriendRequestIconMouseEntered

    private void panelFriendRequestIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendRequestIconMouseExited
        if (!isFriendRequestClicked) {
            panelFriendRequestIcon.setBackground(new Color(6, 20, 29));
        }
    }//GEN-LAST:event_panelFriendRequestIconMouseExited

    private void panelFriendSuggestionIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendSuggestionIconMouseClicked
        friendLayout.show(FriendContainer, "FriendSuggestionCard");
        panelFriendSuggestionIcon.setBackground(new Color(121, 98, 242));
        panelFriendlistIcon.setBackground(new Color(6, 20, 29));
        panelFriendRequestIcon.setBackground(new Color(6, 20, 29));
        isFriendSuggestionClicked = true;
        isFriendListClicked = false;
        isFriendRequestClicked = false;

    }//GEN-LAST:event_panelFriendSuggestionIconMouseClicked

    private void panelFriendlistIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendlistIconMouseClicked
        try {
            displayFriend();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        friendLayout.show(FriendContainer, "FriendListCard");
        panelFriendlistIcon.setBackground(new Color(121, 98, 242));
        panelFriendSuggestionIcon.setBackground(new Color(6, 20, 29));
        panelFriendRequestIcon.setBackground(new Color(6, 20, 29));
        isFriendSuggestionClicked = false;
        isFriendListClicked = true;
        isFriendRequestClicked = false;

    }//GEN-LAST:event_panelFriendlistIconMouseClicked

    private void panelFriendRequestIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFriendRequestIconMouseClicked
        try {
            displayPendingRequest();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        friendLayout.show(FriendContainer, "FriendRequestCard");
        panelFriendRequestIcon.setBackground(new Color(121, 98, 242));
        panelFriendlistIcon.setBackground(new Color(6, 20, 29));
        panelFriendSuggestionIcon.setBackground(new Color(6, 20, 29));
        isFriendSuggestionClicked = false;
        isFriendListClicked = false;
        isFriendRequestClicked = true;
    }//GEN-LAST:event_panelFriendRequestIconMouseClicked

    private void btnPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPostMouseEntered
        btnPost.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnPostMouseEntered

    private void btnCancelPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPostMouseEntered
        btnCancelPost.setBackground(new Color(195, 7, 103));
    }//GEN-LAST:event_btnCancelPostMouseEntered

    private void btnPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPostMouseExited
        btnPost.setBackground(new Color(40, 52, 62));
    }//GEN-LAST:event_btnPostMouseExited

    private void btnCancelPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPostMouseExited
        btnCancelPost.setBackground(new Color(40, 52, 62));
    }//GEN-LAST:event_btnCancelPostMouseExited

    private void saveBioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBioMouseEntered
        saveBio.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_saveBioMouseEntered

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        jPanel14.setBackground(new Color(195, 7, 103));
    }//GEN-LAST:event_jPanel14MouseEntered

    private void saveBioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBioMouseExited
        saveBio.setBackground(new Color(49, 52, 62));
    }//GEN-LAST:event_saveBioMouseExited

    private boolean isBtnMyPostIsClicked = true;
    private boolean isFriendPostIsClicked;
    
    public javax.swing.JScrollBar verticalScrollBar;
    private void btnMyPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyPostMouseClicked
        if (!hasPost) {
            
            NoPost noPost = new NoPost("You don't have any post.");
            postInnerContainer.add(noPost);
            postInnerContainer.revalidate();
            postInnerContainer.repaint();
        }

        try {
            verticalScrollBar.setValue(verticalScrollBar.getMinimum());
            displayMyPost();
            
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        isBtnMyPostIsClicked = true;
        isFriendPostIsClicked = false;

        btnMyPost.setForeground(new Color(0, 167, 255));
        btnFriendPost.setForeground(new Color(115, 130, 144));

        btnMyPost.requestFocus();
        friendName.setText("");
    }//GEN-LAST:event_btnMyPostMouseClicked

    private void btnFriendPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFriendPostMouseClicked
        if (!hasFriendPost) {
            NoPost noPost = new NoPost("No posts from friends yet.");
            postInnerContainer.add(noPost);
            postInnerContainer.revalidate();
            postInnerContainer.repaint();
        }
        try {
            verticalScrollBar.setValue(verticalScrollBar.getMinimum());
            displayFriendPost();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        isFriendPostIsClicked = true;
        isBtnMyPostIsClicked = false;

        btnFriendPost.setForeground(new Color(0, 167, 255));
        btnMyPost.setForeground(new Color(115, 130, 144));

        btnFriendPost.requestFocus();
        
        friendName.setText("");
    }//GEN-LAST:event_btnFriendPostMouseClicked

    private void btnMyPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyPostMouseEntered
        if (!isBtnMyPostIsClicked) {
            btnMyPost.setForeground(new Color(0, 167, 255));
        }
    }//GEN-LAST:event_btnMyPostMouseEntered

    private void btnMyPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyPostMouseExited
        if (!isBtnMyPostIsClicked) {
            btnMyPost.setForeground(new Color(115, 130, 144));
        }
    }//GEN-LAST:event_btnMyPostMouseExited

    private void btnFriendPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFriendPostMouseEntered
        if (!isFriendPostIsClicked) {
            btnFriendPost.setForeground(new Color(0, 167, 255));
        }
    }//GEN-LAST:event_btnFriendPostMouseEntered

    private void btnFriendPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFriendPostMouseExited
        if (!isFriendPostIsClicked) {
            btnFriendPost.setForeground(new Color(115, 130, 144));
        }
    }//GEN-LAST:event_btnFriendPostMouseExited

    String path = null;
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        path = f.getAbsolutePath();

        if (path != null) {
            txtImageIndicator.setText("Image added");
        } else {
            JOptionPane.showMessageDialog(this, "Error adding image. Please try again.");
        }

    }//GEN-LAST:event_jLabel16MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        new LoginForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        jPanel11.setBackground(new Color(195, 7, 103));
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        jPanel11.setBackground(new Color(40, 52, 62));
    }//GEN-LAST:event_jPanel11MouseExited

    private void btnMyProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyProfileMouseEntered
        if (!btnMyProfileIsClicked) {
            btnMyProfile.setBackground(new Color(58, 58, 112));
        }
    }//GEN-LAST:event_btnMyProfileMouseEntered

    private void btnMyProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyProfileMouseExited
        if (!btnMyProfileIsClicked) {
            btnMyProfile.setBackground(new Color(6, 20, 29));
        }
    }//GEN-LAST:event_btnMyProfileMouseExited

    private void btnFriendlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFriendlistMouseEntered
        if (!btnFriendListIsClicked) {
            btnFriendlist.setBackground(new Color(58, 58, 112));
        }
    }//GEN-LAST:event_btnFriendlistMouseEntered

    private void btnFriendlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFriendlistMouseExited
        if (!btnFriendListIsClicked) {
            btnFriendlist.setBackground(new Color(6, 20, 29));
        }
    }//GEN-LAST:event_btnFriendlistMouseExited

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        jPanel14.setBackground(new Color(40, 52, 62));
    }//GEN-LAST:event_jPanel14MouseExited

    private void mainPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseClicked
        mainPanel.requestFocusInWindow();
    }//GEN-LAST:event_mainPanelMouseClicked

    private void postInnerContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postInnerContainerMouseClicked
        mainPanel.requestFocusInWindow();
    }//GEN-LAST:event_postInnerContainerMouseClicked

    private void friendNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_friendNameMouseClicked

    private void friendNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendNameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_friendNameMouseEntered

    private void friendNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendNameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_friendNameMouseExited

    private void actionListenerBioTextArea() {
        bioTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel();
            }

            private void updateLabel() {
                if (bioTextArea.getText().equals("Put your bio here...")) {
                    SwingUtilities.invokeLater(() -> txtCharacterCount.setText(100 + " characters remaining"));
                } else {
                    int remainingChars = 100 - bioTextArea.getText().length();
                    SwingUtilities.invokeLater(() -> txtCharacterCount.setText(remainingChars + " characters remaining"));
                }
            }
        });

    }

    private ArrayList<PostInformation> getFriendPost() throws IOException {

        ArrayList<PostInformation> friendPosts = new ArrayList<PostInformation>();
        int currentUserID = 0;
        try {
            currentUserID = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
            return friendPosts; // Return empty list if current user ID retrieval fails
        }

        String sql = "SELECT * FROM ( "
                + "SELECT a.user_id AS account_user_id, a.name, a.password, a.profile_picture, "
                + "p.post_id, p.user_id AS post_user_id, p.post_content, p.post_picture, p.time_stamp AS post_time "
                + "FROM account_table a "
                + "JOIN post_table p ON a.user_id = p.user_id "
                + "JOIN friendship_table f ON p.user_id = f.friend_id "
                + "WHERE f.user_id = ? AND f.status = 'Accepted' "
                + "UNION "
                + "SELECT a.user_id AS account_user_id, a.name, a.password, a.profile_picture, "
                + "p.post_id, p.user_id AS post_user_id, p.post_content, p.post_picture, p.time_stamp AS post_time "
                + "FROM account_table a "
                + "JOIN post_table p ON a.user_id = p.user_id "
                + "JOIN friendship_table f ON p.user_id = f.user_id "
                + "WHERE f.friend_id = ? AND f.status = 'Accepted' "
                + ") AS combined_results "
                + "ORDER BY post_time DESC;";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, currentUserID);
            pst.setInt(2, currentUserID);
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
                    Timestamp timestamp = rs.getTimestamp("post_time");
                    int post_id = rs.getInt("post_id");
                    int friend_id = rs.getInt("account_user_id");
                    

                    Blob postImageBlob = rs.getBlob("post_picture");
                    if (postImageBlob == null || postImageBlob.length() == 0) {
                        PostInformation postInformation = new PostInformation(icon, username, postContent, timestamp, post_id, friend_id);
                        friendPosts.add(postInformation);
                    } else {
                        try (InputStream inputStream1 = postImageBlob.getBinaryStream()) {
                            BufferedImage postImage = ImageIO.read(inputStream1);
                            Image scaledPostImage = postImage.getScaledInstance(387, 189, Image.SCALE_SMOOTH);
                            ImageIcon postPicture = new ImageIcon(scaledPostImage);
                            PostInformation postInformation = new PostInformation(icon, username, postContent, timestamp, postPicture, post_id, friend_id);
                            friendPosts.add(postInformation);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return friendPosts;
    }

    private boolean hasFriendPost = true;

    public void displayFriendPost() throws SQLException {
        int currentUserID = CurrentUserID();
        try {
            ArrayList<PostInformation> posts = getFriendPost();
            postInnerContainer.removeAll();
            if (posts.isEmpty()) {
                NoPost noPost = new NoPost("No posts in the newsfeed.");
                postInnerContainer.add(noPost);
                hasFriendPost = false;
            } else {
                Collections.shuffle(posts);
            }

            for (PostInformation post : posts) {
                if (post.getPostPicture() == null) {
                    CustomPostTextPanel CustomPostTextPanel = new CustomPostTextPanel(post.getIcon(), post.getUsername(), post.getContent(), post.getTimeStamp(), post.getPostId(), currentUserID, this, post.getFriendID());
                    CustomBorderPostStack customBorder = new CustomBorderPostStack();
                    postInnerContainer.add(CustomPostTextPanel);
                    postInnerContainer.add(customBorder);
                    postInnerContainer.revalidate();
                    postInnerContainer.repaint();
                } else {
                    CustomPostPicturePanel postPicturePanel = new CustomPostPicturePanel(post.getIcon(), post.getUsername(), post.getContent(), post.getTimeStamp(), post.getPostPicture(), post.getPostId(), currentUserID, this, post.getFriendID());
                    CustomBorderPostStack customBorder = new CustomBorderPostStack();
                    postInnerContainer.add(postPicturePanel);
                    postInnerContainer.add(customBorder);
                    postInnerContainer.revalidate();
                    postInnerContainer.repaint();
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   String sql = "SELECT a.*, p.* " +
//                         "FROM account_table a " +
//                         "JOIN post_table p ON a.user_id = p.user_id " +
//                         "WHERE a.user_id = ?";

    private ArrayList<PostInformation> getMyPost() throws IOException {

        ArrayList<PostInformation> getMyPosts = new ArrayList<PostInformation>();
        int currentUserID = 0;
        try {
            currentUserID = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        int currentUserID = CurrentUserID();
        try {
            ArrayList<PostInformation> posts = getMyPost();
            postInnerContainer.removeAll();
            if (posts.isEmpty()) {
                hasPost = false;
                NoPost noPost = new NoPost("No posts in the newsfeed.");
                postInnerContainer.add(noPost);
            }
            for (PostInformation post : posts) {
                if (post.getPostPicture() == null) {
                    CustomMyPostPanel customPostTextPanel = new CustomMyPostPanel(post.getIcon(), post.getUsername(), post.getContent(), post.getTimeStamp(), post.getPostId(), currentUserID, this);
                    CustomBorderPostStack customBorder = new CustomBorderPostStack();
                    postInnerContainer.add(customPostTextPanel);
                    postInnerContainer.add(customBorder);
                    postInnerContainer.revalidate();
                    postInnerContainer.repaint();
                } else {
                    CustomMyPostPicturePanel postPicturePanel = new CustomMyPostPicturePanel(post.getIcon(), post.getUsername(), post.getContent(), post.getTimeStamp(), post.getPostPicture(), post.getPostId(), currentUserID, this);
                    CustomBorderPostStack customBorder = new CustomBorderPostStack();
                    postInnerContainer.add(postPicturePanel);
                    postInnerContainer.add(customBorder);
                    postInnerContainer.revalidate();
                    postInnerContainer.repaint();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//RETRIEVE FRIEND REQUEST
    private ArrayList<UserInformation> pendingFriendRequest() throws IOException {

        ArrayList<UserInformation> pendingFriends = new ArrayList<UserInformation>();
        int currentUserID = 0;
        try {
            currentUserID = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "SELECT account_table.user_id, account_table.name, account_table.profile_picture "
                    + "FROM friendship_table "
                    + "JOIN account_table ON friendship_table.user_id = account_table.user_id "
                    + "WHERE friendship_table.friend_id = ? AND friendship_table.status = 'Pending'";

            pst = con.prepareStatement(sql);
            pst.setInt(1, currentUserID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Blob imageBlob = rs.getBlob("profile_picture");
                InputStream inputStream = imageBlob.getBinaryStream();
                BufferedImage image = ImageIO.read(inputStream);
                CirclePicture circleImage = new CirclePicture();
                BufferedImage circularImage = circleImage.makeCircularImage(image);

                Image scaledImage = circularImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                int friendID = rs.getInt("user_id");
                String name = rs.getString("name");

                UserInformation pendingFriend = new UserInformation(icon, name, friendID);
                pendingFriends.add(pendingFriend);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pendingFriends;
    }

    public void displayPendingRequest() throws SQLException {
        try {
            ArrayList<UserInformation> users = pendingFriendRequest();
            FriendRequestCard.removeAll();
            for (UserInformation user : users) {
                CustomFriendRequestPanel customPanel = new CustomFriendRequestPanel(user.getIcon(), user.getName(), CurrentUserID(), user.getFriendID(), this);
                CustomBorderFriend customBorder = new CustomBorderFriend();
                FriendRequestCard.add(customPanel);
                FriendRequestCard.add(customBorder);
                FriendRequestCard.revalidate();
                FriendRequestCard.repaint();
            }
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<UserInformation> getFriends() throws IOException {
        ArrayList<UserInformation> friends = new ArrayList<UserInformation>();
        int id = 0;
        try {
            id = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String query = "SELECT * FROM account_table "
                    + "WHERE user_id IN (SELECT friend_id FROM friendship_table WHERE user_id = ? AND status = 'accepted') "
                    + "OR user_id IN (SELECT user_id FROM friendship_table WHERE friend_id = ? AND status = 'accepted')";

            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Blob imageBlob = rs.getBlob("profile_picture");
                InputStream inputStream = imageBlob.getBinaryStream();
                BufferedImage image = ImageIO.read(inputStream);
                CirclePicture circleImage = new CirclePicture();
                BufferedImage circularImage = circleImage.makeCircularImage(image);

                Image scaledImage = circularImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);

                int friendID = rs.getInt("user_id");
                String name = rs.getString("name");

                UserInformation friend = new UserInformation(icon, name, friendID);
                friends.add(friend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return friends;
    }

    private void displayFriend() throws SQLException, IOException {
        ArrayList<UserInformation> users = getFriends();
        FriendListCard.removeAll();
        for (UserInformation user : users) {
            CustomFriendListPanel customPanel = new CustomFriendListPanel(user.getIcon(), user.getName(), CurrentUserID(), user.getFriendID(), this);
            CustomBorderFriend customBorder = new CustomBorderFriend();
            FriendListCard.add(customPanel);
            FriendListCard.add(customBorder);
            FriendListCard.revalidate();
            FriendListCard.repaint();
        }
    }

    private ArrayList<UserInformation> getPotentialFriends() throws IOException {
        ArrayList<UserInformation> users = new ArrayList<UserInformation>();
        try {
            String query = "SELECT * FROM account_table WHERE user_id != ? AND user_id NOT IN "
                    + "(SELECT friend_id FROM friendship_table WHERE user_id = ?) "
                    + "AND user_id NOT IN (SELECT user_id FROM friendship_table WHERE friend_id = ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            int userId = CurrentUserID();
            pstmt.setInt(1, userId); // Replace with the actual value of user_id
            pstmt.setInt(2, userId);
            pstmt.setInt(3, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Blob imageBlob = rs.getBlob("profile_picture");
                InputStream inputStream = imageBlob.getBinaryStream();
                BufferedImage image = ImageIO.read(inputStream);
                CirclePicture circleImage = new CirclePicture();
                BufferedImage circularImage = circleImage.makeCircularImage(image);

                Image scaledImage = circularImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);

                int friendID = rs.getInt(1);
                String name = rs.getString(4);
                UserInformation user = new UserInformation(icon, name, friendID);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    protected void displayFriendSuggestion() throws IOException, SQLException {
        ArrayList<UserInformation> users = getPotentialFriends();
        FriendSuggestionCard.removeAll();
        for (UserInformation user : users) {
            CustomFriendSuggestionPanel customPanel = new CustomFriendSuggestionPanel(user.getIcon(), user.getName(), CurrentUserID(), user.getFriendID(), this);
            CustomBorderFriend customBorder = new CustomBorderFriend();
            FriendSuggestionCard.add(customPanel);
            FriendSuggestionCard.add(customBorder);
            FriendSuggestionCard.revalidate();
            FriendSuggestionCard.repaint();

        }
    }

    private int CurrentUserID() throws SQLException {
        int userID = 0;
        pst = con.prepareStatement("SELECT user_id FROM account_table WHERE username = ?");
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            userID = rs.getInt("user_id");
        }
        return userID;
    }

    public void LoadProfile() throws SQLException, IOException {
        txtUsername.setText("@" + username);
        txtUsernameRight.setText("@" + username);
        mainPanel.requestFocus();
        pst = con.prepareStatement("SELECT * FROM account_table WHERE username = ?");
        pst.setString(1, username);
        rs = pst.executeQuery();
        if (rs.next() == true) {
            Blob imageBlob = rs.getBlob("profile_picture");
            InputStream inputStream = imageBlob.getBinaryStream();
            BufferedImage image = ImageIO.read(inputStream);
            CirclePicture circleImage = new CirclePicture();
            BufferedImage circularImage = circleImage.makeCircularImage(image);

            Image scaledImage = circularImage.getScaledInstance(43, 43, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            Image scaledSmallProfile = circularImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            ImageIcon smallProfileIcon = new ImageIcon(scaledSmallProfile);

            Blob coverPhotoBlob = rs.getBlob("cover_photo");
            InputStream coverPhotoStream = coverPhotoBlob.getBinaryStream();
            BufferedImage coverBufferedImage = ImageIO.read(coverPhotoStream);
            Image coverImage = coverBufferedImage.getScaledInstance(223, 159, Image.SCALE_SMOOTH);
            ImageIcon coverIcon = new ImageIcon(coverImage);

            txtProfilePicture.setIcon(icon);
            txtProfilePictureRight.setIcon(icon);
            profilePicturePostPanel.setIcon(smallProfileIcon);
            profilePicturePostPanel1.setIcon(smallProfileIcon);
            String bio = rs.getString(5);
            String formattedBioText = formatBioText(bio, 32);
            txtBio.setText(formattedBioText);

            coverPhotoImage.setIcon(coverIcon);
            String name = rs.getString(4);
            txtName.setText(name);
            Name.setText(name);
            friendName.setText("");

            txtNumberFollowing.setText(Integer.toString(getNumberOfFollowing()));
            txtNumberFollowers.setText(Integer.toString(getNumberOfFollowers()));

            
            
            if(isFriendSuggestionClicked){
                panelFriendSuggestionIcon.setBackground(new Color(121, 98, 242));
                panelFriendlistIcon.setBackground(new Color(6, 20, 29));
                panelFriendRequestIcon.setBackground(new Color(6, 20, 29));
            }
            else if(isFriendListClicked){
                panelFriendSuggestionIcon.setBackground(new Color(6, 20, 29));
                panelFriendlistIcon.setBackground(new Color(121, 98, 242));
                panelFriendRequestIcon.setBackground(new Color(6, 20, 29));
            }
            else{
                panelFriendSuggestionIcon.setBackground(new Color(6, 20, 29));
                panelFriendlistIcon.setBackground(new Color(6, 20, 29));
                panelFriendRequestIcon.setBackground(new Color(121, 98, 242));
            }
        }
    }

    private void displayDefaultIcon() {
        String suggestionPath = "/imagesIcon/join.png";
        ImageIcon FriendSuggestionIcon = new ImageIcon(getClass().getResource(suggestionPath));
        Image FriendSuggestionImage = FriendSuggestionIcon.getImage();
        Image ScaledSuggestion = FriendSuggestionImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon ScaledSuggestionIcon = new ImageIcon(ScaledSuggestion);
        txtAddedFriend1.setIcon(ScaledSuggestionIcon);

        String friendPath = "/imagesIcon/friend.png";
        ImageIcon FriendIcon = new ImageIcon(getClass().getResource(friendPath));
        Image FriendImage = FriendIcon.getImage();
        Image ScaledFriend = FriendImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon ScaledFriendIcon = new ImageIcon(ScaledFriend);
        txtFriendlist.setIcon(ScaledFriendIcon);

        String requestPath = "/imagesIcon/friend-request.png";
        ImageIcon RequestIcon = new ImageIcon(getClass().getResource(requestPath));
        Image RequestImage = RequestIcon.getImage();
        Image ScaledRequest = RequestImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon ScaledRequestIcon = new ImageIcon(ScaledRequest);
        txtAddedFriend.setIcon(ScaledRequestIcon);

        String addPicture = "/imagesIcon/addPicture.png";
        ImageIcon addPictureIcon = new ImageIcon(getClass().getResource(addPicture));
        Image addPictureImage = addPictureIcon.getImage();
        Image scaledAddPicture = addPictureImage.getScaledInstance(21, 21, Image.SCALE_SMOOTH);
        ImageIcon ScaledAddPictureIcon = new ImageIcon(scaledAddPicture);
        jLabel16.setIcon(ScaledAddPictureIcon);
    }

    private void getProfilePicture(int width, int height, JLabel variable) throws SQLException, IOException {
        pst = con.prepareStatement("SELECT * FROM account_table WHERE username = ?");
        pst.setString(1, username);
        rs = pst.executeQuery();
        if (rs.next() == true) {
            Blob imageBlob = rs.getBlob("profile_picture");
            InputStream inputStream = imageBlob.getBinaryStream();
            BufferedImage image = ImageIO.read(inputStream);
            CirclePicture circlePicture = new CirclePicture();
            BufferedImage circularImage = circlePicture.makeCircularImage(image);
            Image scaledImage = circularImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            variable.setIcon(icon);
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

    private int getNumberOfFollowing() {
        int count = 0;
        int id = 0;
        try {
            id = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "SELECT "
                    + "(SELECT COUNT(*) FROM friendship_table WHERE friend_id = ? AND status = 'accepted') AS friends_count, "
                    + "(SELECT COUNT(*) FROM friendship_table WHERE user_id = ?) AS following_count";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1) + rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    private int getNumberOfFollowers() {
        int count = 0;
        int id = 0;
        try {
            id = CurrentUserID();
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "SELECT "
                    + "(SELECT COUNT(*) FROM friendship_table WHERE user_id = ? AND status = 'Accepted') AS friends_count, "
                    + "(SELECT COUNT(*) FROM friendship_table WHERE friend_id = ?) AS following_count";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1) + rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacebookInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacebookInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacebookInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacebookInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacebookInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BioPanel;
    private javax.swing.JPanel FriendContainer;
    private javax.swing.JPanel FriendListCard;
    private javax.swing.JPanel FriendRequestCard;
    private javax.swing.JPanel FriendSuggestionCard;
    private javax.swing.JPanel FriendlistPanel;
    private javax.swing.JLabel Name;
    private javax.swing.JPanel PostPanel;
    private javax.swing.JPanel PostPanelCard;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JPanel RightSidePanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JPanel SwitchPanel;
    private javax.swing.JTextArea bioTextArea;
    private javax.swing.JPanel btnCancelPost;
    private javax.swing.JPanel btnEditBio;
    private javax.swing.JPanel btnEditProfile;
    protected javax.swing.JLabel btnFriendPost;
    private javax.swing.JPanel btnFriendlist;
    public javax.swing.JLabel btnMyPost;
    private javax.swing.JPanel btnMyProfile;
    private javax.swing.JPanel btnPost;
    private javax.swing.JLabel coverPhotoImage;
    private javax.swing.JPanel displayFollow;
    private javax.swing.JPanel displayProfile;
    private javax.swing.JPanel editCoverPhoto;
    public javax.swing.JLabel friendName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelFriendRequestIcon;
    private javax.swing.JPanel panelFriendSuggestionIcon;
    private javax.swing.JPanel panelFriendlistIcon;
    public javax.swing.JPanel postInnerContainer;
    private javax.swing.JPanel postSection;
    private javax.swing.JTextArea postTextArea;
    private javax.swing.JLabel profilePicturePostPanel;
    private javax.swing.JLabel profilePicturePostPanel1;
    private javax.swing.JPanel saveBio;
    private javax.swing.JLabel txtAddedFriend;
    private javax.swing.JLabel txtAddedFriend1;
    private javax.swing.JLabel txtBio;
    private javax.swing.JLabel txtCharacterCount;
    private javax.swing.JLabel txtCharacterCount1;
    private javax.swing.JLabel txtCoverPhoto;
    private javax.swing.JLabel txtFriendlist;
    private javax.swing.JLabel txtImageIndicator;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtNumberFollowers;
    private javax.swing.JLabel txtNumberFollowing;
    private javax.swing.JLabel txtProfilePicture;
    private javax.swing.JLabel txtProfilePictureRight;
    private javax.swing.JLabel txtUsername;
    private javax.swing.JLabel txtUsernameRight;
    // End of variables declaration//GEN-END:variables
}
