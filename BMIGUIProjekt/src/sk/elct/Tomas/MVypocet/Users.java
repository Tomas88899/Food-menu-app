package sk.elct.Tomas.MVypocet;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;




public class Users 
{
	


	// FIELDS
	private String name;
	private String height;
	private String weight;
	private String gender;
	private String lifeStyleIndex;
	
	//CONSTRUCTOR
	
	public Users()
	{
		
		super();
		
	}
	
	
	
	public Users(String name,String height, String weight,String gender,String lifeStyleIndex) 
	{	
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.lifeStyleIndex = lifeStyleIndex;
	}
	
	
	
	//METODS
	
	
	public void citaj(String name)
	{
		this.name= name;
		String test;
	    String [] arr = new String [5];
		
	    
		try (BufferedReader rd1 = new BufferedReader(new FileReader("Source//Profils//" + name + ".txt")))
		{
		    
	    	for(int i = 0; i < 5; i++)
	    	{
	    		test = rd1.readLine();
	    	arr[i] = test;
	    	}
	    	rd1.close();
		}
		catch (Exception e)
		{
		    System.err.println("Chyba při čtení ze souboru.");
		}
		this.name = arr[0];
		this.height = arr[1];
		this.weight = arr[2];
		this.gender = arr[3];
		this.lifeStyleIndex = arr[4];
	}

	
	public void Uloz(String name) 
	{	 
		try 
		{
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("Source//Profils//" + this.name + ".txt"));
		
		bw1.write(this.name);
		bw1.newLine();
		bw1.write(this.height);
		bw1.newLine();
		bw1.write(this.weight);
		bw1.newLine();
		bw1.write(this.gender);
		bw1.newLine();
		bw1.write(this.lifeStyleIndex);
		bw1.close();

	    System.out.println("Do souboru bylo připsáno");
		}
		catch (Exception error2)
		{
		System.err.println("Do bw1 se nepovedlo zapsat." );
		}
	}	
	
	public String getLifeStyleIndex() {
		return lifeStyleIndex;
	}



	public void Ulozlist() 
	{	 
		try 
		{
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("Source//Profils.txt", true));
		
		bw1.write(this.name);
		bw1.newLine();
		
		
		bw1.close();

	    System.out.println("Do souboru bylo připsáno");
		}
		catch (Exception error2)
		{
		System.err.println("Do bw1 se nepovedlo zapsat." );
		}
	}	
	
	
	
	
	
	
	



	public String getName() {
		return name;
	}



	public String getGender() {
		return gender;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	public String getWeight() {
		return weight;
	}



	public void setWeight(String weight) {
		this.weight = weight;
	}

}


	
	
	

	
