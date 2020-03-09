package com.company;
// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubmissionFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel firstWordLabel;
    private JLabel secondWordLabel;
    private JTextField firstWordTextField;
    private JTextField secondWordTextField;
    private JButton submit;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int formHeight = screenSize.height/2;
    int formWidth = screenSize.width;

    void fillLabelSize(JLabel label){
        Font labelFont = label.getFont();
        String labelText = label.getText();
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();
        double widthRatio = (double)componentWidth / (double)stringWidth;
        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    }

    public SubmissionFrame()
    {
        setTitle("Submission Form");
        setBounds(10, 10, formWidth, formHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setSize(formWidth/2, formHeight/4);
        fillLabelSize(title);
        title.setLocation(formWidth/4, formHeight/10);
        c.add(title);

        firstWordLabel = new JLabel("First Word");
        firstWordLabel.setSize(formWidth/7, formHeight/5);
        firstWordLabel.setLocation(formWidth/7, formHeight/5*2);
        fillLabelSize(firstWordLabel);
        c.add(firstWordLabel);

        firstWordTextField = new JTextField();
        firstWordTextField.setSize(formWidth/7, formHeight/5);
        firstWordTextField.setLocation(formWidth/7*2, formHeight/5*2);
        firstWordTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        c.add(firstWordTextField);

        secondWordLabel = new JLabel("Second Word");
        secondWordLabel.setSize(formWidth/7*2, formHeight/5);
        secondWordLabel.setLocation((int) (formWidth/7*3.5), formHeight/5*2);
        secondWordLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        c.add(secondWordLabel);

        secondWordTextField = new JTextField();
        secondWordTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        secondWordTextField.setSize(formWidth/7, formHeight/5);
        secondWordTextField.setLocation(formWidth/7*5, formHeight/5*2);
        c.add(secondWordTextField);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 30));
        submit.setSize(formWidth/7, formHeight/6);
        submit.setLocation((formWidth/2-formWidth/14), (int)(formHeight/5*3.5));
        submit.addActionListener(this);
        c.add(submit);
        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        String firstWord = firstWordTextField.getText();
        String secondWord = secondWordTextField.getText();
        LCS lcs =new LCS(firstWord,secondWord);
        this.setVisible(false);
        GridFrame f = new GridFrame(lcs.getC(),lcs.getB(),firstWord,secondWord);

    }
}



