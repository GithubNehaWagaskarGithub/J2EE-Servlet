package Model;

import java.util.ArrayList;

public class DTO 
{
	private int RollNO;
	private String Name;	
	private String Div;
	private String Address;
	private String City;
	private double Marks;
	
	public DTO() 
	{
	}
	public DTO(int rollNO, String name, String div, String address, String city, double marks) 
	{
		RollNO = rollNO;
		Name = name;
		Div = div;
		Address = address;
		City = city;
		Marks = marks;
	}
	public int getRollNO() {
		return RollNO;
	}
	public void setRollNO(int rollNO) {
		RollNO = rollNO;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDiv() {
		return Div;
	}
	public void setDiv(String div) {
		Div = div;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public double getMarks() {
		return Marks;
	}
	public void setMarks(double marks) {
		Marks = marks;
	}
	
	
}
