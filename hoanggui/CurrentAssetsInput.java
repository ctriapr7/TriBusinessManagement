/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/*this class is used for inserting data that is related to Current Assets, and storing
it into a separate database.
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


public class CurrentAssetsInput extends JFrame implements ActionListener
{
    //formulate the Frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business image.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JRadioButton cashButton;
    private JRadioButton debtorButton;
    private JRadioButton stockButton;
    ButtonGroup currentAssetsButtonGroup;
    private JLabel valueLabel;
    private JTextField valueTextField;
    private JButton storeButton;
    private JButton showBalanceSheetButton;
    private JButton backButton;
    private JPanel insertPanel;
    private JPanel buttonPanel;
    private JPanel storePanel;
    private JLabel imageLabel;
    private JScrollPane myScrollPanel = new JScrollPane();
    JTable CurrentAssetsTable = new JTable();
    
    public CurrentAssetsInput()
    {
        super("Current Assets input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //initialize buttons and add buttons together
        cashButton = new JRadioButton("Cash");
        debtorButton = new JRadioButton("Debtor");
        stockButton = new JRadioButton("Stock");
        
        //initialize Store button
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //initialize button group to attach Radio buttons together
        currentAssetsButtonGroup = new ButtonGroup();
        currentAssetsButtonGroup.add(cashButton);
        currentAssetsButtonGroup.add(debtorButton);
        currentAssetsButtonGroup.add(stockButton);
        
        //add image 
        imageLabel = new JLabel(MY_IMAGE);
        
        //Initialize panel to add buttons
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(cashButton);
        buttonPanel.add(debtorButton);
        buttonPanel.add(stockButton);
        buttonPanel.setBackground(new Color(235,208,208));
        
        //add value label and text field 
        valueLabel = new JLabel("Value");
        valueTextField = new JTextField(20);
        
        //initialize panel to add value label and textfield and image together
        insertPanel = new JPanel(new FlowLayout());
        insertPanel.add(valueLabel);
        insertPanel.add(valueTextField);
        insertPanel.add(imageLabel);
        insertPanel.setBackground(new Color(235,208,208));
        
        //add second button group
        showBalanceSheetButton = new JButton("Show balance sheet");
        showBalanceSheetButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        
        //add Store button
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //initialize second panel to add buttons together
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
        
        // if the Client presses Store button
        if (command.equals("Store"))
        {
            try
            {
                //set the value inserted by the Client
                double currentAssetsValue = Double.parseDouble(valueTextField.getText());
                //"call out" the Object of the computation class for set and get methods
                businessComputation newObject = new businessComputation();
                //get the value inserted by the Client
                newObject.setCurrentAssets(currentAssetsValue);
                
                //the scenario in which the Client presses the Cash button
                if (cashButton.isSelected())
                {
                    newObject.setCurrentAssetsString(newObject.getCashString());
                    newObject.calculateCumulativeCurrentAssets(currentAssetsValue);
                }
                //the scenario in which the Client presses the Debtor button
                else if (debtorButton.isSelected())
                {
                    newObject.setCurrentAssetsString(newObject.getDebtorString());
                    newObject.calculateCumulativeCurrentAssets(currentAssetsValue);
                }
                //the scenario in which the Client presses the Stock button
                else if (stockButton.isSelected())
                {
                    newObject.setCurrentAssetsString(newObject.getStockString());
                    newObject.calculateCumulativeCurrentAssets(Double.parseDouble(valueTextField.getText()));
                    newObject.calculateCumulativeStocks(currentAssetsValue);
                }
                DbFunction myObj = new DbFunction();
                
                //insert the Type of Current Assets and its value into database
                myObj.insertCurrentAssets(newObject.getCurrentAssets(), newObject.getCurrentAssetsString());
                
                //navigate the Client to the output Frame
                CurrentAssetsOutput currentAssetsOutputObject = new CurrentAssetsOutput(newObject);
            }   
            //handling exceptions
            catch (NumberFormatException nfe)
            {
                errorFrame err= new errorFrame("Please enter a number!");
            }
            catch (Exception exceptionObj)
            {
                System.out.println("You did something wrong");
            }
        }
            
        // if the Client presses Back button
        else if (command.equals("Back"))
        {
            this.dispose();
        }
        // if the Client presses Show balance sheet button
        else if (command.equals("Show balance sheet"))
        {
            System.out.println("Button to show balance sheet");
        }
      
    }
    
    //main method
    public static void main(String[] args)
    {
        CurrentAssetsInput currentAssetsObject = new CurrentAssetsInput();
    }    
}
