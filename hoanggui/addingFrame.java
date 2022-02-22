/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/* this Class is used for navigating the Client to the Class that she wants to use for storing 
into database.
*/

import hoanggui.FixedAssetsInput;
import hoanggui.qaFrame;
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

public class addingFrame extends JFrame implements ActionListener
{
    //formulating the frame
    public final Color BACKGROUND_COLOR = new Color(254,253,90);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("esig.jpg");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JPanel firstButtonPanel;
    private JButton fixedAssetsButton;
    private JButton currentAssetsButton;
    private JButton shortTermLiabilitiesButton;
    private JButton longTermLiabilitiesButton;
    private JPanel secondButtonPanel;
    private JButton backButton;
    private JButton showBalanceSheetButton;
    private JMenu mainMenu;
    private JMenuBar mainBar;
    private JMenuItem helpItem1;
    private JMenuItem helpItem2;
    private JLabel imageLabel;
    
    public addingFrame()
    {
        super("Adding");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //initialize buttons that navigates the Client to store what she needs
        fixedAssetsButton = new JButton("Fixed Assets");
        fixedAssetsButton.addActionListener(this);
        currentAssetsButton = new JButton("Current Assets");
        currentAssetsButton.addActionListener(this);
        shortTermLiabilitiesButton = new JButton("Short Term Liabilities");
        shortTermLiabilitiesButton.addActionListener(this);
        longTermLiabilitiesButton = new JButton("Long Term Liabilities");
        longTermLiabilitiesButton.addActionListener(this);
        
        
        
        //additional buttons
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        showBalanceSheetButton = new JButton("Show Balance Sheet");
        showBalanceSheetButton.addActionListener(this);
        
        //initialize second panel to contain additional buttons
        secondButtonPanel = new JPanel(new FlowLayout());
        secondButtonPanel.add(backButton);
        secondButtonPanel.add(showBalanceSheetButton);
        
        //add image Label
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        //add buttons
        firstButtonPanel = new JPanel(new FlowLayout());
        firstButtonPanel.add(fixedAssetsButton);
        firstButtonPanel.add(currentAssetsButton);
        firstButtonPanel.add(shortTermLiabilitiesButton);
        firstButtonPanel.add(longTermLiabilitiesButton);
        firstButtonPanel.setBackground(new Color(46,151,108));
        firstButtonPanel.add(imageLabel);
        
         //JMenu
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
        
        this.add(firstButtonPanel, BorderLayout.CENTER);
        this.add(secondButtonPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //if the Client presses Back button
        if (command.equals("Back"))
        {
            this.dispose();
        }
        //if the Client presses Questions and Answers button
        else if (command.equals("Questions and Answers"))
        {
            qaFrame qaObject = new qaFrame();
        }
        //if the Client presses About this program button
        else if (command.equals("About this program"))
        {
            introductionFrame introductionObject = new introductionFrame();
        }
        //if the Client presses Fixed Assets button
        else if (command.equals("Fixed Assets"))
        {
            FixedAssetsInput fixedAssetsObject = new FixedAssetsInput();
        }
        //if the Client presses Current Assets button
        else if (command.equals("Current Assets"))
        { 
            CurrentAssetsInput currentAssetsObject = new CurrentAssetsInput();
        }
        //if the Client presses Short Term Liabilities button
        else if (command.equals("Short Term Liabilities"))
        {
            ShortTermLiabilitiesInput shortTermLiabilitiesObject = new ShortTermLiabilitiesInput();
        }
        //if the Client presses Long Term Liabilities button
        else if (command.equals("Long Term Liabilities"))
        {
            LongTermLiabilitiesInput longTermLiabilitiesObject = new LongTermLiabilitiesInput();
        }
        //if the Client presses Show balance sheet button
        else if (command.equals("Show balance sheet"))
        {
            balanceSheetTableFrame balanceSheetObject = new balanceSheetTableFrame();
        }
    }
    
    //main method
    public static void main(String[] args)
    {
        addingFrame addingFrameObject = new addingFrame();
    }    
}

