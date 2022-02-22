/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/* this class is used for displaying the value of long term liabilities that were 
inserted by the Client at the input frame and navigating the Client to database.
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
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class LongTermLiabilitiesOutput extends JFrame implements ActionListener
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
    JTable LongTermLiabilitiesTable = new JTable();
    private JLabel imageLabel;

    public LongTermLiabilitiesOutput(businessComputation newObject)  
    {
        super("Long Term Liabilities result");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //initialize the Message label
        messageLabel = new JLabel("The long term liabilities just typed is " + newObject.getLongTermLiabilitiesString() +" and its value is " +newObject.getLongTermLiabilities(), SwingConstants.CENTER);
       
        //adding image
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
        
        //adding aditional buttons
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
        //naming the columuns of the database
        String[] columnHeaders = {"LONG TERM LIABILITIES VALUE", "TYPE OF LONG TERM LIABILITIES"};
        String command = e.getActionCommand();
        //if the Client presses exit button
        if (command.equals("Exit"))
        {
            System.exit(0);
        }
        //if the Client presses Show database button
        else if (command.equals("Show database"))
        {
            DbFunction obj1 = new DbFunction();
            longTermLiabilitiesTableFrame newTable = new longTermLiabilitiesTableFrame();
        }
        //if the Client presses Back button
        else if (command.equals("Back"))
        {
            this.dispose();
        }
        //if the Client presses Home button
        else if (command.equals("Home"))
        {
            BusinessMainInput mainObject = new BusinessMainInput();
        }
    }
}
