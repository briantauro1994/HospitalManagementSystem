/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagementsystem1;

/**
 *
 * @author shalom
 */
import DatabaseConnection.DbConnection;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.sql.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.LabelUI;

class MenuPage {
	JTabbedPane tabbedPane;
	JPanel mainbodypanel, billdisplaypanel, pathdisplaypanel;
	int i = 1;

	JTextArea billtextarea;
	JLabel totaldisplaylabel;
	JTextField patient_name_label;

	// JLabel patient_name;

	DefaultTableModel billtablemodel;
	DefaultTableModel pathistory;
	JTable billtable;
	JTable pattable;
	JScrollPane billdisplayscroll, patdisplayscroll;
	Image img;

	String name;
	String address;
	String phone;
	String age;
	String sex;
	String illness;

	int billamountint;
	double totalsum1 = 0;
	JFileChooser fc = null;

	MenuPage() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// create menupageframe JFrame
		final JFrame menupageframe = new JFrame("Menu Page");
		menupageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menupageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menupageframe.setBackground(Color.white);
		menupageframe.setLayout(null);

		// CREATE HEADERPANEL JPANEL
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(10, 10, screenSize.width - 20, 100);
		// headerpanel.setBackground(Color.cyan);
		headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		headerpanel.setBackground(Color.white);
		// CREATE HEADERPANELSH JPANEL
		JPanel headerpanelsh = new JPanel();
		headerpanelsh.setLayout(null);
		headerpanelsh.setBounds(16, 16, screenSize.width - 20, 100);
		headerpanelsh.setBackground(Color.gray);

		// CREATE HEADING JLABEL
		JLabel heading = new JLabel("       AKSHAYA HOSPITAL");
		Font font = new Font("Garamond", Font.BOLD, 50);
		heading.setFont(font);
		heading.setForeground(new Color(5, 109, 32));
		heading.setBounds(510, 30, 700, 45);

	/*	JLabel heading1 = new JLabel("Akshaya MILITARY HOSPITAL");
		Font font1 = new Font("Garamond", Font.BOLD, 35);
		heading1.setFont(font1);
		heading1.setForeground(new Color(5, 109, 32));
		heading1.setBounds(screenSize.width - 697, 33, 700, 45);*/

		// LOGO

		// JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel panel = new JPanel(new BorderLayout()) {
			protected void paintComponent(Graphics g) {
				try {
					img = ImageIO
							.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/hos11.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
			}
		}

		;

		panel.setBounds(50, 0, 100, 90);

		// add headerpanel
		menupageframe.add(headerpanel);
		menupageframe.add(headerpanelsh);
		headerpanel.add(heading);
		//headerpanel.add(heading1);
		headerpanel.add(panel);

		// FOOTER JPANEL
		JButton home = new JButton("Home");
		home.setBackground(Color.white);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				menupageframe.setVisible(true);
				new HomePage();
			}
		});
		home.setBounds((screenSize.width / 2), 650, 100, 30);
		menupageframe.add(home);
		JButton aboutus = new JButton("About Us");
		aboutus.setBackground(Color.white);
		aboutus.setBounds((screenSize.width / 2) + 100, 650, 100, 30);
		aboutus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				menupageframe.setVisible(true);
				new AboutUs();
			}
		});
		menupageframe.add(aboutus);
		JButton contactus = new JButton("Contact Us");
		contactus.setBackground(Color.white);
		contactus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				menupageframe.setVisible(true);
				new ContactUs();
			}
		});
		contactus.setBounds((screenSize.width / 2) + 200, 650, 100, 30);
		menupageframe.add(contactus);

		// create mainbodypanel JPanel
		mainbodypanel = new JPanel();
		mainbodypanel.setLayout(null);
		mainbodypanel.setBounds(15, 110, screenSize.width - 10, screenSize.height - (screenSize.height / 7));
		mainbodypanel.setBackground(Color.white);

		// create Jtabbedpane
		JTabbedPane tabpane = new JTabbedPane();
		tabpane.setBounds(10, 110, screenSize.width - 10, screenSize.height - (screenSize.height / 7));
		menupageframe.add(tabpane);
		try {
			img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/aboutus.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// OUTPATIENT start
		try {
			img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel1=null;
		try {
			panel1 = new JPanel() {
			Image	img1 = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
				  protected void paintComponent(Graphics g) {
				  super.paintComponent(g); g.drawImage(img1, 0, 0, null); }
				 
			};
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		panel1.setLayout(null);
		panel1.setOpaque(false);
		panel1.setBounds(0, 120, screenSize.width - 10, screenSize.height - (screenSize.height / 6));

		panel1.requestFocus();
		// FORM start

		JPanel outform = new JPanel();
		outform.setLayout(null);
		outform.setBounds(310, 25, 450, 480);
		//outform.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		//outform.setBackground(Color.white);
		JLabel outlabel = new JLabel("Enter Details of Out Patient");
		outlabel.setBounds(140, 20, 300, 40);
		final JTextField outname = new HintTextField("Enter Name");
		outname.setBounds(80, 70, 300, 40);
		final JTextField outaddress = new HintTextField("Enter Address");
		outaddress.setBounds(80, 120, 300, 40);
		final JTextField outnumber = new HintTextField("Enter Phone Number");
		outnumber.setBounds(80, 170, 300, 40);
		final JTextField outage = new HintTextField("Enter Age");
		outage.setBounds(80, 220, 300, 40);
		final JTextField outsex = new HintTextField("Enter Sex");
		outsex.setBounds(80, 270, 300, 40);
		final JTextField outillness = new HintTextField("Enter Illness");
		outillness.setBounds(80, 320, 300, 40);
		final JTextField prescription = new HintTextField("Enter Prescription");
		prescription.setBounds(80, 370, 300, 40);
		JButton outbutton = new JButton("Submit");
		outbutton.setBounds(100, 420, 250, 40);
		outbutton.setBackground(Color.white);
		outform.add(outlabel);
		outform.add(outname);
		outform.add(outname);
		outform.add(outaddress);
		outform.add(outnumber);
		outform.add(outage);
		outform.add(outsex);
		outform.add(outillness);
		outform.add(prescription);
		outform.add(outbutton);
outform.setOpaque(false);
		panel1.add(outform);
		// FORM end

		outbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PreparedStatement pstmt1 = null;
				PreparedStatement pstmt = null;
				PreparedStatement billpstmt = null;
				PreparedStatement patienthistory = null;
				try {
					Connection conn = new DbConnection().connect();
					// Connection conn =
					// DriverManager.getConnection("jdbc:odbc:hospital");
					String query = "insert into Patients(Pname, Address, Pnumber, Age, Sex, Illness,Prescription) values(?, ?, ?, ?, ?, ?,?)";

					// FOR BILLING TABLE start
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Patients");
					r.next();
					int count = r.getInt("rowcount");
					count = count + 1;
					String billquery = "CREATE TABLE patient_" + count + " " + "(id INT NULL AUTO_INCREMENT, "
							+ " bill_item VARCHAR(255), " + " billamount VARCHAR(255),PRIMARY KEY(id)" + ")";

					String patientHistory = "CREATE TABLE patientHistory_" + count + " "
							+ "(id INT NULL AUTO_INCREMENT, " + "patId INT," + " Illness VARCHAR(255), "
							+ " Prescription VARCHAR(255),PRIMARY KEY(id)" + ")";

					billpstmt = conn.prepareStatement(billquery);
					billpstmt.executeUpdate();
					System.out.println("Inserted into patient_id");
					// FOR BILLING TABLE end
					patienthistory = conn.prepareStatement(patientHistory);
					patienthistory.executeUpdate();

					String query1 = "insert into  patientHistory_" + count
							+ "(patId,Illness,Prescription) values(?, ?,?)";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, outname.getText());
					pstmt.setString(2, outaddress.getText());
					pstmt.setString(3, outnumber.getText());
					pstmt.setString(4, outage.getText());
					pstmt.setString(5, outsex.getText());
					pstmt.setString(6, outillness.getText());
					pstmt.setString(7, prescription.getText());
					pstmt.executeUpdate(); // execute insert statement
					pstmt1 = conn.prepareStatement(query1);

					pstmt1.setInt(1, count);
					pstmt1.setString(2, outillness.getText());
					pstmt1.setString(3, prescription.getText());
					pstmt1.executeUpdate();

					JOptionPane.showMessageDialog(null, "Successfully entered details");
					new MenuPage();
					menupageframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// OUTPATIENT end

		// PATIENT DB START
		JPanel panel2=null;
		try {
			panel2 = new JPanel() {
				Image	img1 = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
				  protected void paintComponent(Graphics g) {
				  super.paintComponent(g);
				  g.drawImage(img1, 0, 0, null); }
				 
			};
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel2.setOpaque(false);
		// panel2.setBackground(Color.green);
		panel2.setBounds(15, 90, screenSize.width - 10, screenSize.height - (screenSize.height / 6));
panel2.setOpaque(false);
		panel2.setLayout(null);

		JButton editpatient = new JButton("Edit Records");
		editpatient.setBounds(550, 15, 150, 40);
		//editpatient.setBackground(Color.white);
		editpatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				menupageframe.setVisible(false);
				new Edit();
			}
		});

		i = 1;
		DefaultTableModel patientmodel = new DefaultTableModel();
		patientmodel.addColumn("id");
		patientmodel.addColumn("Name");
		patientmodel.addColumn("Address");
		patientmodel.addColumn("Age");
		patientmodel.addColumn("Phone Number");
		patientmodel.addColumn("Sex");
		patientmodel.addColumn("Illness");
		patientmodel.addColumn("Buttons");

		try {
			Connection conn = new DbConnection().connect();
			// Connection conn =
			// DriverManager.getConnection("jdbc:odbc:hospital");
			PreparedStatement pst = conn.prepareStatement("Select * from Patients");
			ResultSet rs = pst.executeQuery();
			// Statement s = conn.createStatement();
			// ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM
			// Patients");
			// r.next();
			// int count = r.getInt("rowcount");
			// System.out.println(count);
			// JButton[] buttons = new JButton[10];
			while (rs.next()) {

				String id = rs.getString("id");
				String name = rs.getString("PName");
				String address = rs.getString("Address");
				String phone = rs.getString("PNumber");
				String age = rs.getString("Age");
				String sex = rs.getString("Sex");
				String illness = rs.getString("Illness");
				patientmodel.addRow(new Object[] { id, name, address, phone, age, sex, illness });
				i++;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JTable patienttable = new JTable()
				{
			
			
			
	           
			@Override
					public void setOpaque(boolean isOpaque) {
						// TODO Auto-generated method stub
						super.setOpaque(false);
					}
			public Component prepareRenderer(TableCellRenderer renderer,int row, int column)
			
			{
			Component c=super.prepareRenderer(renderer, row, column);
			if(c instanceof JComponent)
			{
				((JComponent)c).setOpaque(false);
		return c;
			}
			return c;
			
			}
				};


patienttable.getTableHeader().setOpaque(false);



			patienttable.setModel(patientmodel);
			patienttable.setOpaque(false);
			((DefaultTableCellRenderer)patienttable.getDefaultRenderer(Object.class)).setOpaque(false);

		JScrollPane patientpane = new JScrollPane(patienttable);
		
patientpane.setOpaque(false);

		patientpane.setBounds(10, 70, 1240, 120);
		panel2.add(editpatient);
		panel2.add(patientpane);
		panel2.setOpaque(false);
		panel2.setVisible(true);
		// PATIENT DB END

		// DOCOTORS DB start
		try {
				img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel3=null;
		try {
			panel3 = new JPanel() {
			Image	img2 = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
				  protected void paintComponent(Graphics g) {
				  super.paintComponent(g); g.drawImage(img2, 0, 0, null); }
				 
			};
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel3.setOpaque(false);
		panel3.setLayout(null);
		// panel3.setBackground(Color.blue);
		panel3.setBounds(15, 90, screenSize.width - 10, screenSize.height - (screenSize.height / 6));

		JButton editdoctor = new JButton("Edit Records");
		editdoctor.setBounds(550, 15, 150, 40);
		editdoctor.setBackground(Color.WHITE);
		editdoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				menupageframe.setVisible(false);
				new EditDoc();
			}
		});

		DefaultTableModel doctormodel = new DefaultTableModel();
		doctormodel.addColumn("id");
		doctormodel.addColumn("Name");
		doctormodel.addColumn("Specialisation");
		doctormodel.addColumn("Address");
		doctormodel.addColumn("Phone Number");

		try {
			Connection conn = new DbConnection().connect();
			// Connection conn =
			// DriverManager.getConnection("jdbc:odbc:hospital");
			PreparedStatement pst = conn.prepareStatement("Select * from doctors");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("DocName");
				String specialisation = rs.getString("Specialisation");
				String address = rs.getString("Address");
				String age = rs.getString("phoneno");
				doctormodel.addRow(new Object[] { id, name, specialisation, address, age });

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JTable doctortable = new JTable(doctormodel);
	//	doctortable.setBackground(Color.white);
		doctortable.setOpaque(false);
		JScrollPane doctorpane = new JScrollPane(doctortable);
		doctorpane.setBounds(10, 70, 1240, 120);
		panel3.add(editdoctor);
		doctorpane.setOpaque(false);
		panel3.add(doctorpane);
		panel3.setOpaque(false);
		panel3.setVisible(true);

		// DOCOTORS DB end

		// BILL PAYMENT START
		final JPanel panel4 = new JPanel() {
			
			  protected void paintComponent(Graphics g) {
				  try {
					img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  super.paintComponent(g); g.drawImage(img, 0, 0, null); }
			 
		};
		panel4.setLayout(null);
		panel4.setOpaque(true);
		// panel4.setBackground(Color.yellow);
		panel4.setBounds(15, 90, screenSize.width - 10, screenSize.height - (screenSize.height / 6));

		// ID PANEL start
		JPanel billidpanel = new JPanel();
		billidpanel.setLayout(null);
		billidpanel.setBounds(350, 10, 500, 50);
		billidpanel.setOpaque(false);;
		final JTextField billidfield = new JTextField("Enter id");
		JButton billidbutton = new JButton("Show");
		billidfield.setBounds(10, 5, 200, 30);
		billidbutton.setBounds(250, 5, 220, 30);

		billidpanel.add(billidfield);
		billidpanel.add(billidbutton);

		// ID PANEL end
		billidbutton.setBackground(Color.white);

		// BILL ENTRY PANEL start

		final JTextField bill_item = new JTextField("Bill Item");
		bill_item.setBounds(140, 130, 300, 30);

		final JTextField bill_amt = new JTextField("Bill Amount");
		bill_amt.setBounds(140, 200, 300, 30);

		JButton bill_submit = new JButton("Add");
		bill_submit.setBounds(240, 260, 75, 30);
		bill_submit.setBackground(Color.white);
		JButton total_amt = new JButton("Show Total Amount");
		total_amt.setBounds(180, 320, 230, 30);
		total_amt.setBackground(Color.white);
		final JPanel billentrypanel = new JPanel();
		billentrypanel.setLayout(null);
		billentrypanel.setBounds(0, 100, 560, 400);
	//	billentrypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		//billentrypanel.setBackground(Color.white);
billentrypanel.setOpaque(false);
		bill_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PreparedStatement pstmt = null;
				try {
					int a = Integer.parseInt(billidfield.getText());
					Connection conn = new DbConnection().connect();
					// Connection conn =
					// DriverManager.getConnection("jdbc:odbc:hospital");
					String query = "insert into patient_" + a + "(bill_item, billamount) values(?, ?)";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, bill_item.getText());
					pstmt.setString(2, bill_amt.getText());

					pstmt.executeUpdate(); // execute insert statement
					JOptionPane.showMessageDialog(null, "Added Sucesfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// BILL ENTRY PANEL end

		// BILL DISPLAY PANEL start

		billidbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					int a = Integer.parseInt(billidfield.getText());
					Connection conn1 = new DbConnection().connect();
					// Connection
					// conn1=DriverManager.getConnection("jdbc:odbc:hospital");
					// FOR PATIENT NAME start
					Statement s = conn1.createStatement();
					ResultSet r = s.executeQuery("SELECT * FROM Patients WHERE id=" + a + "");
					r.next();
					String patient_name = r.getString("PName");
					String patient_age = r.getString("Age");
					String patient_sex = r.getString("Sex");

					billentrypanel.setBackground(Color.white);
					patient_name_label = new JTextField("Patient Name: " + patient_name);
					billentrypanel.add(patient_name_label);
					patient_name_label.setBounds(20, 20, 150, 30);
					patient_name_label = new JTextField("Patient Age: " + patient_age);
					billentrypanel.add(patient_name_label);
					patient_name_label.setBounds(220, 20, 150, 30);
					patient_name_label = new JTextField("Patient Sex: " + patient_sex);
					billentrypanel.add(patient_name_label);
					patient_name_label.setBounds(380, 20, 150, 30);

					// FOR PATIENT NAME END
				} catch (Exception e) {
					e.printStackTrace();
				}

				// BILL TABLE start
				billtablemodel = new DefaultTableModel();
				billtablemodel.addColumn("Bill Item");
				billtablemodel.addColumn("Bill Amount");

				PreparedStatement pstmt = null;
				try {
					Connection conn = new DbConnection().connect();

					// Connection
					// conn=DriverManager.getConnection("jdbc:odbc:hospital");
					int a = Integer.parseInt(billidfield.getText());

					PreparedStatement pst = conn.prepareStatement("Select * from patient_" + a + "");
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						String billitem = rs.getString("bill_item");
						String billamount = rs.getString("billamount");
						billtablemodel.addRow(new Object[] { billitem, billamount });

					}

					billtable = new JTable(billtablemodel);
					billtable.setBackground(Color.white);
					// billtablemodel.fireTableDataChanged();
					billdisplayscroll = new JScrollPane(billtable);
					billdisplayscroll.setBounds(20, 20, 470, 280);
					billdisplaypanel.add(billdisplayscroll);
					billdisplaypanel.setBackground(Color.white);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		total_amt.setBackground(Color.white);
		total_amt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				billdisplaypanel.setVisible(true);
				billtablemodel.fireTableDataChanged();
				billtable.repaint();

				try {
					Connection conn = new DbConnection().connect();

					// Connection
					// conn=DriverManager.getConnection("jdbc:odbc:hospital");
					int a = Integer.parseInt(billidfield.getText());

					Statement s = conn.createStatement();
					System.out.println("long before");
					ResultSet rs = s.executeQuery("SELECT * FROM patient_" + a + "");
					System.out.println("bit before");

					totalsum1 = 0;
					int sum1 = 0;
					// PreparedStatement pst = conn.prepareStatement("SELECT
					// SUM(billamount) AS totaltt FROM patient_"+a+"");
					//
					// ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						System.out.println("before");

						String id = rs.getString("bill_item");
						String name = rs.getString("billamount");
						sum1 = Integer.parseInt(name);
						totalsum1 = totalsum1 + sum1;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				String total2 = String.valueOf(totalsum1);
				totaldisplaylabel = new JLabel();
				totaldisplaylabel.setText("");
				billdisplaypanel.add(totaldisplaylabel);
				totaldisplaylabel.setText("Amount payable: " + total2);
				// billdisplaypanel.add(totaldisplaylabel);
				// totaldisplaylabel.setBounds(250,50,300,600);
				// totaldisplaylabel.repaint();

				JTextField totaltext = new JTextField();
				totaltext.setText("Amount payable: " + total2);
				billdisplaypanel.add(totaltext);
				totaltext.setBounds(150, 300, 200, 30);
				System.out.println(total2);

			}
		});

		billdisplaypanel = new JPanel();
		billdisplaypanel.setLayout(null);
		// billdisplaypanel.setBackground(Color.red);
		panel4.add(billdisplaypanel);
		billdisplaypanel.setBounds(580, 100, 500, 400);
		billdisplaypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		billdisplaypanel.setVisible(false);
		billdisplaypanel.setBackground(Color.white);
		// BILL DISPLAY PANEL end

		billentrypanel.add(bill_item);
		billentrypanel.add(bill_amt);
		billentrypanel.add(total_amt);
		billentrypanel.add(bill_submit);

		panel4.add(billentrypanel);

		panel4.add(billidpanel);

		// BILL PAYMENT END

		// New Patient
		JPanel panel5 = new JPanel() {
			
			  protected void paintComponent(Graphics g) {
				  try {
					img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  super.paintComponent(g); g.drawImage(img, 0, 0, null); }
			 
		};

		// panel1.setBackground(Color.red);
		panel5.setOpaque(true);
		panel5.setBounds(15, 100, screenSize.width - 10, screenSize.height - (screenSize.height / 6));
		panel5.setLayout(null);
		// FORM start
		JPanel outform1 = new JPanel();
		outform1.setLayout(null);
		outform1.setBounds(0, 25, 510, 280);
		//outform1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		//outform1.setBackground(Color.white);
		JLabel outlabel1 = new JLabel("Enter Details of Out Patient");
		outlabel1.setBounds(140, 20, 300, 40);
		final JTextField outid = new HintTextField("Enter id");
		outid.setBounds(80, 70, 300, 40);
		JButton outbutton2 = new JButton("Check");
		outbutton2.setBounds(400, 70, 100, 40);
		outbutton2.setBackground(Color.white);
		final JTextField outillness1 = new HintTextField("Enter Illness");
		outillness1.setBounds(80, 120, 300, 40);
		final JTextField pres = new HintTextField("Enter Prescription");
		pres.setBounds(80, 170, 300, 40);
		JButton outbutton1 = new JButton("Submit");
		outbutton1.setBounds(100, 220, 250, 40);
		outbutton1.setBackground(Color.white);
		outform1.add(outlabel1);

		outform1.add(outillness1);
		outform1.add(outbutton1);
		outform1.add(outid);
		outform1.add(outbutton2);
		outform1.add(pres);
outform1.setOpaque(false);
		outbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PreparedStatement pstmt = null;

				String query2 = "insert into  patientHistory_" + outid.getText()
						+ "(patId,Illness,Prescription) values(?, ?,?)";

				try {
					Connection conn = new DbConnection().connect();
					pstmt = conn.prepareStatement(query2);
					pstmt.setString(1, outid.getText());
					pstmt.setString(2, outillness1.getText());
					pstmt.setString(3, pres.getText());
					pstmt.executeUpdate(); // execute insert statement
					JOptionPane.showMessageDialog(null, "Added Sucesfully");

				} catch (Exception e)

				{
					System.out.println(e.getMessage());
				}

			}
		});

		outbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				pathdisplaypanel.setVisible(true);
				pathistory = new DefaultTableModel();
				pathistory.addColumn("ID");
				pathistory.addColumn("Patient Id");
				pathistory.addColumn("Illness");
				pathistory.addColumn("Prescription");

				PreparedStatement pstmt = null;
				try {
					Connection conn = new DbConnection().connect();

					// Connection
					// conn=DriverManager.getConnection("jdbc:odbc:hospital");
					int a = Integer.parseInt(outid.getText());

					PreparedStatement pst = conn.prepareStatement("Select * from patientHistory_" + a + "");
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						String id = rs.getString("id");
						String patid = rs.getString("patid");
						String illness = rs.getString("Illness");
						String prescription1 = rs.getString("Prescription");

						pathistory.addRow(new Object[] { id, patid, illness, prescription1 });

					}
					pattable = new JTable(pathistory);
					// billtablemodel.fireTableDataChanged();
					patdisplayscroll = new JScrollPane(pattable);
					patdisplayscroll.setBounds(20, 25, 470, 280);
					patdisplayscroll.setAutoscrolls(true);
					pathdisplaypanel.add(patdisplayscroll);
					pathdisplaypanel.setBackground(Color.white);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		pathdisplaypanel = new JPanel();
		pathdisplaypanel.setLayout(null);
		// billdisplaypanel.setBackground(Color.red);
		panel5.add(pathdisplaypanel);
		pathdisplaypanel.setBounds(550, 25, 500, 280);
		pathdisplaypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		pathdisplaypanel.setBackground(Color.WHITE);
panel5.setOpaque(false);
		pathdisplaypanel.setVisible(false);
		panel5.add(outform1);

		// Images
		JPanel panel6 = new JPanel() {
			
			  protected void paintComponent(Graphics g) {
				  try {
						img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  super.paintComponent(g); g.drawImage(img, 0, 0, null); }
			 
		};

		fc = new JFileChooser();

		panel6.setOpaque(false);
		panel6.setLayout(null);
		
		panel6.setBounds(15, 90, screenSize.width - 10, screenSize.height - (screenSize.height / 6));
		JPanel outform11 = new JPanel();
		outform11.setOpaque(false);
		outform11.setLayout(null);
		outform11.setBounds(400, 150, 400, 300);
		//outform11.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		JLabel outlabel11 = new JLabel("Enter Details of Out Patient");
		outlabel11.setBounds(140, 20, 300, 40);
		final JTextField outid11 = new HintTextField("Enter id");
		outid11.setBounds(80, 70, 300, 40);
		JButton outbutton21 = new JButton("Check");
		outbutton2.setBounds(400, 70, 100, 40);
		outbutton21.setBackground(Color.white);
		final JTextField outillness11 = new HintTextField("Enter Illness");
		outillness11.setBounds(80, 120, 300, 40);
		final JTextField loc = new HintTextField("Location of Image");
		loc.setBounds(80, 170, 300, 40);
		JButton browse = new JButton("Browse");
		browse.setBounds(100, 220, 100, 40);
		JButton save = new JButton("Save");
		save.setBounds(250, 220, 100, 40);
		outform11.add(outlabel1);
		save.setBackground(Color.white);
		browse.setBackground(Color.white);
		outform11.add(outillness11);
		outform11.add(browse);
		outform11.add(outid11);
		outform11.add(loc);
		outform11.add(browse);
		
		outform11.add(save);
		browse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(outform11);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					// This is where a real application would open the file.
					// log.append("Opening: " + file.getName() + "." + newline);
					loc.setText(file.getAbsolutePath());
				} else {
					// log.append("Open command cancelled by user." + newline);
				}
				// log.setCaretPosition(log.getDocument().getLength());

			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PreparedStatement pstmt = null;

				String query2 = "insert into  patientimages(pid,location) values(?, ?)";

				try {
					Connection conn = new DbConnection().connect();
					pstmt = conn.prepareStatement(query2);
					pstmt.setString(1, outid11.getText());
					pstmt.setString(2, fc.getSelectedFile().getAbsolutePath());

					pstmt.executeUpdate(); // execute insert statement
					JOptionPane.showMessageDialog(null, "Added Sucesfully");

				} catch (Exception e)

				{
					System.out.println(e.getMessage());
				}

			}
		});
		panel6.add(outform11, BorderLayout.CENTER);

		// panel 7
		JPanel panel7 = new JPanel()

		{
			
			 protected void paintComponent(Graphics g) {
				 try {
						img = ImageIO.read(new File("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/final.jpg"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 
			 super.paintComponent(g); g.drawImage(img, 0, 0, null); }
			 

		};

	/*	panel7.setBackground(new Color(7, 53, 70));
		panel6.setBackground(new Color(7, 53, 70));
		panel5.setBackground(new Color(7, 53, 70));
		panel4.setBackground(new Color(7, 53, 70));
		panel3.setBackground(new Color(7, 53, 70));
		panel2.setBackground(new Color(7, 53, 70));
	//	panel1.setBackground(new Color(7, 53, 70));
*/
		fc = new JFileChooser();

		panel7.setOpaque(false);
		panel7.setLayout(null);
		// panel3.setBackground(Color.blue);
		panel7.setBounds(15, 90, screenSize.width - 10, screenSize.height - (screenSize.height / 6));
		JPanel outform7 = new JPanel();
		outform7.setLayout(null);
		outform7.setOpaque(false);
		
		outform7.setBounds(400, 150, 400, 300);
		//outform7.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		outform7.setBackground(Color.white);
		JLabel outlabel7 = new JLabel("Enter Details of Out Patient");
		outlabel7.setBounds(140, 20, 300, 40);
		final JTextField outid7 = new HintTextField("Enter id");
		outid7.setBounds(80, 70, 200, 40);
		JButton outbutton7 = new JButton("Check");
		outbutton7.setBounds(400, 70, 100, 40);
		outbutton7.setBackground(Color.white);
		final JTextField outillness7 = new HintTextField("Enter Illness");
		outillness7.setBounds(80, 120, 200, 40);
		final JTextField loc7 = new HintTextField("Location of Image");
		loc7.setBounds(80, 170, 200, 40);
		JButton browse7 = new JButton("Browse");
		browse7.setBounds(100, 220, 100, 40);
		JButton save7 = new JButton("Save");
		save7.setBounds(240, 220, 100, 40);
		outform7.add(outlabel1);
		browse7.setBackground(Color.white);
		save7.setBackground(Color.white);
		outform7.add(outillness7);
		outform7.add(browse7);
		outform7.add(outid7);
		outform7.add(loc7);
		outform7.add(browse7);
		outform7.add(save7);
		browse7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(outform11);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					// This is where a real application would open the file.
					// log.append("Opening: " + file.getName() + "." + newline);
					loc7.setText(file.getAbsolutePath());
				} else {
					// log.append("Open command cancelled by user." + newline);
				}
				// log.setCaretPosition(log.getDocument().getLength());

			}
		});
		save7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PreparedStatement pstmt = null;

				String query2 = "insert into  patientvideos(pid,location) values(?, ?)";

				try {
					String st = "http://10.4.5.139:8080/HospitalManagementServer/images/";
					Connection conn = new DbConnection().connect();
					pstmt = conn.prepareStatement(query2);
					pstmt.setString(1, outid7.getText());
					pstmt.setString(2, st + fc.getSelectedFile().getName());

					pstmt.executeUpdate(); // execute insert statement
					JOptionPane.showMessageDialog(null, "Added Sucesfully");

				} catch (Exception e)

				{
					JOptionPane.showMessageDialog(null, "boom");
					System.out.println(e.getMessage());
				}

			}
		});
		panel7.add(outform7, BorderLayout.CENTER);

		// add panels to tabpane
		tabpane.setTabPlacement(SwingConstants.LEFT);
		ImageIcon image1 = new ImageIcon(
				"/home/shalom/NetBeansProjects/HospitalManagementSystem1/src/main/java/Images/1.jpg");

		JLabel label1 = new JLabel("", image1, JLabel.CENTER);
		ImageIcon image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/lon.png");
		// Create vertical labels to render tab titles
		tabpane.addTab("          NEW PATIENT", image2, panel1, "<html><h1><b>NEW PATIENT");
		image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/pi.png");
		tabpane.addTab("       PATIENT Records", image2, panel2, "<html><h1><b>PATIENT Records</html>");
		image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/kan.png");
		tabpane.addTab("       DOCTOR Records", image2, panel3, "<html><h1><b>DOCTOR Records</html>");
		image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/wel1.png");
		tabpane.addTab("        Existing Patient", image2, panel4, "<html><h1><b>Existing Patient<br>");
		image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/bill1.png");
		tabpane.addTab("        BILL Payments", image2, panel5, "<html><h1><b>BILL Payments<br>");
		image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/pic.png");
		tabpane.addTab("      Images Upload", image2, panel6, "<html><h1><b>Images Upload");
		image2 = new ImageIcon("/home/shalom/git/HospitalManagementSystem/src/main/java/Images/video.png");
		tabpane.addTab("      Videos Upload", image2, panel7, "<html><h1><b> Videos Upload");

		tabpane.setBackgroundAt(0, Color.white);
		tabpane.setBackgroundAt(1, Color.white);
		tabpane.setBackgroundAt(2, Color.white);
		tabpane.setBackgroundAt(3, Color.white);
		tabpane.setBackgroundAt(4, Color.white);
		tabpane.setBackgroundAt(5, Color.white);
		tabpane.setBackgroundAt(6, Color.white);

		tabpane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pathdisplaypanel.setVisible(false);
				billdisplaypanel.setVisible(false);
			}
		});

		// tabpane.add(panel5,"<html>N<br>E<br>W<br>P<br>A<br>T<br>I<br>E<br>N<br>T</html>");

		// menupageframe.pack();

		// add mainbodypanel
		menupageframe.add(mainbodypanel);
		menupageframe.setVisible(true);
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuPage();
			}
		});
	}

}
