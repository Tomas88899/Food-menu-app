package sk.elct.Tomas.MVypocet;

public class Kaloriescal
{


int maitainweight;
int looseweight;
int bareminimu;
private int weight;
private int gender;
private int lifeStyleIndex;
private String genderstr;


public Kaloriescal(int weight,int gender,int lifeStyleIndex)
{
	super();
	this.weight = weight;
	this.gender = gender;
	this.lifeStyleIndex = lifeStyleIndex;
	
	
	if (gender == 1)
	{		
		genderstr = "Muz";
		if (lifeStyleIndex == 0)
		{
			maitainweight = weight * 31;
			looseweight = (weight * 31) - 500;
			
		}
		else if (lifeStyleIndex == 1)
		{
			maitainweight = weight * 38;
			looseweight = (weight * 38) - 500;
			
		}
		else if (lifeStyleIndex == 2)
		{
			maitainweight = weight * 42;
			looseweight = (weight * 42) - 500;
			
		}
		else
		{
			maitainweight = weight * 60;
			looseweight = (weight * 60) - 500;
		}
	}
	else if (gender == 2) 
	{
		genderstr = "Zena";
		if (lifeStyleIndex == 0)
		{
			maitainweight = weight * 30;
			looseweight = (weight * 30) - 500;
			
		}
		else if (lifeStyleIndex == 1)
		{
			maitainweight = weight * 35;
			looseweight = (weight * 35) - 500;
			
		}
		else if (lifeStyleIndex == 2)
		{
			maitainweight = weight * 37;
			looseweight = (weight * 37) - 500;
			
		}
		else
		{
			maitainweight = weight * 50;
			looseweight = (weight * 50) - 500;
		}
	}
	else
	{
		genderstr = "Nezadane";
		maitainweight = 0;
		looseweight = 0;
	}
			

}

public int getMaitainweight() {
	return maitainweight;
}

public int getLooseweight() {
	return looseweight;
}

public String getGender() {
	return genderstr;
}











}
