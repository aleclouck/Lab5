/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connecttobooks;

/**
 *
 * @author alexander.louck418
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class ConnectToDBTest {
    public static void main(String[] args) {
    try{
        String host = "jdbc:derby://localhost:1527/DBTests";
        String dbName = "student";
        String dbPass = "student";
        Connection conn = DriverManager.getConnection( host, dbName, dbPass );
        Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM STUDENT.Test1";
        ResultSet Rset = state.executeQuery( SQL );
        System.out.println("ID"+" "+"Question");
        while(Rset.next( )){
            int Id = Rset.getInt("ID");
            String sName = Rset.getString("Question");
            System.out.println(Id+" "+sName);
        }
        System.out.println("Test2:");
        SQL = "SELECT * FROM STUDENT.Test2";
        Rset = state.executeQuery( SQL );
        while(Rset.next( )){
            int Id = Rset.getInt("ID");
            String sName = Rset.getString("Question");
            System.out.println(Id+" "+sName);
        }
    }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
    }
}
