/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/*this class is used for displaying the fixed assets database table 
that were inserted by the Client 
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class fixedAssetsTableFrame extends JFrame implements ActionListener
{
    //formulating the frame
    public final Color BACKGROUND_COLOR = new Color(78,95,90);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    
    //declaring variables
    private JButton exitButton;
    private JButton showDatabaseButton;
    private JScrollPane myScrollPane = new JScrollPane();
    JTable FixedAssetsTable = new JTable();

    public fixedAssetsTableFrame()  
    {
        super("Fixed Assets Table frame");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
       //defining exit buttons
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);     
        
        //installing database to java
        DbFunction obj1 = new DbFunction();
        String[] columnHeaders = {"FIXED ASSETS VALUE", "TYPE OF FIXED ASSETS"};

        //displaying table
        FixedAssetsTable = new JTable(obj1.displayFixedAssets("FixedAssetsTable"), columnHeaders);
        myScrollPane.getViewport().add(FixedAssetsTable);
        FixedAssetsTable.setFillsViewportHeight(true);
        this.add(myScrollPane, BorderLayout.NORTH);
        this.add(exitButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    
    //actionListener
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        
        //if the Client presses exit button
        if (command.equals("Exit"))
        {
            this.dispose();
        }
    }
}
