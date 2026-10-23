package crms;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class MainFrame extends javax.swing.JFrame {
    //private JButton caseOfficerButton;
    //private JButton viewEvidenceButton;


    public MainFrame() {
        initComponents();
        setTitle("Crime Record Management System");
        //setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
      
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headinglbl = new javax.swing.JLabel();
        addCrimebtn = new javax.swing.JButton();
        viewCrimebtn = new javax.swing.JButton();
        officerMapbtn = new javax.swing.JButton();
        addEvidencebtn = new javax.swing.JButton();
        viewEvidencevbtn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        bgImglbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headinglbl.setBackground(new java.awt.Color(153, 153, 0));
        headinglbl.setFont(new java.awt.Font("Aparajita", 3, 48)); // NOI18N
        headinglbl.setText("Welcome to Crime Record Management System");
        getContentPane().add(headinglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 770, 70));

        addCrimebtn.setBackground(new java.awt.Color(0, 0, 0));
        addCrimebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addCrimebtn.setForeground(new java.awt.Color(30, 144, 255));
        addCrimebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shape.png"))); // NOI18N
        addCrimebtn.setText("Add New Crime");
        addCrimebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCrimebtnActionPerformed(evt);
            }
        });
        getContentPane().add(addCrimebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 190, 53));
        addCrimebtn.getAccessibleContext().setAccessibleName("jButton2");

        viewCrimebtn.setBackground(new java.awt.Color(0, 0, 0));
        viewCrimebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewCrimebtn.setForeground(new java.awt.Color(30, 144, 255));
        viewCrimebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shape.png"))); // NOI18N
        viewCrimebtn.setText("View Crime Records");
        viewCrimebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCrimebtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewCrimebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, -1, 53));

        officerMapbtn.setBackground(new java.awt.Color(0, 0, 0));
        officerMapbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        officerMapbtn.setForeground(new java.awt.Color(30, 144, 255));
        officerMapbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shape.png"))); // NOI18N
        officerMapbtn.setText("Case-Officer Mapping");
        officerMapbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officerMapbtnActionPerformed(evt);
            }
        });
        getContentPane().add(officerMapbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, 53));

        addEvidencebtn.setBackground(new java.awt.Color(0, 0, 0));
        addEvidencebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addEvidencebtn.setForeground(new java.awt.Color(30, 144, 255));
        addEvidencebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shape.png"))); // NOI18N
        addEvidencebtn.setText("Add Evidence");
        addEvidencebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEvidencebtnActionPerformed(evt);
            }
        });
        getContentPane().add(addEvidencebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 201, 53));

        viewEvidencevbtn.setBackground(new java.awt.Color(0, 0, 0));
        viewEvidencevbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewEvidencevbtn.setForeground(new java.awt.Color(30, 144, 255));
        viewEvidencevbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shape.png"))); // NOI18N
        viewEvidencevbtn.setText("View Evidence");
        viewEvidencevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEvidencevbtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewEvidencevbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, 201, 53));

        logout_btn.setBackground(new java.awt.Color(0, 0, 0));
        logout_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logout_btn.setForeground(new java.awt.Color(255, 99, 71));
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        getContentPane().add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 710, 150, 60));

        bgImglbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Blur.jpg"))); // NOI18N
        getContentPane().add(bgImglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1200, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCrimebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCrimebtnActionPerformed
        // TODO add your handling code here:
        AddCrimeForm addCrimeForm = new AddCrimeForm();
        addCrimeForm.show();
        dispose();
    }//GEN-LAST:event_addCrimebtnActionPerformed

    private void viewCrimebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCrimebtnActionPerformed
        // TODO add your handling code here:
        setLocationRelativeTo(null);
        ViewCrimeForm viewCrimeForm = new ViewCrimeForm();
        viewCrimeForm.show();
        dispose();
    }//GEN-LAST:event_viewCrimebtnActionPerformed

    private void addEvidencebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEvidencebtnActionPerformed
        // TODO add your handling code here:
        new AddEvidenceForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_addEvidencebtnActionPerformed

    private void officerMapbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officerMapbtnActionPerformed

        new CaseOfficerMappingForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_officerMapbtnActionPerformed

    private void viewEvidencevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEvidencevbtnActionPerformed
        // TODO add your handling code here:
        new ViewEvidenceForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_viewEvidencevbtnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        try {
            new AdminLoginForm().setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logout_btnActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        //SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //new MainFrame().setVisible(true);
                    new AdminLoginForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCrimebtn;
    private javax.swing.JButton addEvidencebtn;
    private javax.swing.JLabel bgImglbl;
    private javax.swing.JLabel headinglbl;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton officerMapbtn;
    private javax.swing.JButton viewCrimebtn;
    private javax.swing.JButton viewEvidencevbtn;
    // End of variables declaration//GEN-END:variables
}
