package com.mycompany.hospitalmanagementsystem1;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridHome
{

    public static void main(String[] args)
    {
        GridHome main = new GridHome(args);
        main.go();
    }

    public GridHome(String ... args)
    {}

    public void go()
    {
        JPanel headerPanel = getPanel(Color.RED);
        JPanel footerPanel = getPanel(Color.BLUE);

        JPanel p1 = getPanel(Color.GRAY);
        p1.setLayout(new GridLayout(4, 2));
        
        
        p1.setLayout(new GridLayout(2,4,20,20));
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        p1.add(new JButton("Button 3"));
        p1.add(new JButton("Button 4"));
        p1.add(new JButton("Button 5"));
        p1.add(new JButton("Button 6"));
        p1.add(new JButton("Button 7"));
        p1.add(new JButton("Button 8"));
       
        
        JPanel p2 = getPanel(Color.BLACK);
        JPanel p3 = getPanel(Color.blue);
        JPanel p4 = getPanel(Color.green);

        GridLayout gridLayout = new GridLayout(2,2);
        JPanel middlePanel = new JPanel(gridLayout);
        middlePanel.add(p1);
        middlePanel.add(p2);
        middlePanel.add(p3);
        middlePanel.add(p4);
       
        JFrame mainFrame = new JFrame();
        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(middlePanel, BorderLayout.CENTER);
        mainFrame.add(footerPanel, BorderLayout.SOUTH);
        mainFrame.pack();

        mainFrame.setVisible(true);

    }

    private JPanel getPanel(Color c)
    {
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createLineBorder(c));
        return result;
    }

}