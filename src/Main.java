import interbase.interclient.DataSource;
import interbase.interclient.Driver;
import interbase.interclient.Connection;
import interbase.interclient.Statement;

import java.sql.ConnectionBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Connecting to Interbase");

        java.util.Properties properties = new java.util.Properties();
        properties.put ("user", "sysdba");
        properties.put ("password", "masterkey");

        try {
            //Create the InterClient driver object explicitly
            java.sql.Driver driver = new interbase.interclient.Driver();
            //Open a database connection using the driver's connect method of the
            java.sql.Connection connection = driver.connect("jdbc:interbase://gds_db/C:/data/testdb1.ib", properties);
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery ("select empno, empname from employee where empno='123'");
            while (rs.next ()) {
//get the values for the current row
                String empno = rs.getString(1);
                String empname = rs.getString(2);

                System.out.print("\n");
                System.out.println("Employee Number: " + empno);
                System.out.println("Employee Name: " + empname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}