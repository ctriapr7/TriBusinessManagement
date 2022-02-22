/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaDb 
{
    private String dbName;
    private Object[][] data;
    private Connection dbConn;

    // this method is to get the date from the table
    public Object[][] getData(String tableName, String[] tableHeaders) {
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s= null;
        String dbQuery="SELECT * FROM " + tableName;
        ArrayList<ArrayList<String>> dataList = new ArrayList<>();
        
        try {
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while(rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for(int i =0; i <columnCount; i++) 
                {
                    row.add(rs.getString(tableHeaders[i]));
                }
                dataList.add(row);
            }
            this.data = new Object[dataList.size()][columnCount];
            for(int i =0; i<dataList.size(); i++) 
            {
                ArrayList<String> row ;
                row = dataList.get(i);
                for(int j =0; j< columnCount; j++) 
                {
                    this.data[i][j] = row.get(j);
                }
            }
            
        }
        catch(Exception e) {
            System.exit(0);
        }
        
        return this.data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }
    
    public JavaDb(String dbName) {
        this.dbName = dbName;
        setDbConn();
    }
    
    public JavaDb() {
        this.dbName = "";
        this.dbConn = null;
    }
    
    public String getDbName() {
        return dbName;
    }
        
    public void setDbName(String dbName) {
        this.dbName = dbName;
    } 

    public Connection getDbConn() {
        return this.dbConn;
    }

    //this method is to set the DB connection
    public void setDbConn() {
        String connectionURL = "jdbc:derby:" + this.dbName;
        
        this.dbConn = null;
        try 
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
        }
        catch (SQLException err)
        {
            System.err.println("SQL Connection error.");
            err.printStackTrace(System.err);
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            System.err.println("Class Not Found Error");
            Logger.getLogger(JavaDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeDbConn() {
        try {
            this.dbConn.close();
           
        }
        catch (Exception err) {
            System.err.println("DB closing error");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    }
    // this method is to create the database
    public void createDb(String newDbName) {
        this.dbName = newDbName;
        String connectionURL = "jdbc:derby:" + this.dbName + ";create=true";
        
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
            System.out.println("New database created");
            this.dbConn.close();
        }
        catch (Exception err) {
            System.err.println("DB creation error!");
            err.printStackTrace(System.err);
            System.exit(0);
        }
        
    }
    // this method is to create a new table
    public void createTable(String newTable, String dbName) {
        Statement s;
        setDbName(dbName);
        setDbConn();
        try {
            s = this.dbConn.createStatement();
            s.execute(newTable);
            System.out.println("New table created");
            this.dbConn.close();
        }
        catch (SQLException err) {
            System.out.println("Table creation error");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    }
}
