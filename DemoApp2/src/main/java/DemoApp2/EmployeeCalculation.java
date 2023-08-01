package DemoApp2;

public class EmployeeCalculation {
	public double calculateSal(String desig,double sal) {
		if(desig.equals("dev"))
		{
			sal=sal+sal*0.3;
		}
		else
		{
			sal=sal+sal*0.2;
		}
		return sal;
	}
}
