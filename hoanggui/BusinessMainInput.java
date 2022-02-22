/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;


/* This class is used for the main frame, which is the one that the Client will see first as she opens the program, 
and it navigates the Client to where she needs.
*/

//import
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class BusinessMainInput extends JFrame implements ActionListener
{
    //formulate the Frame by setting its size and color and image attached to the Class
    public final Color BACKGROUND_COLOR = new Color(158,208,215);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("main input image.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables 
    private JLabel logoLabel;
    private JMenuBar mainBar;
    private JMenu mainMenu;
    private JMenuItem helpItem1;
    private JMenuItem helpItem2;
    private JButton addingButton;
    private JButton testingButton;
    private JButton showBalanceSheetButton;
    private JPanel buttonPanel;
    private JLabel imageLabel;
    private JLabel introductionLabel1;
    private JLabel introductionLabel2;
    private JLabel introductionLabel3;
    private JPanel introductionPanel;
    private JScrollPane myScrollPane = new JScrollPane();
    JTable BalanceSheetTable = new JTable();
    //private JButton showFixedAssetsButton;
    
    public BusinessMainInput()
    {
        super("Business management main input");
        this.setBounds(400,100,900,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //initializing introduction labels 
        introductionLabel1 = new JLabel("Welcome to Business Management prorgram");
        
        
        //the navigating buttons
        addingButton = new JButton("Adding");
        addingButton.addActionListener(this);
        testingButton = new JButton("Testing");
        testingButton.addActionListener(this);
        showBalanceSheetButton = new JButton("Show balance sheet");
        showBalanceSheetButton.addActionListener(this);
        /*showFixedAssetsButton = new JButton("Show Fixed Assets");
        showFixedAssetsButton.addActionListener(this);*/
              
        
        
        //adding image Label 
        imageLabel = new JLabel(MY_IMAGE);
        
        //adding buttons into 1 panel
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setForeground(new Color(254,253,193));
        buttonPanel.add(addingButton);
        buttonPanel.add(testingButton);
        buttonPanel.add(showBalanceSheetButton);
        //buttonPanel.add(showFixedAssetsButton);
        
        //defining JMenu and its 
        mainBar = new JMenuBar();
        mainMenu = new JMenu("Help");
        helpItem1 = new JMenuItem("Questions and Answers");
        helpItem1.addActionListener(this);
        helpItem2 = new JMenuItem("About this program");
        helpItem2.addActionListener(this);
        mainMenu.add(helpItem1);
        mainMenu.add(helpItem2);
        mainBar.add(mainMenu);
        this.setJMenuBar(mainBar);
        
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(imageLabel, BorderLayout.CENTER);
        
        this.setVisible(true);
        
    }
    /**
     * @param args the command line arguments
     */
    
     //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        String[] columnHeaders = {"FIXED ASSETS", "CURRENT ASSETS", "SHORT TERM LIABILITIES",
            "LONG TERM LIABILITIES", "EQUITY"};
        String command = e.getActionCommand();
        //if the Client presses Questions and Answers button
        
        if (command.equals("Questions and Answers"))
        {
            qaFrame qaObject = new qaFrame();
        }
        //if the Client presses About this program button
        else if (command.equals("About this program"))
        {
            introductionFrame introductionObject = new introductionFrame();
        }
        //if the Client presses Adding button
        else if (command.equals("Adding"))
        {
            addingFrame addingObject = new addingFrame();
        }
        //if the Client presses Testing button
        else if (command.equals("Testing"))
        {
            testingFrame testingObject = new testingFrame();
        }
        //if the Client presses Show balance sheet button
        else if (command.equals("Show balance sheet"))
        {
            businessComputation computationObject = new businessComputation();
            DbFunction dbObject = new DbFunction();
            
            double totalFixedAssets;
            totalFixedAssets = computationObject.getTotalFixedAssets();
            double totalCurrentAssets;
            totalCurrentAssets = computationObject.getTotalCurrentAssets();
            double totalShortTermLiabilities;
            totalShortTermLiabilities = computationObject.getShortTermLiabilities();
            double totalLongTermLiabilities;
            totalLongTermLiabilities = computationObject.getTotalLongTermLiabilities();
            
            computationObject.calculateEquity(totalFixedAssets, totalCurrentAssets, 
                    totalShortTermLiabilities, totalLongTermLiabilities);
            
            dbObject.insertBalanceSheet(totalFixedAssets, totalCurrentAssets,
                    totalShortTermLiabilities, totalLongTermLiabilities,
                    computationObject.getEquity());
            /*if (computationObject.getTotalFixedAssets()==0)
            {
                errorFrame errorObject = new errorFrame("Your fixed assets is currently 0");
            }
            if (computationObject.getTotalCurrentAssets()==0)
            {
                errorFrame errorObject = new errorFrame("Your current assets is currently 0");
            }
            if (computationObject.getTotalShortTermLiabilities()==0)
            {
                errorFrame errorObject = new errorFrame("Your short term liabilities is currently 0");
            }
            if (computationObject.getTotalLongTermLiabilities()==0)
            {
                errorFrame errorObject = new errorFrame("Your long term liabilities is currently 0");
            }
            else*/
            balanceSheetTableFrame balanceSheetObject = new balanceSheetTableFrame();
        }
        
    }
    
    //main method
    public static void main(String[] args) 
    {
    BusinessMainInput newObject = new BusinessMainInput();    
        // TODO code application logic here
    }
    
}
