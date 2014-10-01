/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_connect;

/**
 *
 * @author alexander.louck418
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class DB_Connect 
{
    public static void main(String[] args) 
    {
        try
        {
            String host = "jdbc:derby://localhost:1527/Books";
            String uName = "student";
            String uPass = "student";
            Connection conn = DriverManager.getConnection( host, uName, uPass );
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM STUDENT.AUTHORS";
            ResultSet Rset = state.executeQuery( SQL );
            System.out.println("ID"+" "+"Author_Name");
            while(Rset.next( ))
            {
                int Id = Rset.getInt("ID");
                String sName = Rset.getString("Author_Name");
                System.out.println(Id+" "+sName);
            }
        }
        catch ( SQLException err ) 
        {
            System.out.println( err.getMessage( ) );
        }
    }
}