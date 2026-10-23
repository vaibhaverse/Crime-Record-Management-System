package crms;

import ConnectionProvider.DatabaseConnector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCrimeForm extends javax.swing.JFrame {
    
    private JTable crimeTable;
    private JTextField searchField;
    private JButton searchButton, backButton, refreshButton;
    private DefaultTableModel tableModel;
    private JButton editButton;
    private JButton deleteButton;


    
    public ViewCrimeForm() {
        initComponents();
        setTitle("View Crime Records");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        refreshButton = new JButton("Refresh");
        backButton = new JButton("Back");
        editButton = new JButton("Edit Crime");
        deleteButton = new JButton("Delete Crime");
        
        searchPanel.add(deleteButton);
        searchPanel.add(editButton);
        searchPanel.add(new JLabel("Search (Case Number):"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);
        searchPanel.add(backButton);
        add(searchPanel, BorderLayout.NORTH);

        // Table Model
        tableModel = new DefaultTableModel();
        crimeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(crimeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Define Table Columns
        tableModel.addColumn("Crime ID");
        tableModel.addColumn("Case Number");
        tableModel.addColumn("Crime Type");
        tableModel.addColumn("Description");
        tableModel.addColumn("Crime Date");
        tableModel.addColumn("Location");
        tableModel.addColumn("Status");

        loadCrimeRecords();

        // Action Listeners
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCrime();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadCrimeRecords();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainFrame();
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        int selectedRow = crimeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ViewCrimeForm.this, "Select a crime to edit.");
            return;
        }
        
        // Get selected crime data
        int crimeId = (int) crimeTable.getValueAt(selectedRow, 0);
        String caseNumber = (String) crimeTable.getValueAt(selectedRow, 1);
        String crimeType = (String) crimeTable.getValueAt(selectedRow, 2);
        String description = (String) crimeTable.getValueAt(selectedRow, 3);
        String crimeDate = crimeTable.getValueAt(selectedRow, 4).toString();
        String location = (String) crimeTable.getValueAt(selectedRow, 5);
        String status = (String) crimeTable.getValueAt(selectedRow, 6);

        // Open Update Form
        new UpdateCrimeForm(crimeId, caseNumber, crimeType, description, crimeDate, location, status);
        dispose();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        int selectedRow = crimeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ViewCrimeForm.this, "Select a crime to delete.");
            return;
        }

        // Get selected crime_id
        int crimeId = (int) crimeTable.getValueAt(selectedRow, 0);

        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(ViewCrimeForm.this,
                "Are you sure you want to delete this record?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            deleteCrime(crimeId);
        }
            }
        });


        setVisible(true);
    }

    // Load All Crime Records
    private void loadCrimeRecords() {
        tableModel.setRowCount(0); // Clear table
        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM crimes")) {

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("crime_id"),
                        rs.getString("case_number"),
                        rs.getString("crime_type"),
                        rs.getString("description"),
                        rs.getDate("crime_date"),
                        rs.getString("location"),
                        rs.getString("status")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading records: " + e.getMessage());
        }
    }
    
    // Search Crime by Case Number
    private void searchCrime() {
        String caseNumber = searchField.getText().trim();
        if (caseNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a case number to search!");
            return;
        }

        tableModel.setRowCount(0);
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM crimes WHERE case_number LIKE ?")) {
            pstmt.setString(1, "%" + caseNumber + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("crime_id"),
                        rs.getString("case_number"),
                        rs.getString("crime_type"),
                        rs.getString("description"),
                        rs.getDate("crime_date"),
                        rs.getString("location"),
                        rs.getString("status")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching records: " + e.getMessage());
        }
    }
    
    // Method to delete a crime record
    private void deleteCrime(int crimeId) {
        try (Connection conn = DatabaseConnector.connect();
         PreparedStatement pstmt = conn.prepareStatement("DELETE FROM crimes WHERE crime_id = ?")) {
        
        pstmt.setInt(1, crimeId);
        int rowsDeleted = pstmt.executeUpdate();
        
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Crime record deleted successfully.");
            loadCrimeData(); // Refresh table
        } else {
            JOptionPane.showMessageDialog(this, "Deletion failed. Record not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error deleting record: " + e.getMessage());
        }
    }
    
    // Method to load crime data into the table
    private void loadCrimeData() {
    try (Connection conn = DatabaseConnector.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM crimes")) {

        DefaultTableModel model = (DefaultTableModel) crimeTable.getModel();
        model.setRowCount(0); // Clear existing data

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("crime_id"),
                rs.getString("case_number"),
                rs.getString("crime_type"),
                rs.getString("description"),
                rs.getDate("crime_date"),
                rs.getString("location"),
                rs.getString("status")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }


    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1452, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ViewCrimeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCrimeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCrimeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCrimeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCrimeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
