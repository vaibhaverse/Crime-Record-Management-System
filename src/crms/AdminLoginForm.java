package crms;

import ConnectionProvider.DatabaseConnector;
import javax.swing.*;
import static java.lang.System.exit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminLoginForm extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public AdminLoginForm() throws SQLException {
        this.con = DatabaseConnector.getConnection();
        initComponents();
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
          
    }
    
    // Method to check admin credentials
    private void authenticateAdmin() {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    try (Connection conn = DatabaseConnector.connect();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admins WHERE username = ? AND password = ?")) {
        
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            
            // Using an anonymous inner class to invoke the action
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainFrame().setVisible(true);
                    dispose(); // Close the login window
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Try again.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
    }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        exit_btn = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        username_icon = new javax.swing.JLabel();
        password_icon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 140, 50));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 140, 50));

        usernameField.setBackground(new java.awt.Color(20, 6, 65));
        usernameField.setForeground(new java.awt.Color(221, 130, 117));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 290, 50));

        exit_btn.setBackground(new java.awt.Color(21, 7, 66));
        exit_btn.setForeground(new java.awt.Color(221, 130, 117));
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        getContentPane().add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 150, 40));

        loginButton.setBackground(new java.awt.Color(21, 7, 66));
        loginButton.setForeground(new java.awt.Color(221, 130, 117));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login Icon.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 160, 40));

        passwordField.setBackground(new java.awt.Color(21, 7, 66));
        passwordField.setForeground(new java.awt.Color(221, 130, 117));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 290, 50));

        username_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        getContentPane().add(username_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 40, 50));

        password_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/key.png"))); // NOI18N
        getContentPane().add(password_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 40, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        authenticateAdmin();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed

        exit(0);
    }//GEN-LAST:event_exit_btnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AdminLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminLoginForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminLoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel password_icon;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel username_icon;
    // End of variables declaration//GEN-END:variables
}
