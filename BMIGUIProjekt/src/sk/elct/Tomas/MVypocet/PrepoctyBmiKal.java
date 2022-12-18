package sk.elct.Tomas.MVypocet;



import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class PrepoctyBmiKal 
{
	static String message=" ";
	public static double bmi;
	public static JFrame frame = new JFrame();
	
	
	
	
	public PrepoctyBmiKal()
	{
		super();
		
	}
	public static String bmi(Users user) 
	{
		
		try
		{	
		
		String height = user.getHeight();
		 String weight = user.getWeight();
		 int a = Integer.parseInt(height);
		 int b = Integer.parseInt(weight);
		
		 
		bmi = b / ( ( a / 100.0 ) * ( a / 100.0 ));

		
		if (bmi > 30.00)
		{
			message ="Mas Obezitu";
			
		}
		else if (bmi <29.99 && bmi >= 25)
		{
			message ="Mas Nadvahu";
			
		}
		else if (bmi < 24.999 && bmi >= 18.5)
		{			
			message ="Zdravy";
			
		}
		else if (bmi < 18.5)
		{
			
			message = "Si podviziveny/a";
		}
		else
		{
			message = "Nezadane";
		}
		
		
		}
		catch (NumberFormatException e)
		{
			
			JOptionPane.showMessageDialog(frame,"Nespravne zadane udaje");
		}
	String result = String.format("%.2f",bmi);
	return result;
	

	
	
	

	
	}	

	public static String getMessage() {
		return message;
	}




}
