/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

//errorFrame that will appear whenever the Client has errors

public class errorFrame extends JFrame implements ActionListener {
    // declaration
    private final Color FRAME_COLOR = new Color(15,20,10);

    private JLabel error;
    private JButton backButton;

    public errorFrame(String errorName)
    {
        super();
        this.setBounds(420, 300, 400, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBackground(FRAME_COLOR);
        this.setLayout(new BorderLayout());
        
        error = new JLabel(errorName);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        
        this.add(error, BorderLayout.CENTER);
        this.add(backButton, BorderLayout.SOUTH);

        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Back"))
        {
            this.dispose();
        }

    }
}
