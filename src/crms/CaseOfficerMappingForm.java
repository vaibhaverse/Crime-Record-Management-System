package crms;

import ConnectionProvider.DatabaseConnector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CaseOfficerMappingForm extends javax.swing.JFrame {
    private JComboBox<String> crimeDropdown;
    private JComboBox<String> officerDropdown;
    private JButton assignButton;
    private JButton backButton; // New back button
    private JTable mappingTable;
    private DefaultComboBoxModel<String> crimeModel;
    private DefaultComboBoxModel<String> officerModel;
    
    public CaseOfficerMappingForm() {
        initComponents();
        setTitle("Case-Officer Mapping");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Dropdowns and Button
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        crimeModel = new DefaultComboBoxModel<>();
        crimeDropdown = new JComboBox<>(crimeModel);
        officerModel = new DefaultComboBoxModel<>();
        officerDropdown = new JComboBox<>(officerModel);
        assignButton = new JButton("Assign Officer");
        backButton = new JButton("Back");  // Create Back Button

        inputPanel.add(new JLabel("Select Crime:"));
        inputPanel.add(crimeDropdown);
        inputPanel.add(new JLabel("Select Officer:"));
        inputPanel.add(officerDropdown);
        inputPanel.add(assignButton);
         inputPanel.add(backButton);  // Add back button to the panel
        add(inputPanel, BorderLayout.NORTH);

        // Table for Mapping
        mappingTable = new JTable();
        add(new JScrollPane(mappingTable), BorderLayout.CENTER);

        // Load Data
        loadCrimes();
        loadOfficers();
        loadMappings();

        // Action: Assign Officer
        assignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignOfficer();
            }
        });
        
         // Action: Back Button (navigate to previous screen or close window)
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });
    }
    
    // Load Crimes from Database
    private void loadCrimes() {
        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT crime_id, case_number FROM crimes")) {

            crimeModel.removeAllElements();
            while (rs.next()) {
                crimeModel.addElement(rs.getInt("crime_id") + " - " + rs.getString("case_number"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Load Officers from Database
    private void loadOfficers() {
        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT officer_id, name FROM Officers")) {

            officerModel.removeAllElements();
            while (rs.next()) {
                officerModel.addElement(rs.getInt("officer_id") + " - " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Load Existing Mappings
    private void loadMappings() {
    try (Connection conn = DatabaseConnector.connect();
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs = stmt.executeQuery("SELECT co.mapping_id, c.case_number, o.name " +
                 "FROM case_officer co " +
                 "JOIN crimes c ON co.crime_id = c.crime_id " +
                 "JOIN officers o ON co.officer_id = o.officer_id")) {

        mappingTable.setModel(new ResultSetTableModel(rs));
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    
    // Navigate Back to MainFrame
    private void goBack() {
        new MainFrame().setVisible(true);
        dispose();
    }
    
    // Assign Officer to Crime
    private void assignOfficer() {
        String crimeSelection = (String) crimeDropdown.getSelectedItem();
        String officerSelection = (String) officerDropdown.getSelectedItem();

        if (crimeSelection == null || officerSelection == null) {
            JOptionPane.showMessageDialog(this, "Select both crime and officer.");
            return;
        }

        int crimeId = Integer.parseInt(crimeSelection.split(" - ")[0]);
        int officerId = Integer.parseInt(officerSelection.split(" - ")[0]);

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO case_officer (crime_id, officer_id) VALUES (?, ?)")) {

            stmt.setInt(1, crimeId);
            stmt.setInt(2, officerId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Officer assigned successfully.");
            loadMappings();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CaseOfficerMappingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaseOfficerMappingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaseOfficerMappingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaseOfficerMappingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaseOfficerMappingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
