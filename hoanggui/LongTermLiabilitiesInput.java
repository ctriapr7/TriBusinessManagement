/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;


/* this class is used for inserting data that is related to Long Term Liabilities, 
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
import java.util.ArrayList;
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class LongTermLiabilitiesInput extends JFrame implements ActionListener
{
    //formulating the frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business image.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JRadioButton mortgageButton;
    private JRadioButton debenturesButton;
    private JRadioButton bankLoansButton;
    ButtonGroup longTermLiabilitiesButtonGroup;
    private JLabel valueLabel;
    private JTextField valueTextField;
    private JButton storeButton;
    private JButton showBalanceSheetButton;
    private JButton backButton;
    private JPanel insertPanel;
    private JPanel buttonPanel;
    private JPanel storePanel;
    private JScrollPane myScrollPanel = new JScrollPane();
    JTable LongTermLiabilitiesTable = new JTable();
    
    public LongTermLiabilitiesInput()
    {
        super("Fixed Assets input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //add Radio buttons that only allows the Client to choose one of them.
        mortgageButton = new JRadioButton("Mortgage");
        debenturesButton = new JRadioButton("Debentures");
        bankLoansButton = new JRadioButton("Bank Loans");
        
        //initialize Store button
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //add Radio buttons together
        longTermLiabilitiesButtonGroup = new ButtonGroup();
        longTermLiabilitiesButtonGroup.add(mortgageButton);
        longTermLiabilitiesButtonGroup.add(debenturesButton);
        longTermLiabilitiesButtonGroup.add(bankLoansButton);
        
        //add buttons
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(mortgageButton);
        buttonPanel.add(debenturesButton);
        buttonPanel.add(bankLoansButton);
        buttonPanel.setBackground(new Color(235,208,208));
        
        //add value text field
        valueLabel = new JLabel("Value");
        valueTextField = new JTextField(20);
        
        //add image
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        //initialize panel that contains value label and textfield and image
        insertPanel = new JPanel(new FlowLayout());
        insertPanel.add(valueLabel);
        insertPanel.add(valueTextField);
        insertPanel.add(imageLabel);
        insertPanel.setBackground(new Color(235,208,208));
        
        //initialize additional buttons
        showBalanceSheetButton = new JButton("Show balance sheet");
        showBalanceSheetButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //initialize second panel to contain additional buttons
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
         double totalLongTermLiabilities=0;
       ArrayList<Double> longTermLiabilitiesList = new ArrayList<>();
        String command = e.getActionCommand();
        //if the Client presses Store button
        if (command.equals("Store"))
        {
            try
            {
                //set the value of Long term liabilities
                double longTermLiabilitiesValue = Double.parseDouble(valueTextField.getText());
                
                //"call out" the object of computation class
                businessComputation newObject = new businessComputation();
                
                //get the value of long term liabilities
                newObject.setLongTermLiabilities(longTermLiabilitiesValue);
                
                //Debentures will be saved to the database as the type of long term liabilities
                if (debenturesButton.isSelected())
                {
                    newObject.setLongTermLiabilitiesString(newObject.getDebenturesString());
                    newObject.calculateCumulativeLongTermLiabilities(longTermLiabilitiesValue);
                }
                //Mortgage will be saved to the database as the type of long term liabilities
                else if (mortgageButton.isSelected())
                {
                    newObject.setLongTermLiabilitiesString(newObject.getMortgageString());
                    newObject.calculateCumulativeLongTermLiabilities(longTermLiabilitiesValue);
                }
                //Bank loans will be saved to the database as the type of long term liabilities
                else if (bankLoansButton.isSelected())
                {
                    newObject.setLongTermLiabilitiesString(newObject.getBankLoansString());
                    newObject.calculateCumulativeLongTermLiabilities(longTermLiabilitiesValue);
                }
                DbFunction myObj = new DbFunction();
                
                //insert the type of short term liabilities and its value to database
                myObj.insertLongTermLiabilities(newObject.getLongTermLiabilities(), newObject.getLongTermLiabilitiesString());
                
                //navigate the Client to the output frame
                LongTermLiabilitiesOutput longTermLiabilitiesOutputObject = new LongTermLiabilitiesOutput(newObject);
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
        LongTermLiabilitiesInput LongTermLiabilitiesObject = new LongTermLiabilitiesInput();
    }    
}

