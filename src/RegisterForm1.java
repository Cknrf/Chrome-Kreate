
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegisterForm1 extends javax.swing.JFrame {

    /**
     * s
     * Creates new form RegisterForm1
     */
    public RegisterForm1() {
        initComponents();
        Connect();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/facebook", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSignIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(224, 0, 0));

        jPanel1.setBackground(new java.awt.Color(14, 14, 14));
        jPanel1.setForeground(new java.awt.Color(14, 14, 14));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(196, 196, 196));
        jLabel1.setText("Register");

        jLabel2.setForeground(new java.awt.Color(164, 143, 160));
        jLabel2.setText("Username");

        txtUsername.setBackground(new java.awt.Color(24, 25, 27));
        txtUsername.setForeground(new java.awt.Color(255, 240, 245));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setText("Password");

        txtPassword.setBackground(new java.awt.Color(24, 25, 27));
        txtPassword.setForeground(new java.awt.Color(255, 240, 245));
        txtPassword.setPreferredSize(new java.awt.Dimension(15, 24));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnRegister.setForeground(java.awt.Color.black);
        btnRegister.setText("Sign Up");
        btnRegister.setFocusPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(164, 143, 160));
        jLabel4.setText("Already have an account?");

        txtSignIn.setForeground(java.awt.Color.white);
        txtSignIn.setText("Sign in");
        txtSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSignInMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txtUsername)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSignIn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(308, 388));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
       register();
    }//GEN-LAST:event_btnRegisterActionPerformed
    // Start of the Code


    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSignInMouseClicked
        new LoginForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_txtSignInMouseClicked

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPassword.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnRegister.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private boolean doesNotContainSpace(String username) {
        int length = username.length();
        boolean doesNotContain = true;

        for (int i = 0; i < length; i++) {
            char ch = username.charAt(i);
            if (ch == ' ') {
                doesNotContain = false;
                break;
            }
        }
        return doesNotContain;
    }

    private boolean isPasswordLong(String password) {
        if (password.length() <= 8) {
            return false;
        }
        return true;
    }

    private boolean containSpecialChar(String password) {

        int length = password.length();
        boolean found = false;

        for (int i = 0; i < length; i++) {
            char t = password.charAt(i);

            if (t == '@' || t == '_' || t == '$' || t == '!') {
                found = true;
                break;
            }

        }
        return found;
    }

    private boolean isPasswordContainCapital(String password) {

        int length = password.length();
        boolean hasCapital = false;

        for (int i = 0; i < length; i++) {
            char t = password.charAt(i);

            if (t >= 'A' && t <= 'Z') {
                hasCapital = true;
                break;
            }
        }
        return hasCapital;
    }

    private boolean isPasswordContainLowerCase(String password) {

        int length = password.length();
        boolean hasLowerCase = false;

        for (int i = 0; i < length; i++) {
            char t = password.charAt(i);

            if (t >= 'a' && t <= 'z') {
                hasLowerCase = true;
                break;
            }
        }
        return hasLowerCase;
    }
    
    private boolean accountDoesExist(String username){
        try {
            pst = con.prepareStatement("SELECT COUNT(*) FROM account_table WHERE username = ?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private void register(){
        String username = txtUsername.getText().strip();
        String password = new String(txtPassword.getPassword());
        password = password.strip();
        

        boolean isLong = isPasswordLong(password);
        boolean passwordDoesNotContainSpace = doesNotContainSpace(password);
        boolean hasSpecialChar = containSpecialChar(password);
        boolean hasCapital = isPasswordContainCapital(password);
        boolean hasLowerCase = isPasswordContainLowerCase(password);
        boolean doesNotContain = doesNotContainSpace(username);
        boolean hasUsernameSpecialChar = containSpecialChar(username);
        

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username field is required!");
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password field is required!");
        } else if (!doesNotContain && hasUsernameSpecialChar) {
            JOptionPane.showMessageDialog(this, "Username should not contain any spaces\n");
            JOptionPane.showMessageDialog(this, "Username should not contain any special character");

        } else if (!doesNotContain) {
            JOptionPane.showMessageDialog(this, "Username should not contain any spaces");
        } else if (hasUsernameSpecialChar) {
            JOptionPane.showMessageDialog(this, "Username should not contain any special character");
        } else if (username.length() <= 4) {
            JOptionPane.showMessageDialog(this, "Username should consist more than 4 characters!");
        } else if (username.length() >= 20) {
            JOptionPane.showMessageDialog(this, "Username should not consist more than 20 characters!");
        } 
        else if(accountDoesExist(username)){
            JOptionPane.showMessageDialog(this, "Username already exist, choose other username");
        }
        else if (!isLong && !hasSpecialChar && !hasCapital && !hasLowerCase && !passwordDoesNotContainSpace) {
            JOptionPane.showMessageDialog(this, "Password should meet the following criteria:\n"
                    + " - Be longer than 8 characters\n"
                    + " - Contain a special character (@, !, $, _)\n"
                    + " - Contain a capital letter\n"
                    + " - Contain a lowercase letter\n"
                    + " - Does not contain spaces");
        } else if (!isLong) {
            JOptionPane.showMessageDialog(this, "Password should consist more than 12 characters!");
        } else if (!hasSpecialChar) {
            JOptionPane.showMessageDialog(this, "Password should consist Special Character (@, !, $, _)");
        } else if (!hasCapital) {
            JOptionPane.showMessageDialog(this, "Password should consist Capital Letter");
        } else if (!hasLowerCase) {
            JOptionPane.showMessageDialog(this, "Password should consist Lower Case Letter");
        }
        else if(!passwordDoesNotContainSpace){
            JOptionPane.showMessageDialog(this, "Passwod should not contain spaces");
        }
        else {
            GetStarted getStarted = new GetStarted(username, password);
            getStarted.setVisible(true);
            this.setVisible(false);
        }
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
            java.util.logging.Logger.getLogger(RegisterForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtSignIn;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
