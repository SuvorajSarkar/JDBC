import java.sql.Statement;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class EmployDatabase {
    public static void createTable(Connection con)throws SQLException{
        String createtable="create table employInfo(employid int,empName varchar(255),empPost varchar(255),employSalary int)";
        //statement
        Statement state=con.createStatement();
        state.execute(createtable);
    }

    public static boolean tableExists(Connection con, String TableName)throws SQLException {
        DatabaseMetaData meta=(DatabaseMetaData)con.getMetaData();//metadata mane root directories er kotha bola hoche 
        ResultSet tables=meta.getTables(null, null, TableName, null);
        
        return tables.next();
    }
}
