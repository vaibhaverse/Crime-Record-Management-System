package crms;
import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private int columnCount;
    private Object[][] data;

    public ResultSetTableModel(ResultSet rs) throws SQLException {
        this.rs = rs;
        rsmd = rs.getMetaData();
        columnCount = rsmd.getColumnCount();
        loadData();
    }

    private void loadData() throws SQLException {
        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        data = new Object[rowCount][columnCount];
        int row = 0;

        while (rs.next()) {
            for (int col = 0; col < columnCount; col++) {
                data[row][col] = rs.getObject(col + 1);
            }
            row++;
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
}
