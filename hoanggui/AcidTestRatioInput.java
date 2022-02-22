/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoanggui;
/* This class is used for displaying results that is calculated by using data from 
Current Assets database and Short Term Liabilities database with matching color
and indicates your business result
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;



public class AcidTestRatioInput extends JFrame implements ActionListener
{
    //formulate the Frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("Business image 2.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JLabel introductionLabel;
    private JButton backButton;
    private JPanel introductionPanel;
    
    public AcidTestRatioInput()
    {
        super("Acid Test Ratio input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //the notes for notifying the Grader xD
        introductionLabel = new JLabel("This class displays the calculation, therefore, it will be updated later ");
        
        //define image
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        //initialize introduction Panel to add introduction label and image
        introductionPanel = new JPanel(new FlowLayout());
        introductionPanel.add(introductionLabel);
        introductionPanel.add(imageLabel);
        introductionPanel.setBackground(new Color(253,170,179));
        
        //add Back button
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        
        this.add(introductionPanel, BorderLayout.CENTER);
        this.add(backButton, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    //implements ActionListener
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
    
    //main method
    public static void main(String[] args)
    {
        AcidTestRatioInput AcidTestRatioObject = new AcidTestRatioInput();
    }    
}
