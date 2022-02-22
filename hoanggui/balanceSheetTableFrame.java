/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/* this Class is used for collecting data from Fixed Assets, current assets, 
short term liabilities, and long term liabilities, and calculating the overall 
equity to judge a business performance.
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class balanceSheetTableFrame extends JFrame implements ActionListener
{
    //formulate the frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
 
    //declaring variables
    private JLabel introductionLabel;
    private JButton backButton;
    private JPanel introductionPanel;
    private JScrollPane myScrollPane = new JScrollPane();
    JTable BalanceSheetTable = new JTable();
    
    public balanceSheetTableFrame() 
    {
        super("Balance sheet table");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        businessComputation newObject = new businessComputation();
        introductionLabel = new JLabel("Total fixed Assets is "+newObject.getTotalFixedAssets());
        //add image 
        
       /* //initialize introduction panel to add image and label to it
       introductionPanel = new JPanel(new FlowLayout());
       introductionPanel.add(introductionLabel);
       introductionPanel.setBackground(new Color(253,170,179));*/
        
       //installing the database function
        DbFunction obj1 = new DbFunction();
        String[] columnHeaders = {"FIXED ASSETS", "CURRENT ASSETS", "SHORT TERM LIABILITIES",
        "LONG TERM LIABILITIES", "EQUITY"};
        
        //displaying the database
        BalanceSheetTable = new JTable(obj1.displayCurrentAssets("BalanceSheetTable"), columnHeaders);
        myScrollPane.getViewport().add(BalanceSheetTable);
        BalanceSheetTable.setFillsViewportHeight(true);
        //add button and its function
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        this.add(myScrollPane, BorderLayout.CENTER);
        this.add(introductionLabel, BorderLayout.SOUTH);
        this.add(backButton, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    //implements actionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        //if the Client presses Back button
        String command = e.getActionCommand();
        if (command.equals("Back"))
        {
            this.dispose();
        }
      
    }

}
