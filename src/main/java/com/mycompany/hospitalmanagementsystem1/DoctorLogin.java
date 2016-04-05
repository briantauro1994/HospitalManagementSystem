/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagementsystem1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DatabaseConnection.DbConnection;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class DoctorLogin 
{
    DoctorLogin()
    {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // HOME PAGE FRAME
        final JFrame homepageframe = new JFrame("test frame");
        homepageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //homepageframe.setSize(900,900);
JLabel bgimage = new JLabel(new ImageIcon("/home/shalom/NetBeansProjects/HospitalManagementSystem1/src/main/java/Images/death.jpg"));

       homepageframe.setContentPane(bgimage);
        // WRAPPER 
        JPanel wrapper = new JPanel();
        wrapper.setLayout(null);
        wrapper.setBackground(Color.WHITE);
        //wrapper.setBackground(Color.green);

//        // CREATE HEADERPANEL JPANEL
//        JPanel headerpanel = new JPanel();
//        headerpanel.setLayout(null);
//        headerpanel.setBounds(5,5,screenSize.width-10,100);
//        headerpanel.setBackground(Color.cyan);
//
//        //create heading JLabel
//        JLabel heading = new JLabel("Hospital Heading");
//        heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
//        heading.setBounds(screenSize.width-500,30,500,50);
//
//        //create logo button JButton
//        JButton logo = new JButton();
//        logo.setBackground(Color.black);
//        ImageIcon icon = new ImageIcon("Images\\logo.png");
//        Image img = icon.getImage();
//        Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
//        ImageIcon logoicon = new ImageIcon(newimg);
//        logo.setIcon(logoicon);
//        logo.setBounds(50,0,100,100);
        
        
        // CREATE HEADERPANEL JPANEL
        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBackground(Color.WHITE);
        headerpanel.setBounds(10,10,screenSize.width-20,100);
        //headerpanel.setBackground(Color.cyan);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED)); 

        // CREATE HEADERPANELSH JPANEL
        JPanel headerpanelsh = new JPanel();
        headerpanelsh.setLayout(null);
          headerpanelsh.setBackground(Color.WHITE);
        headerpanelsh.setBounds(16,16,screenSize.width-20,100);
        headerpanelsh.setBackground(new Color(200, 200, 200));            

        // CREATE HEADING JLABEL
        JLabel heading = new JLabel("Akshaya MILITARY HOSPITAL");
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
panel.setBackground(Color.WHITE);







        //FOOTER JPANEL

        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                homepageframe.setVisible(false);
                new DoctorLogin();
            }
        });
        home.setBounds((screenSize.width/2)-140,650,100,30);
        homepageframe.add(home);
        JButton aboutus = new JButton("About Us");
        aboutus.setBounds((screenSize.width/2)-40,650,100,30);
        aboutus.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
               homepageframe.setVisible(false);
               new AboutUs();
           }
        });
        homepageframe.add(aboutus);
        JButton contactus = new JButton("Contact Us");
        contactus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                homepageframe.setVisible(false);
                new ContactUs();
            }
        });
        contactus.setBounds((screenSize.width/2)+60,650,100,30);
        homepageframe.add(contactus);
        
        

        // MAIN CONTENT JPANEL
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        //mainpanel.setBackground(Color.YELLOW);
        mainpanel.setBounds(20, 130, 850, 450);
        
        
        JLabel mainpanel_pic = new JLabel(new ImageIcon("/home/shalom/NetBeansProjects/HospitalManagementSystem1/src/main/java/Images/mainpanel.jpg"));
        mainpanel_pic.setBounds(20,130,850,450);
        ImageIcon iconfounder1 = new ImageIcon("/home/shalom/NetBeansProjects/HospitalManagementSystem1/src/main/java/Images/mainpanel.jpg");
        Image imgfounder1 = iconfounder1.getImage();
        Image newimg1 = imgfounder1.getScaledInstance(850, 550, Image.SCALE_SMOOTH ) ;  
        ImageIcon logoicon1 = new ImageIcon(newimg1);
        mainpanel_pic.setIcon(logoicon1);
        mainpanel.add(mainpanel_pic);
        
        
        
        
        
        
        // LOGIN PANEL
        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(null);		
        loginpanel.setBounds(470, 130, 450, 450);
         AbstractBorder brdr = new TextBubbleBorder(Color.GRAY,4,16,0);
        
        loginpanel.setBorder(brdr);
        
loginpanel.setBackground(Color.WHITE);
        JLabel loginlabel = new JLabel("LOGIN");
        loginlabel.setBounds(200,0,300,100);
        loginlabel.setFont(new Font("TimesNewRoman",Font.BOLD,18));                

        final JTextField username = new HintTextField("Enter Username");
        username.setBounds(100,120,300,50);

        final JPasswordField password = new HintPasswordField("Enter Password");
        password.setBounds(100,210,300,50);

        JButton loginbutton = new JButton("LOGIN");
        JButton signupbutton = new JButton("SIGN UP");
        loginbutton.setBounds(15,320,200,50);
signupbutton.setBounds(225,320,200,50);
        //LOGIN ACTION
signupbutton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 homepageframe.setVisible(false);
		new DoctorRegistration().setVisible(true);
	}
});
        loginbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(username.getText().length()==0)
                    JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
                else if(password.getPassword().length == 0)
                    JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
                else 
                {
                    String user = username.getText();   
                    char[] pass = password.getPassword(); 
                    String pwd = String.copyValueOf(pass);  
                    if(validate_login(user,pwd))
                    {
                        JOptionPane.showMessageDialog(null, "Correct Login Credentials");
                        homepageframe.setVisible(false);
			new MenuPage();
                    }
                    else
                       JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");        
 homepageframe.setVisible(false);
			new MenuPage();
                }
            }
        });
        
        
        
        



        // ADD
        headerpanel.add(panel);
        headerpanel.add(heading);
        headerpanel.add(heading1);

        wrapper.add(headerpanel);
        wrapper.add(headerpanelsh);
        wrapper.add(mainpanel);	
        
       password.setFocusable(true);
        
       
        
        loginpanel.add(loginlabel);
        loginpanel.add(username);
        loginpanel.add(password);
        loginpanel.add(loginbutton);
        loginpanel.add(signupbutton);
        wrapper.add(loginpanel);

        homepageframe.add(wrapper);	

        homepageframe.pack();

        // SCROLLBARS
        JScrollPane pane = new JScrollPane(wrapper);
        homepageframe.add(pane);
pane.requestFocus();
homepageframe.add(loginpanel);
        // HOMEPAGE VISIBILITY
        homepageframe.setVisible(true);
    }
    
    private boolean validate_login(String username,String password)
        {
            try{           
                // Connection conn=DriverManager.getConnection(
                    // "jdbc:ucanaccess://C://Users//diabolicfeak//Documents//test.accdb"); 
					Connection conn = new DbConnection().connect();
                PreparedStatement pst = conn.prepareStatement("Select * from doctors where username=? and password=?");
                pst.setString(1, username); 
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();                        
                if(rs.next())            
                    return true;    
                else
                    return false;            
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }       
         }

    public static void main(String ar[])
    {
        new DoctorLogin();		
    }
	
	
}

