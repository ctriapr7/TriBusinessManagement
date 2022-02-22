/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/* this class is used for displaying (confirming) the results that are inserted 
by the Client at the Current Assets Input class and navigates the Client to 
the database where stores the data typed by the Client relating to Current Assets.
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class CurrentAssetsOutput extends JFrame implements ActionListener
{
    //formulating the Frame
     public final Color BACKGROUND_COLOR = new Color(224,182,187);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("esig.jpg");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JPanel buttonPanel;
    private JLabel messageLabel;
    private JButton backButton;
    private JButton exitButton;
    private JButton showDatabaseButton;
    private JButton homeButton;
    private JScrollPane myScrollPanel = new JScrollPane();
    JTable CurrentAssetsTable = new JTable();
    private JLabel imageLabel;

    public CurrentAssetsOutput(businessComputation newObject)  
    {
        //formulating the Frames
        super("Current assets result");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //declaring the message label
        messageLabel = new JLabel("The curent assets just typed is " + newObject.getCurrentAssetsString() +" and its value is " +newObject.getCurrentAssets(), SwingConstants.CENTER);
       
        //initializing the image label
        imageLabel = new JLabel(MY_IMAGE);
        
        //defining additional buttons
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        showDatabaseButton = new JButton("Show database");
        showDatabaseButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        homeButton = new JButton("Home");
        homeButton.addActionListener(this);
        
        //adding buttons to the Button panel
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(exitButton);
        buttonPanel.add(showDatabaseButton);
        buttonPanel.add(backButton);
        buttonPanel.add(homeButton);
        buttonPanel.add(imageLabel);
        
        this.add(messageLabel, BorderLayout.NORTH);
        this.add(buttonPanel);
        
        this.setVisible(true);
    }
    
    
    //actionListener
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //insert the column headers of JTable into the frame 
        String[] columnHeaders = {"CURRENT ASSETS VALUE", "TYPE OF CURRENT ASSETS"};
        String command = e.getActionCommand();
        //in the Scenario at which the Client presses "Exit"
        if (command.equals("Exit"))
        {
            System.exit(0);
        }
        //in the Scenario at which the Client presses "Show database"
        else if (command.equals("Show database"))
        {
            DbFunction obj1 = new DbFunction();
            currentAssetsTableFrame newTable = new currentAssetsTableFrame();
        }
        else if (command.equals("Back"))
        {
            this.dispose();
        }
        else if (command.equals("Home"))
        {
            BusinessMainInput mainObject = new BusinessMainInput();
        }
    }
}
