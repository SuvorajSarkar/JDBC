import java.sql.Statement;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class EmployDatabase {
    public static void createTable(Connection con)throws SQLException{
        String createtableQuery="create table employinfo(employid int,empName varchar(255),empPost varchar(255),employSalary int)";
        //statement
        Statement state=con.createStatement();
        state.execute(createtableQuery);
    }

    public static void insertrecords(Connection con)throws SQLException{
        String insertrecordQuery="INSERT INTO employinfo(employid,empName,empPost,employSalary) VALUES"+
        "(101,'suvo','manager',50000),"+
        "(102,'raj','software devloper',30000),"+
        "(103,'sarkar','engineer',31000),"+
        "(104,'raja','frontend devloper',32000),"+
        "(105,'diya','ui ux',35000)"
        ;
        Statement state=con.createStatement();
        state.execute(insertrecordQuery);
    }
    
    public static void updateRecords(Connection con) throws SQLException{
        String updaterecordquery="UPDATE employinfo SET employSalary = 40000 WHERE employid=103";
        Statement state=con.createStatement();
        state.executeUpdate(updaterecordquery);
    }
    public static void selectRecord(Connection con) throws SQLException{
        String selectQuery="SELECT * FROM employinfo";
        Statement state=con.createStatement();
        ResultSet res=state.executeQuery(selectQuery);
        while(res.next()){
            //process and print the retrive data
            while(res.next()){
                //fetch all the data
                int employid=res.getInt("employid");
               String empName= res.getString("empName");
               String empPost=res.getString("empPost");
               int employSalary=res.getInt("employSalary");

               //display the data
               System.out.println("employid: " + employid);
               System.out.println("employname: "+empName);
               System.out.println("employ post: "+empPost);
               System.out.println("employSalary: "+employSalary);
            }
        }
    }
    public static void DeleteRecord(Connection con) throws SQLException{
        String deleterecordsquery="delete from employinfo where empName='suvo'";
        Statement state=con.createStatement();
       int count= state.executeUpdate(deleterecordsquery);
       System.out.println(count +" records deleted successfully") ;

    }

    public static boolean tableExists(Connection con, String TableName)throws SQLException {
        DatabaseMetaData meta=(DatabaseMetaData)con.getMetaData();//metadata mane root directories er kotha bola hoche 
        ResultSet tables=meta.getTables(null, null, TableName, null);
        
        return tables.next();
    }
}
