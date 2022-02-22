/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

import java.sql.Connection;
import java.sql.PreparedStatement;

/* this method is used for inserting the data that were typed by the Client
to the Database and display the Database to Frames
*/
public class DbFunction 
{
    //Fixed Assets : retrieving data from the Input class
     public void insertFixedAssets(double fixedAssetsValue, String typeOfFixedAssets) 
     {
        Connection myDbConn;
        String dbQuery;
        int status;
        
        JavaDb dbObj2 = new JavaDb("BusinessManagement");
        myDbConn = dbObj2.getDbConn();
        
        dbQuery = "INSERT INTO FixedAssetsTable VALUES (?,?)";
        
        try{
            
            PreparedStatement s = myDbConn.prepareStatement(dbQuery);
            s.setDouble(1,fixedAssetsValue);
            s.setString(2,typeOfFixedAssets);
            status = s.executeUpdate();
        }
        catch (Exception e) 
        {
            errorFrame err1 = new errorFrame("Inserting into Database Error");
        }  
    }
     
     //Fixed Assets : the method to display the JTable (database) to the Frame
     public Object[][] displayFixedAssets(String tableName) 
     {
        Connection myDbConn;
        String[] columnNames = {"fixedAssetsValue", "typeOfFixedAssets"};
        Object[][] data = null;
        String dbQuery;
        int status;
        
        JavaDb dbObj = new JavaDb("BusinessManagement");
        myDbConn = dbObj.getDbConn();
            
        data = dbObj.getData(tableName, columnNames);
        return data;
    }
     
    //Current Assets : retrieving data from the Input class
     public void insertCurrentAssets(double currentAssetsValue, String typeOfCurrentAssets) 
     {
        Connection myDbConn;
        String dbQuery;
        int status;
        
        JavaDb dbObj3 = new JavaDb("BusinessManagement");
        myDbConn = dbObj3.getDbConn();
        
        dbQuery = "INSERT INTO CurrentAssetsTable VALUES (?,?)";
        
        try{
            
            PreparedStatement s = myDbConn.prepareStatement(dbQuery);
            s.setDouble(1,currentAssetsValue);
            s.setString(2,typeOfCurrentAssets);
            status = s.executeUpdate();
        }
        catch (Exception e) 
        {
            errorFrame err1 = new errorFrame("Inserting into Database Error");
        }  
    }
     
     //Current   Assets : the method to display the JTable (database) to the Frame
     public Object[][] displayCurrentAssets(String tableName) 
     {
        Connection myDbConn;
        String[] columnNames = {"currentAssetsValue", "typeOfCurrentAssets"};
        Object[][] data = null;
        String dbQuery;
        int status;
        
        JavaDb dbObj = new JavaDb("BusinessManagement");
        myDbConn = dbObj.getDbConn();
            
        data = dbObj.getData(tableName, columnNames);
        return data;
    }
     
     //Short Term Liabilities Assets : retrieving data from the Input class
     public void insertShortTermLiabilities(double shortTermLiabilitiesValue, String typeOfShortTermLiabilities) 
     {
        Connection myDbConn;
        String dbQuery;
        int status;
        
        JavaDb dbObj3 = new JavaDb("BusinessManagement");
        myDbConn = dbObj3.getDbConn();
        
        dbQuery = "INSERT INTO ShortTermLiabilitiesTable VALUES (?,?)";
        
        try{
            
            PreparedStatement s = myDbConn.prepareStatement(dbQuery);
            s.setDouble(1,shortTermLiabilitiesValue);
            s.setString(2,typeOfShortTermLiabilities);
            status = s.executeUpdate();
        }
        catch (Exception e) 
        {
            errorFrame err1 = new errorFrame("Inserting into Database Error");
        }  
    }
     
     //Short term Liabilities : the method to display the JTable (database) to the Frame
     public Object[][] displayShortTermLiabilities(String tableName) 
     {
        Connection myDbConn;
        String[] columnNames = {"shortTermLiabilitiesValue", "typeOfShortTermLiabilities"};
        Object[][] data = null;
        String dbQuery;
        int status;
        
        JavaDb dbObj = new JavaDb("BusinessManagement");
        myDbConn = dbObj.getDbConn();
            
        data = dbObj.getData(tableName, columnNames);
        return data;
    }
     
     //Long term liabilities : retrieving data from the Input class
     public void insertLongTermLiabilities(double longTermLiabilitiesValue, String typeOfLongTermLiabilities) 
     {
        Connection myDbConn;
        String dbQuery;
        int status;
        
        JavaDb dbObj3 = new JavaDb("BusinessManagement");
        myDbConn = dbObj3.getDbConn();
        
        dbQuery = "INSERT INTO LongTermLiabilitiesTable VALUES (?,?)";
        
        try{
            
            PreparedStatement s = myDbConn.prepareStatement(dbQuery);
            s.setDouble(1,longTermLiabilitiesValue);
            s.setString(2,typeOfLongTermLiabilities);
            status = s.executeUpdate();
        }
        catch (Exception e) 
        {
            errorFrame err1 = new errorFrame("Inserting into Database Error");
        }  
    }
     
     //Balance Sheet : the method to display the JTable (database) to the Frame
     public Object[][] displayLongTermLiabilities(String tableName) 
     {
        Connection myDbConn;
        String[] columnNames = {"longTermLiabilitiesValue", "typeOfLongTermLiabilities"};
        Object[][] data = null;
        String dbQuery;
        int status;
        
        JavaDb dbObj = new JavaDb("BusinessManagement");
        myDbConn = dbObj.getDbConn();
            
        data = dbObj.getData(tableName, columnNames);
        return data;
    }
     
     //Balance Sheet : retrieving data from the Input class
     public void insertBalanceSheet(double fixedAssetsValue, double currentAssetsValue, double shortTermLiabilitiesValue, double longTermLiabilitiesValue, double equityValue) 
     {
        Connection myDbConn;
        String dbQuery;
        int status;
        
        JavaDb dbObj4 = new JavaDb("BusinessManagement");
        myDbConn = dbObj4.getDbConn();
        
        dbQuery = "INSERT INTO BalanceSheetTable VALUES (?,?,?,?,?)";
        
        try{
            
            PreparedStatement s = myDbConn.prepareStatement(dbQuery);
            s.setDouble(1,fixedAssetsValue);
            s.setDouble(2,currentAssetsValue);
            s.setDouble(3,shortTermLiabilitiesValue);
            s.setDouble(4,longTermLiabilitiesValue);
            s.setDouble(5,equityValue);
            status = s.executeUpdate();
        }
        catch (Exception e) 
        {
            errorFrame err1 = new errorFrame("Inserting into Database Error");
        }  
    }
     
     //Long term liabilities : the method to display the JTable (database) to the Frame
     public Object[][] displayBalanceSheet(String tableName) 
     {
        Connection myDbConn;
        String[] columnNames = {"fixedAssetsValue", "currentAssetsValue", "shortTermLiabilitiesValue","longTermLiabilitiesValue", "equityValue"};
     
        Object[][] data = null;
        String dbQuery;
        int status;
        
        JavaDb dbObj = new JavaDb("BusinessManagement");
        myDbConn = dbObj.getDbConn();
            
        data = dbObj.getData(tableName, columnNames);
        return data;
    }
}
