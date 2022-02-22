/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

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

/**
 *
 * @author hoangcongtri
 */

/* the Frame that is used for introducing to the Client general idea of this program:
what this program is supposed to do.
*/
public class introductionFrame extends JFrame implements ActionListener
{
    //declaration
    public final Color BACKGROUND_COLOR = new Color(252,236,190);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business introduction.jpg");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    private JLabel introductionLabel1;
    private JLabel introductionLabel2;
    private JLabel introductionLabel3;
    private JLabel introductionLabel4;
    private JLabel imageLabel;
    private JPanel introductionPanel;
    
    private JButton backButton;
    
    
    public introductionFrame()
    {
        super("Introduction");
        this.setBounds(200, 100, 600, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //add introduction Label
        JLabel introductionLabel1 = new JLabel("This Business Management program helps you");
        JLabel introductionLabel2 = new JLabel ("with calculating and storing your business’s statistics as well as performance.");
        JLabel introductionLabel3 = new JLabel ("Moreover, there are more options when you can predict the result of any decision");
        JLabel introductionLabel4 = new JLabel ("you will make by taking statistic tests");
        
        //define image label
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        //initialize introduction Panel to add introduction Labels together
        JPanel introductionPanel = new JPanel(new FlowLayout());
        introductionPanel.add(introductionLabel1);
        introductionPanel.add(introductionLabel2);
        introductionPanel.add(introductionLabel3);
        introductionPanel.add(introductionLabel4);
        introductionPanel.add(imageLabel);
        introductionPanel.setBackground(new Color(252,236,190));
        
        //add Back buttons
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        
        this.add(backButton, BorderLayout.SOUTH);
        this.add(introductionPanel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        //the scenario in which the Client presses the Back button
        String command = e.getActionCommand();
        if (command.equals("Back"))
        {
            this.dispose();
        }
    }
    
    //main method
    public static void main(String[] args)
    {
        introductionFrame introductionObject = new introductionFrame();
    }
    
}
