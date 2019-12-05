import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import tn.esprit.pidev.Entities.Collaborator;
import tn.esprit.pidev.Entities.ExpenseForm;
import tn.esprit.pidev.Service.Impl.ExpenseFormService;

@ManagedBean(name="ExpenseBean")
@SessionScoped
public class ExpenseFormBean implements Serializable{
	private static Collaborator collaborator;
	static {
		collaborator=new Collaborator();
		FacesContext facescontext =FacesContext.getCurrentInstance();
		Map<String,Object> SessionMap=facescontext.getExternalContext().getSessionMap();
		collaborator=(Collaborator) SessionMap.get("collaborator");

	}
	
public static Collaborator getCollaborator() {
		return collaborator;
	}
	public static void setCollaborator(Collaborator collaborator) {
		ExpenseFormBean.collaborator = collaborator;
	}
	public ExpenseFormService getEformS() {
		return EformS;
	}
	public void setEformS(ExpenseFormService eformS) {
		EformS = eformS;
	}
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String Description;
private String Justification;
private float Amount;
private String date;
private boolean state;

public boolean isState() {
	return state;
}
public void setState(boolean state) {
	this.state = state;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
@EJB
ExpenseFormService EformS;

public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getJustification() {
	return Justification;
}
public void setJustification(String justification) {
	Justification = justification;
}
public float getAmount() {
	return Amount;
}
public void setAmount(float amount) {
	Amount = amount;
}

public int doCreateEform() {
	ExpenseForm e =new ExpenseForm();
	e.setCollab(collaborator);
	e.setAmount(Float.toString(Amount));
	e.setDescription(Description);
	e.setJustification(Justification);
	
	return EformS.createExpForm(e);

}
public String doConfirm(ExpenseForm a) {
			
	/*if(e.contains(EformS.findMreqById(a.getId()))) {*/
		
		a.setState(true);
		EformS.ChangeState(a);
		
	System.out.println(a);
return "aaaa";
}


public String doRefuse(int id) {
	
	EformS.removeMreq(id);
	return ("aaaaa");
}
private static List<ExpenseForm> e;

public List<ExpenseForm> getE() {
	return e;
}
public void setE(List<ExpenseForm> e) {
	this.e = e;
}
public void getAllEforms(){
	
	 e=EformS.findAllExpenseForms();
	
	
	
}
public String Eform2() {
	e=EformS.affConf();
	return "/Pages/admin/ExpenseForm2?faces-redirect=true";

}
public String goExpense() {
	getAllEforms();
	return "/Pages/admin/ExpenseForm?faces-redirect=true";
	
}

}

