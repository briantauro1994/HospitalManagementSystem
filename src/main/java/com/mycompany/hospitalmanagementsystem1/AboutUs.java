/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagementsystem1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;




public class AboutUs
{
	
	AboutUs()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//create aboutusframe Jframe
		final JFrame aboutusframe = new JFrame("About Us");
		aboutusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		aboutusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutusframe.setVisible(true);
		aboutusframe.setLayout(null);
		
		//create Background Image for JFrame
		JLabel bgimage = new JLabel(new ImageIcon("Images//aboutus.jpg"));
		
		aboutusframe.setContentPane(bgimage);
                
                
        // CREATE HEADERPANEL JPANEL
        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10,10,screenSize.width-20,100);
        //headerpanel.setBackground(Color.cyan);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED)); 

        // CREATE HEADERPANELSH JPANEL
        JPanel headerpanelsh = new JPanel();
        headerpanelsh.setLayout(null);
        headerpanelsh.setBounds(16,16,screenSize.width-20,100);
        headerpanelsh.setBackground(new Color(200, 200, 200));            

        // CREATE HEADING JLABEL
        JLabel heading = new JLabel("AKshaya MILITARY HOSPITAL");
        Font font = new Font("Garamond", Font.BOLD, 35);
        heading.setFont(font);
        heading.setForeground(new Color(0, 255, 226));            
        heading.setBounds(screenSize.width-700,30,700,45);

        JLabel heading1 = new JLabel("Akshaya MILITARY HOSPITAL");
        Font font1 = new Font("Garamond", Font.BOLD, 35);
        heading1.setFont(font1);
        heading1.setForeground(new Color(0, 126, 112));            
        heading1.setBounds(screenSize.width-697,33,700,45);
            
  
        // LOGO
        ImageIcon image = new ImageIcon("/home/shalom/NetBeansProjects/HospitalManagementSystem1/src/main/java/Images/logo.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add( label, BorderLayout.CENTER );
        panel.setBounds(50,5,100,90);
		
		
        //create mainbodypanel JPanel
        JPanel mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        mainbodypanel.setBackground(new Color(0,0,0,0));
        


        //create Founder1 image
        JLabel founder1 = new JLabel();

        ImageIcon iconfounder1 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/Brian.jpg");
        Image imgfounder1 = iconfounder1.getImage();
        Image newimg1 = imgfounder1.getScaledInstance(250, 250, Image.SCALE_SMOOTH ) ;  
        ImageIcon logoicon1 = new ImageIcon(newimg1);
        founder1.setIcon(logoicon1);

        JLabel founder1name = new JLabel("Founder : Dr.BRIAN");
        founder1name.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
        founder1name.setBounds(8*screenSize.width/10,270,250,20);

        founder1.setOpaque(true);
        founder1.setBackground(Color.red);
        founder1.setBounds(8*screenSize.width/10,15,250,250);

        //create Founder2 image
        JLabel founder2 = new JLabel();

        ImageIcon iconfounder2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/Akshaya.jpg");
        Image imgfounder2 = iconfounder2.getImage();
        Image newimg2 = imgfounder2.getScaledInstance(250, 250, Image.SCALE_SMOOTH ) ;  
        ImageIcon logoicon2 = new ImageIcon(newimg2);
        founder2.setIcon(logoicon2);

        JLabel founder2name = new JLabel("Cofounder : Dr.AKSHAYA");
        founder2name.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
        founder2name.setBackground(Color.white);
        founder2name.setBounds(8*screenSize.width/10,270+280,250,20);

        founder2.setOpaque(true);
        founder2.setBackground(Color.red);
        founder2.setBounds(8*screenSize.width/10,300,250,250);


        //create JLabel for AboutUs text for mainbodypanel


        String text = "OUR MISSION";
        String text1 = "To provide the highest quality care and service for all people in the prevention, diagnosis and treatment of human illness.";
        String text2 = "ABOUT US";
        String text3 = "At Akshaya Military Hospital, our staff, faculty, students, volunteers and supporters are dedicated to improving the lives of people and families affected by psychiatric illness. As the largest psychiatric affiliate of Harvard Medical School, Simpsons has been meeting the needs of individuals and families with psychiatric illness since our founding in 1811. We are here to help you.";

        JTextArea aboutustext = new JTextArea();
        aboutustext.setText(text);
        aboutustext.append(System.getProperty("line.separator"));
        aboutustext.append(System.getProperty("line.separator"));
        aboutustext.append(text1);
        aboutustext.append(System.getProperty("line.separator"));
        aboutustext.append(System.getProperty("line.separator"));
        aboutustext.append(text2);
        aboutustext.append(System.getProperty("line.separator"));
        aboutustext.append(System.getProperty("line.separator"));
        aboutustext.append(text3);
        aboutustext.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
        aboutustext.setLineWrap(true);
        aboutustext.setWrapStyleWord(true);
        aboutustext.setEditable(false);
        aboutustext.setOpaque(true);


        aboutustext.setBackground(new Color(255,255,255,125));
        aboutustext.setBounds(100,100,screenSize.width/2,screenSize.height/2);


        aboutusframe.pack();


        //add headerpanel
        aboutusframe.add(headerpanel);
        aboutusframe.add(headerpanelsh);
        headerpanel.add(heading);
        headerpanel.add(heading1);
        headerpanel.add(panel);
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
             aboutusframe.setVisible(false);
                new HomePage();
            }
        });
        home.setBounds((screenSize.width/2)-140,650,100,30);
        aboutusframe.add(home);
        JButton aboutus = new JButton("About Us");
        aboutus.setBounds((screenSize.width/2)-40,650,100,30);
        aboutus.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
        	   aboutusframe.setVisible(false);
               new AboutUs();
           }
        });
        aboutusframe.add(aboutus);
        JButton contactus = new JButton("Contact Us");
        contactus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	 aboutusframe.setVisible(false);
            	 
                new ContactUs();
            }
        });
        contactus.setBounds((screenSize.width/2)+60,650,100,30);
       aboutusframe.add(contactus);

        //add mainbodypanel
        
        aboutusframe.add(mainbodypanel);
        mainbodypanel.add(founder1);
        mainbodypanel.add(founder1name);
        mainbodypanel.add(founder2);
        mainbodypanel.add(founder2name);
        mainbodypanel.add(aboutustext);	
				
		
    }
	
	public static void main(String a[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new AboutUs();
			}
		});
	}
}
