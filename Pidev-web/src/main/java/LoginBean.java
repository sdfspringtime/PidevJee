import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import tn.esprit.pidev.Entities.Collaborator;
import tn.esprit.pidev.Service.Impl.CollabService;
import tn.esprit.pidev.Service.Impl.ExpenseFormService;

@ManagedBean(name="employeBean")
@SessionScoped
public class LoginBean implements Serializable{
	private String login; 
	private String password;
	private static Collaborator collaborator;
	static {
	
	}
	
	
	public String getLogin() {
		return login;
	}
	public  Collaborator getCollaborator() {
		return collaborator;
	}
	public  void setCollaborator(Collaborator collaborator) {
		LoginBean.collaborator = collaborator;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public CollabService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(CollabService employeService) {
		this.employeService = employeService;
	}
	@EJB
	CollabService employeService;
	@EJB
	ExpenseFormService ee;
	public String doLogin() {
		
	
		
		FacesContext facescontext =FacesContext.getCurrentInstance();
		Map<String,Object> SessionMap=facescontext.getExternalContext().getSessionMap();
		SessionMap.put("collaborator", collaborator);
	String navigateTo = "null";
	collaborator = employeService.getEmployeByEmailAndPassword(login, password);
	System.out.println(collaborator);
	
	if (collaborator != null ) {
	navigateTo = "/Pages/admin/welcome?faces-redirect=true"; }
	else {
	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
	return navigateTo;}
	

	}
	
	
