package sk.elct.Tomas.M.Graphic;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sk.elct.Tomas.MVypocet.Users;



public class CreateUserWindow 
{
	
	JFrame frame2;
	String gender = "0";
	String lifeStyleIndex = "0";
	
	JComboBox <String> lifeStyleBox = new JComboBox <String>();
	DefaultComboBoxModel <String> lifestilemodel = new DefaultComboBoxModel <String>();
	
	
	
	public CreateUserWindow()
	{   
		super();
		
		lifestilemodel.removeAllElements();
		lifestilemodel.addElement("Vyber");
		lifestilemodel.addElement("Sedavom spôsob života");
		lifestilemodel.addElement("Rekreačne cvičenie");
		lifestilemodel.addElement("každodenný tréning");
		lifestilemodel.addElement("Viacfázový tréning");
		
		 
		
		JTextField textfieldname = new JTextField(10);
		JTextField textFieldHeight = new JTextField(10);
		JTextField textFieldweight = new JTextField(10);
		
		
		frame2 = new JFrame("Pridaj Uzivatela");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel labelname = new JLabel("Meno");
		JLabel labelheight = new JLabel("Vyska");
		JLabel labelweight = new JLabel("Vaha");
		JLabel labelGender = new JLabel("Pohlavie");
		JLabel lifeStyleLabel = new JLabel ("Sposob zivota: ");
		JButton saveUserButton = new JButton("Pridaj");
		saveUserButton.addActionListener((e) -> addUser(textfieldname.getText(),textFieldHeight.getText(),textFieldweight.getText(),gender,lifeStyleIndex));
		saveUserButton.setBounds(150, 180, 120, 25);
	
		JButton backButton = new JButton("Naspäť");
		backButton.setBounds(10, 180, 120, 25);
		backButton.addActionListener(e -> stepBack());
		
		labelname.setBounds(10, 20, 120, 25);
		textfieldname.setBounds(130, 20, 120, 25);
		labelheight.setBounds(10, 50, 120, 25);
		textFieldHeight.setBounds(130, 50, 120, 25);
		labelweight.setBounds(10, 80, 120, 25);
		textFieldweight.setBounds(130, 80, 120, 25);
		labelGender.setBounds(10, 110, 120, 25);
		lifeStyleLabel.setBounds(10, 140, 120, 25);
		 
		JRadioButton manButton = new JRadioButton("Muz");
		manButton.setBounds(130, 107, 50, 30);
		manButton.addActionListener(e -> gender = "1");
	    
	    JRadioButton womanButton = new JRadioButton("Zena");
	    womanButton.setBounds(180, 107, 70, 30);
	    womanButton.addActionListener(e -> gender = "2");
	    
	    lifestilemodel.setSelectedItem("Vyber");
	    lifeStyleBox.setBounds(130, 140,150, 25);
	    lifeStyleBox.setBackground(Color.WHITE);
	    lifeStyleBox.setEditable(false);
	    lifeStyleBox.setModel(lifestilemodel);
	    lifeStyleBox.addActionListener(e -> this.lifeStyleIndex = "" + lifeStyleBox.getSelectedIndex());
	    
		ButtonGroup group = new ButtonGroup();
	    group.add(manButton);
	    group.add(womanButton);
	    
	    
	    panel.add(labelname);
		panel.add(textfieldname);
		panel.add(labelheight);
		panel.add(textFieldHeight);
		panel.add(labelweight);
		panel.add(textFieldweight);
		panel.add(saveUserButton);
		panel.add(backButton);
		panel.add(labelGender);
		panel.add(manButton);
		panel.add(womanButton);
		panel.add(lifeStyleLabel);
		panel.add(lifeStyleBox);
		
		frame2.add(panel);
		frame2.setSize(300,270);
		frame2.setResizable(false);
		frame2.setDefaultCloseOperation(1);
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
	
	}

	

	public  void addUser(String name,String height,String weight,String gender,String lifeStyleIndex)
	{
	  
		if (name.isBlank())
		{
			JOptionPane.showMessageDialog(frame2,"Nezadal si meno Uzivatela");
		}
		else
		{
			Users user = new Users(name,height,weight,gender,lifeStyleIndex);
			user.Uloz(name);
			user.Ulozlist();
			new MainWindow();
     		frame2.dispose();
		}
	}
 
	public void stepBack()
	{
		frame2.dispose();
		new MainWindow();
	}
	



}

