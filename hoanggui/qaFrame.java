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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/* this Class is used for answering general questions that are likely to be asked 
by the Client.
*/

public class qaFrame extends JFrame implements ActionListener
{
    public final Color BACKGROUND_COLOR = new Color(254,253,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    
    //declaring variables
    private JLabel questionOneLabel;
    private JLabel answerOneLabel;
    private JLabel questionTwoLabel;
    private JLabel answerTwoLabel;
    private JButton backButton;
    private JPanel buttonPanel;
    private JPanel QA1Panel;
    
    public qaFrame()
    {
    super("Help Frame");
        this.setBounds(100, 50, 500, 150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
    //add question Label
    questionOneLabel = new JLabel("Why can't I insert data");
    answerOneLabel = new JLabel("You have to choose type of data and insert value by number");
    questionTwoLabel = new JLabel("How can I test a decision in the future?");
    answerTwoLabel = new JLabel("Press the testing button navigates you to the Frame");
    
    //add back button
    backButton = new JButton("Back");
    backButton.addActionListener(this);
    
    //initialize a Panel to contain questions and answers
    QA1Panel = new JPanel(new FlowLayout());
    QA1Panel.add(questionOneLabel);
    QA1Panel.add(answerOneLabel);
    QA1Panel.add(questionTwoLabel);
    QA1Panel.add(answerTwoLabel);
    QA1Panel.setBackground(new Color(74,157,99));
    
    this.add(QA1Panel, BorderLayout.CENTER);
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
    
    public static void main(String[] args)
    {
        qaFrame qaFrameObject = new qaFrame();
    }    
    
}
