/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/*this class is used for displaying the Short term liabilities database table 
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


public class shortTermLiabilitiesTableFrame extends JFrame implements ActionListener
{
    //formulating the frame
    public final Color BACKGROUND_COLOR = new Color(78,95,90);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    
    //declaring variables
    private JButton exitButton;
    private JButton showDatabaseButton;
    private JScrollPane myScrollPane = new JScrollPane();
    JTable ShortTermLiabilitiesTable = new JTable();

    public shortTermLiabilitiesTableFrame()  
    {
        super("Short Term Liabilities Table frame");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
       //declaring exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);     
        
        //installing database to Java
        DbFunction obj1 = new DbFunction();
        String[] columnHeaders = {"SHORT TERM LIABILITIES VALUE", "TYPE OF SHORT TERM LIABILITIES"};

        //displaying database
        ShortTermLiabilitiesTable = new JTable(obj1.displayShortTermLiabilities("ShortTermLiabilitiesTable"), columnHeaders);
        myScrollPane.getViewport().add(ShortTermLiabilitiesTable);
        ShortTermLiabilitiesTable.setFillsViewportHeight(true);
        this.add(myScrollPane, BorderLayout.NORTH);
        this.add(exitButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    
    //actionListener
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        
        //the scenario in which the Client presses Exit button
        if (command.equals("Exit"))
        {
            this.dispose();
        }
    }
}
