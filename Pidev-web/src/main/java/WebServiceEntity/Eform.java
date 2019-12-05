package WebServiceEntity;

public class Eform {
    private int EF_Id ;
    private String Justification;
    private String amount ;
    private String date ;
    private String description;
    private boolean state ;
	public int getEF_Id() {
		return EF_Id;
	}
	public void setEF_Id(int eF_Id) {
		EF_Id = eF_Id;
	}
	public String getJustification() {
		return Justification;
	}
	public void setJustification(String justification) {
		Justification = justification;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

}
