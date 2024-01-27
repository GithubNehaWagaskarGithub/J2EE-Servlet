package Model;

public class StudentClass 
{
	private int SId;
	private String SName;
	private String SDiv;
	private String SAdd;
	private String SCity;
	private double SPer;
	
	public StudentClass(int SId, String SName, String SDiv, String SAdd, String SCity, double SPer) 
	{
		this.SId=SId;
		this.SName=SName;
		this.SDiv=SDiv;
		this.SAdd=SAdd;
		this.SCity=SCity;
		this.SPer=SPer;
	}
	public StudentClass() 
	{
		
	}
	public int getSId() {
		return SId;
	}
	public void setSId(int sId) {
		SId = sId;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getSDiv() {
		return SDiv;
	}
	public void setSDiv(String sDiv) {
		SDiv = sDiv;
	}
	public String getSAdd() {
		return SAdd;
	}
	public void setSAdd(String sAdd) {
		SAdd = sAdd;
	}
	public String getSCity() {
		return SCity;
	}
	public void setSCity(String sCity) {
		SCity = sCity;
	}
	public double getSPer() {
		return SPer;
	}
	public void setSPer(double sPer) {
		SPer = sPer;
	}
	
}
