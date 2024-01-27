package Model;

public class DTO 
{
	private int id;
	private double sal;
	
	public DTO() 
	{
		
	}
	
	public DTO(int id, double sal) 
	{
		this.id = id;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
}
