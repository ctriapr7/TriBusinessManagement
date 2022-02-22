/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

import java.util.ArrayList;

/* This class is used for executing setter and getter methods, and calculations
for Testing classes.
*/
public class businessComputation 
{
    //declaring variables
    private double fixedAssets;
    private String propertyString = "Property";
    private String machineryString = "Machinery";
    private String equipmentString = "Equipment";
    private String fixedAssetsString;
    private double currentAssets;
    private String cashString = "Cash";
    private String debtorString = "Debtor";
    private String stockString = "Stock";
    private String currentAssetsString;
    private double shortTermLiabilities;
    private String shortTermLoansString = "Short Term Loans";
    private String dividendsString = "Dividends";
    private String taxString = "Tax";
    private String tradeCreditorsString = "Trade Creditors";
    private String shortTermLiabilitiesString;
    private double longTermLiabilities;
    private String mortgageString = "Mortgage";
    private String debenturesString = "Debentures";
    private String bankLoansString = "Bank Loans";
    private String longTermLiabilitiesString;
    private ArrayList<Double> fixedAssetsList = new ArrayList<>();
    private ArrayList<Double> currentAssetsList = new ArrayList<>();
    private ArrayList<Double> shortTermLiabilitiesList = new ArrayList<>();
    private ArrayList<Double> longTermLiabilitiesList = new ArrayList<>();
    private ArrayList<Double> stocksList = new ArrayList<>();
    public double stocks;
    public double equity;
    public double currentRatio;
    public double acidTestRatio;
    public double cumulativeStocks=0;
    public double totalFixedAssets;
    public double totalCurrentAssets;
    public double totalShortTermLiabilities;
    public double totalLongTermLiabilities;
    
    //setters and getter method for Fixed Assets class
    public void setFixedAssets(double fixedAssets)
    {
        this.fixedAssets = fixedAssets;
    }
    
    public String getPropertyString()
    {
        return propertyString;
    }
    
    public String getMachineryString()
    {
        return machineryString;
    }
    
    public String getEquipmentString()
    {
        return equipmentString;
    }
    
    public void setFixedAssetsString(String fixedAssetsString)
    {
        this.fixedAssetsString = fixedAssetsString;
    }
    
    public String getFixedAssetsString()
    {
        return fixedAssetsString;
    }
    
    public double getFixedAssets()
    {
        return fixedAssets;
    }
    
    
    //setters and getter method for Current Assets class
    public void setCurrentAssets(double currentAssets)
    {
        this.currentAssets = currentAssets;
    }
   
    public String getCashString()
    {
        return cashString;
    }
    
    public String getDebtorString()
    {
        return debtorString;
    }
    
    public String getStockString()
    {
        return stockString;
    }
    
    public void setCurrentAssetsString(String currentAssetsString)
    {
        this.currentAssetsString = currentAssetsString;
    }
    
    public String getCurrentAssetsString()
    {
        return currentAssetsString;
    }
    
    public double getCurrentAssets()
    {
        return currentAssets;
    }
    
    //setters and getter method for Short Term Liabilities
     public void setShortTermLiabilities(double shortTermLiabilities)
    {
        this.shortTermLiabilities = shortTermLiabilities;
    }
   
    public String getShortTermLoansString()
    {
        return shortTermLoansString;
    }
    
    public String getTradeCreditorsString()
    {
        return tradeCreditorsString;
    }
    
    public String getTaxString()
    {
        return taxString;
    }
    
    public String getDividendsString()
    {
        return dividendsString;
    }
    public void setShortTermLiabilitiesString(String shortTermLiabilitiesString)
    {
        this.shortTermLiabilitiesString = shortTermLiabilitiesString;
    }
    
    public String getShortTermLiabilitiesString()
    {
        return shortTermLiabilitiesString;
    }
    
    public double getShortTermLiabilities()
    {
        return shortTermLiabilities;
    }
    
    //setters and getter method for long term liabilities
    public void setLongTermLiabilities(double longTermLiabilities)
    {
        this.longTermLiabilities = longTermLiabilities;
    }
   
    public String getBankLoansString()
    {
        return bankLoansString;
    }
    
    public String getDebenturesString()
    {
        return debenturesString;
    }
    
    public String getMortgageString()
    {
        return mortgageString;
    }
    

    public void setLongTermLiabilitiesString(String longTermLiabilitiesString)
    {
        this.longTermLiabilitiesString = longTermLiabilitiesString;
    }
    
    public String getLongTermLiabilitiesString()
    {
        return longTermLiabilitiesString;
    }
    
    public double getLongTermLiabilities()
    {
        return longTermLiabilities;
    }
    
    
    //Setters and getters for stocks 
    public void calculateCumulativeStocks(double stocks)
    {
        cumulativeStocks = cumulativeStocks + stocks;
    }
    
    public double getCumulativeStocks()
    {
        return cumulativeStocks;
    }
    
    public void setEquity(double equity)
    {
        this.equity = equity;
    }
            
    public void calculateEquity(double fixedAssets, double currentAssets, double shortTermLiabilities, double longTermLiabilities)
    {
        double result = fixedAssets + currentAssets - (shortTermLiabilities + longTermLiabilities);
        setEquity(result);
    }
    
    public double getEquity()
    {
        return equity;
    }
    
    //calculate and return Acid Test Ratio
    public void calculateCurrentRatio(double currentAssets, double shortTermLiabilities)
    {
        currentRatio = currentAssets/shortTermLiabilities;
    }
    
    public double getCurrentRatio()
    {
        return currentRatio;
    }
    
    public void calculateAcidTestRatio(double currentAssets, double stocks, double shortTermLiabilities)
    {
        acidTestRatio = (currentAssets - stocks)/shortTermLiabilities;
    }
    
    public double getAcidTestRatio()
    {
        return acidTestRatio;
    }
    
    //fixed Assets database
    public void addFixedAssets(double fixedAssetsValue)
    {
        fixedAssetsList.add(fixedAssetsValue);
    }
    
    public double getTotalFixedAssetsList()
    {
        double totalFixedAssets=0;
        Double[] fixedAssetsArray = fixedAssetsList.toArray(new Double[fixedAssetsList.size()]);
        System.out.println(fixedAssetsList);
            for (int m=0; m< fixedAssetsArray.length; m++)
            {
                    totalFixedAssets = totalFixedAssets + fixedAssetsArray[m];
            }
        return totalFixedAssets;
    }
    
    public void addCurrentAssets(double currentAssetsValue)
    {
        currentAssetsList.add(currentAssetsValue);
    }
    
    public double getTotalCurrentAssetsList()
    {
        double totalCurrentAssets=0;
        Double[] currentAssetsArray = currentAssetsList.toArray(new Double[currentAssetsList.size()]);
        for (int m=0; m< currentAssetsArray.length; m++)
        {
            totalCurrentAssets = totalCurrentAssets + currentAssetsArray[m];
        }
        return totalCurrentAssets;
    }
    
    public void addShortTermLiabilities(double shortTermLiabilitiesValue)
    {
        shortTermLiabilitiesList.add(shortTermLiabilitiesValue);
    }
    
    public double getTotalShortTermLiabilitiesList()
    {
        double totalShortTermLiabilities=0;
        Double[] shortTermLiabilitiesArray = shortTermLiabilitiesList.toArray(new Double[shortTermLiabilitiesList.size()]);
            for (int m=0; m< shortTermLiabilitiesArray.length; m++)
            {
                    totalShortTermLiabilities = totalShortTermLiabilities + shortTermLiabilitiesArray[m];
            }
        return totalShortTermLiabilities;
    }
    
    public void addLongTermLiabilities(double longTermLiabilitiesValue)
    {
        longTermLiabilitiesList.add(longTermLiabilitiesValue);
    }
    
    public double getTotalLongTermLiabilitiesList()
    {
        double totalLongTermLiabilities=0;
        Double[] longTermLiabilitiesArray = longTermLiabilitiesList.toArray(new Double[longTermLiabilitiesList.size()]);
            for (int m=0; m< longTermLiabilitiesArray.length; m++)
            {
                    totalLongTermLiabilities = totalLongTermLiabilities + longTermLiabilitiesArray[m];
            }
        return totalLongTermLiabilities;
    }
    
    public void addStocks(double stocksValue)
    {
        stocksList.add(stocksValue);
    }
    
    public double getTotalStocksList()
    {
        double totalStocks=0;
        Double[] stocksArray = stocksList.toArray(new Double[stocksList.size()]);
            for (int m=0; m< stocksArray.length; m++)
            {
                    totalStocks = totalStocks + stocksArray[m];
            }
        return totalStocks;
    }
    
    public void setTotalFixedAssets(double totalFixedAssets)
    {
        this.totalFixedAssets = totalFixedAssets;
    }
    
    public void setTotalCurrentAssets(double totalCurrentAssets)
    {
        this.totalCurrentAssets = totalCurrentAssets;
    }
    
    public void setTotalShortTermLiabilities(double totalShortTermLiabilities)
    {
        this.totalShortTermLiabilities = totalShortTermLiabilities;
    }
    
    public void setTotalLongTermLiabilities(double totalLongTermLiabilities)
    {
        this.totalLongTermLiabilities = totalLongTermLiabilities;
    }
    
    
        public double getTotalFixedAssets()
    {
        return totalFixedAssets;
    }
        
        public double getTotalCurrentAssets()
    {
        return totalCurrentAssets;
    }
        
         public double getTotalShortTermLiabilities()
    {
        return totalShortTermLiabilities;
    }
         
        public double getTotalLongTermLiabilities()
    {
        return totalLongTermLiabilities;
    }
        
        
}
