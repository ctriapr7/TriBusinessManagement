/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;
/* this class is used for inserting data that is related to Short Term Liabilities, 
storing it into a separate database in order to collect data for Balance Sheet
calculation.
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ShortTermLiabilitiesInput extends JFrame implements ActionListener
{
    //formulating the Frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business image.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JRadioButton shortTermLoansButton;
    private JRadioButton tradeCreditorsButton;
    private JRadioButton taxButton;
    private JRadioButton dividendsButton;
    ButtonGroup shortTermLiabilitiesButtonGroup;
    private JLabel valueLabel;
    private JTextField valueTextField;
    private JButton storeButton;
    private JButton showBalanceSheetButton;
    private JButton backButton;
    private JPanel insertPanel;
    private JPanel buttonPanel;
    private JPanel storePanel;
    private JScrollPane myScrollPanel = new JScrollPane();
    JTable ShortTermLiabilitiesTable = new JTable();
    
    public ShortTermLiabilitiesInput()
    {
        super("Short Term Liabilities input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //add Radio buttons that only allow the Client to choose one of them
        shortTermLoansButton = new JRadioButton("Short Term Loans");
        tradeCreditorsButton = new JRadioButton("Trade Creditors");
        taxButton = new JRadioButton("Tax");
        dividendsButton = new JRadioButton("Dividends");
        
        //initialize Store button
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //add Button group together
        shortTermLiabilitiesButtonGroup = new ButtonGroup();
        shortTermLiabilitiesButtonGroup.add(shortTermLoansButton);
        shortTermLiabilitiesButtonGroup.add(tradeCreditorsButton);
        shortTermLiabilitiesButtonGroup.add(taxButton);
        shortTermLiabilitiesButtonGroup.add(dividendsButton);
        
        //add button to the frame
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(shortTermLoansButton);
        buttonPanel.add(tradeCreditorsButton);
        buttonPanel.add(taxButton);
        buttonPanel.add(dividendsButton);
        buttonPanel.setBackground(new Color(235,208,208));
        
        //add value label and textfield
        valueLabel = new JLabel("Value");
        valueTextField = new JTextField(20);
        
        //add image
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        insertPanel = new JPanel(new FlowLayout());
        insertPanel.add(valueLabel);
        insertPanel.add(valueTextField);
        insertPanel.add(imageLabel);
        insertPanel.setBackground(new Color(235,208,208));
        
        //additional buttons
        showBalanceSheetButton = new JButton("Show balance sheet");
        showBalanceSheetButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //intiialize the third panel to contain additional buttons
        storePanel = new JPanel(new FlowLayout());
        storePanel.add(backButton);
        storePanel.add(storeButton);
        storePanel.add(showBalanceSheetButton);
        
        
        
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(insertPanel, BorderLayout.CENTER);
        this.add(storePanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //if the Client presses Store button
        if (command.equals("Store"))
        {
             try
            {
                //set the value of short term liabilities
                double shortTermLiabilitiesValue = Double.parseDouble(valueTextField.getText());
                businessComputation newObject = new businessComputation();
                
                //get the value of Short term liabilities
                newObject.setShortTermLiabilities(shortTermLiabilitiesValue);
                
                //trade creditors will be saved as a type of short term liabilities
                if (tradeCreditorsButton.isSelected())
                {
                    newObject.setShortTermLiabilitiesString(newObject.getTradeCreditorsString());
                    newObject.calculateCumulativeShortTermLiabilities(shortTermLiabilitiesValue);
                }
                 //tax will be saved as a type of short term liabilities
                else if (taxButton.isSelected())
                {
                    newObject.setShortTermLiabilitiesString(newObject.getTaxString());
                    newObject.calculateCumulativeShortTermLiabilities(shortTermLiabilitiesValue);
                }
                 //Short term loans will be saved as a type of short term liabilities
                else if (shortTermLoansButton.isSelected())
                {
                    newObject.setShortTermLiabilitiesString(newObject.getShortTermLoansString());
                    newObject.calculateCumulativeShortTermLiabilities(shortTermLiabilitiesValue);
                }
                 //dividends will be saved as a type of short term liabilities
                else if (dividendsButton.isSelected())
                {
                    newObject.setShortTermLiabilitiesString(newObject.getDividendsString());
                    newObject.calculateCumulativeShortTermLiabilities(shortTermLiabilitiesValue);
                }
                
                DbFunction myObj = new DbFunction();
                
                //insert type of data and its value into the database
                myObj.insertShortTermLiabilities(newObject.getShortTermLiabilities(), newObject.getShortTermLiabilitiesString());
                
                ShortTermLiabilitiesOutput shortTermLiabilitiesObject = new ShortTermLiabilitiesOutput(newObject);
            }   
             //exception handling
            catch (NumberFormatException nfe)
            {
                errorFrame err= new errorFrame("Please enter a number!");
            }
            catch (Exception exceptionObj)
            {
                System.out.println("You did something wrong");
            }
        }
        //if the Client presses Back button
        else if (command.equals("Back"))
        {
            this.dispose();
        }
        //if the Client presses Show balance sheet button
        else if (command.equals("Show balance sheet"))
        {
            System.out.println("Button to show balance sheet");
        }
      
    }
    
    //main method
    public static void main(String[] args)
    {
        ShortTermLiabilitiesInput shortTermLiabilitiesObject = new ShortTermLiabilitiesInput();
    }    
}

