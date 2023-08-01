package Demo;

public class Validation 
{
	public double Operation(int qty,double price,String category) 
	{
		double res=0.0;
		if(category.equals("veg"))
		{
			res=(price*qty)+((price*qty)*0.05);
		}
		
		else
		{
			res=(price*qty)+((price*qty)*0.1);
		}
		return res;
	}
}
