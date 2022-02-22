/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/*this class is used for displaying the Long term liabilities database table 
that were inserted by the Client 
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class longTermLiabilitiesTableFrame extends JFrame implements ActionListener
{
    //formulating the frames
    public final Color BACKGROUND_COLOR = new Color(78,95,90);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    
    //declaring variables
    private JButton exitButton;
    private JButton showDatabaseButton;
    private JScrollPane myScrollPane = new JScrollPane();
    JTable LongTermLiabilitiesTable = new JTable();

    public longTermLiabilitiesTableFrame()  
    {
        super("Long Term Liabilities Table frame");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
       //defining exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);     
        
        //installing the database
        DbFunction obj1 = new DbFunction();
        String[] columnHeaders = {"LONG TERM LIABILITIES VALUE", "TYPE OF LIABILITIES"};

        //displaying the database
        LongTermLiabilitiesTable = new JTable(obj1.displayLongTermLiabilities("LongTermLiabilitiesTable"), columnHeaders);
        myScrollPane.getViewport().add(LongTermLiabilitiesTable);
        LongTermLiabilitiesTable.setFillsViewportHeight(true);
        this.add(myScrollPane, BorderLayout.NORTH);
        this.add(exitButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    
    //actionListener
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        
        //if the Client presses Exit button
        if (command.equals("Exit"))
        {
            this.dispose();
        }
    }
}
