/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagementsystem1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DatabaseConnection.DbConnection;

public class DoctorRegistration extends JFrame implements ActionListener
{ 

  JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9,l10,l11;

  JTextField tf1, tf2, tf5, tf6, tf7,tf8,tf9,tf10;

  JButton btn1, btn2,home,aboutus,contact;

  JPasswordField p1, p2;



  DoctorRegistration()
   {

      

      setSize(700, 700);

      setLayout(null);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setTitle("Doctor Registration Form ");



      l1 = new JLabel("Doctor Registration Form ");

      l1.setForeground(Color.blue);

      l1.setFont(new Font("Serif", Font.BOLD, 20));



      l2 = new JLabel("UserName:");

      l3 = new JLabel("Email-ID:");

      l4 = new JLabel("Create Passowrd:");

      l5 = new JLabel("Confirm Password:");

      l6 = new JLabel("Country:");

      l7 = new JLabel("State:");

      l8 = new JLabel("Phone No:"); 
l9=new JLabel("Name");
l10=new JLabel("Specialisation");
l11=new JLabel("Address");
      tf1 = new JTextField();

      tf2 = new JTextField();

      p1 = new JPasswordField();

      p2 = new JPasswordField();

      tf5 = new JTextField();

      tf6 = new JTextField();

      tf7 = new JTextField();

      tf8 = new JTextField();
      tf9 = new JTextField();
      tf10 = new JTextField();

      btn1 = new JButton("Submit");

      btn2 = new JButton("Clear");

home=new JButton("Home");
aboutus=new JButton("About us");
contact=new JButton("Contact");
home.addActionListener(this);
aboutus.addActionListener(this);
contact.addActionListener(this);

      btn1.addActionListener(this);

      btn2.addActionListener(this);



      l1.setBounds(100, 30, 400, 30);

      l2.setBounds(80, 70, 200, 30);

      l3.setBounds(80, 110, 200, 30);

      l4.setBounds(80, 150, 200, 30);

      l5.setBounds(80, 190, 200, 30);

      l6.setBounds(80, 230, 200, 30);

      l7.setBounds(80, 270, 200, 30);

      l8.setBounds(80, 310, 200, 30);
      l9.setBounds(80, 350, 200, 30);
      l10.setBounds(80, 390, 200, 30);
      l11.setBounds(80, 430, 200, 30);
      tf1.setBounds(300, 70, 200, 30);

      tf2.setBounds(300, 110, 200, 30);

      p1.setBounds(300, 150, 200, 30);

      p2.setBounds(300, 190, 200, 30);

      tf5.setBounds(300, 230, 200, 30);

      tf6.setBounds(300, 270, 200, 30);

      tf7.setBounds(300, 310, 200, 30);
      tf8.setBounds(300, 350, 200, 30);
      tf9.setBounds(300, 390, 200, 30);
      tf10.setBounds(300, 430, 200, 30);
      btn1.setBounds(450, 480, 100, 30);

      btn2.setBounds(560, 480, 100, 30);
      home.setBounds(250,600,100,30);
      aboutus.setBounds(350,600,100,30);
      contact.setBounds(450,600,100,30);

add(home);
add(aboutus);
add(contact);
      add(l1);

      add(l2);

      add(tf1);

      add(l3);

      add(tf2);

      add(l4);

      add(p1);

      add(l5);

      add(p2);

      add(l6);

      add(tf5);

      add(l7);
add(l8);
add(l9);
add(l10);
add(l11);
add(tf8);
add(tf9);
add(tf10);
      add(tf6);

      add(l8);

      add(tf7);

      add(btn1);

      add(btn2);
      

  }



  public void actionPerformed(ActionEvent e)
   {
  	if(e.getSource()==home)
  	{
  		this.setVisible(false);
  		new HomePage();
  	}
  	else
  		if(e.getSource()==aboutus)
  		{
  			this.setVisible(false);
      		new AboutUs();
  		}
  		else
  			if(e.getSource()==contact)
  			{
  				this.setVisible(false);
  	    		new ContactUs();
  			}
  else
      if (e.getSource() == btn1)
       {

          int x = 0;

          String s1 = tf1.getText();

          String s2 = tf2.getText();



          char[] s3 = p1.getPassword();

          char[] s4 = p2.getPassword(); 

          String s8 = new String(s3);

          String s9 = new String(s4);



          String s5 = tf5.getText();

          String s6 = tf6.getText();

          String s7 = tf7.getText();
          String s10 = tf8.getText();
          String s11 = tf9.getText();
          String s12 = tf10.getText();
          if (s8.equals(s9))
         {

              try
             {

                 

                  Connection con = new DbConnection().connect();
                  PreparedStatement ps = con.prepareStatement("insert into doctors(username,emailid,password,country,state,phoneno,DocName,Specialisation,Address) values(?,?,?,?,?,?,?,?,?)");

                  ps.setString(1, s1);

                  ps.setString(2, s2);

                  ps.setString(3, s8);

                  ps.setString(4, s5);

                  ps.setString(5, s6);

                  ps.setString(6, s7);
                  ps.setString(7,s10 );
              
                  ps.setString(8,s11 );
                  ps.setString(9,s12 );

                  ps.executeUpdate();

                  x++;

                  if (x > 0)
                  {

                      JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");

                  }

              }
        catch (Exception ex)
              {

                  System.out.println(ex);

              }

          }
        else
         {

              JOptionPane.showMessageDialog(btn1, "Password Does Not Match");

          } 

      }
        else
     {

          tf1.setText("");

          tf2.setText("");

          p1.setText("");

          p2.setText("");

          tf5.setText("");

          tf6.setText("");

          tf7.setText("");

      }

  } 

  public static void main(String args[])
 {

      new DoctorRegistration().setVisible(true);;

  }
}