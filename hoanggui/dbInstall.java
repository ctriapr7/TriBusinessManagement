/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/*this class is used for installing database to Java
*/

public class dbInstall
{
    public static void main(String[] args) {
        // TODO code application logic here
        
        //intializing Tables
        String fixedAssetsTable;
        String currentAssetsTable;
        String shortTermLiabilitiesTable;
        String longTermLiabilitiesTable;
        String balanceSheetTable;
        
        
        JavaDb objDb = new JavaDb();
        // create new database
        objDb.createDb("BusinessManagement");

        //define new table, you can create multiple tables
        fixedAssetsTable = "CREATE TABLE FixedAssetsTable ( " + 
                        "fixedAssetsValue double, " +
                        "typeOfFixedAssets varchar(30)  "  +    
                        ")";
        currentAssetsTable = "CREATE TABLE CurrentAssetsTable ( " + 
                        "currentAssetsValue double, " +
                        "typeOfCurrentAssets varchar(30)  "  +    
                        ")";
        shortTermLiabilitiesTable = "CREATE TABLE ShortTermLiabilitiesTable ( " + 
                        "shortTermLiabilitiesValue double, " +
                        "typeOfShortTermLiabilities varchar(30)  "  +    
                        ")";
        longTermLiabilitiesTable = "CREATE TABLE LongTermLiabilitiesTable ( " + 
                        "longTermLiabilitiesValue double, " +
                        "typeOfLongTermLiabilities varchar(30)  "  +    
                        ")";
        balanceSheetTable = "CREATE TABLE BalanceSheetTable ( " + 
                        "fixedAssetsValue double, " +
                        "currentAssetsValue double,  "  + 
                        "shortTermLiabilitiesValue double , "+
                        "longTermLiabilitiesValue double , "+
                        "equityValue double "+  
                        ")";
        
        
        // create tables
        objDb.createTable(fixedAssetsTable, "BusinessManagement");
        objDb.createTable(currentAssetsTable, "BusinessManagement");
        objDb.createTable(shortTermLiabilitiesTable, "BusinessManagement");
        objDb.createTable(longTermLiabilitiesTable, "BusinessManagement");
        objDb.createTable(balanceSheetTable, "BusinessManagement");
               
    
    }
}
