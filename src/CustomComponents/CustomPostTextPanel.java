
import CustomPanels.CirclePicture;
import CustomPanels.CustomBorderPostStack;
import CustomPanels.RoundedPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CustomPostTextPanel extends javax.swing.JPanel {

    public CustomPostTextPanel() {

    }

    private ImageIcon icon;
    private String username;
    private String content;
    private Timestamp timeStamp;
    private int post_id;
    private int user_id;
    private boolean hasAlreadyLiked = false;
    private FacebookInterface facebook;
    private String formattedDate;

    public CustomPostTextPanel(ImageIcon icon, String username, String content, Timestamp timeStamp, int post_id, int user_id, FacebookInterface facebook) {
        this.icon = icon;
        this.username = username;
        this.content = content;
        this.timeStamp = timeStamp;
        this.post_id = post_id;
        this.user_id = user_id;
        this.facebook = facebook;
        initComponents();
        Connect();
        displayLike();

        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime timeStampDateTime = timeStamp.toLocalDateTime();
        Duration duration = Duration.between(timeStampDateTime, timeNow);

        formattedDate = formatDuration(duration, timeStampDateTime, timeNow);

        jTextArea1.setText(content);
        jLabel9.setText(formattedDate);

        String like = "/imagesIcon/like.png";
        ImageIcon likeIcon = new ImageIcon(getClass().getResource(like));
        Image likeIconImage = likeIcon.getImage();
        Image scaleLike = likeIconImage.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon scaleLikeIcon = new ImageIcon(scaleLike);
        txtLikeIcon.setIcon(scaleLikeIcon);
        DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        SwingUtilities.invokeLater(() -> jTextArea1.setCaretPosition(0));

        hasAlreadyLiked = hasUserLikedPost(user_id, post_id);
        if (hasAlreadyLiked) {
            btnLike.setBackground(new Color(153, 153, 255));
        }
    }

    private int friend_id;

    public CustomPostTextPanel(ImageIcon icon, String username, String content, Timestamp timeStamp, int post_id, int user_id, FacebookInterface facebook, int friend_id) {
        this.icon = icon;
        this.username = username;
        this.content = content;
        this.timeStamp = timeStamp;
        this.post_id = post_id;
        this.user_id = user_id;
        this.facebook = facebook;
        this.friend_id = friend_id;
        initComponents();
        Connect();
        displayLike();

        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime timeStampDateTime = timeStamp.toLocalDateTime();
        Duration duration = Duration.between(timeStampDateTime, timeNow);

        formattedDate = formatDuration(duration, timeStampDateTime, timeNow);

        jTextArea1.setText(content);
        jLabel9.setText(formattedDate);

        String like = "/imagesIcon/like.png";
        ImageIcon likeIcon = new ImageIcon(getClass().getResource(like));
        Image likeIconImage = likeIcon.getImage();
        Image scaleLike = likeIconImage.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon scaleLikeIcon = new ImageIcon(scaleLike);
        txtLikeIcon.setIcon(scaleLikeIcon);
        DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        SwingUtilities.invokeLater(() -> jTextArea1.setCaretPosition(0));

        hasAlreadyLiked = hasUserLikedPost(user_id, post_id);
        if (hasAlreadyLiked) {
            btnLike.setBackground(new Color(153, 153, 255));
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

    private String formatDuration(Duration duration, LocalDateTime timestampDateTime, LocalDateTime now) {
        long seconds = duration.getSeconds();
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (seconds == 1) {
            return " a second ago";
        } else if (seconds < 60) {
            return seconds + " seconds ago";
        } else if (minutes == 1) {
            return "a minute ago";
        } else if (minutes < 60) {
            return minutes + " minutes ago";
        } else if (hours == 1) {
            return "an hour ago";
        } else if (hours < 24) {
            return hours + " hours ago";
        } else if (days == 1) {
            return "Yesterday";
        } else if (days <= 7) {
            return days + " days ago";
        } else {
            return timestampDateTime.toLocalDate().toString();
        }
    }

    public void likePost(int userId, int postId) {
        // Check if the user has already liked the post
        boolean hasLiked = hasUserLikedPost(userId, postId);

        if (!hasLiked) {

            try {
                String query = "INSERT INTO like_table (post_id, user_id) VALUES (?, ?)";
                pst = con.prepareStatement(query);
                pst.setInt(1, postId);
                pst.setInt(2, userId);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CustomPostTextPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(facebook, "You already liked the post");
        }
    }

    private boolean hasUserLikedPost(int userId, int postId) {
        try {
            String query = "SELECT COUNT(*) FROM like_table WHERE post_id = ? AND user_id = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, postId);
            pst.setInt(2, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomPostTextPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void displayLike() {
        int postID = post_id;
        try {
            String sql = "SELECT COUNT(*) AS like_count FROM like_table WHERE post_id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, postID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int likeCount = rs.getInt("like_count");

                jLabel11.setText(Integer.toString(likeCount));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomPostTextPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<PostInformation> getMyPost() throws IOException {

        ArrayList<PostInformation> getMyPosts = new ArrayList<PostInformation>();
        int currentUserID = friend_id;

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
        int currentUserID = user_id;
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

        jPanel7 = new RoundedPanel(25);
        jPanel8 = new javax.swing.JPanel();
        txtProfilePicture3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new ScrollPaneClass11();
        jTextArea1 = new javax.swing.JTextArea();
        btnRekreate = new RoundedPanel(20);
        jLabel10 = new javax.swing.JLabel();
        btnLike = new RoundedPanel(20);
        jLabel1 = new javax.swing.JLabel();
        txtLikeIcon = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 20, 29));
        setMaximumSize(new java.awt.Dimension(466, 195));
        setMinimumSize(new java.awt.Dimension(466, 195));
        setPreferredSize(new java.awt.Dimension(466, 195));
//475 preferred size
        jPanel7.setBackground(new java.awt.Color(27, 39, 48));
        jPanel7.setMaximumSize(new java.awt.Dimension(466, 195));
        jPanel7.setMinimumSize(new java.awt.Dimension(466, 195));
        jPanel7.setPreferredSize(new java.awt.Dimension(466, 195));

        jPanel8.setBackground(new java.awt.Color(27, 39, 48));

        txtProfilePicture3.setIcon(icon);
        txtProfilePicture3.setMaximumSize(new java.awt.Dimension(30, 30));
        txtProfilePicture3.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel8.setForeground(new java.awt.Color(230, 234, 236));
        jLabel8.setText(username);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8(evt);
            }
        });

        jTextArea1.setText(content);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel9.setForeground(new java.awt.Color(115, 130, 144));

        jLabel9.setText(formattedDate);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtProfilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                        .addComponent(txtProfilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 39, 48), 2));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(27, 39, 48));
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(213, 222, 225));
        jTextArea1.setRows(5);
        jTextArea1.setCaretPosition(0);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
                DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
                SwingUtilities.invokeLater(() -> jTextArea1.setCaretPosition(0));
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        btnRekreate.setBackground(new java.awt.Color(40, 52, 62));
        btnRekreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRekreate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnRekreateFocusGained(evt);
            }
        });
        btnRekreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRekreateMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRekreateMouseExited(evt);
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRekreateMouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Rekreate");

        javax.swing.GroupLayout btnRekreateLayout = new javax.swing.GroupLayout(btnRekreate);
        btnRekreate.setLayout(btnRekreateLayout);
        btnRekreateLayout.setHorizontalGroup(
                btnRekreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(btnRekreateLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel10)
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        btnRekreateLayout.setVerticalGroup(
                btnRekreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
//what
        btnLike.setBackground(new java.awt.Color(40, 52, 62));
        btnLike.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLikeMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLikeMouseExited(evt);
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLikeMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Like");

        javax.swing.GroupLayout btnLikeLayout = new javax.swing.GroupLayout(btnLike);
        btnLike.setLayout(btnLikeLayout);
        btnLikeLayout.setHorizontalGroup(
                btnLikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(btnLikeLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        btnLikeLayout.setVerticalGroup(
                btnLikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        txtLikeIcon.setText("jLabel6");
        txtLikeIcon.setPreferredSize(new java.awt.Dimension(15, 15));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel11.setForeground(new java.awt.Color(115, 130, 144));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap(44, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(btnLike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnRekreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44))))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(txtLikeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLikeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRekreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {
//        Border focusBorder = BorderFactory.createLineBorder(Color.BLACK);
//        jTextArea1.setBorder(focusBorder);
        DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        SwingUtilities.invokeLater(() -> jTextArea1.setCaretPosition(0));
    }

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {

    }

    private void btnRekreateMouseClicked(java.awt.event.MouseEvent evt) {
        int currentUserID = 0;
        currentUserID = user_id;
        try {
            String text = jTextArea1.getText();
            String[] words = text.split("\\s");
            String post = String.join(" ", words);

            pst = con.prepareStatement("INSERT INTO post_table (user_id, post_content) VALUES(?, ?)");
            pst.setInt(1, currentUserID);
            pst.setString(2, post);
            int r = pst.executeUpdate();

            if (r > 0) {
                JOptionPane.showMessageDialog(this, "Rekreated the post of " + username + " successfully");
                facebook.LoadProfile();
                facebook.verticalScrollBar.setValue(facebook.verticalScrollBar.getMinimum());
                facebook.displayMyPost();
                facebook.btnMyPost.setForeground(new Color(0, 167, 255));
                facebook.btnFriendPost.setForeground(new Color(115, 130, 144));
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, there was an error Rekreating the post. Please try again.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacebookInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void btnRekreateFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void btnRekreateMouseEntered(java.awt.event.MouseEvent evt) {
        btnRekreate.setBackground(new Color(153, 153, 255));
    }

    private void btnRekreateMouseExited(java.awt.event.MouseEvent evt) {
        btnRekreate.setBackground(new Color(40, 52, 62));
    }

    private void btnLikeMouseEntered(java.awt.event.MouseEvent evt) {
        if (!hasAlreadyLiked) {
            btnLike.setBackground(new Color(153, 153, 255));
        }
    }

    private void btnLikeMouseExited(java.awt.event.MouseEvent evt) {
        if (!hasAlreadyLiked) {
            btnLike.setBackground(new Color(40, 52, 62));
        }
    }

    private void btnLikeMouseClicked(java.awt.event.MouseEvent evt) {
        likePost(user_id, post_id);
        displayLike();
        btnLike.setBackground(new Color(153, 153, 255));
        hasAlreadyLiked = hasUserLikedPost(user_id, post_id);

    }

    private void jLabel8(java.awt.event.MouseEvent evt) {
        try {
            facebook.verticalScrollBar.setValue(facebook.verticalScrollBar.getMinimum());
            FriendProfile friendProfile = new FriendProfile(friend_id, facebook);
            facebook.postInnerContainer.removeAll();
            facebook.postInnerContainer.add(friendProfile);
            CustomBorderPostStack customBorder = new CustomBorderPostStack();
            facebook.postInnerContainer.add(customBorder);
            displayMyPost();
            facebook.revalidate();
            facebook.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(CustomPostTextPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel btnLike;
    private javax.swing.JPanel btnRekreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel txtLikeIcon;
    private javax.swing.JLabel txtProfilePicture3;
    // End of variables declaration                   
}
