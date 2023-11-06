import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        Connection con = null;
        try {
            // get the connection
            con = JDBCUtil.getConnection();

            // create the table
            if (!EmployDatabase.tableExists(con, "employInfo")) {
                EmployDatabase.createTable(con);
                System.out.println("Table employ info create succesfully");
            } else {
                System.out.println("Table empData already exists");
            }

            /*
             * //insert records
             * EmployDatabase.insertRecords(con);
             * System.out.println("records inserted succesfully");
             * 
             * //UPDATE RECORDS
             * EmployDatabase.updateRecords(con);
             * System.out.println("records update succesfully");
             * 
             * //SELECT RECORDS(read)
             * EmployDatabase.selectRecord(con);
             * 
             * //Delete records
             * EmployDatabase.DeleteRecord(con);
             */
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
