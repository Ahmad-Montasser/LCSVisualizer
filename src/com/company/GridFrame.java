package com.company;

import javax.swing.*;
import java.awt.*;

public class GridFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int gridHeight;
    private int gridWidth;
    private int firstWordLength;
    private int stepX=0;
    private int stepY=0;
    private int secondWordLength;
    private int[][] numbers;
    private String[][] arrows;
    private Insets insets ;
    private String firstWord;
    private String secondWord;
    public void delay(long x){
        for(int j=0;j<x;j++){}
    }

    public void DrawArrays(Graphics g){
        g.setColor(Color.BLACK);
        for (int k=0;k<firstWordLength+1;k++){
            for(int i=0;i<secondWordLength+1;i++){
                g.setFont(new Font("Arial",Font.PLAIN,30));
                g.setColor(Color.BLACK);
                g.drawString(numbers[stepY][stepX]+"",74+50*stepX,insets.top+85+50*stepY);
                if(!(i==0||k==0)) {
                    g.setFont(new Font("Calibri", Font.PLAIN, 20));
                    g.setColor(Color.RED);
                    if (arrows[stepY][stepX].equals("T"))
                        g.drawString("↑", 55 + 50 * stepX, insets.top + 65 + 50 * stepY);
                    if (arrows[stepY][stepX].equals("L"))
                        g.drawString("←", 55 + 50 * stepX, insets.top + 65 + 50 * stepY);
                    if (arrows[stepY][stepX].equals("TL")) {
                        g.setColor(Color.GREEN);
                        g.drawString("↖", 55 + 50 * stepX, insets.top + 65 + 50 * stepY);
                    }
                }//delay
                try{Thread.sleep(300);}catch(Exception e){}
            stepX++;
            }
            stepX=0;
            stepY++;
        }
        stepY=0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Horizontal Lines
        for (int i=0;i<=firstWordLength+2;i++)
            g.drawLine(0,i*50+insets.top,
                    gridWidth+50 +insets.left,i*50+insets.top);
        //Vertical Lines
        for (int i = 0; i<= secondWordLength+2; i++)
            g.drawLine(i*50+insets.left,0,
                    i*50+insets.left, gridHeight+50 +insets.top);
        //The 2 words
        g.setFont(new Font("Arial",Font.PLAIN,30));
        for(int i=0; i<secondWordLength;i++)
            g.drawString(secondWord.charAt(i)+"",insets.left+20+50*(i+2),insets.top+30);
        for(int i=0; i<firstWordLength;i++)
            g.drawString(firstWord.charAt(i)+"",insets.left+20,insets.top+30+50*(i+2));
        DrawArrays(g);
    }

    GridFrame(int[][] NUMBERS, String[][] ARROWS, String firstWord, String secondWord){
        this.numbers=NUMBERS;
        this.arrows=ARROWS;
        this.firstWord =firstWord;
        this.secondWord =secondWord;
        this.firstWordLength=firstWord.length();
        this.secondWordLength = secondWord.length();
        gridHeight =(firstWordLength+1)*50;
        gridWidth = (secondWordLength+1) *50;
        JFrame temp = new JFrame();
        temp.pack();
        insets = temp.getInsets();
        this.setMinimumSize(screenSize);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


}
