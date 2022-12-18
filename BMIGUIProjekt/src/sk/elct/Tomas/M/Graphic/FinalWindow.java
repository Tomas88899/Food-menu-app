package sk.elct.Tomas.M.Graphic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sk.elct.Tomas.MVypocet.Kaloriescal;
import sk.elct.Tomas.MVypocet.PrepoctyBmiKal;
import sk.elct.Tomas.MVypocet.Users;
import sk.elct.Tomas.MVypocet.foodMenu;

public class FinalWindow extends JFrame
{
	
	
	private String height;
	private String name;
	private String weight;
	private String bmi;
	private String maintain;
	private String loose;
	private String message;
	private String gender;
	private String lifeStyleIndex;
	private String strrecepie1;
	private String strrecepie2;
	private String strrecepie3;
	private String strrecepie4;
	private String strrecepie5;
	private int calCount1;
	private int calCount2;
	private int calCount3;
	private int calCount4;
	private int calCount5;
	private Integer totalCount;
	private String genderstr;
	
	JComboBox <String> foodLisBox1 = new JComboBox <String>();
	JComboBox <String> foodLisBox2 = new JComboBox <String>();
	JComboBox <String> foodLisBox3 = new JComboBox <String>();
	JComboBox <String> foodLisBox4 = new JComboBox <String>();
	JComboBox <String> foodLisBox5 = new JComboBox <String>();
	
	JFrame frame3;
	JPanel panel;
	JLabel labelname;
	JLabel labelheight;
	JLabel labelweight;
	JLabel labelbmi;
	JLabel labelpkl;
	JLabel labelMaintain;
	JLabel labelLoose;
	JLabel labelGender;
	JLabel breakfast;
	JLabel snack1;
	JLabel lunch;
	JLabel snack2;
	JLabel dinner;
	JLabel calCountTotal;
	
	JTextField textfieldname;
	JTextField textFieldHeight;
	JTextField textFieldWeight;
	JTextField textfielDBmi;
	JTextField textfieldPkl;
	JTextField textfielMaintain;
	JTextField textFieldLoose;
	JTextField textFieldGender;
	JTextField textFieldMessage;
	JTextField textFieldTotalKcal;
	
	JButton recipe1;
	JButton recipe2;
	JButton recipe3;
	JButton recipe4;
	JButton recipe5;
	JButton countButton;
	JButton backButton;
	
	
	public FinalWindow(String name) 
	{
		super();
		this.name = name;
		;
		loadInfo(name);
		loadFood();
		
		recipe1 = new JButton("Recept");
		recipe2 = new JButton("Recept");
		recipe3 = new JButton("Recept");
		recipe4 = new JButton("Recept");
		recipe5 = new JButton("Recept");
		countButton = new JButton("Prepocitaj");
		backButton = new JButton("Naspäť");
		
		textfieldname = new JTextField(10);
		textFieldHeight = new JTextField(10);
		textFieldWeight = new JTextField(10);
		textfielDBmi = new JTextField(10);
		textfieldPkl = new JTextField(10);
		textfielMaintain = new JTextField(10);
		textFieldLoose = new JTextField(10);
		textFieldGender = new JTextField(10);
		textFieldMessage = new JTextField(60);
		textFieldTotalKcal = new JTextField(10);
		
		foodLisBox1.setSelectedItem(null);
		foodLisBox2.setSelectedItem(null);
		foodLisBox3.setSelectedItem(null);
		foodLisBox4.setSelectedItem(null);
		foodLisBox5.setSelectedItem(null);
		
		frame3 = new JFrame("Pridaj Uzivatela");
		panel = new JPanel();
		panel.setLayout(null);
		labelname = new JLabel("Meno: ");
		labelheight = new JLabel("Vyska: ");
		labelweight = new JLabel("Vaha: ");
		labelbmi = new JLabel("BMI Index: ");
		labelpkl = new JLabel("Denny prijem Kcal ");
		labelMaintain = new JLabel("Na udrzanie vahy: ");
		labelLoose = new JLabel("Na schudnutie: ");
		labelGender = new JLabel("Pohlavie ");
		breakfast = new JLabel("Ranajky");
		snack1 = new JLabel("Desiata");
		lunch = new JLabel("Obed");
		snack2 = new JLabel("Olovrant");
		dinner = new JLabel("Vecera");
		calCountTotal = new JLabel("Celkovy pocet Kcal");
		
		countButton.setBounds(650, 350, 100, 25);
		countButton.addActionListener(e -> countCal());
		
		backButton.setBounds(10, 350, 100, 25);
		backButton.addActionListener(e -> stepBack());
		
		breakfast.setBounds(400, 20, 320, 25);
		recipe1.setBounds(650, 50, 100, 25);
		recipe1.addActionListener(e -> foodMenu.citaj(strrecepie1));
		foodLisBox1.setBounds(400, 50, 220, 25);
		foodLisBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie1 =((String)foodLisBox1.getSelectedItem());
				calCount1 = foodMenu.storeKcalbox(strrecepie1);
			}
		});
		
		snack1.setBounds(400, 80, 320, 25);
		recipe2.setBounds(650, 110, 100, 25);
		recipe2.addActionListener(e -> foodMenu.citaj(strrecepie2));
		foodLisBox2.setBounds(400, 110, 220, 25);
		foodLisBox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie2 =((String)foodLisBox2.getSelectedItem());
				calCount2 = foodMenu.storeKcalbox(strrecepie2);
			}
		});
		
		lunch.setBounds(400, 140, 320, 25);
		recipe3.setBounds(650, 170, 100, 25);
		recipe3.addActionListener(e -> foodMenu.citaj(strrecepie3));
		foodLisBox3.setBounds(400, 170, 220, 25);
		foodLisBox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie3 =((String)foodLisBox3.getSelectedItem());
				calCount3 = foodMenu.storeKcalbox(strrecepie3);
			}
		});
		
		snack2.setBounds(400, 200, 320, 25);
		recipe4.setBounds(650,230, 100, 25);
		recipe4.addActionListener(e -> foodMenu.citaj(strrecepie4));
		foodLisBox4.setBounds(400, 230, 220, 25);
		foodLisBox4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie4 =((String)foodLisBox4.getSelectedItem());
				calCount4 = foodMenu.storeKcalbox(strrecepie4);
			}
		});
		
		dinner.setBounds(400, 260, 320, 25);
		recipe5.setBounds(650, 290, 100, 25);
		recipe5.addActionListener(e -> foodMenu.citaj(strrecepie5));
		foodLisBox5.setBounds(400, 290, 220, 25);
		foodLisBox5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie5 =((String)foodLisBox5.getSelectedItem());
				calCount5 = foodMenu.storeKcalbox(strrecepie5);
			}
		});
		
		calCountTotal.setBounds(400, 350, 320, 25);
		textFieldTotalKcal.setBounds(520, 350, 120, 25);
								
		labelname.setBounds(10, 20, 120, 25);
		textfieldname.setText(name);
		textfieldname.setBounds(130, 20, 120, 25);
		textfieldname.setBackground(Color.WHITE);
		textfieldname.setEditable(false);
		
		labelheight.setBounds(10, 50, 120, 25);
		textFieldHeight.setText(height);
		textFieldHeight.setBounds(130, 50, 120, 25);
		textFieldHeight.setBackground(Color.WHITE);
		textFieldHeight.setEditable(false);
		
		labelweight.setBounds(10, 80, 120, 25);
		textFieldWeight.setText(weight);
		textFieldWeight.setBounds(130, 80, 120, 25);
		textFieldWeight.setBackground(Color.WHITE);
		textFieldWeight.setEditable(false);
		
		labelbmi.setBounds(10,140, 120, 25);
		textfielDBmi.setText(bmi);
		textfielDBmi.setBounds(130, 140, 120, 25);
		textfielDBmi.setBackground(Color.WHITE);
		textfielDBmi.setEditable(false);
		
		textFieldMessage.setText(message);
		textFieldMessage.setBackground(Color.WHITE);
		textFieldMessage.setBounds(10, 170, 120, 25);
		
		labelpkl.setBounds(10,200, 120, 25);	
		labelMaintain.setBounds(10,230, 120, 25);
		textfielMaintain.setText(maintain);
		textfielMaintain.setBounds(130, 230, 120, 25);
		textfielMaintain.setBackground(Color.WHITE);
		textfielMaintain.setEditable(false);
		
		labelLoose.setBounds(10,260, 120, 25);
		textFieldLoose.setText(loose);
		textFieldLoose.setBounds(130, 260, 120, 25);
		textFieldLoose.setBackground(Color.WHITE);
		textFieldLoose.setEditable(false);
		
		labelGender.setBounds(10,110, 120, 25);
		textFieldGender.setText(genderstr);
		textFieldGender.setBounds(130, 110, 120, 25);
		textFieldGender.setBackground(Color.WHITE);
		textFieldGender.setEditable(false);
		
		
		panel.add(recipe1);
		panel.add(recipe2);
		panel.add(recipe3);
		panel.add(recipe4);
		panel.add(recipe5);
		panel.add(countButton);
		panel.add(backButton);
		panel.add(breakfast);
		panel.add(snack1);
		panel.add(lunch);
		panel.add(snack2);
		panel.add(dinner);
		panel.add(foodLisBox1);
		panel.add(foodLisBox2);
		panel.add(foodLisBox3);
		panel.add(foodLisBox4);
		panel.add(foodLisBox5);
		
		panel.add(labelname);
		panel.add(textfieldname);
		panel.add(labelheight);
		panel.add(textFieldHeight);
		panel.add(labelweight);
		panel.add(textFieldWeight);
		panel.add(labelbmi);
		panel.add(textfielDBmi);
		panel.add(labelpkl);
		panel.add(textfieldPkl);
		panel.add(labelMaintain);
		panel.add(textfielMaintain);
		panel.add(labelLoose);
		panel.add(textFieldLoose);
		panel.add(labelGender);
		panel.add(textFieldGender);
		panel.add(textFieldMessage);
		panel.add(calCountTotal);
		panel.add(textFieldTotalKcal);
		
		
		frame3.add(panel);
		frame3.setSize(800,470);
		frame3.setResizable(false);
		frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame3.setLocationRelativeTo(null);
		frame3.setVisible(true);
 
	   
   }

		public void loadInfo(String name)
		{
			name = this.name;
		try
		{
		Users user = new Users();
		user.citaj(name);
		height = user.getHeight();
		weight = user.getWeight();
		gender = user.getGender();
		lifeStyleIndex = user.getLifeStyleIndex();
		bmi = PrepoctyBmiKal.bmi(user);
		message = PrepoctyBmiKal.getMessage();
		Kaloriescal kal = new Kaloriescal(Integer.parseInt(weight),Integer.parseInt(gender),Integer.parseInt(lifeStyleIndex));
		genderstr = kal.getGender();
		loose = "" + kal.getLooseweight();
		maintain = "" + kal.getMaitainweight();
		}
		catch (NumberFormatException e)
		{
			
		}
		}
		
		public  void loadFood()
		{
			 	String line = "";
			   
			   try {
				  	
				   
				   BufferedReader br = new BufferedReader(new FileReader("Source//Jedalnicek.csv"));
			    		while((line = br.readLine()) != null)
			    		{	
			    			
			    			String separed =line.replace(';',' ');

			    			foodLisBox1.addItem(separed);
			    			foodLisBox2.addItem(separed);
			    			foodLisBox3.addItem(separed);
			    			foodLisBox4.addItem(separed);
			    			foodLisBox5.addItem(separed);
			    		}
			      br.close();
			    	}
			    	catch(IOException e)
			    	{
			    		e.printStackTrace();
			    	}
		}

		public  void countCal()
{
	totalCount = (calCount1 + calCount2 + calCount3 + calCount4 + calCount5 );
	textFieldTotalKcal.setText(totalCount.toString());
}

		public void stepBack()
		{
			frame3.dispose();
			new MainWindow();
		}





}
