package sk.elct.Tomas.MVypocet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class foodMenu 
{


private String selectiom;
private String name;

public static int storeKcalbox(String selection)
{
	int calCount =0;
	
	

	Pattern p = Pattern.compile("\\d+");
	Matcher m = p.matcher(selection);
	while (m.find())
	{
		calCount = Integer.parseInt(m.group());
		
		if (calCount == 0)
		{
		calCount = calCount + Integer.parseInt(m.group());
		}
		else
		{
			calCount = 0;
			calCount = calCount + Integer.parseInt(m.group());
		}
	}
	
return calCount;

}	    	

public static void citaj(String name)
{
	
		String food;
		String nextLine = "\n";
		JFrame frame4 = new JFrame();
		JTextArea menu = new JTextArea();
		JPanel panel = new JPanel();
		 try (BufferedReader rd12 = new BufferedReader(new FileReader("Source//Recepis//" + name + ".txt")))
		{
			    while ((food = rd12.readLine()) != null)
			    { 
			    	
			    	menu.append(food);
			    	
			    	menu.append(nextLine);
			    }
			    
			    rd12.close();
		}
		catch (Exception error2)
		 	{
			System.err.println("nepodarilo sa nacitat recept" );
			}
		
		    menu.setSize(800,300);
		 	frame4.add(menu);
			frame4.setSize(800,300);
			frame4.setResizable(true);
			frame4.setDefaultCloseOperation(1);
			frame4.setLocationRelativeTo(null);
			frame4.setVisible(true);
	
	
}


}	    	